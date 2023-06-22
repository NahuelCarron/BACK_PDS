package ar.edu.unsam.pds.domains

import javax.persistence.*

@Entity
class MetodoDePago(
    @Column
    var tipo: String? = null,
    @Column
    var numero: String? = null,
    @ManyToOne
    var usuario: Usuario? = null,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}