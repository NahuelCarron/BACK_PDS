package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.controller.dto.AmigoDTO
import ar.edu.unsam.pds.controller.dto.HospedajeUsuarioDTO
import ar.edu.unsam.pds.controller.dto.PosibleAmigo
import ar.edu.unsam.pds.controller.dto.ReservaUsuarioDTO
import ar.edu.unsam.pds.domains.*
import ar.edu.unsam.pds.exceptions.ErrorAlCargarSaldo
import ar.edu.unsam.pds.exceptions.ErrorFechaNacimiento
import ar.edu.unsam.pds.repositories.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*
import javax.transaction.Transactional

@Service
class UserService {

    @Autowired
    lateinit var usuarioRepositorio: UsuarioRepositorio
    @Autowired
    lateinit var reservasRepositorio: ReservasRepositorio
    @Autowired
    lateinit var amigosRepositorio: AmigosRepositorio
    @Autowired
    lateinit var hospedajeService: HospedajeService
    @Autowired
    lateinit var reservaService: ReservaService
    @Autowired
    lateinit var hospedajesRepo: HospedajeRepositorio

    @Transactional(Transactional.TxType.NEVER)
    fun getUserInfo(userId: Long): Usuario {
        return this.usuarioRepositorio.findById(userId).get()
    }
    @Transactional(Transactional.TxType.NEVER)
    fun getUserAmigos(userId: Long): List<AmigoDTO> {
        return this.amigosRepositorio.getUserAmigos(userId)
    }
    @Transactional(Transactional.TxType.NEVER)
    fun getUserComentarios(userId: Long): List<ComentarioHospedaje> {
        var reservas = this.reservasRepositorio.obtenerComentariosPorUsuario(userId)
        return getComentarios(reservas)
    }
    fun getComentarios(reservas : List<Reserva>): List<ComentarioHospedaje>{
        return reservas.map{
            ComentarioHospedaje(
                reservaId = it.id,
                duenioNombre = it.hospedaje?.duenio?.nombre,
                duenioApellido = it.hospedaje?.duenio?.apellido,
                duenioProfileUrl = it.hospedaje?.duenio?.profileUrl,
                hospedajeNombre = it.hospedaje?.nombre,
                hospedajePais = it.hospedaje?.pais,
                comentario = it.comentario?.comentario,
                cantidadEstrellas = it.comentario?.puntaje,
            )
        }
    }
    @Transactional(Transactional.TxType.NEVER)
    fun getUserReservas(userId: Long): List<ReservaUsuarioDTO> {
        return this.reservasRepositorio.obtenerReservasPorUsuario(userId)
    }
    @Transactional(Transactional.TxType.NEVER)
    fun getUserHospedajes(userId: Long): List<HospedajeUsuarioDTO> {
        var resultado = this.hospedajesRepo.obtenerHospedajesPorUsuario(userId)
        return resultado.map{ HospedajeUsuarioDTO(
            id = it.id, nombre = it.nombre,
            descripcion = it.descripcion, costoBase = it.costoBase,
            ubicacion = it.ubicacion, puntaje= it.puntajePromedio ) }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun eliminarComentario(reservaId: Int) {
        val reserva = reservaService.obtenerReserva(reservaId.toLong())
        reserva.comentario = null
        this.reservasRepositorio.save(reserva)
        this.hospedajeService.actualizarPuntajePromedio(reserva.hospedaje!!)
    }

    fun agregarAmigo(userId: Int, nuevoAmigoId: Int){
        val usuario = this.usuarioRepositorio.findById(userId.toLong()).get()
        val nuevoAmigo = this.usuarioRepositorio.findById(nuevoAmigoId.toLong()).get()
        this.amigosRepositorio.save(RelacionAmigo(usuario=usuario, amigo=nuevoAmigo))
    }

    fun posiblesAmigos(userId: Long): List<PosibleAmigo>{
        return this.amigosRepositorio.getPosiblesAmigos(userId)
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun eliminarAmigo(userId: Int, amigoId: Int) {
        // Note: podria usarse el metodo delete() pero seria mas quilombo ya que debemos buscar la relacion, etc
        this.amigosRepositorio.eliminarAmigo(userId.toLong(), amigoId.toLong())
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun actualizarSaldo(userId: Long, nuevoSaldo: Double){
        if(nuevoSaldo <= 0.0){
            throw ErrorAlCargarSaldo("Ha ingresado un valor de saldo incorrecto")
        }
        if(nuevoSaldo > 100000.0){
            throw ErrorAlCargarSaldo("Ha excedido al valor maximo de carga")
        }
        this.usuarioRepositorio.actualizarSaldo(nuevoSaldo, userId)
    }
    @Transactional(Transactional.TxType.REQUIRED)
    fun actualizarFecha(userId: Long, fecha: LocalDate){
        if(fecha >= LocalDate.now()){
            throw ErrorFechaNacimiento("La fecha no debe ser superior al actual")
        }
        this.usuarioRepositorio.actualizarFechaNacimiento(fecha, userId)
    }
    @Transactional(Transactional.TxType.REQUIRED)
    fun actualizarPais(userId: Long, pais: String){
        this.usuarioRepositorio.actualizarPais(Pais.valueOf(pais), userId)
    }


}