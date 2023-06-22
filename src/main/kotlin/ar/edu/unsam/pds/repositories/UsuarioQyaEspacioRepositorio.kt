package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.domains.Qya
import ar.edu.unsam.pds.domains.UsuarioQyaEspacio
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UsuarioQyaEspacioRepositorio: CrudRepository<UsuarioQyaEspacio, Long> {

    @Query("""
        SELECT uqe.qya
        FROM UsuarioQyaEspacio uqe
        WHERE (:idEspacio IS NULL OR uqe.espacio.id = :idEspacio)
        AND (:idUsuario IS NULL OR uqe.usuario.id = :idUsuario)
    """)
    fun getQyas(
            idUsuario: Long?,
            idEspacio: Long?,
    ): List<Qya>

    @Query("""
        SELECT uqe
        FROM UsuarioQyaEspacio uqe
        WHERE uqe.usuario.id = :idUsuario
        AND uqe.espacio.id = :idEspacio
    """)
    fun getBy(idUsuario: Long, idEspacio: Long): Optional<UsuarioQyaEspacio>

}