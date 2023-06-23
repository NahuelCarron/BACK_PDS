package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.controller.dto.PuntajeComentarioDTO
import ar.edu.unsam.pds.controller.dto.RentaDTO
import ar.edu.unsam.pds.services.RentasService
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
    lateinit var rentaService: RentasService

    @PostMapping("/realizarRenta")
    fun realizarRenta(@RequestBody rentaDTO : RentaDTO){
        this.rentaService.realizarRenta(rentaDTO)
    }

    @PostMapping("/calificarRenta")
    @Operation(summary = "Endpoint para calificar una renta")
    fun calificarRenta(@RequestBody puntajeComentarioDTO: PuntajeComentarioDTO) {
       this.rentaService.calificarRenta(puntajeComentarioDTO)
    }
    @PostMapping("/calificarInquilino")
    @Operation(summary = "Endpoint para calificar un inquilino")
    fun calificarInquilino(@RequestBody puntajeComentarioDTO: PuntajeComentarioDTO) {
        this.rentaService.calificarRenta(puntajeComentarioDTO)
    }
}