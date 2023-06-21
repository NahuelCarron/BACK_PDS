package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.domains.Pais
import ar.edu.unsam.pds.domains.Usuario
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface UsuarioRepositorio: CrudRepository<Usuario, Long> {

    @Query("""
        SELECT u.id_usuario
        FROM Usuario u
        WHERE u.username = :username AND u.contrasenia = :password
    """)
    fun obtenerId(username: String, password: String): Long

    @Modifying
    @Query("""
       UPDATE Usuario SET fecha_nacimiento = :nuevaFecha WHERE id_usuario= :idUser
    """)
    fun actualizarFechaNacimiento(nuevaFecha: LocalDate, idUser: Long)

    @Modifying
    @Query("""
       UPDATE Usuario SET pais = :nuevoPais WHERE id_usuario= :idUser
    """)
    fun actualizarPais(nuevoPais: Pais, idUser: Long)


}