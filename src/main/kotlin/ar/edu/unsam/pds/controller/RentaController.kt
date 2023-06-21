package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.controller.dto.PuntajeComentarioDTO
import ar.edu.unsam.pds.controller.dto.RentaDTO
import ar.edu.unsam.pds.services.ReservaService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class RentaController {
    @Autowired
    lateinit var reservaService: ReservaService

    @PostMapping("/realizarReserva")
    fun realizarRenta(@RequestBody reservaDTO : RentaDTO){
        this.reservaService.realizarReserva(reservaDTO)
    }

    @PostMapping("/calificarReserva")
    @Operation(summary = "Endpoint para calificar una reserva")
    fun calificarRenta(@RequestBody puntajeComentarioDTO: PuntajeComentarioDTO): Int {
        // TODO: implementar
        return 200
    }
}