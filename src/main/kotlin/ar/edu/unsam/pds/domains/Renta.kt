package ar.edu.unsam.pds.domains

import ar.edu.unsam.pds.exceptions.ErrorFechas
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import javax.persistence.*
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class Renta(
        @ManyToOne
    val usuario: Usuario? = null,
        @ManyToOne
    val espacio: Espacio? = null,
        @Column(name = "fechaDesde")
    val fecha_desde: LocalDate? = null,
        @Column(name = "fechaHasta")
    val fecha_hasta: LocalDate? = null,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    // NOTE: este es el equivalente a un elemento de una tabla N->N, para evitar mapear
    //       todos los hospetajes y tener los comentarios de 1 usuario o viceversa.

    fun calcularCostoTotal() : Long {
        this.validarFechas()
        return espacio!!.calcularTotal(this.fecha_desde!!, this.fecha_hasta!!)
    }

    fun realizarCompra(){
        // TODO: implementar
    }

    fun validarFechas(){
        if (this.fecha_desde!!.isAfter(this.fecha_hasta!!)){
            throw ErrorFechas("Error al seleccionar las fechas")
        }
    }

}