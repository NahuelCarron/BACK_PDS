package ar.edu.unsam.phm.services

import ar.edu.unsam.phm.controller.BusinessException
import ar.edu.unsam.phm.controller.dto.HospedajeDTO
import ar.edu.unsam.phm.controller.dto.HospedajesCantPaginasDTO
import ar.edu.unsam.phm.controller.dto.toDTO
import ar.edu.unsam.phm.domains.ComentarioHospedaje
import ar.edu.unsam.phm.domains.Hospedaje
import ar.edu.unsam.phm.domains.Reserva
import ar.edu.unsam.phm.exceptions.ErrorFechas
import ar.edu.unsam.phm.exceptions.IdInvalido
import ar.edu.unsam.phm.exceptions.NoEsDuenioDelHospedaje
import ar.edu.unsam.phm.exceptions.elementoEliminado
import ar.edu.unsam.phm.repositories.ComentarioRepositorio
import ar.edu.unsam.phm.repositories.HospedajeRepositorio
import ar.edu.unsam.phm.repositories.ReservasRepositorio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional
import kotlin.math.*

@Service
class HospedajeService {
    @Autowired
    lateinit var hospedajesRepo: HospedajeRepositorio
    @Autowired
    lateinit var reservasRepo: ReservasRepositorio
    @Autowired
    lateinit var comentariosRepo: ComentarioRepositorio

    var cantidadPorPagina = 12

    @Transactional(Transactional.TxType.NEVER)
    fun obtenerHospedaje(id : Long ) : HospedajeDTO? {
        try{
            var hospedaje = hospedajesRepo.findById(id).get()
            hospedaje.comentarios = this.obtenerUltimos3Comentarios(hospedaje)
            return hospedaje.toDTO()
        }catch (e: Exception){
             throw BusinessException("No existe el elemento seleccionado")
        }

    }

    @Transactional(Transactional.TxType.NEVER)
    fun getHospedajes(
            ubicacion: String?,
            fechaInicio: LocalDate?,
            fechaFin: LocalDate?,
            maxPasajeros: Int?,
            numeroPagina: Int?,
            puntajes: List<Int>?
    ) : HospedajesCantPaginasDTO {

        if (fechaInicio!!.isAfter(fechaFin)){
            println("pasa por aqui")
            throw ErrorFechas("Error al seleccionar las fechas")
        }
        var puntajesABuscar : List<Int>
        puntajesABuscar = if (puntajes!!.size == 1 && puntajes?.get(0) == 1) {
            listOf(-1,0,1,2,3,4,5)
        } else puntajes!!

        var resultado: List<Hospedaje> = this.hospedajesRepo.find(
                ubicacion,
                fechaInicio,
                fechaFin,
                maxPasajeros,
                puntajesABuscar
        )
        val cantidadPaginas = this.cantidadDePaginas(resultado.size)
        resultado = filtrarPorPagina(resultado, numeroPagina)
        return HospedajesCantPaginasDTO(resultado.map { it.toDTO() }, cantidadPaginas)
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun modificarHospedaje(id: Long, hospedajeBody : Hospedaje) {
        try{
            if (id == null) {
                throw IdInvalido("No se puede actualizar un objeto sin id")
            }
            var hospedaje = this.hospedajesRepo.findById(id).get()
            this.validarEstaActivo(hospedaje)
            hospedaje.nombre = hospedajeBody.nombre
            hospedaje.descripcion = hospedajeBody.descripcion
            hospedaje.otrosAspectos = hospedajeBody.otrosAspectos
            hospedaje.detalleAlojamiento = hospedajeBody.detalleAlojamiento
            hospedaje.ubicacion = hospedajeBody.ubicacion
            hospedaje.capacidad = hospedajeBody.capacidad
            hospedaje.habitaciones = hospedajeBody.habitaciones
            hospedaje.banios = hospedajeBody.banios
            hospedaje.costoBase = hospedajeBody.costoBase
            hospedaje.hospedajeTipo = hospedajeBody.hospedajeTipo
            hospedaje.servicios = hospedajeBody.servicios
            hospedajesRepo.save(hospedaje)

        } catch (e: Exception) {
            throw BusinessException("No existe el elemento seleccionado")
        }
    }

    fun actualizarPuntajePromedio(hospedaje: Hospedaje){
        hospedaje.puntajePromedio = hospedajesRepo.obtenerPromedioHospedaje(hospedaje.id!!)
        hospedajesRepo.save(hospedaje)
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun eliminarHospedaje(userId: Long, hospedajeId: Long){
        val hospedaje = this.hospedajesRepo.findById(hospedajeId).get()
        this.validarEstaActivo(hospedaje)
        this.validarDuenioHospedaje(userId, hospedaje)
        hospedaje.estaActivo = false
        hospedajesRepo.save(hospedaje)
    }

    fun validarEstaActivo(hospedaje: Hospedaje){
        if(hospedaje.estaActivo != true){
            throw elementoEliminado("El elemento está eliminado.")
        }
    }
    fun cantidadDePaginas(cantidadHospedajes : Int) : Int = ceil(cantidadHospedajes.toDouble().div(cantidadPorPagina)).toInt()


    fun filtrarPorPagina(hospedajes: List<Hospedaje>, numeroPagina: Int?): List<Hospedaje> {
        var resultado = hospedajes
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

    fun crearHospedaje(nuevoHospedaje : Hospedaje){
        Hospedaje.validarDatos(nuevoHospedaje)
        hospedajesRepo.save(nuevoHospedaje)
    }

    fun promedioPuntaje(idHospedaje: Long): Int{
        return this.hospedajesRepo.obtenerPromedioHospedaje(idHospedaje)
    }
    fun obtenerUltimos3Comentarios(hospedaje: Hospedaje): List<ComentarioHospedaje> {
        return this.comentariosRepo.obtenerComentariosOrdenados(hospedaje.id!!).take(3)
    }

    fun validarDuenioHospedaje(userId: Long, hospedaje: Hospedaje){
        if( hospedaje.duenio?.id!!.toInt() != userId.toInt() ) throw NoEsDuenioDelHospedaje("Un hospedaje solo puede ser eliminado por el dueño")
    }

    //TODO: Desde la query se puede validar que la fecha seleccionada esta ocupada. REVISAR
    fun estaOcupado(reserva : Reserva, fechaInicio: LocalDate, fechaFin: LocalDate) : Boolean {
        return return this.antesDelHorarioReservado(reserva,fechaInicio) || this.despuesDelHorarioReservado(reserva, fechaFin) || this.fueraDelHorarioReservado (reserva, fechaInicio,fechaFin)
    }

    fun fueraDelHorarioReservado(reserva : Reserva, filtroFechaInicio: LocalDate, filtroFechaFin: LocalDate): Boolean{
        return(filtroFechaInicio < reserva.inicio) && (filtroFechaFin > reserva.inicio)
    }

    fun antesDelHorarioReservado(reserva : Reserva, filtroFechaInicio: LocalDate): Boolean {
        return (reserva.inicio!! <= filtroFechaInicio) && (reserva.fin!! >= filtroFechaInicio)
    }

    fun despuesDelHorarioReservado(reserva : Reserva, filtroFechaFin: LocalDate): Boolean {
        return (reserva.inicio!! <= filtroFechaFin) && (reserva.fin!! >= filtroFechaFin)
    }


}



