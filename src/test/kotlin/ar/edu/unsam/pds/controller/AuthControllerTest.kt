package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.domains.Usuario
import ar.edu.unsam.pds.repositories.UsuarioRepositorio
import ar.edu.unsam.pds.services.AuthService
import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Dado un controller de autenticacion")
class AuthControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var usuarioRepositorio: UsuarioRepositorio
    @Autowired
    lateinit var authService: AuthService
    var objectMapper: ObjectMapper = ObjectMapper()

    @Test
    fun `Testeo endpoint de login correctamente`() {
        val credentials = mapOf("username" to "karolg", "password" to "abc123")
        val response = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(credentials))
                )
                .andExpect(status().isOk)
                .andReturn()
                .response
                .contentAsString
        val id: Long? = objectMapper
                .readValue(
                        response,
                        Usuario::class.java
                )
                .id_usuario
        id shouldNotBe null
        id!! shouldBeGreaterThan 0
        this.usuarioRepositorio.findById(id.toLong()).get().username shouldBe "karolg"
    }

    @Test
    fun `Testeo endpoint de login que explota`() {
        // TODO: aplicar assertThrows con request de mockMvc
        assertThrows<EmptyResultDataAccessException> {
            this.authService.login("username invalido", "abc123")
        }
        assertThrows<EmptyResultDataAccessException> {
            this.authService.login("karolg", "password invalido")
        }
    }

}