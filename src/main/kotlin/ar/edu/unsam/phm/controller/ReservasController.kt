package ar.edu.unsam.phm.controller

import ar.edu.unsam.phm.controller.dto.PuntajeComentarioDTO
import ar.edu.unsam.phm.controller.dto.ReservaDTO
import ar.edu.unsam.phm.services.ReservaService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class ReservasController {
    @Autowired
    lateinit var reservaService: ReservaService

    @PostMapping("/realizarReserva")
    fun realizarReserva(@RequestBody reservaDTO : ReservaDTO){
        this.reservaService.realizarReserva(reservaDTO)
    }

    @PostMapping("/calificarReserva")
    @Operation(summary = "Endpoint para calificar una reserva")
    fun calificarReserva(@RequestBody puntajeComentarioDTO: PuntajeComentarioDTO): Int {
        this.reservaService.calificarReserva(puntajeComentarioDTO)
        return 200
    }
}