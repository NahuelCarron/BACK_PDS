package ar.edu.unsam.pds.domains

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import javax.persistence.*

@JsonInclude(JsonInclude.Include.NON_EMPTY)
class ComentarioEspacio(
        var rentaId: Long? = null,
        var duenioNombre: String? = null,
        var duenioApellido: String? = null,
        var espacioNombre: String? = null,
        var duenioProfileUrl: String? = null,
        var espacioPais: Pais? = null,
        var cantidadEstrellas: Int? = null,
        var comentario: String? = null,
        var fechaPublicacion: LocalDate? = null,
        var nombreUsuario: String? = null,
        var apellidoUsuario: String? = null
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
        @ManyToOne
        var renta: Renta? = null,
        @Column
        var tipoComentario: String? = null,
) {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null
}