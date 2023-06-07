package ar.edu.unsam.phm.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequestException(mensaje: String) : RuntimeException(mensaje) {}
