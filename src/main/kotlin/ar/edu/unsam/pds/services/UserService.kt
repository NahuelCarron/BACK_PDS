package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.controller.dto.HospedajeUsuarioDTO
import ar.edu.unsam.pds.controller.dto.RentaUsuarioDTO
import ar.edu.unsam.pds.domains.*
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
    lateinit var reservasRepositorio: RentasRepositorio
    @Autowired
    lateinit var hospedajesRepo: HospedajeRepositorio

    @Transactional(Transactional.TxType.NEVER)
    fun getUserInfo(userId: Long): Usuario {
        return this.usuarioRepositorio.findById(userId).get()
    }

    @Transactional(Transactional.TxType.NEVER)
    fun getUserComentarios(userId: Long): List<ComentarioEspacio> {
        var reservas = this.reservasRepositorio.obtenerComentariosPorUsuario(userId)
        return getComentarios(reservas)
    }

    fun getComentarios(reservas : List<Renta>): List<ComentarioEspacio>{
        return reservas.map{
            ComentarioEspacio(
                reservaId = it.id_renta,
                duenioNombre = it.espacio?.duenio?.nombre,
                duenioApellido = it.espacio?.duenio?.apellido,
                duenioProfileUrl = it.espacio?.duenio?.foto_perfil,
                hospedajeNombre = it.espacio?.titulo,
                hospedajePais = it.espacio?.pais,
                comentario = "", // TODO: fix hardcodeo
                cantidadEstrellas = 0, // TODO: fix hardcodeo
            )
        }
    }

    @Transactional(Transactional.TxType.NEVER)
    fun getUserReservas(userId: Long): List<RentaUsuarioDTO> {
        // TODO: implementar
        return listOf()
    }

    @Transactional(Transactional.TxType.NEVER)
    fun getUserHospedajes(userId: Long): List<HospedajeUsuarioDTO> {
        var resultado = this.hospedajesRepo.obtenerHospedajesPorUsuario(userId)
        return resultado.map{ HospedajeUsuarioDTO(
            id = it.id_espacio, nombre = it.titulo,
            descripcion = it.descripcion, costoBase = it.costo_hora,
            ubicacion = it.ubicacion, puntaje= it.puntajePromedio ) }
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