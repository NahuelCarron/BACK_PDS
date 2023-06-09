package ar.edu.unsam.pds.domains

import javax.persistence.*

@Entity
class RelacionAmigo(
        @ManyToOne
        val usuario: Usuario,
        @ManyToOne
        val amigo: Usuario,
) {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null
}