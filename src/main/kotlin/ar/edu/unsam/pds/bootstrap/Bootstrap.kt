package ar.edu.unsam.pds.bootstrap

import ar.edu.unsam.pds.domains.*
import ar.edu.unsam.pds.repositories.*
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class Bootstrap: InitializingBean {

    @Autowired
    private lateinit var usuariosRepository: UsuarioRepositorio

    @Autowired
    private lateinit var hospedajeRepository: HospedajeRepositorio

    @Autowired
    private lateinit var reservasRepository: ReservasRepositorio

    @Autowired
    private lateinit var amigosRepository: AmigosRepositorio

    @Autowired
    private lateinit var comentarioRepositoryCrud: ComentarioRepositorio

    fun iniciarUsuarios() {
        usuariosRepository.save(eminem)
        usuariosRepository.save(solari)
        usuariosRepository.save(michaelJackson)
        usuariosRepository.save(karolg)
    }

    fun iniciarHospedajes() {
        //Casas
        hospedajeRepository.save(hospedajeCasa1)
        hospedajeRepository.save(hospedajeCasa2)
        hospedajeRepository.save(hospedajeCasa3)
        hospedajeRepository.save(hospedajeCasa4)
        hospedajeRepository.save(hospedajeCasa5)
        hospedajeRepository.save(hospedajeCasa6)
        hospedajeRepository.save(hospedajeCasa7)
        hospedajeRepository.save(hospedajeCasa8)
        //Departamentos
        hospedajeRepository.save(hospedajeDepartamento1)
        hospedajeRepository.save(hospedajeDepartamento2)
        hospedajeRepository.save(hospedajeDepartamento3)
        hospedajeRepository.save(hospedajeDepartamento4)
        hospedajeRepository.save(hospedajeDepartamento5)
        hospedajeRepository.save(hospedajeDepartamento6)
        hospedajeRepository.save(hospedajeDepartamento7)
        hospedajeRepository.save(hospedajeDepartamento8)
        //Cabañas
        hospedajeRepository.save(hospedajeCabania1)
        hospedajeRepository.save(hospedajeCabania2)
        hospedajeRepository.save(hospedajeCabania3)
        hospedajeRepository.save(hospedajeCabania4)
        hospedajeRepository.save(hospedajeCabania5)
        hospedajeRepository.save(hospedajeCabania6)
        hospedajeRepository.save(hospedajeCabania7)
        hospedajeRepository.save(hospedajeCabania8)
    }

    fun iniciarReserva(){
        this.crearReserva(reservaUsuario1Casa1)
        this.crearReserva(reservaUsuario1Casa2)
        this.crearReserva(reservaUsuario1Depto5)
        this.crearReserva(reservaUsuario2Casa2)
        this.crearReserva(reservaUsuario2Casa3)
        this.crearReserva(reservaUsuario3Casa4)
        this.crearReserva(reservaUsuario3Casa5)
        this.crearReserva(reservaUsuario4Casa6)
        this.crearReserva(reservaUsuario4Casa7)
        this.crearReserva(reservaUsuario1Casa7)
        this.crearReserva(reservaUsuario1Casa8)
        this.crearReserva(reservaUsuario4Casa1v1)
        this.crearReserva(reservaUsuario3Casa1)
        this.crearReserva(reservaUsuario4Casa1v2)
    }

    fun crearReserva(reserva : Reserva){
        reservasRepository.save(reserva)
        if(reserva.comentario != null) {
            comentarioRepositoryCrud.save(reserva.comentario!!)
            this.cargarPuntaje(reserva.hospedaje!!)
        }
    }

    fun cargarPuntaje(hospedaje : Hospedaje){
        hospedaje.puntajePromedio = hospedajeRepository.obtenerPromedioHospedaje(hospedaje.id!!)
        hospedajeRepository.save(hospedaje)
    }

    fun iniciarAmigos() {
        this.amigosRepository.save(RelacionAmigo(usuario = eminem, amigo= solari))
        this.amigosRepository.save(RelacionAmigo(usuario = eminem, amigo= michaelJackson))

        this.amigosRepository.save(RelacionAmigo(usuario = solari, amigo= eminem))
        this.amigosRepository.save(RelacionAmigo(usuario = solari, amigo= michaelJackson))
        this.amigosRepository.save(RelacionAmigo(usuario = solari, amigo= karolg))

        this.amigosRepository.save(RelacionAmigo(usuario = michaelJackson, amigo= solari))
        this.amigosRepository.save(RelacionAmigo(usuario = michaelJackson, amigo= eminem))
        this.amigosRepository.save(RelacionAmigo(usuario = michaelJackson, amigo= karolg))
    }

    override fun afterPropertiesSet() {
        iniciarUsuarios()
        iniciarHospedajes()
        iniciarReserva()
        iniciarAmigos()

    }
}