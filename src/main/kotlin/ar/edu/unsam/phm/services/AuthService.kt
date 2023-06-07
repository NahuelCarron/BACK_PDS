package ar.edu.unsam.phm.services

import ar.edu.unsam.phm.domains.Usuario
import ar.edu.unsam.phm.exceptions.BadRequestException
import ar.edu.unsam.phm.repositories.UsuarioRepositorio
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
        resultado.id = this.usuarioRepositorio.obtenerId(username, password)
        return resultado
    }

}