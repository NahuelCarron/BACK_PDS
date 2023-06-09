package ar.edu.unsam.pds.domains

import ar.edu.unsam.pds.exceptions.CalificacionInvalida
import ar.edu.unsam.pds.exceptions.CantidadPasajerosIncorrecto
import ar.edu.unsam.pds.exceptions.ErrorFechas
import ar.edu.unsam.pds.exceptions.SaldoInsuficiente
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import javax.persistence.*
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class Reserva(
    @ManyToOne
    val usuario: Usuario? = null,
    @ManyToOne
    val hospedaje: Hospedaje? = null,
    @Column(name = "fechaInicio")
    val inicio: LocalDate? = null,
    @Column(name = "fechaFin")
    val fin: LocalDate? = null,
    @Column
    var cantPasajeros: Int? = null,
    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true) // FIXME: El CascadeType.ALL es para que cuando se crea una reserva, se crea un Comentario, si se elimina una reserva, se elimina un comentario

    var comentario: Comentario? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    // NOTE: este es el equivalente a un elemento de una tabla N->N, para evitar mapear
    //       todos los hospetajes y tener los comentarios de 1 usuario o viceversa.

    fun validarPuntaje() {
        if (this.comentario?.puntaje!! < 0 || this.comentario?.puntaje!! > 5) {
            throw CalificacionInvalida("El puntaje debe estar entre 0 y 5")
        }
    }

    fun calcularCostoTotal() : Double {
        this.validarFechas()
        this.validarCantidadPasajeros()
        return hospedaje!!.calcularTotal(this.inicio!!, this.fin!!,this.cantPasajeros!!)
    }

    fun realizarCompra(){
        if (this.calcularCostoTotal() > this.usuario?.saldo!!){
            throw SaldoInsuficiente("No tienes saldo disponible para efectuar la reserva")
        }
        this.usuario.saldo = this.usuario.saldo!! - calcularCostoTotal()
    }

    fun validarCantidadPasajeros(){
        if (this.cantPasajeros!! > this.hospedaje?.capacidad!!){
            throw CantidadPasajerosIncorrecto("La cantidad de pasajeros excede a la capacidad maxima del Hospedaje")
        }
        if (this.cantPasajeros!! == 0){
            throw CantidadPasajerosIncorrecto("Debe seleccionar una cantidad de Pasajeros por reserva")
        }
    }

    fun validarFechas(){
        if (this.inicio!!.isAfter(this.fin!!)){
            throw ErrorFechas("Error al seleccionar las fechas")
        }
    }

}