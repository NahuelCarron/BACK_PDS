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
        r.id_renta,
        u.nombre,
        u.apellido,
        h.titulo,
        u.foto_perfil,
        h.pais,
        c.puntaje,
        c.comentario,
        c.fechaPublicacion
    )
    FROM Espacio h
    JOIN Usuario u ON h.duenio.id_usuario = u.id_usuario
    JOIN Renta r ON r.espacio.id_espacio = h.id_espacio
    JOIN Comentario c ON r.id_renta = c.renta.id_renta
    WHERE r.espacio.id_espacio = :idHospedaje
    ORDER BY c.fechaPublicacion DESC
    """)
    fun obtenerComentariosOrdenados(idHospedaje: Long): List<ComentarioEspacio>
}