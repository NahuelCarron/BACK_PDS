package ar.edu.unsam.phm.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class ErrorFechas(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class CantidadPasajerosIncorrecto(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class ReservaYaTieneComentario(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class NoExisteReserva(mensaje: String) : RuntimeException(mensaje) {}

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
class FechaDeFinNoAlcanzada(mensaje: String) : RuntimeException(mensaje) {}
