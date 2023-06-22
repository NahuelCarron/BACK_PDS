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
import ar.edu.unsam.pds.exceptions.NoEsDuenioDelEspacio
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
    fun modificarEspacio(id: Long, espacioBody : Espacio) {
        try{
            if (id == null) {
                throw IdInvalido("No se puede actualizar un objeto sin id")
            }
            var espacio = this.espaciosRepositorio.findById(id).get()
            this.validarEstaActivo(espacio)
            espacio.titulo = espacioBody.titulo
            espacio.descripcion = espacioBody.descripcion
            espacio.otrosAspectos = espacioBody.otrosAspectos
            espacio.detalleAlojamiento = espacioBody.detalleAlojamiento
            espacio.ubicacion = espacioBody.ubicacion
            espacio.capacidad = espacioBody.capacidad
            espacio.habitaciones = espacioBody.habitaciones
            espacio.banios = espacioBody.banios
            espacio.costo_hora = espacioBody.costo_hora
            espacio.servicios = espacioBody.servicios
            espaciosRepositorio.save(espacio)

        } catch (e: Exception) {
            throw BusinessException("No existe el elemento seleccionado")
        }
    }

    fun actualizarPuntajePromedio(espacio: Espacio){
        espacio.puntajePromedio = espaciosRepositorio.obtenerPromedioEspacio(espacio.id!!)
        espaciosRepositorio.save(espacio)
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun eliminarEspacio(userId: Long, espacioId: Long){
        val espacio = this.espaciosRepositorio.findById(espacioId).get()
        this.validarEstaActivo(espacio)
        this.validarDuenioEspacio(userId, espacio)
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

    fun validarDuenioEspacio(userId: Long, espacio: Espacio){
        if( espacio.duenio?.id!!.toInt() != userId.toInt() ) throw NoEsDuenioDelEspacio("Un espacio solo puede ser eliminado por el dueño")
    }

    //TODO: Desde la query se puede validar que la fecha seleccionada esta ocupada. REVISAR
    fun estaOcupado(renta : Renta, fechaInicio: LocalDate, fechaFin: LocalDate) : Boolean {
        return return this.antesDelHorarioRentado(renta,fechaInicio) || this.despuesDelHorarioRentado(renta, fechaFin) || this.fueraDelHorarioRentado (renta, fechaInicio,fechaFin)
    }

    fun fueraDelHorarioRentado(renta : Renta, filtroFechaInicio: LocalDate, filtroFechaFin: LocalDate): Boolean{
        return(filtroFechaInicio < renta.fecha_desde) && (filtroFechaFin > renta.fecha_desde)
    }

    fun antesDelHorarioRentado(renta : Renta, filtroFechaInicio: LocalDate): Boolean {
        return (renta.fecha_desde!! <= filtroFechaInicio) && (renta.fecha_hasta!! >= filtroFechaInicio)
    }

    fun despuesDelHorarioRentado(renta : Renta, filtroFechaFin: LocalDate): Boolean {
        return (renta.fecha_desde!! <= filtroFechaFin) && (renta.fecha_hasta!! >= filtroFechaFin)
    }


}


