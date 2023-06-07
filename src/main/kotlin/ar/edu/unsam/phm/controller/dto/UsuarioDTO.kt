package ar.edu.unsam.phm.controller.dto

import ar.edu.unsam.phm.domains.Pais
import ar.edu.unsam.phm.domains.Usuario
import java.time.LocalDate

data class UsuarioDTO(
    val id: Int? = null,
    val username: String? = null,
    val password: String? = null,
    val nombre: String? = null,
    val apellido: String? = null,
    var fechaNacimiento: LocalDate? = null,
    var pais: String? = null,
    var saldo: Double? = null,
    val profileUrl: String? = null,
    var amigos: MutableList<UsuarioIdDTO>? = null,
)

data class UsuarioIdDTO(
    val id: Int? = null,
)
data class PosibleAmigo(
    val id: Long? = null,
    val nombre: String? = null,
    val apellido: String? = null,
)
data class AmigoDTO(
    val id: Long? = null,
    val nombre: String? = null,
    val apellido: String? = null,
    var profileUrl: String? = null,
    val pais: Pais? = null
)

fun Usuario.toIdDTO() = UsuarioIdDTO(id!!.toInt())