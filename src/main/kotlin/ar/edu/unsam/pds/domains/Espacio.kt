package ar.edu.unsam.pds.domains

import ar.edu.unsam.pds.exceptions.EspacioInvalido
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*
import javax.persistence.*

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
class Espacio(
    @Column(length = 200)
    var titulo: String? = null,
    @Column(length = 1000)
    var descripcion: String? = null,
    @Column
    var dimensiones: Double? = null,
    @ElementCollection(targetClass = Uso::class)
    @Enumerated(EnumType.STRING)
    @JoinTable(
        name = "espacio_uso",
        joinColumns = [JoinColumn(name = "espacio_id")]
    )
    @Column(name = "usos")
    var usos: MutableList<Uso>? = null,
    @Column(length = 5000)
    var detalleAlojamiento: String? = null,
    @ElementCollection(targetClass = Servicio::class)
    @Enumerated(EnumType.STRING)
    @JoinTable(
        name = "espacio_servicio",
        joinColumns = [JoinColumn(name = "espacio_id")]
    )
    @Column(name = "servicio")
    var servicios: MutableList<Servicio>? = null,
    @ManyToOne
    var duenio: Usuario? = null,
    @Column
    var costo_hora: Double? = null,
    @Column(length = 150)
    var ubicacion: String? = null,
    @Enumerated(EnumType.STRING)
    var pais: Pais? = null,

    ) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column
    var estaActivo: Boolean = true

    @Column
    var puntajePromedio: Int = -1

    @Transient
    var comentarios: List<ComentarioEspacio>?= listOf()

    @Transient
    var qya: List<Qya>?= listOf()

    fun calcularTotal(fechaInicio: LocalDate, fechaFin: LocalDate): Long {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin)
    }

    companion object {

        fun validarDatos(espacio: Espacio) {
            validarTexto("nombre", espacio.titulo, 100)
            validarTexto("descripcion", espacio.descripcion, 1000)
            validarTexto("detalleAlojamiento", espacio.detalleAlojamiento, 1000)
            validarTexto("ubicacion", espacio.ubicacion, 100)
            if (espacio.costo_hora == null || espacio.costo_hora == 0.0) {
                throw EspacioInvalido("El costo hora del espacio no puede ser 0")
            }
            // NOTE: si el pais existe, ya es validado por jackson al deserializarlo
            if (espacio.pais == null) {
                throw EspacioInvalido("El pais del espacio no puede ser nulo")
            }

        }

        fun validarTexto(nombre: String, texto: String?, limite: Int) {
            if (texto == null || texto == "") {
                throw EspacioInvalido("El $nombre del espacio no puede estar vacío")
            }
            if (texto.length > limite) {
                throw EspacioInvalido("El $nombre del espacio no puede tener más de $limite caracteres")
            }
        }

        fun validadCantidad(nombre: String, cantidad: Int?, limite: Int) {
            if (cantidad == null || cantidad == 0) {
                throw EspacioInvalido("La $nombre del espacio no puede ser nulo o 0")
            }
            if (cantidad > limite) {
                throw EspacioInvalido("La $nombre del espacio no puede ser mayor a $limite")
            }
        }

    }

}
