package ar.edu.unsam.phm.controller

import ar.edu.unsam.phm.controller.dto.FiltroHospedaje
import ar.edu.unsam.phm.controller.dto.HospedajeDTO
import ar.edu.unsam.phm.controller.dto.HospedajesCantPaginasDTO
import ar.edu.unsam.phm.domains.Hospedaje
import ar.edu.unsam.phm.services.HospedajeService
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
class HospedajeController {
    @Autowired
    lateinit var hospedajeService: HospedajeService
    var objectMapper: ObjectMapper = JsonMapper.builder()
            .addModule(JavaTimeModule())
            .build()
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    @GetMapping("/hospedaje/{id}")
    fun obtenerHospedaje(@PathVariable id: Long): HospedajeDTO {
       return hospedajeService.obtenerHospedaje(id)!!
    }

    // TODO: cambiar request de POST a GET
    @PostMapping("/hospedajes/list")
    fun getHospedajes(@RequestBody body: String)
    : HospedajesCantPaginasDTO {
        val dto = objectMapper.readValue(body, FiltroHospedaje::class.java)
        return this.hospedajeService.getHospedajes(
                dto.ubicacion,
                dto.fechaInicio,
                dto.fechaFin,
                dto.capacidad,
                dto.numeroPagina,
                dto.puntajes,
        )
    }

    @PutMapping("/hospedajes/nuevo")
    fun crearHospedaje(@RequestBody body: String) {
        val nuevo = objectMapper.readValue(body, Hospedaje::class.java)
        this.hospedajeService.crearHospedaje(nuevo)
    }

    @PutMapping("/hospedajes/{id}")
    fun editarHospedaje(@PathVariable id: Long, @RequestBody hospedajeBody : Hospedaje){
        this.hospedajeService.modificarHospedaje(id, hospedajeBody)
    }
    @DeleteMapping("/hospedajes/{userId}/eliminar/{hospedajeId}")
    fun eliminarHospedaje(@PathVariable userId: Long, @PathVariable hospedajeId: Long){
        this.hospedajeService.eliminarHospedaje(userId, hospedajeId)
    }

}