package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.controller.dto.FiltroEspacio
import ar.edu.unsam.pds.controller.dto.EspacioDTO
import ar.edu.unsam.pds.controller.dto.EspaciosCantPaginasDTO
import ar.edu.unsam.pds.domains.Espacio
import ar.edu.unsam.pds.domains.Pais
import ar.edu.unsam.pds.domains.TiempoRenta
import ar.edu.unsam.pds.domains.Uso
import ar.edu.unsam.pds.repositories.UsuarioRepositorio
import ar.edu.unsam.pds.services.EspacioService
import ar.edu.unsam.pds.services.UserService
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
    @Autowired
    lateinit var usuarioRepo: UsuarioRepositorio

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
        println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
        println(body)
        val dto = objectMapper.readValue(body, FiltroEspacio::class.java)
        return this.espaciosService.getEspacios(dto)
    }

    @PutMapping("/espacios/nuevo")
    fun crearEspacio(@RequestBody body: String) {
        val nuevo = objectMapper.readValue(body, Espacio::class.java)
        //val duenio = this.usuarioRepo.findById(body.duenio!!.id!!).get()
        //val espacio = Espacio(body.titulo, body.descripcion, body.dimensiones, body.usos, body.detalleAlojamiento,
            //body.servicios, duenio, body.costo_hora, body.ubicacion, Pais.ARG, TiempoRenta.costo_hora)
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



