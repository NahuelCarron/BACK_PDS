package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.controller.dto.EspacioRentaDTO
import ar.edu.unsam.pds.controller.dto.ReputacionUsuarioDTO
import ar.edu.unsam.pds.domains.Renta
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RentasRepositorio: CrudRepository<Renta, Long> {

    @Query("""
        SELECT new ar.edu.unsam.pds.controller.dto.EspacioRentaDTO( e, r.fecha_desde, r.fecha_hasta, r.costoTotal, r.id,
           (SELECT c2
            FROM Comentario c2
            WHERE c2.renta.id = r.id AND c2.tipoComentario = 'inquilino'
            ))
            FROM Renta r
            LEFT JOIN Espacio e ON r.espacio.id = e.id
            LEFT JOIN Usuario u ON u.id = e.duenio.id
            LEFT JOIN Comentario c ON c.renta.id = r.id
            WHERE e.duenio.id = :userId
            GROUP BY e.id, r.fecha_desde, r.fecha_hasta, r.costoTotal, r.id
        """)
    fun obtenerRentasDeEspaciosDelUsuario(userId:Long):List<EspacioRentaDTO>
    @Query("""
       SELECT new ar.edu.unsam.pds.controller.dto.EspacioRentaDTO( e, r.fecha_desde, r.fecha_hasta, r.costoTotal, r.id,
           (SELECT c2
            FROM Comentario c2
            WHERE c2.renta.id = r.id AND c2.tipoComentario = 'renta'))
            FROM Renta r
            LEFT JOIN Espacio e ON r.espacio.id = e.id
            LEFT JOIN Usuario u ON u.id = e.duenio.id
            LEFT JOIN Comentario c ON c.renta.id = r.id
            WHERE r.usuario.id = :userId
            GROUP BY e.id, r.fecha_desde, r.fecha_hasta, r.costoTotal, r.id
        """)
    fun obtenerRentasPorUsuario(userId:Long):List<EspacioRentaDTO>
    @Query("""
       SELECT r
	    FROM Renta r
        JOIN Comentario c ON r.id = c.renta.id
	    WHERE r.usuario.id = :userId
        AND c.comentario IS NOT NULL
        """)
    fun obtenerComentariosPorUsuario(userId:Long):List<Renta>

    @Query("""
       SELECT r
	    FROM Renta r
	    WHERE r.espacio.id = :espacioId
        """)
    fun obtenerRentasPorEspacio(espacioId:Long):List<Renta>
    @Query("""
        SELECT COALESCE(AVG(c.puntaje), -1)
        FROM Renta r
        LEFT JOIN Comentario c ON c.renta.id = r.id
        WHERE r.espacio.id = :idEspacio AND c.tipoComentario = 'renta'
        GROUP BY r.espacio.id
        HAVING COALESCE(AVG(c.puntaje), -1) >= -1
    """)
    fun obtenerPromedioComentarios(idEspacio: Long): Int

    @Query("""
       SELECT new ar.edu.unsam.pds.controller.dto.ReputacionUsuarioDTO(d.nombre, d.apellido, e.titulo, e.pais,c.puntaje, c.comentario, c.fechaPublicacion, r.fecha_desde, r.fecha_hasta)
        FROM Comentario c
        LEFT JOIN Renta r ON r.id = c.renta.id
        LEFT JOIN Usuario u ON u.id = r.usuario.id
        LEFT JOIN Espacio e ON e.id = r.espacio.id
        LEFT JOIN Usuario d ON d.id = e.duenio.id
        WHERE r.usuario.id = :idUsuario AND c.tipoComentario = 'inquilino'
        """)
    fun obtenerReputacionUsuario(idUsuario:Long):List<ReputacionUsuarioDTO>

}