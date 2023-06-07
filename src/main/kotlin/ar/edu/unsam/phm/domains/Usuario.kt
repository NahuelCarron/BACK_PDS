package ar.edu.unsam.phm.domains

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import javax.persistence.*

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
class Usuario(
        @Column(length = 100)
        var username: String? = null,
        @Column(length = 100)
        var password: String? = null,
        @Column(length = 150)
        var nombre: String? = null,
        @Column(length = 150)
        var apellido: String? = null,
        @Column(columnDefinition = "DATE")
        var fechaNacimiento: LocalDate? = null,
        @Enumerated(EnumType.STRING)
        var pais: Pais? = null,
        @Column
        var saldo: Double? = null,
        @Column
        var profileUrl: String? = null, // TODO: sustituir base url hardcodeada
) {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null

}


