package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.controller.dto.AmigoDTO
import ar.edu.unsam.pds.controller.dto.HospedajeUsuarioDTO
import ar.edu.unsam.pds.controller.dto.PosibleAmigo
import ar.edu.unsam.pds.controller.dto.ReservaUsuarioDTO
import ar.edu.unsam.pds.domains.ComentarioHospedaje
import ar.edu.unsam.pds.domains.Hospedaje
import ar.edu.unsam.pds.domains.Reserva
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

    @GetMapping("/usuarios/{userId}/amigos")
    @Operation(summary = "Endpoint acceder a los amigos del usuario")
    fun getUserAmigos(@PathVariable userId: Long): List<AmigoDTO> {
        return this.userService.getUserAmigos(userId)
    }

    @GetMapping("/usuarios/{userId}/comentarios")
    @Operation(summary = "Endpoint acceder a los comentarios del usuario")
    fun getUserComentarios(@PathVariable userId: Long): List<ComentarioHospedaje> {
        return this.userService.getUserComentarios(userId)
    }

    @GetMapping("/usuarios/{userId}/reservas")
    @Operation(summary = "Endpoint acceder a las reservas compradas por el usuario")
    fun getUserReservas(@PathVariable userId: Long): List<ReservaUsuarioDTO> {
        return this.userService.getUserReservas(userId)
    }

    @GetMapping("/usuarios/{userId}/hospedajes")
    @Operation(summary = "Endpoint acceder a las publicaciones del usuario")
    fun getUserHospedajes(@PathVariable userId: Long): List<HospedajeUsuarioDTO>{
      return this.userService.getUserHospedajes(userId)
    }

    @PostMapping("/usuarios/{userId}/agregarAmigo/{nuevoAmigoId}")
    @Operation(summary = "Endpoint para agregar un amigo")
    fun agregarAmigo(@PathVariable userId: Int, @PathVariable nuevoAmigoId: Int): Int {
        this.userService.agregarAmigo(userId, nuevoAmigoId)
        return 200
    }
    @GetMapping("/usuarios/{userId}/posiblesAmigos")
    @Operation(summary = "Endpoint para obtener los usuarios que pueden ser amigos del usuario")
    fun posiblesAmigos(@PathVariable userId: Long): List<PosibleAmigo> {
        return this.userService.posiblesAmigos(userId)
    }

    @DeleteMapping("/comentarios/{reservaId}/delete")
    @Operation(summary = "Endpoint eliminar un comentario")
    fun eliminarComentario(@PathVariable reservaId: Int) {
        this.userService.eliminarComentario(reservaId)
    }

    @DeleteMapping("/usuarios/{userId}/amigos/{amigoId}/delete")
    @Operation(summary = "Endpoint eliminar un amigo")
    fun eliminarAmigo(@PathVariable userId: Int, @PathVariable amigoId: Int) {
        this.userService.eliminarAmigo(userId, amigoId)
    }

    @PostMapping("nuevoSaldo/{userId}")
    @Operation(summary = "Endpoint para cargar saldo")
    fun cargarSaldo(@PathVariable userId: Long,@RequestBody nuevoSaldo: Double){
        this.userService.actualizarSaldo(userId,nuevoSaldo)
    }

    @PostMapping("cambiarFechaNac/{userId}")
    @Operation(summary = "Endpoint para carmbiar Fecha Nacimiento")
    fun modificarFecha(@PathVariable userId: Long,@RequestBody nuevaFecha: LocalDate){
        this.userService.actualizarFecha(userId,nuevaFecha)
    }

    @PostMapping("cambiarPais/{userId}")
    @Operation(summary = "Endpoint para carmbiar Pais")
    fun modificarPais(@PathVariable userId: Long,@RequestBody pais: String){
        this.userService.actualizarPais(userId,pais)
    }

}