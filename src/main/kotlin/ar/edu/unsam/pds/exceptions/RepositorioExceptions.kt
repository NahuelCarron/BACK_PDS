package ar.edu.unsam.pds.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class IdInvalido(mensaje: String): RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class elementoEliminado(mensaje: String): RuntimeException(mensaje) {}
