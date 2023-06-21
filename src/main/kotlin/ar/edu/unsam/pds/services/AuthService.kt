package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.domains.Usuario
import ar.edu.unsam.pds.exceptions.BadRequestException
import ar.edu.unsam.pds.repositories.UsuarioRepositorio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthService {

    @Autowired
    lateinit var usuarioRepositorio: UsuarioRepositorio

    fun login(username: String, password: String): Usuario {
          if(username == ""){
              throw BadRequestException("tiene que poner un usuario")
          }

        if(password == ""){
            throw BadRequestException("tiene que poner una contraseña")
        }
        val resultado = Usuario()
        resultado.id_usuario = this.usuarioRepositorio.obtenerId(username, password)
        return resultado
    }

}