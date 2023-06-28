package ar.edu.unsam.pds.bootstrap

import ar.edu.unsam.pds.domains.*
import ar.edu.unsam.pds.repositories.*
import ar.edu.unsam.pds.services.UserService
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Bootstrap: InitializingBean {

    @Autowired
    private lateinit var usuariosRepository: UsuarioRepositorio
    @Autowired
    private lateinit var usuarioService: UserService
    @Autowired
    private lateinit var espacioRepository: EspacioRepositorio

    @Autowired
    private lateinit var rentaRepository: RentasRepositorio

    @Autowired
    private lateinit var comentarioRepository: ComentarioRepositorio

    fun iniciarUsuarios() {
        this.usuarioService.crearUsuario(eminem)
        this.usuarioService.crearUsuario(solari)
        this.usuarioService.crearUsuario(michaelJackson)
        this.usuarioService.crearUsuario(karolg)
    }

    fun iniciarEspacios() {
        //Casas
        espacioRepository.save(espacioCasa1)
        espacioRepository.save(espacioCasa2)
        espacioRepository.save(espacioCasa3)
        espacioRepository.save(espacioCasa4)
        espacioRepository.save(espacioCasa5)
        espacioRepository.save(espacioCasa6)
        espacioRepository.save(espacioCasa7)
        espacioRepository.save(espacioCasa8)
        //Departamentos
        espacioRepository.save(espacioDepartamento1)
        espacioRepository.save(espacioDepartamento2)
        espacioRepository.save(espacioDepartamento3)
        espacioRepository.save(espacioDepartamento4)
        espacioRepository.save(espacioDepartamento5)
        espacioRepository.save(espacioDepartamento6)
        espacioRepository.save(espacioDepartamento7)
        espacioRepository.save(espacioDepartamento8)
        //Cabañas
        espacioRepository.save(espacioCabania1)
        espacioRepository.save(espacioCabania2)
        espacioRepository.save(espacioCabania3)
        espacioRepository.save(espacioCabania4)
        espacioRepository.save(espacioCabania5)
        espacioRepository.save(espacioCabania6)
        espacioRepository.save(espacioCabania7)
        espacioRepository.save(espacioCabania8)
    }

    fun iniciarRentas(){
        this.crearRentas(rentaUsuario1Casa1)
        this.crearRentas(rentaUsuario1Casa2)
        this.crearRentas(rentaUsuario1Depto5)
        this.crearRentas(rentaUsuario2Casa2)
        this.crearRentas(rentaUsuario2Casa3)
        this.crearRentas(rentaUsuario3Casa4)
        this.crearRentas(rentaUsuario3Casa5)
        this.crearRentas(rentaUsuario4Casa6)
        this.crearRentas(rentaUsuario4Casa7)
        this.crearRentas(rentaUsuario1Casa7)
        this.crearRentas(rentaUsuario1Casa8)
        this.crearRentas(rentaUsuario4Casa1v1)
        this.crearRentas(rentaUsuario3Casa1)
        this.crearRentas(rentaUsuario4Casa1v2)
    }

    fun crearRentas(renta: Renta){
        rentaRepository.save(renta)
    }
    fun iniciarComentarios(){
        crearComentario(comentarioRentaUsuario1Casa1)
        crearComentario(comentarioRentaUsuario1Casa2)
        crearComentario(comentarioRentaUsuario2Casa2)
        crearComentario(comentarioInquilinoUsuario2Casa2)
    }
    fun crearComentario(comentario: Comentario){
        comentarioRepository.save(comentario)
        var espacio = espacioRepository.findById(comentario.renta!!.espacio!!.id!!).get()
        if (comentario.tipoComentario == "renta") { cargarPuntaje(espacio)}
    }
    fun cargarPuntaje(espacio : Espacio){
        espacio.puntajePromedio = rentaRepository.obtenerPromedioComentarios(espacio.id!!)
        espacioRepository.save(espacio)
    }
    override fun afterPropertiesSet() {
        iniciarUsuarios()
        iniciarEspacios()
        iniciarRentas()
        iniciarComentarios()
    }
}