package ar.edu.unsam.pds.domains

import ar.edu.unsam.pds.exceptions.HospedajeInvalido
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
        @Column(length = 5000)
    var descripcion: String? = null,
        @Column
    var dimensiones: Double? = null,
        @ElementCollection(targetClass = Uso::class)
        @Enumerated(EnumType.STRING)
        @JoinTable(
                name = "espacio_uso",
                joinColumns = [JoinColumn(name = "espacio_id")]
        )
        @Column(name = "uso")
    var uso: MutableList<Uso>? = null,
        @Column
    var capacidad: Int? = null,
        @Column
    var habitaciones: Int? = null,
        @Column
    var banios: Int? = null,
        @Column(length = 255)
    var detalleAlojamiento: String? = null,
        @Column(length = 255)
    var otrosAspectos: String? = null,
        @ElementCollection(targetClass = Servicio::class)
    @Enumerated(EnumType.STRING)
    @JoinTable(
        name = "hospedaje_servicio",
        joinColumns = [JoinColumn(name = "hospedaje_id")]
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

        @Convert(converter = TipoHospedajeConverter::class)
    var hospedajeTipo: TipoHospedaje? = null


    ) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id_espacio: Long? = null

    @Column
    var estaActivo: Boolean = true

    @Column
    var puntajePromedio: Int = -1

    @Transient
    var comentarios: List<ComentarioEspacio>?= listOf()

    fun calcularPlus(cantPasajeros : Int): Double{
        return hospedajeTipo!!.calcularPlus(this, cantPasajeros)
    }

    fun calcularTotal(fechaInicio: LocalDate, fechaFin: LocalDate): Long {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin)
    }

    fun poseeServicio(servicio: Servicio): Boolean {
        return servicios?.contains(servicio) ?: false
    }



    companion object {

        fun validarDatos(hospedaje: Espacio) {
            validarTexto("nombre", hospedaje.titulo, 100)
            validarTexto("descripcion", hospedaje.descripcion, 1000)
            validadCantidad("capacidad", hospedaje.capacidad, 100000)
            validadCantidad("habitaciones", hospedaje.habitaciones, 1000)
            validadCantidad("banios", hospedaje.banios, 1000)
            validarTexto("detalleAlojamiento", hospedaje.detalleAlojamiento, 1000)
            validarTexto("otrosAspectos", hospedaje.otrosAspectos, 1000)
            validarTexto("ubicacion", hospedaje.ubicacion, 100)
            if (hospedaje.costo_hora == null || hospedaje.costo_hora == 0.0) {
                throw HospedajeInvalido("El costo base del hospedaje no puede ser 0")
            }
            // NOTE: si el pais existe, ya es validado por jackson al deserializarlo
            if (hospedaje.pais == null) {
                throw HospedajeInvalido("El pais del hospedaje no puede ser nulo")
            }
            // NOTE: si el tipo de hospedaje existe, ya es validado por jackson al deserializarlo
            if (hospedaje.hospedajeTipo == null) {
                throw HospedajeInvalido("El tipo de hospedaje no puede ser nulo")
            }

        }

        fun validarTexto(nombre: String, texto: String?, limite: Int) {
            if (texto == null || texto == "") {
                throw HospedajeInvalido("El $nombre del hospedaje no puede estar vacío")
            }
            if (texto.length > limite) {
                throw HospedajeInvalido("El $nombre del hospedaje no puede tener más de $limite caracteres")
            }
        }

        fun validadCantidad(nombre: String, cantidad: Int?, limite: Int) {
            if (cantidad == null || cantidad == 0) {
                throw HospedajeInvalido("La $nombre del hospedaje no puede ser nulo o 0")
            }
            if (cantidad > limite) {
                throw HospedajeInvalido("La $nombre del hospedaje no puede ser mayor a $limite")
            }
        }

    }

}
