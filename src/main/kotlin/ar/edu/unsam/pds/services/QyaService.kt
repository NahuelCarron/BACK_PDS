package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.domains.Qya
import ar.edu.unsam.pds.domains.UsuarioQyaEspacio
import ar.edu.unsam.pds.repositories.EspacioRepositorio
import ar.edu.unsam.pds.repositories.QyaRepositorio
import ar.edu.unsam.pds.repositories.UsuarioQyaEspacioRepositorio
import ar.edu.unsam.pds.repositories.UsuarioRepositorio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class QyaService {

    @Autowired
    lateinit var qyaRepositorio: QyaRepositorio
    @Autowired
    lateinit var uqeRepositorio: UsuarioQyaEspacioRepositorio
    @Autowired
    lateinit var usuarioRepositorio: UsuarioRepositorio
    @Autowired
    lateinit var espacioRepositorio: EspacioRepositorio

    fun enviarPregunta(idUsuario: Long, idEspacio: Long, pregunta: String) {
        val qya = Qya(
                pregunta = pregunta,
                fechaPublicacion = LocalDate.now(),
                )
        val optionalUqe = this.uqeRepositorio.getBy(idUsuario, idEspacio)
        val uqe: UsuarioQyaEspacio = if (optionalUqe.isPresent) {
            optionalUqe.get()
        } else {
            UsuarioQyaEspacio(
                    usuario = this.usuarioRepositorio.findById(idUsuario).get(),
                    qya = listOf(),
                    espacio = this.espacioRepositorio.findById(idEspacio).get(),
                    )
        }
        uqe.qya += qya
        this.qyaRepositorio.save(qya)
        this.uqeRepositorio.save(uqe)
    }

    fun getQyas(
            idUsuario: Long?,
            idEspacio: Long?,
        ): List<Qya> {
        return this.uqeRepositorio.getQyas(
                idUsuario,
                idEspacio,
        )
    }

    fun responder(idQya: Long, respuesta: String) {
        val qya = this.qyaRepositorio.findById(idQya).get()
        qya.respuesta = respuesta
        this.qyaRepositorio.save(qya)
    }
}