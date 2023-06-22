package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.controller.dto.QyaPreguntaDto
import ar.edu.unsam.pds.controller.dto.QyaRespuestaDto
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

    @PostMapping("/preguntas/enviar")
    fun enviarPregunta(@RequestBody body: QyaPreguntaDto) {
        this.qyaService.enviarPregunta(body.idUsuario, body.idEspacio, body.pregunta)
    }

    @GetMapping("/preguntas")
    fun getQyas(
            @RequestParam idUsuario: Long?,
            @RequestParam idEspacio: Long?,
    ): List<Qya> {
        return this.qyaService.getQyas(
                idUsuario,
                idEspacio,
                )
    }

    @PutMapping("/preguntas/responder")
    fun responder(@RequestBody body: String) {
        val dto = objectMapper.readValue(body, QyaRespuestaDto::class.java)
        this.qyaService.responder(dto.id_qya, dto.respuesta)
    }
}