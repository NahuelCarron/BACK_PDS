package ar.edu.unsam.pds.controller

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("HospedajeTest")
class HospedajeTest {

    @Test
    fun `Testeando los costos por noche de cada hospedaje`() {
        // "Costo total de hospedajeCasa1"
        hospedaje1.calcularPrecio(reserva1.cantPasajeros!!) shouldBe 28128.0
        // "Costo total de hospedajeDepartamento2"
        hospedaje2.calcularPrecio(reserva2.cantPasajeros!!) shouldBe 33156.0
        // "Costo total de hospedajeCabania3"
        hospedaje3.calcularPrecio(reserva3.cantPasajeros!!) shouldBe 33520.0
    }

    @Test
    fun `Testeando los costos por noche de cada hospedaje 2`() {
        // "Costo total de hospedajeCasa1"
        hospedaje1.calcularTotal(reserva1.fecha_desde!!, reserva1.fecha_hasta!!,reserva1.cantPasajeros!!) shouldBe 28128.0
        // "Costo total de hospedajeDepartamento2"
        hospedaje2.calcularTotal(reserva2.fecha_desde!!, reserva2.fecha_hasta!!,reserva2.cantPasajeros!!) shouldBe 132624.0
        // "Costo total de hospedajeCabania3"
        hospedaje3.calcularTotal(reserva3.fecha_desde!!, reserva3.fecha_hasta!!,reserva3.cantPasajeros!!) shouldBe 167600.0
    }

}

