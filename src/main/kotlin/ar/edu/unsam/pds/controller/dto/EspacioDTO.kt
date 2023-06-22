package ar.edu.unsam.pds.controller.dto

import ar.edu.unsam.pds.domains.*
import java.time.LocalDate

data class EspacioDTO(
        val id: Int? = null,
        val nombre: String? = null,
        val descripcion: String? = null,
        val capacidad: Int? = null,
        val habitaciones: Int? = null,
        val banios: Int? = null,
        val detalleAlojamiento: String? = null,
        val otrosAspectos: String? = null,
        val servicios: MutableList<Servicio>? = null,
        var id_usuario_duenio: UsuarioIdDTO? = null,
        val costoBase: Double? = null,
        val ubicacion: String? = null,
        val pais: Pais? = null,
        var puntaje: Int? = null,
        var comentarios: List<ComentarioEspacio>? = null,
        val estaActivo: Boolean? = null
)
data class comentarioEspacioDTO(
    var duenioNombre: String = "",
    var duenioApellido: String = "",
    val fechaPublicacion: LocalDate? = null,
    var comentario: String = ""
)

fun Espacio.toDTO() = EspacioDTO(id!!.toInt(),titulo,descripcion,capacidad,habitaciones,banios,detalleAlojamiento,
    otrosAspectos,servicios,duenio?.toIdDTO(),costo_hora,ubicacion,pais,puntajePromedio,comentarios, estaActivo)

data class EspacioIdDTO(
    val id: Int? = null,
)

fun Espacio.toIdDTO() = EspacioIdDTO(id!!.toInt())

data  class FiltroEspacio(
    val ubicacion: String = "",
    val fechaInicio: LocalDate? = null,
    val fechaFin: LocalDate? = null,
    val capacidad: Int? = null,
    val numeroPagina: Int? = null,
    val puntajes: List<Int>? = null
)
data class EspaciosCantPaginasDTO(
        val espacios: List<EspacioDTO>? = null,
        val cantidadPaginas : Int? = null
)
data class EspacioUsuarioDTO(
    val id: Long? = null,
    val nombre: String? = null,
    val descripcion: String? = null,
    val costoBase: Double? = null,
    val ubicacion: String? = null,
    var puntaje: Int? = null,

)


