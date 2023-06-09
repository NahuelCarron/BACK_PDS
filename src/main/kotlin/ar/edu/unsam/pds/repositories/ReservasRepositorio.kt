package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.controller.dto.ReservaDTO
import ar.edu.unsam.pds.controller.dto.ReservaUsuarioDTO
import ar.edu.unsam.pds.domains.Hospedaje
import ar.edu.unsam.pds.domains.Reserva
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ReservasRepositorio: CrudRepository<Reserva, Long> {

    @Query("""
       SELECT new ar.edu.unsam.pds.controller.dto.ReservaUsuarioDTO(
       r.id, h, r.inicio, r.fin, c.puntaje, r.cantPasajeros, h.costoBase
       ) 
	    FROM Reserva r
        LEFT JOIN Hospedaje h ON r.hospedaje.id = h.id
        LEFT JOIN Comentario c ON r.comentario.id = c.id
	    WHERE r.usuario.id = :userId
        """)
    fun obtenerReservasPorUsuario(userId:Long):List<ReservaUsuarioDTO>

    @Query("""
       SELECT r
	    FROM Reserva r
	    WHERE r.usuario.id = :userId
        AND r.comentario IS NOT NULL
        """)
    fun obtenerComentariosPorUsuario(userId:Long):List<Reserva>


    @Query("""
       SELECT r
	    FROM Reserva r
	    WHERE r.hospedaje.id = :hospedajeId
        """)
    fun obtenerReservasPorHospedaje(hospedajeId:Long):List<Reserva>

}