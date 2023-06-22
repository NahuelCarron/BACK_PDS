package ar.edu.unsam.pds.domains

import java.time.LocalDate
import javax.persistence.*

@Entity
class Qya(
        @Column
    var pregunta: String? = null,
        @Column
    var respuesta: String? = null,
        @Column(name = "fechaPublicacion")
    val fechaPublicacion: LocalDate? = null,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}