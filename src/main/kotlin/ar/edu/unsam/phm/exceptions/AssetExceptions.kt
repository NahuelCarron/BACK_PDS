package ar.edu.unsam.phm.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class AssetInvalido(mensaje: String): RuntimeException(mensaje) {}
