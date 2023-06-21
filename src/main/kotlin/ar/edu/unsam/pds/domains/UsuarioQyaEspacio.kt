package ar.edu.unsam.pds.domains

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class UsuarioQyaEspacio(
        @Column
        var id_usuario: Long? = null,
        @Column
        var id_qya: Long? = null,
        @Column
        var id_espacio: Long? = null,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id_usuario_qya_espacio: Long? = null // TODO: reveer cual es el id de esta clase
}