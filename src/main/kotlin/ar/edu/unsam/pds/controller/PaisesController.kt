package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.services.PaisesService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class PaisesController {

    @Autowired
    lateinit var paisesService: PaisesService

    @GetMapping("/paises/list")
    @Operation(summary = "Retorna lista de paises disponibles con formato ISO de 3 letras")
    fun listPaises(): List<String> {
        return this.paisesService.listPaises()
    }

}