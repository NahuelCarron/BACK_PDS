package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.controller.dto.EspacioRentaDTO
import ar.edu.unsam.pds.controller.dto.EspacioUsuarioDTO
import ar.edu.unsam.pds.controller.dto.RentaDTO
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
    fun getUserRentas(userId: Long): List<EspacioRentaDTO> {
        return rentasRepositorio.obtenerRentasPorUsuario(userId)
    }

    @Transactional(Transactional.TxType.NEVER)
    fun getUserEspacios(userId: Long): List<Espacio> {
        var resultado = this.espaciosRepo.obtenerEspaciosPorUsuario(userId)
        return resultado
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