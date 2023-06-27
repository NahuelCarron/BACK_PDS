package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.controller.dto.PuntajeComentarioDTO
import ar.edu.unsam.pds.controller.dto.RentaDTO
import ar.edu.unsam.pds.domains.Renta
import ar.edu.unsam.pds.domains.Usuario
import ar.edu.unsam.pds.services.RentasService
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
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
    var objectMapper: ObjectMapper = JsonMapper.builder()
        .addModule(JavaTimeModule())
        .build()
        .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    @PostMapping("/realizarRenta")
    fun realizarRenta(@RequestBody body : String){
        val nuevo = objectMapper.readValue(body, RentaDTO::class.java)
        this.rentaService.realizarRenta(nuevo)
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