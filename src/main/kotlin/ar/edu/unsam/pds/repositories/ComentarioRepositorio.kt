package ar.edu.unsam.pds.repositories
import ar.edu.unsam.pds.domains.Comentario
import ar.edu.unsam.pds.domains.ComentarioHospedaje
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ComentarioRepositorio: CrudRepository<Comentario, Long> {
    @Query("""
        SELECT new ar.edu.unsam.pds.domains.ComentarioHospedaje(
        r.id,
        u.nombre,
        u.apellido,
        h.nombre,
        u.profileUrl,
        h.pais,
        c.puntaje,
        c.comentario,
        c.fechaPublicacion
    )
    FROM Hospedaje h
    JOIN Usuario u ON h.duenio.id = u.id
    JOIN Reserva r ON r.hospedaje.id = h.id
    JOIN Comentario c ON r.comentario.id = c.id
    WHERE r.hospedaje.id = :idHospedaje
    ORDER BY c.fechaPublicacion DESC
    """)
    fun obtenerComentariosOrdenados(idHospedaje: Long): List<ComentarioHospedaje>
}