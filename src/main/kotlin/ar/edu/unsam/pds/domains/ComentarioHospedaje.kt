package ar.edu.unsam.pds.domains

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import javax.persistence.*

@JsonInclude(JsonInclude.Include.NON_EMPTY)
class ComentarioHospedaje(
        var reservaId: Long? = null,
        var duenioNombre: String? = null,
        var duenioApellido: String? = null,
        var hospedajeNombre: String? = null,
        var duenioProfileUrl: String? = null,
        var hospedajePais: Pais? = null,
        var cantidadEstrellas: Int? = null,
        var comentario: String? = null,
        var fechaPublicacion: LocalDate? = null
) {
    // Nada por ahora
}

@Entity
class Comentario(
        @Column
        var comentario: String? = null,
        @Column
        var puntaje: Int? = null,
        @Column
        var fechaPublicacion: LocalDate? = null,

) {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null
}