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
        SELECT u.id
        FROM Usuario u
        WHERE u.username = :username AND u.password = :password
    """)
    fun obtenerId(username: String, password: String): Long

    @Modifying
    @Query("""
       UPDATE Usuario SET saldo = saldo + :saldo WHERE id= :idUser
    """)
    fun actualizarSaldo(saldo: Double, idUser: Long)

    @Modifying
    @Query("""
       UPDATE Usuario SET fechaNacimiento = :nuevaFecha WHERE id= :idUser
    """)
    fun actualizarFechaNacimiento(nuevaFecha: LocalDate, idUser: Long)

    @Modifying
    @Query("""
       UPDATE Usuario SET pais = :nuevoPais WHERE id= :idUser
    """)
    fun actualizarPais(nuevoPais: Pais, idUser: Long)


}