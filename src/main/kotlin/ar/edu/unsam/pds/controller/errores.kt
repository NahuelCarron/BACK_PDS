package ar.edu.unsam.pds.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BusinessException(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(mensaje: String) : RuntimeException(mensaje) {}

class InexistentIDException(mensaje: String): RuntimeException(mensaje) {}

class ExistentIDException(mensaje: String): RuntimeException(mensaje) {}