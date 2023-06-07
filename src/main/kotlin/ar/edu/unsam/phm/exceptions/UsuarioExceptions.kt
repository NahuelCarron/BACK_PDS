package ar.edu.unsam.phm.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class UsuarioInvalido(mensaje: String): RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class ErrorAlCargarSaldo(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.BAD_REQUEST)
class ErrorFechaNacimiento(mensaje: String) : RuntimeException(mensaje) {}
