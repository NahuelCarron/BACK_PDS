package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.domains.Reserva
import ar.edu.unsam.pds.exceptions.CantidadPasajerosIncorrecto
import ar.edu.unsam.pds.exceptions.ErrorFechas
import ar.edu.unsam.pds.exceptions.SaldoInsuficiente
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("ReservaTest")
class ReservaTest {

    @Test
    fun `Testeando los costos totales`() {
        // "Costo total de la reserva 1 correspondiente a hospedajeCasa1"
        reserva1.calcularCostoTotal() shouldBe 28128.0
        // "Costo total de la reserva 1 correspondiente a hospedajeCasa1 por negativa"
        reserva1.calcularCostoTotal() shouldNotBe 30000.0
        // "Costo total de la reserva 2 correspondiente a hospedajeDepartamento2"
        reserva2.calcularCostoTotal() shouldBe 132624.0
        // "Costo total de la reserva 2 correspondiente a hospedajeDepartamento2 por negativa"
        reserva2.calcularCostoTotal() shouldNotBe 150000.0
        // "Costo total de la reserva 3 correspondiente a hospedajeCabania3"
        reserva3.calcularCostoTotal() shouldBe 167600.0
        // "Costo total de la reserva 3 correspondiente a hospedajeCabania3 por negativa"
        reserva3.calcularCostoTotal() shouldNotBe 200000.0
    }

    @Test
    fun `Testeando los saldos de los usuarios al realizar las compras`() {
        // "saldo disponible del usuario Eminem al realizar la reserva 1"
        reserva1.usuario?.saldo shouldBe 50000
        reserva1.realizarCompra()
        reserva1.usuario?.saldo shouldBe 21872
        // "saldo disponible del usuario Eminem al realizar la reserva 1 por la negativa"
        reserva1.usuario?.saldo shouldNotBe 60000
        assertThrows<SaldoInsuficiente> {
            reserva1.realizarCompra()
        }
        reserva1.usuario?.saldo shouldNotBe 30000
        // "Eminem no puede realizar mas reservas si no tiene credito"
        val message = "No tienes saldo disponible para efectuar la reserva"
        shouldThrow<SaldoInsuficiente>{
            reserva2.realizarCompra()
        }.message shouldBe message
    }

    @Test
    fun `Verificar que tira una excepciòn cuando Eminem se las manda al seleccionar fechas`() {
        val reserva4 = Reserva(
            usuario = eminem,
            hospedaje = hospedaje1,
            inicio = LocalDate.of(2023, 4, 5),
            fin = LocalDate.of(2023, 4, 4),
            cantPasajeros = 5
        )
        // "Error al reservar, fecha Inicio es un dia antes que fecha fin"
        shouldThrow<ErrorFechas>{
            reserva4.calcularCostoTotal()
        }.message shouldBe "Error al seleccionar las fechas"
        // "Error al indicarle la capacidad, supera la maxima del hospedaje"
        shouldThrow<CantidadPasajerosIncorrecto>{
            reserva4.validarCantidadPasajeros()
        }.message shouldBe "La cantidad de pasajeros excede a la capacidad maxima del Hospedaje"
    }

}