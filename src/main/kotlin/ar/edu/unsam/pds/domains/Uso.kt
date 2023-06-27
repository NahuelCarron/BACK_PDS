package ar.edu.unsam.pds.domains

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

enum class Uso {
    FIESTA,
    REUNION,
    TRABAJO,
    BODEGA,
    DEPOSITO,
    OFICINA,
    ESTUDIO,
    VIVIENDA,
    COWORKING,
    ENTRETENIMIENTO,
    COMERCIAL
}
