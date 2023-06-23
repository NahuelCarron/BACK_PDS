package ar.edu.unsam.pds.domains

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class UsuarioQyaEspacio(
        @OneToOne
        var usuario: Usuario,
        @OneToOne
        var qya: Qya? = null,
        @OneToOne
        var espacio: Espacio? = null,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}