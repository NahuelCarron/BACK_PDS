package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.controller.dto.HospedajeDTO
import ar.edu.unsam.pds.services.AudioService
import ar.edu.unsam.pds.services.HospedajeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class controlador_audio_voz {

    @Autowired
    lateinit var audioService: AudioService

    @GetMapping("/asistente")
    fun obtenerHospedaje(){
        audioService.audio_voz()!!
    }

}