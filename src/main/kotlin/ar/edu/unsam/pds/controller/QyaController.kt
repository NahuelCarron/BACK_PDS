package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.domains.Qya
import ar.edu.unsam.pds.services.QyaService
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
class QyaController {

    @Autowired
    lateinit var qyaService: QyaService
    var objectMapper: ObjectMapper = JsonMapper.builder()
            .addModule(JavaTimeModule())
            .build()
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    @PostMapping("/preguntas")
    fun enviarPregunta(@RequestBody body: String) {
        val dto = objectMapper.readValue(body, Qya::class.java)
        this.qyaService.enviarPregunta(dto)
    }
    @GetMapping("/preguntas")
    fun getSinResponder(@RequestParam idUsuario: Long): List<Qya> {
        return this.qyaService.getSinResponder(idUsuario)
    }
}