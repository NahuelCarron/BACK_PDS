package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.domains.Renta
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RentasRepositorio: CrudRepository<Renta, Long> {

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

}