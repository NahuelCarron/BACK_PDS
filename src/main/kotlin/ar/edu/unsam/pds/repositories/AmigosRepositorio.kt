package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.controller.dto.AmigoDTO
import ar.edu.unsam.pds.controller.dto.PosibleAmigo
import ar.edu.unsam.pds.domains.RelacionAmigo
import ar.edu.unsam.pds.domains.Usuario
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AmigosRepositorio: CrudRepository<RelacionAmigo, Long> {

    @Query("""
       SELECT new ar.edu.unsam.pds.controller.dto.AmigoDTO(am.id, am.nombre, am.apellido, am.profileUrl, am.pais)
	        FROM RelacionAmigo ra
	        JOIN Usuario am ON ra.amigo.id = am.id
	        WHERE ra.usuario.id = :userId
        """)
    fun getUserAmigos(userId:Long):List<AmigoDTO>

    @Query("""
           SELECT new ar.edu.unsam.pds.controller.dto.PosibleAmigo(u.id, u.nombre, u.apellido)
            FROM Usuario u
            WHERE u.id <> :userId AND u.id NOT IN (
              SELECT amigo.id
              FROM RelacionAmigo
              WHERE usuario.id = :userId
            )
        """)
    fun getPosiblesAmigos(userId:Long):List<PosibleAmigo>

    @Modifying
    @Query("""
            DELETE
            FROM RelacionAmigo ra
            WHERE (ra.usuario.id = :userId AND ra.amigo.id = :amigoId)
            OR (ra.usuario.id = :amigoId AND ra.amigo.id = :userId)
        """)
    fun eliminarAmigo(userId: Long, amigoId: Long)

}
