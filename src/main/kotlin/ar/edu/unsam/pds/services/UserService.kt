package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.controller.dto.EspacioRentaDTO
import ar.edu.unsam.pds.controller.dto.EspacioUsuarioDTO
import ar.edu.unsam.pds.controller.dto.RentaDTO
import ar.edu.unsam.pds.controller.dto.RentaUsuarioDTO
import ar.edu.unsam.pds.domains.*
import ar.edu.unsam.pds.exceptions.BadRequestException
import ar.edu.unsam.pds.exceptions.ErrorFechaNacimiento
import ar.edu.unsam.pds.exceptions.ErrorFechas
import ar.edu.unsam.pds.exceptions.ErrorUsernamePassword
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
        var res =  rentasRepositorio.obtenerRentasPorUsuario(userId)
        res = res.sortedBy { it.comentario != null }
        return res
    }

    @Transactional(Transactional.TxType.NEVER)
    fun getUserEspacios(userId: Long): List<Espacio> {
        var resultado = this.espaciosRepo.obtenerEspaciosPorUsuario(userId)
        return resultado
    }
    @Transactional(Transactional.TxType.NEVER)
    fun getUserEspaciosRentadosPorOtros(userId: Long): List<EspacioRentaDTO> {
        var resultado = this.rentasRepositorio.obtenerRentasDeEspaciosDelUsuario(userId)
        resultado = resultado.sortedBy { it.comentario != null }
        return resultado
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun actualizarInformacion(userId: Long, usuarioAct: Usuario){
        validarUsuario(usuarioAct, true)
        val usuario = this.usuarioRepositorio.findById(userId).get()
        usuario.nombre = usuarioAct.nombre
        usuario.apellido = usuarioAct.apellido
        usuario.fechaNacimiento = usuarioAct.fechaNacimiento
        usuario.pais = usuarioAct.pais
        usuario.dni = usuarioAct.dni
        this.usuarioRepositorio.save(usuario)
    }
    fun actualizarUsuarioYContrasenia(userId: Long, username: String, password: String){
        val usuario = this.usuarioRepositorio.findById(userId).get()
        validarUsername(username, true, usuario.username!!)
        validarPassword(password)
        usuario.username = username
        usuario.contrasenia = password
        this.usuarioRepositorio.save(usuario)
    }
    fun validarPassword(password : String){
        if(password.length <= 7){
            throw ErrorUsernamePassword("La contraseña debe tener al menos 8 caracteres.")
        }
        if(!contieneNumero(password)){
            throw ErrorUsernamePassword("La contraseña debe tener al menos un número")
        }
        if(!contieneLetra(password)){
            throw ErrorUsernamePassword("La contraseña debe tener al menos una letra")
        }

    }
    fun contieneNumero(texto: String): Boolean {
        val patron = Regex("\\d")
        return patron.containsMatchIn(texto)
    }
    fun contieneLetra(texto: String): Boolean {
        val patron = Regex("[a-zA-Z]")
        return patron.containsMatchIn(texto)
    }
    fun validarUsername(username: String, edicion: Boolean, usernameViejo : String){
        var listaUsers = this.usuarioRepositorio.obtenerNombresUsuario()
        if(edicion) listaUsers = listaUsers.filter { it != usernameViejo}
        if( listaUsers.contains(username)){
            throw ErrorUsernamePassword("El nombre de usuario ya existe")
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    fun crearUsuario(usuario: Usuario){
        validarUsuario(usuario, false)
        this.usuarioRepositorio.save(usuario)
    }
    fun validarUsuario(usuario: Usuario, edicion: Boolean){
        if (usuario.fechaNacimiento!! >= LocalDate.now()) {
            throw ErrorFechas("Fecha seleccionada inválida")
        }
        if(!edicion){
            validarUsername(usuario.username!!, false, "")
            validarPassword(usuario.contrasenia!!)
        }


    }


}