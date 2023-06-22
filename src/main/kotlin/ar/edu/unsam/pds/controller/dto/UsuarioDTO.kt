package ar.edu.unsam.pds.controller.dto

import ar.edu.unsam.pds.domains.Usuario
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

fun Usuario.toIdDTO() = UsuarioIdDTO(id!!.toInt())