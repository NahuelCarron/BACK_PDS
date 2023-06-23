package ar.edu.unsam.pds.repositories
import ar.edu.unsam.pds.domains.Espacio
import ar.edu.unsam.pds.domains.TiempoRenta
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface EspacioRepositorio: CrudRepository<Espacio, Long> {

    @Query("""
       SELECT h FROM Espacio h
	    WHERE h.duenio.id = :userId AND h.estaActivo = true
        """)
    fun obtenerEspaciosPorUsuario(userId:Long):List<Espacio>

    @Query("""
        SELECT h FROM Espacio h
        WHERE h.estaActivo = true
        AND LOWER(h.ubicacion) LIKE CONCAT('%',LOWER(:ubicacion),'%')
        AND (CAST(:fechaInicio AS date) IS NULL AND CAST(:fechaFin AS date) IS NULL) OR NOT EXISTS (
            SELECT r.espacio FROM Renta r
            WHERE r.fecha_desde BETWEEN :fechaInicio AND :fechaFin
            OR r.fecha_hasta BETWEEN :fechaInicio AND :fechaFin
        )
        AND h.dimensiones >= :dimensiones
        AND h.puntajePromedio IN :estrellas
        ORDER BY h.puntajePromedio DESC
        """)
    fun find(
            ubicacion: String?,
            fechaInicio: LocalDate?,
            fechaFin: LocalDate?,
            dimensiones: Double?,
            estrellas: List <Int>?,
    ): List<Espacio>

    @Query("""
        SELECT COALESCE(AVG(c.puntaje), -1)
        FROM Renta r
        LEFT JOIN Comentario c ON r.id = c.renta.id
        WHERE r.espacio.id= :idEspacio
        GROUP BY r.espacio.id
        HAVING COALESCE(AVG(c.puntaje), -1) >= -1
    """)
    fun obtenerPromedioEspacio(idEspacio:Long): Int
}

/*
Interfaz que extiende la interfaz JpaRepository de Spring Data JPA y que declara un método para obtener todos los alojamientos rentados
por un usuario determinado.
Este método utiliza la convención de nomenclatura "findBy" seguida del nombre del atributo "UsuarioId" para generar una consulta SQL para buscar los registros en la tabla "espacios" que coincidan con el valor proporcionado para "userId".
para usar esta interfaz, se debe inyectarla en la clase correspondiente utilizando la anotación @Autowired o @Inject. Además, de tener configurado el datasource y la conexión a la base de datos en el archivo de configuración de Spring.
 */