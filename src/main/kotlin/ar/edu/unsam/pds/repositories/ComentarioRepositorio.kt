package ar.edu.unsam.pds.repositories
import ar.edu.unsam.pds.domains.Comentario
import ar.edu.unsam.pds.domains.ComentarioEspacio
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ComentarioRepositorio: CrudRepository<Comentario, Long> {
    @Query("""
        SELECT new ar.edu.unsam.pds.domains.ComentarioEspacio(
        r.id,
        d.nombre,
        d.apellido,
        h.titulo,
        d.fotoPerfil,
        h.pais,
        c.puntaje,
        c.comentario,
        c.fechaPublicacion,
        u.nombre,
        u.apellido
    )
    FROM Espacio h
    JOIN Usuario d ON h.duenio.id = d.id
    JOIN Renta r ON r.espacio.id = h.id
    JOIN Comentario c ON r.id = c.renta.id
    JOIN Usuario u ON r.usuario.id = u.id
    WHERE r.espacio.id = :idEspacio
    ORDER BY c.fechaPublicacion DESC
    """)
    fun obtenerComentariosOrdenados(idEspacio: Long): List<ComentarioEspacio>

}