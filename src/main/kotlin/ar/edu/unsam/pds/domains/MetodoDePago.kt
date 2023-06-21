package ar.edu.unsam.pds.domains

import javax.persistence.*

@Entity
class MetodoDePago(
    @Column
    var tipo: String? = null,
    @Column
    var numero: String? = null,
    @Column
    var id_usuario: Long? = null,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id_metodo: Long? = null
}