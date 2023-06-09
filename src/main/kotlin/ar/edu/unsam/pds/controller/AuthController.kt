package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.domains.Usuario
import ar.edu.unsam.pds.exceptions.BadRequestException
import ar.edu.unsam.pds.services.AuthService
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class AuthController {

    @Autowired
    lateinit var authService: AuthService
    var objectMapper: ObjectMapper = ObjectMapper()
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    @PostMapping("/login")
    @Operation(summary = "Endpoint para loguearse usando un usuario y contraseña, retorna el ID del usuario")
    fun login(@RequestBody body: String): Usuario {
        val dto: Usuario = this.objectMapper.readValue(body, Usuario::class.java)
        if (dto.username == null) {
            throw BadRequestException("Parametro 'username' es requerido")
        }
        if (dto.password == null) {
            throw BadRequestException("El parametro 'password' es requerido")
        }
        return this.authService.login(dto.username!!, dto.password!!)
    }

}