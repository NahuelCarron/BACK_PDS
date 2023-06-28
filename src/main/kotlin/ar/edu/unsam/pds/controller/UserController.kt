package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.controller.dto.*
import ar.edu.unsam.pds.domains.ComentarioEspacio
import ar.edu.unsam.pds.domains.Espacio
import ar.edu.unsam.pds.domains.Pais
import ar.edu.unsam.pds.domains.Usuario
import ar.edu.unsam.pds.services.UserService
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.util.*

@RestController
@CrossOrigin("*")
class UserController {

    @Autowired
    lateinit var userService: UserService
    var objectMapper: ObjectMapper = JsonMapper.builder()
            .addModule(JavaTimeModule())
            .build()
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    @GetMapping("/usuarios/{userId}/info")
    @Operation(summary = "Endpoint acceder a la informacion basica del usuario")
    fun getUserInfo(@PathVariable userId: Long): Usuario {
        return this.userService.getUserInfo(userId)
    }

    @GetMapping("/usuarios/{userId}/comentarios")
    @Operation(summary = "Endpoint acceder a los comentarios del usuario")
    fun getUserComentarios(@PathVariable userId: Long): List<ComentarioEspacio> {
        return this.userService.getUserComentarios(userId)
    }

    @GetMapping("/usuarios/{userId}/rentas")
    @Operation(summary = "Endpoint acceder a las rentas compradas por el usuario")
    fun getUserRentas(@PathVariable userId: Long): List<EspacioRentaDTO> {
        return this.userService.getUserRentas(userId)
    }

    @GetMapping("/usuarios/{userId}/espacios")
    @Operation(summary = "Endpoint acceder a las publicaciones del usuario")
    fun getUserEspacios(@PathVariable userId: Long): List<EspacioDTO>{
      return this.userService.getUserEspacios(userId).map{ it.toDTO()}
    }
    @GetMapping("/paises")
    @Operation(summary = "Endpoint extraer los paises")
    fun getPaises(): List<Pais>{
        return mutableListOf<Pais>() + Pais.values()
    }
    @GetMapping("/espaciosDelUsuario/{userId}/rentados")
    @Operation(summary = "Endpoint acceder a los espacios del usuario que fueron rentados por otros")
    fun getEspaciosDelUsuarioRentados(@PathVariable userId: Long): List<EspacioRentaDTO>{
        return this.userService.getUserEspaciosRentadosPorOtros(userId)
    }

    @DeleteMapping("/comentarios/{rentaId}/delete")
    @Operation(summary = "Endpoint eliminar un comentario")
    fun eliminarComentario(@PathVariable rentaId: Int) {
        // TODO: implementar
    }

    @PostMapping("editarInformacion/{userId}")
    @Operation(summary = "Endpoint para editar informacion del usuario")
    fun modificarInfo(@PathVariable userId: Long,@RequestBody body: String){
        val usuario = objectMapper.readValue(body, Usuario::class.java)
        this.userService.actualizarInformacion(userId, usuario)
    }
    @PostMapping("editarUsernamePassword/{userId}")
    @Operation(summary = "Endpoint para editar informacion del usuario")
    fun modificarUsernamePassword(@PathVariable userId: Long,@RequestBody userYContra: UsuarioYcontra){
        this.userService.actualizarUsuarioYContrasenia(userId, userYContra.username, userYContra.password)
    }

    @PostMapping("crearUsuario")
    @Operation(summary = "Endpoint para crear un usuario")
    fun crearUsuario(@RequestBody body: String){
        val nuevo = objectMapper.readValue(body, Usuario::class.java)
        this.userService.crearUsuario(nuevo)
    }

}