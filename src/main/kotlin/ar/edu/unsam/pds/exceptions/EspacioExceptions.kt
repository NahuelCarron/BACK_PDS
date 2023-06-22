package ar.edu.unsam.pds.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class CalificacionInvalida(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class SaldoInsuficiente(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class EspacioInvalido(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class NoEsDuenioDelEspacio(mensaje: String) : RuntimeException(mensaje) {}
