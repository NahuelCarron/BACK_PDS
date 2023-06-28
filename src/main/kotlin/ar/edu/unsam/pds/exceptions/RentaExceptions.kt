package ar.edu.unsam.pds.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class ErrorFechas(mensaje: String) : RuntimeException(mensaje) {}
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class ErrorUsernamePassword(mensaje: String) : RuntimeException(mensaje) {}
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class CantidadPasajerosIncorrecto(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class RentaYaTieneComentario(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class NoExisteRenta(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class FechaDeFinNoAlcanzada(mensaje: String) : RuntimeException(mensaje) {}
