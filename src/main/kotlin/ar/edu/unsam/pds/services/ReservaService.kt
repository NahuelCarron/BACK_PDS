package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.controller.BusinessException
import ar.edu.unsam.pds.controller.dto.RentaDTO
import ar.edu.unsam.pds.domains.Renta
import ar.edu.unsam.pds.exceptions.*
import ar.edu.unsam.pds.repositories.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@Service
class ReservaService {
    @Autowired
    lateinit var reservasRepo : RentasRepositorio
    @Autowired
    lateinit var hospedajesRepo : HospedajeRepositorio
    @Autowired
    lateinit var usuariosRepo : UsuarioRepositorio
    @Autowired
    lateinit var hospedajeService : HospedajeService

    fun sePuedeReservar(fechaInicio : LocalDate, fechaFin: LocalDate, idHospedaje: Long) : Boolean {
        var reservasSegunHospedaje = this.reservasRepo.obtenerReservasPorHospedaje(idHospedaje)
        return reservasSegunHospedaje.any { hospedajeService.estaOcupado(it,fechaInicio,fechaFin) }
    }
    @Transactional(Transactional.TxType.REQUIRED)
    fun realizarReserva(reservaDTO : RentaDTO){

        if (this.sePuedeReservar(reservaDTO?.inicio!!,reservaDTO?.fin!!,reservaDTO.hospedaje?.id!!.toLong())){
            throw ErrorFechas("Las fechas seleccionadas no estan disponibles")
        }

        try {
            val nuevaReserva = Renta(usuario = usuariosRepo.findById(reservaDTO.usuario?.id!!.toLong()).get(),
                espacio = hospedajesRepo.findById(reservaDTO.hospedaje.id.toLong()).get(),
                fecha_desde = reservaDTO.inicio,
                fecha_hasta = reservaDTO.fin,
            )
            nuevaReserva.realizarCompra()
            reservasRepo.save(nuevaReserva)
            this.usuariosRepo.save(nuevaReserva.usuario!!) //guarda el nuevo saldo del usuario en el repo de usuarios

        }
        catch (e: Exception) {
            throw BusinessException(e.message!!)
        }
    }
}