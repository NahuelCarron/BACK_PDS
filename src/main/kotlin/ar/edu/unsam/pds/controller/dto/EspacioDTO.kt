package ar.edu.unsam.pds.controller.dto

import ar.edu.unsam.pds.domains.*
import java.time.LocalDate

data class EspacioDTO(
        val id: Int? = null,
        val titulo: String? = null,
        val descripcion: String? = null,
        val detalleAlojamiento: String? = null,
        val servicios: MutableList<Servicio>? = null,
        var duenio: UsuarioIdDTO? = null,
        val costo_hora: Double? = null,
        val ubicacion: String? = null,
        val pais: Pais? = null,
        var puntajePromedio: Int? = null,
        var comentarios: List<ComentarioEspacio>? = listOf(),
        val estaActivo: Boolean? = null,
        val qya: List<Qya>? = listOf()
)
data class comentarioEspacioDTO(
    var duenioNombre: String = "",
    var duenioApellido: String = "",
    val fechaPublicacion: LocalDate? = null,
    var comentario: String = ""
)

fun Espacio.toDTO() = EspacioDTO(id!!.toInt(),titulo,descripcion,detalleAlojamiento
        , servicios,duenio?.toIdDTO(),costo_hora,ubicacion,pais,puntajePromedio,comentarios, estaActivo)


// val pais: Pais? = null,
// var puntajePromedio: Int? = null,
// var comentarios: List<ComentarioEspacio>? = listOf(),
// val estaActivo: Boolean? = null,
// val qya: List<Qya>? = listOf()


data class EspacioIdDTO(
    val id: Int? = null,
)

fun Espacio.toIdDTO() = EspacioIdDTO(id!!.toInt())

data  class FiltroEspacio(
        val tiempoRenta: TiempoRenta? = null,
        val ubicacion: String = "",
        val fechaInicio: LocalDate? = null,
        val fechaFin: LocalDate? = null,
        val dimensiones: Double? = null,
        val numeroPagina: Int? = null,
        val estrellas: List<Int>? = null,
        val uso: String? = null,
        )

data class EspaciosCantPaginasDTO(
        val espacios: List<EspacioDTO>? = null,
        val cantidadPaginas : Int? = null
)
data class EspacioUsuarioDTO(
    val id: Long? = null,
    val nombre: String? = null,
    val descripcion: String? = null,
    val ubicacion: String? = null,
    var puntajePromedio: Int? = null,
    var costo_hora: Double? = null,
    var costo_dia: Double? = null,
    var costo_mes: Double? = null,

)
data class EspacioRentaDTO(
    val espacio: Espacio? = null,
    val fecha_desde: LocalDate? = null,
    val fecha_hasta: LocalDate? = null,
    val costoTotal: Double? = null,
    val comentario: Comentario? = null
)



