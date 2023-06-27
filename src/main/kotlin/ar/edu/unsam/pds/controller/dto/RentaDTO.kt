package ar.edu.unsam.pds.controller.dto

import ar.edu.unsam.pds.domains.Espacio
import ar.edu.unsam.pds.domains.MetodoPago
import java.time.LocalDate
import java.util.*

data class RentaDTO (
        val usuario: UsuarioIdDTO? = null,
        val espacio: EspacioIdDTO? = null,
        val inicio: LocalDate? = null,
        val fin: LocalDate? = null,
        var costoTotal: Double? = null,
        var metodoDePago: MetodoPago? = null
)
data class PuntajeComentarioDTO(
        val comentario: String? = null,
        val puntaje: Int? = null,
        var fechaPublicacion: LocalDate? = null,
        val idRenta: Long?= null,
        val tipoComentario: String? = null,
        val id: Int? = null
)
data class RentaUsuarioDTO (
        val id: Long? = null,
        val inicio: LocalDate? = null,
        val fin: LocalDate? = null,
        val puntaje: Int? = null,
        val cantPasajeros: Int? = null,
        var costoTotal: Double? = null,

        )