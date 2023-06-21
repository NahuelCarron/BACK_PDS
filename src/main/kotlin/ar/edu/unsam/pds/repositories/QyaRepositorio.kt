package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.domains.Qya
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QyaRepositorio: CrudRepository<Qya, Long> {

    // TODO: implementar sinResponder en la query
    @Query("""
        SELECT qya
        FROM Qya qya
        WHERE qya.usuario.id_usuario = :idUsuario
        AND qya.pregunta IS NOT NULL
        AND qya.respuesta IS NULL
    """)
    fun findSinResponder(idUsuario: Long): List<Qya>

}