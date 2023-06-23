package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.controller.dto.QyaEspacio
import ar.edu.unsam.pds.domains.Qya
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QyaRepositorio: CrudRepository<Qya, Long> {
    @Query("""
        SELECT new ar.edu.unsam.pds.controller.dto.QyaEspacio( uqe.id, q.pregunta, u.nombre, q.respuesta, q.fechaPublicacion)
        FROM UsuarioQyaEspacio uqe
        LEFT JOIN Qya q ON q.id = uqe.qya.id
        LEFT JOIN Espacio e ON e.id = uqe.espacio.id
        LEFT JOIN Usuario u ON u.id = uqe.usuario.id
        WHERE e.duenio.id = :idUsuario AND q.respuesta IS NULL
    """)
    fun findPreguntasAResponder(idUsuario: Long): List<QyaEspacio>
}