package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.controller.dto.EspacioDTO
import ar.edu.unsam.pds.repositories.EspacioRepositorio
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import io.kotest.matchers.shouldBe

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Hospedaje")
class HospedajeTestController {
    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var hopedajesRepo : EspacioRepositorio
    var objectMapper: ObjectMapper = ObjectMapper().registerModule(JavaTimeModule())

    @BeforeEach
    fun init() {

    }

    @Test
    fun `se puede buscar un hospedaje por su id`() {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/hospedaje/" + 1))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$.capacidad").value(this.hopedajesRepo.findById(1).get().capacidad.toString()))
    }

    @Test
    fun `Me traigo un hospedaje filtrado`() {
        val filtro = mapOf(
            "ubicacion" to "Aya",
            "fechaInicio" to "2023-04-12",
            "fechaFin" to "2023-04-13",
            "capacidad" to 2,
            "numeroPagina" to 1,
            "puntajes" to listOf(1)
        )
        val response = mockMvc
            .perform(MockMvcRequestBuilders
                .post("/hospedajes/list")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filtro))
            )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()
            .response
            .contentAsString

        val hospedajesNode = objectMapper.readTree(response).get("hospedajes")
        val hospedajes: List<EspacioDTO> = objectMapper.readValue(hospedajesNode.traverse(), object : TypeReference<List<EspacioDTO>>() {})
        hospedajes.size shouldBe 1 // TODO: fix retornando 0 en vez de 1
        //TODO: Comentario para justificar
        /*
        En este código, primero leemos el árbol JSON de la respuesta usando el método readTree().
        Luego, obtenemos la propiedad hospedajes del árbol usando el método get().
        A continuación, usamos el método traverse() en el nodo hospedajes para obtener un objeto JsonParser,
        que podemos pasar al método readValue() para deserializar la lista de Hospedaje.
        */
    }


}