package ar.edu.unsam.pds.controller.dto

import ar.edu.unsam.pds.domains.Espacio
import java.time.LocalDate

data class RentaDTO (
        val usuario: UsuarioIdDTO? = null,
        val espacio: EspacioIdDTO? = null,
        val inicio: LocalDate? = null,
        val fin: LocalDate? = null,
        val cantPasajeros: Int? = null,
        var costoTotal: Double? = null,
)
data class PuntajeComentarioDTO(
        val idRenta: Int,
        val puntaje: Int? = null,
        var comentario: String? = null,
)
data class RentaUsuarioDTO (
        val id: Long? = null,
        val inicio: LocalDate? = null,
        val fin: LocalDate? = null,
        val puntaje: Int? = null,
        val cantPasajeros: Int? = null,
        var costoTotal: Double? = null,

        )