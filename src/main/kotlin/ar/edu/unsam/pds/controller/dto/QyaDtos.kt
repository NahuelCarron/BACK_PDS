package ar.edu.unsam.pds.controller.dto

import ar.edu.unsam.pds.domains.Espacio
import ar.edu.unsam.pds.domains.Qya
import ar.edu.unsam.pds.domains.Usuario
import java.time.LocalDate
import java.util.*

data class QyaPreguntaDto (
        var pregunta: String,
        var idUsuario: Long,
        var idEspacio: Long,
        ) {}

data class QyaRespuestaDto (
        var id_qya: Long,
        var respuesta: String,
        ) {}

data class QyaEspacio(
        var idQya : Long,
        var pregunta: String,
        var nombreUsuario: String,
        var respuesta: String?,
        var fechaPublicacion: LocalDate
)