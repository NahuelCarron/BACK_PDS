package ar.edu.unsam.pds.controller.dto

import ar.edu.unsam.pds.domains.*
import java.time.LocalDate

data class HospedajeDTO(
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
        val hospedajeTipo: TipoHospedaje? = null,
        var puntaje: Int? = null,
        var comentarios: List<ComentarioEspacio>? = null,
        val estaActivo: Boolean? = null
)
data class comentarioHospedajeDTO(
    var duenioNombre: String = "",
    var duenioApellido: String = "",
    val fechaPublicacion: LocalDate? = null,
    var comentario: String = ""
)

fun Espacio.toDTO() = HospedajeDTO(id_espacio!!.toInt(),titulo,descripcion,capacidad,habitaciones,banios,detalleAlojamiento,
    otrosAspectos,servicios,duenio?.toIdDTO(),costo_hora,ubicacion,pais,hospedajeTipo,puntajePromedio,comentarios, estaActivo)

data class HospedajeIdDTO(
    val id: Int? = null,
)

fun Espacio.toIdDTO() = HospedajeIdDTO(id_espacio!!.toInt())

data  class FiltroHospedaje(
    val ubicacion: String = "",
    val fechaInicio: LocalDate? = null,
    val fechaFin: LocalDate? = null,
    val capacidad: Int? = null,
    val numeroPagina: Int? = null,
    val puntajes: List<Int>? = null
)
data class HospedajesCantPaginasDTO(
    val hospedajes: List<HospedajeDTO>? = null,
    val cantidadPaginas : Int? = null
)
data class HospedajeUsuarioDTO(
    val id: Long? = null,
    val nombre: String? = null,
    val descripcion: String? = null,
    val costoBase: Double? = null,
    val ubicacion: String? = null,
    var puntaje: Int? = null,

)


