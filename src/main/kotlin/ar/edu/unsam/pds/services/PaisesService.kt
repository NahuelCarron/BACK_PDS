package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.domains.Pais
import org.springframework.stereotype.Service

@Service
class PaisesService {

    //TODO: Deberiamos tomar de una clase llamada PAIS, asi tomamos todos los paises de ahi y lo unificamos (Ya esta creado)
    fun listPaises(): List<String> {
        return Pais.values().map {it.toString()}
    }

}