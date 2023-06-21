package ar.edu.unsam.pds.domains

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import javax.persistence.*

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
class Usuario(
        @Column(length = 100)
        var username: String? = null,
        @Column(length = 100)
        var contrasenia: String? = null,
        @Column(length = 150)
        var nombre: String? = null,
        @Column(length = 150)
        var apellido: String? = null,
        @Column(columnDefinition = "DATE")
        var fecha_nacimiento: LocalDate? = null,
        @Enumerated(EnumType.STRING)
        var pais: Pais? = null,
        @Column
        var dni: Double? = null,
        @Column
        var foto_perfil: String? = null, // TODO: sustituir base url hardcodeada
) {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id_usuario: Long? = null

}


