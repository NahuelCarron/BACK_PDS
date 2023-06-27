package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.controller.BusinessException
import ar.edu.unsam.pds.controller.dto.PuntajeComentarioDTO
import ar.edu.unsam.pds.controller.dto.RentaDTO
import ar.edu.unsam.pds.domains.Comentario
import ar.edu.unsam.pds.domains.MetodoPago
import ar.edu.unsam.pds.domains.Renta
import ar.edu.unsam.pds.exceptions.*
import ar.edu.unsam.pds.repositories.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@Service
class RentasService {
    @Autowired
    lateinit var rentasRepositorio : RentasRepositorio
    @Autowired
    lateinit var espaciosRepository : EspacioRepositorio
    @Autowired
    lateinit var usuariosRepo : UsuarioRepositorio
    @Autowired
    lateinit var espaciosService : EspacioService
    @Autowired
    lateinit var comentariosRepo : ComentarioRepositorio
    fun calificarRenta(comentario: PuntajeComentarioDTO){
        val renta = rentasRepositorio.findById(comentario.idRenta!!).get()
        val comentario = Comentario(comentario.comentario,comentario.puntaje, comentario.fechaPublicacion, renta, comentario.tipoComentario )
        comentariosRepo.save(comentario)

        val espacio = espaciosRepository.findById(renta.espacio!!.id!!).get()
        val puntajeProm = rentasRepositorio.obtenerPromedioComentarios(espacio.id!!)
        espacio.puntajePromedio = puntajeProm
        espaciosRepository.save(espacio)
    }
    fun sePuedeRentar(fechaInicio : LocalDate, fechaFin: LocalDate, idEspacio: Long) : Boolean {
        var rentasSegunEspacio = this.rentasRepositorio.obtenerRentasPorEspacio(idEspacio)
        return rentasSegunEspacio.any { espaciosService.estaOcupado(it,fechaInicio,fechaFin) }
    }
    @Transactional(Transactional.TxType.REQUIRED)
    fun realizarRenta(renta : RentaDTO){
        if (this.sePuedeRentar(renta?.inicio!!,renta?.fin!!,renta.espacio?.id!!)){
            throw ErrorFechas("Las fechas seleccionadas no estan disponibles")
        }
        try {
            val usuario = this.usuariosRepo.findById(renta.usuario!!.id!!).get()
            val espacio = this.espaciosRepository.findById(renta.espacio!!.id!!).get()
            val nueva = Renta(usuario, espacio, renta.inicio, renta.fin, renta.costoTotal, renta.metodoDePago)
            nueva.validarFechas()
            rentasRepositorio.save(nueva)
        }
        catch (e: Exception) {
            throw BusinessException(e.message!!)
        }
    }
}