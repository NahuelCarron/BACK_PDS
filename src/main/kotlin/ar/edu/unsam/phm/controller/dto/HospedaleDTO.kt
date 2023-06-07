package ar.edu.unsam.phm.controller.dto

import ar.edu.unsam.phm.domains.*
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
    var duenio: UsuarioIdDTO? = null,
    val costoBase: Double? = null,
    val ubicacion: String? = null,
    val pais: Pais? = null,
    val hospedajeTipo: TipoHospedaje? = null,
    var puntaje: Int? = null,
    var comentarios: List<ComentarioHospedaje>? = null,
    val estaActivo: Boolean? = null
)
data class comentarioHospedajeDTO(
    var duenioNombre: String = "",
    var duenioApellido: String = "",
    val fechaPublicacion: LocalDate? = null,
    var comentario: String = ""
)

fun Hospedaje.toDTO() = HospedajeDTO(id!!.toInt(),nombre,descripcion,capacidad,habitaciones,banios,detalleAlojamiento,
    otrosAspectos,servicios,duenio?.toIdDTO(),costoBase,ubicacion,pais,hospedajeTipo,puntajePromedio,comentarios, estaActivo)

data class HospedajeIdDTO(
    val id: Int? = null,
)

fun Hospedaje.toIdDTO() = HospedajeIdDTO(id!!.toInt())

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


