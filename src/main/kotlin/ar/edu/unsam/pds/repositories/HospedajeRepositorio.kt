package ar.edu.unsam.pds.repositories
import ar.edu.unsam.pds.domains.Hospedaje
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface HospedajeRepositorio: CrudRepository<Hospedaje, Long> {

    @Query("""
       SELECT h FROM Hospedaje h
	    WHERE h.duenio.id = :userId AND h.estaActivo = true
        """)
    fun obtenerHospedajesPorUsuario(userId:Long):List<Hospedaje>

    @Query("""
        SELECT h FROM Hospedaje h
        WHERE h.estaActivo = true
        AND LOWER(h.ubicacion) LIKE CONCAT('%',LOWER(:ubicacion),'%')
        AND NOT EXISTS (
            SELECT r.hospedaje FROM Reserva r
            WHERE r.inicio BETWEEN :fechaInicio AND :fechaFin
            OR r.fin BETWEEN :fechaInicio AND :fechaFin
        )
        AND h.capacidad >= :maxPasajeros
        AND h.puntajePromedio IN :puntajes
        ORDER BY h.puntajePromedio DESC
        """)
    fun find(
            ubicacion: String?,
            fechaInicio: LocalDate?,
            fechaFin: LocalDate?,
            maxPasajeros: Int?,
            puntajes: List <Int>?
    ): List<Hospedaje>

    @Query("""
        SELECT COALESCE(AVG(c.puntaje), -1)
        FROM Reserva r
        LEFT JOIN Comentario c ON r.comentario.id = c.id
        WHERE r.hospedaje.id= :idHospedaje
        GROUP BY r.hospedaje.id
        HAVING COALESCE(AVG(c.puntaje), -1) >= -1
    """)
    fun obtenerPromedioHospedaje(idHospedaje:Long): Int
}

/*
Interfaz que extiende la interfaz JpaRepository de Spring Data JPA y que declara un método para obtener todos los alojamientos reservados
por un usuario determinado.
Este método utiliza la convención de nomenclatura "findBy" seguida del nombre del atributo "UsuarioId" para generar una consulta SQL para buscar los registros en la tabla "hospedajes" que coincidan con el valor proporcionado para "userId".
para usar esta interfaz, se debe inyectarla en la clase correspondiente utilizando la anotación @Autowired o @Inject. Además, de tener configurado el datasource y la conexión a la base de datos en el archivo de configuración de Spring.
 */