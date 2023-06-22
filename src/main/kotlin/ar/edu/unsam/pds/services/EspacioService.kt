package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.controller.BusinessException
import ar.edu.unsam.pds.controller.dto.EspacioDTO
import ar.edu.unsam.pds.controller.dto.EspaciosCantPaginasDTO
import ar.edu.unsam.pds.controller.dto.toDTO
import ar.edu.unsam.pds.domains.ComentarioEspacio
import ar.edu.unsam.pds.domains.Espacio
import ar.edu.unsam.pds.domains.Renta
import ar.edu.unsam.pds.exceptions.ErrorFechas
import ar.edu.unsam.pds.exceptions.IdInvalido
import ar.edu.unsam.pds.exceptions.NoEsDuenioDelHospedaje
import ar.edu.unsam.pds.exceptions.elementoEliminado
import ar.edu.unsam.pds.repositories.ComentarioRepositorio
import ar.edu.unsam.pds.repositories.EspacioRepositorio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional
import kotlin.math.*

@Service
class EspacioService {
    @Autowired
    lateinit var espaciosRepositorio: EspacioRepositorio
    @Autowired
    lateinit var comentariosRepo: ComentarioRepositorio

    var cantidadPorPagina = 12

    @Transactional(Transactional.TxType.NEVER)
    fun obtenerEspacio(id : Long ) : EspacioDTO? {
        try{
            val espacio = espaciosRepositorio.findById(id).get()
            espacio.comentarios = this.obtenerUltimos3Comentarios(espacio)
            return espacio.toDTO()
        }catch (e: Exception){
             throw BusinessException("No existe el elemento seleccionado")
        }

    }

    @Transactional(Transactional.TxType.NEVER)
    fun getEspacios(
            ubicacion: String? = null,
            fechaInicio: LocalDate? = null,
            fechaFin: LocalDate? = null,
            cantidadPasajeros: Int? = null,
            numeroPagina: Int? = null,
            puntajes: List<Int>? = null,
    ) : EspaciosCantPaginasDTO {

        // NOTE: las fechas pueden ser nulas
        if (fechaInicio != null && fechaFin != null){
            if (fechaInicio.isAfter(fechaFin)) {
                println("pasa por aqui")
                throw ErrorFechas("Error al seleccionar las fechas")
            }
        }
        // NOTE: puntajes nulos se reemplazan por todos
        val todosLosPuntajes = listOf(-1,0,1,2,3,4,5)
        val puntajesABuscar : List<Int> = if ((puntajes == null ) || (puntajes.size == 1 && puntajes[0] == 1)) {
            todosLosPuntajes
        } else puntajes

        var resultado: List<Espacio> = this.espaciosRepositorio.find(
                ubicacion,
                fechaInicio,
                fechaFin,
                cantidadPasajeros ?: 1,
                puntajesABuscar
        )
        val cantidadPaginas = this.cantidadDePaginas(resultado.size)
        resultado = filtrarPorPagina(resultado, numeroPagina ?: 1)
        return EspaciosCantPaginasDTO(resultado.map { it.toDTO() }, cantidadPaginas)
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun modificarEspacio(id: Long, hospedajeBody : Espacio) {
        try{
            if (id == null) {
                throw IdInvalido("No se puede actualizar un objeto sin id")
            }
            var espacio = this.espaciosRepositorio.findById(id).get()
            this.validarEstaActivo(espacio)
            espacio.titulo = hospedajeBody.titulo
            espacio.descripcion = hospedajeBody.descripcion
            espacio.otrosAspectos = hospedajeBody.otrosAspectos
            espacio.detalleAlojamiento = hospedajeBody.detalleAlojamiento
            espacio.ubicacion = hospedajeBody.ubicacion
            espacio.capacidad = hospedajeBody.capacidad
            espacio.habitaciones = hospedajeBody.habitaciones
            espacio.banios = hospedajeBody.banios
            espacio.costo_hora = hospedajeBody.costo_hora
            espacio.servicios = hospedajeBody.servicios
            espaciosRepositorio.save(espacio)

        } catch (e: Exception) {
            throw BusinessException("No existe el elemento seleccionado")
        }
    }

    fun actualizarPuntajePromedio(hospedaje: Espacio){
        hospedaje.puntajePromedio = espaciosRepositorio.obtenerPromedioEspacio(hospedaje.id!!)
        espaciosRepositorio.save(hospedaje)
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun eliminarEspacio(userId: Long, hospedajeId: Long){
        val espacio = this.espaciosRepositorio.findById(hospedajeId).get()
        this.validarEstaActivo(espacio)
        this.validarDuenioHospedaje(userId, espacio)
        espacio.estaActivo = false
        espaciosRepositorio.save(espacio)
    }

    fun validarEstaActivo(espacio: Espacio){
        if(espacio.estaActivo != true){
            throw elementoEliminado("El elemento está eliminado.")
        }
    }
    fun cantidadDePaginas(cantidadEspacios : Int) : Int = ceil(cantidadEspacios.toDouble().div(cantidadPorPagina)).toInt()


    fun filtrarPorPagina(espacios: List<Espacio>, numeroPagina: Int?): List<Espacio> {
        var resultado = espacios
        if (numeroPagina != null && numeroPagina > 0) {
            val inicio = (numeroPagina - 1) * cantidadPorPagina
            var fin = inicio + cantidadPorPagina
            if (fin > resultado.size) {
                fin = resultado.size
            }
            if ((inicio >= 0) && (inicio <= fin)) {
                resultado = resultado.subList(inicio, fin)
            }
        }
        return resultado
    }

    fun crearEspacio(nuevoEspacio : Espacio){
        Espacio.validarDatos(nuevoEspacio)
        espaciosRepositorio.save(nuevoEspacio)
    }

    fun promedioPuntaje(idEspacio: Long): Int{
        return this.espaciosRepositorio.obtenerPromedioEspacio(idEspacio)
    }
    fun obtenerUltimos3Comentarios(espacio: Espacio): List<ComentarioEspacio> {
        return this.comentariosRepo.obtenerComentariosOrdenados(espacio.id!!).take(3)
    }

    fun validarDuenioHospedaje(userId: Long, espacio: Espacio){
        if( espacio.duenio?.id!!.toInt() != userId.toInt() ) throw NoEsDuenioDelHospedaje("Un hospedaje solo puede ser eliminado por el dueño")
    }

    //TODO: Desde la query se puede validar que la fecha seleccionada esta ocupada. REVISAR
    fun estaOcupado(renta : Renta, fechaInicio: LocalDate, fechaFin: LocalDate) : Boolean {
        return return this.antesDelHorarioRentado(renta,fechaInicio) || this.despuesDelHorarioRentado(renta, fechaFin) || this.fueraDelHorarioRentado (renta, fechaInicio,fechaFin)
    }

    fun fueraDelHorarioRentado(reserva : Renta, filtroFechaInicio: LocalDate, filtroFechaFin: LocalDate): Boolean{
        return(filtroFechaInicio < reserva.fecha_desde) && (filtroFechaFin > reserva.fecha_desde)
    }

    fun antesDelHorarioRentado(reserva : Renta, filtroFechaInicio: LocalDate): Boolean {
        return (reserva.fecha_desde!! <= filtroFechaInicio) && (reserva.fecha_hasta!! >= filtroFechaInicio)
    }

    fun despuesDelHorarioRentado(reserva : Renta, filtroFechaFin: LocalDate): Boolean {
        return (reserva.fecha_desde!! <= filtroFechaFin) && (reserva.fecha_hasta!! >= filtroFechaFin)
    }


}



