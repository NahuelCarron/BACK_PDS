package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.controller.dto.FiltroEspacio
import ar.edu.unsam.pds.controller.dto.EspacioDTO
import ar.edu.unsam.pds.controller.dto.EspaciosCantPaginasDTO
import ar.edu.unsam.pds.domains.Espacio
import ar.edu.unsam.pds.services.EspacioService
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
class EspacioController {
    @Autowired
    lateinit var espaciosService: EspacioService
    var objectMapper: ObjectMapper = JsonMapper.builder()
            .addModule(JavaTimeModule())
            .build()
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    @GetMapping("/espacios/{id}")
    fun obtenerEspacio(@PathVariable id: Long): EspacioDTO {
       return espaciosService.obtenerEspacio(id)!!
    }

    // TODO: cambiar request de POST a GET
    @PostMapping("/espacios/list")
    fun getEspacios(@RequestBody body: String)
    : EspaciosCantPaginasDTO {
        val dto = objectMapper.readValue(body, FiltroEspacio::class.java)
        return this.espaciosService.getEspacios(
                dto.ubicacion,
                dto.fechaInicio,
                dto.fechaFin,
                dto.capacidad,
                dto.numeroPagina,
                dto.puntajes,
        )
    }

    @PutMapping("/espacios/nuevo")
    fun crearEspacio(@RequestBody body: String) {
        val nuevo = objectMapper.readValue(body, Espacio::class.java)
        this.espaciosService.crearEspacio(nuevo)
    }

    @PutMapping("/espacios/{id}")
    fun editarEspacio(@PathVariable id: Long, @RequestBody body: Espacio){
        this.espaciosService.modificarEspacio(id, body)
    }
    @DeleteMapping("/espacios/{userId}/eliminar/{espacioId}")
    fun eliminarEspacio(@PathVariable userId: Long, @PathVariable espacioId: Long){
        this.espaciosService.eliminarEspacio(userId, espacioId)
    }

}