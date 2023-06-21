package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.domains.Qya
import ar.edu.unsam.pds.repositories.QyaRepositorio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QyaService {

    @Autowired
    lateinit var qyaRepo : QyaRepositorio

    fun enviarPregunta(qya: Qya) {
        this.qyaRepo.save(qya)
    }

    fun getSinResponder(idUsuario: Long): List<Qya> {
        return this.qyaRepo.findSinResponder(idUsuario)
    }

}