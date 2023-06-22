package ar.edu.unsam.pds.controller.dto

import ar.edu.unsam.pds.domains.*
import java.time.LocalDate
import java.util.*

data class EspacioDTO(
        val id: Int? = null,
        val titulo: String? = null,
        val descripcion: String? = null,
        val capacidad: Int? = null,
        val detalleAlojamiento: String? = null,
        val otrosAspectos: String? = null,
        val servicios: MutableList<Servicio>? = null,
        var id_usuario_duenio: UsuarioIdDTO? = null,
        val costo_hora: Double? = null,
        val costo_dia: Double? = null,
        val costo_mes: Double? = null,
        val ubicacion: String? = null,
        val usos : List<Uso>? = null,
        val pais: Pais? = null,
        var puntajePromedio: Int? = null,
        var comentarios: List<ComentarioEspacio>? = null,
        val estaActivo: Boolean? = null
)
data class comentarioEspacioDTO(
    var duenioNombre: String = "",
    var duenioApellido: String = "",
    val fechaPublicacion: LocalDate? = null,
    var comentario: String = ""
)

fun Espacio.toDTO() = EspacioDTO(id!!.toInt(),titulo,descripcion,capacidad,detalleAlojamiento,
    otrosAspectos,servicios,duenio?.toIdDTO(),costo_hora,costo_dia, costo_mes,ubicacion,uso,pais,puntajePromedio,comentarios, estaActivo)

data class EspacioIdDTO(
    val id: Int? = null,
)

fun Espacio.toIdDTO() = EspacioIdDTO(id!!.toInt())

data  class FiltroEspacio(
    val tipoRenta: String = "",
    val fechaInicio: LocalDate? = null,
    val fechaFin: LocalDate? = null,
    val ubicacion: String = "",
    val cantPasajeros: Int? = null,
    val dimensiones: Double? = null,
    val uso : List<String>? = null,
    val estrellas: List<Int>? = null,
    val numeroPagina: Int? = null,

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



