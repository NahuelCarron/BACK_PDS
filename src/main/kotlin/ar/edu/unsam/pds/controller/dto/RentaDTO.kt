package ar.edu.unsam.pds.controller.dto

import ar.edu.unsam.pds.domains.Espacio
import java.time.LocalDate

data class RentaDTO (
    val usuario: UsuarioIdDTO? = null,
    val hospedaje: HospedajeIdDTO? = null,
    val inicio: LocalDate? = null,
    val fin: LocalDate? = null,
    val cantPasajeros: Int? = null,
    var costoTotal: Double? = null,
)
data class PuntajeComentarioDTO(
    val idReserva: Int,
    val puntaje: Int? = null,
    var comentario: String? = null,
)
data class RentaUsuarioDTO (
        val id: Long? = null,
        val hospedaje: Espacio? = null,
        val inicio: LocalDate? = null,
        val fin: LocalDate? = null,
        val puntaje: Int? = null,
        val cantPasajeros: Int? = null,
        var costoTotal: Double? = null,

        )
