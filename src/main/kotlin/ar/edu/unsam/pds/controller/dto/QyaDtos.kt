package ar.edu.unsam.pds.controller.dto

data class QyaPreguntaDto (
        var pregunta: String,
        var idUsuario: Long,
        var idEspacio: Long,
        ) {}

data class QyaRespuestaDto (
        var id_qya: Long,
        var respuesta: String,
        ) {}