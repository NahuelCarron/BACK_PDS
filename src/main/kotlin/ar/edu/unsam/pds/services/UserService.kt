package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.controller.dto.EspacioUsuarioDTO
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
    lateinit var rentasRepositorio: RentasRepositorio
    @Autowired
    lateinit var espaciosRepo: EspacioRepositorio

    @Transactional(Transactional.TxType.NEVER)
    fun getUserInfo(userId: Long): Usuario {
        return this.usuarioRepositorio.findById(userId).get()
    }

    @Transactional(Transactional.TxType.NEVER)
    fun getUserComentarios(userId: Long): List<ComentarioEspacio> {
        var rentas = this.rentasRepositorio.obtenerComentariosPorUsuario(userId)
        return getComentarios(rentas)
    }

    fun getComentarios(rentas : List<Renta>): List<ComentarioEspacio>{
        return rentas.map{
            ComentarioEspacio(
                rentaId = it.id,
                duenioNombre = it.espacio?.duenio?.nombre,
                duenioApellido = it.espacio?.duenio?.apellido,
                duenioProfileUrl = it.espacio?.duenio?.fotoPerfil,
                espacioNombre = it.espacio?.titulo,
                espacioPais = it.espacio?.pais,
                comentario = "", // TODO: fix hardcodeo
                cantidadEstrellas = 0, // TODO: fix hardcodeo
            )
        }
    }

    @Transactional(Transactional.TxType.NEVER)
    fun getUserRentas(userId: Long): List<RentaUsuarioDTO> {
        // TODO: implementar
        return listOf()
    }

    @Transactional(Transactional.TxType.NEVER)
    fun getUserEspacios(userId: Long): List<EspacioUsuarioDTO> {
        var resultado = this.espaciosRepo.obtenerEspaciosPorUsuario(userId)
        return resultado.map{ EspacioUsuarioDTO(
            id = it.id, nombre = it.titulo,
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

    @Transactional(Transactional.TxType.REQUIRED)
    fun crearUsuario(usuario: Usuario){
        this.usuarioRepositorio.save(usuario)
    }


}