package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.controller.BusinessException
import ar.edu.unsam.pds.controller.dto.PuntajeComentarioDTO
import ar.edu.unsam.pds.controller.dto.ReservaDTO
import ar.edu.unsam.pds.domains.Comentario
import ar.edu.unsam.pds.domains.Reserva
import ar.edu.unsam.pds.exceptions.*
import ar.edu.unsam.pds.repositories.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@Service
class ReservaService {
    @Autowired
    lateinit var reservasRepo : ReservasRepositorio
    @Autowired
    lateinit var hospedajesRepo : HospedajeRepositorio
    @Autowired
    lateinit var usuariosRepo : UsuarioRepositorio
    @Autowired
    lateinit var hospedajeService : HospedajeService

    fun obtenerReserva(idReserva : Long) : Reserva {
        return reservasRepo.findById(idReserva).orElseThrow {throw NoExisteReserva("No se encontró el duenio indicado: $idReserva")}
    }

    fun sePuedeReservar(fechaInicio : LocalDate, fechaFin: LocalDate, idHospedaje: Long) : Boolean {
        var reservasSegunHospedaje = this.reservasRepo.obtenerReservasPorHospedaje(idHospedaje)
        return reservasSegunHospedaje.any { hospedajeService.estaOcupado(it,fechaInicio,fechaFin) }
    }
    @Transactional(Transactional.TxType.REQUIRED)
    fun realizarReserva(reservaDTO : ReservaDTO){

        if (this.sePuedeReservar(reservaDTO?.inicio!!,reservaDTO?.fin!!,reservaDTO.hospedaje?.id!!.toLong())){
            throw ErrorFechas("Las fechas seleccionadas no estan disponibles")
        }

        try {
            val nuevaReserva = Reserva(usuario = usuariosRepo.findById(reservaDTO.usuario?.id!!.toLong()).get(),
                hospedaje = hospedajesRepo.findById(reservaDTO.hospedaje.id.toLong()).get(),
                inicio = reservaDTO.inicio,
                fin = reservaDTO.fin,
                cantPasajeros = reservaDTO.cantPasajeros
            )
            nuevaReserva.realizarCompra()
            reservasRepo.save(nuevaReserva)
            this.usuariosRepo.save(nuevaReserva.usuario!!) //guarda el nuevo saldo del usuario en el repo de usuarios

        }
        catch (e: Exception) {
            throw BusinessException(e.message!!)
        }
    }
    @Transactional(Transactional.TxType.REQUIRED)
    fun calificarReserva(puntajeComentarioDTO: PuntajeComentarioDTO){
        val reserva = validarExistenciaReserva(puntajeComentarioDTO.idReserva)
        if(reserva.comentario == null){
            reserva.comentario = Comentario()
        }
        calificarReservaValidacion(reserva,puntajeComentarioDTO)
        reserva.comentario?.comentario = puntajeComentarioDTO.comentario
        reserva.comentario?.puntaje = puntajeComentarioDTO.puntaje
        reserva.comentario?.fechaPublicacion = LocalDate.now()
        hospedajeService.actualizarPuntajePromedio(reserva.hospedaje!!)
    }

    fun calificarReservaValidacion(reserva: Reserva, puntajeComentario : PuntajeComentarioDTO){
        validarQueNoTengaComentarioPuntaje(reserva)
        validarFechaReserva(reserva)
        validarPuntaje(puntajeComentario)
    }
    fun validarFechaReserva(reserva: Reserva){
        if(reserva.fin!!.isAfter(LocalDate.now())) throw FechaDeFinNoAlcanzada("No se puede calificar ya que la fecha de finalización de la reserva no ha pasado.")
    }
    fun validarQueNoTengaComentarioPuntaje(reserva :Reserva) {
        if (reserva.comentario?.comentario != null && reserva.comentario?.puntaje != null) throw ReservaYaTieneComentario("La reserva ya esta calificada")
    }
    fun validarExistenciaReserva(idReserva: Int): Reserva {
        val reserva = this.reservasRepo.findById(idReserva.toLong()).get()
        if (reserva == null) throw NoExisteReserva("No existe reserva con ID "+ idReserva)
        return reserva
    }

    fun validarPuntaje(puntajeComentario : PuntajeComentarioDTO) {
        if (puntajeComentario.puntaje!! < 0 || puntajeComentario.puntaje > 5) {
            throw CalificacionInvalida("El puntaje debe estar entre 0 y 5")
        }
    }

}