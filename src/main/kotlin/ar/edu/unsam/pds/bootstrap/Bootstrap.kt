package ar.edu.unsam.pds.bootstrap

import ar.edu.unsam.pds.domains.*
import ar.edu.unsam.pds.repositories.*
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Bootstrap: InitializingBean {

    @Autowired
    private lateinit var usuariosRepository: UsuarioRepositorio

    @Autowired
    private lateinit var espacioRepository: EspacioRepositorio

    @Autowired
    private lateinit var reservasRepository: RentasRepositorio

    fun iniciarUsuarios() {
        usuariosRepository.save(eminem)
        usuariosRepository.save(solari)
        usuariosRepository.save(michaelJackson)
        usuariosRepository.save(karolg)
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
        this.crearRentas(reservaUsuario1Casa1)
        this.crearRentas(reservaUsuario1Casa2)
        this.crearRentas(reservaUsuario1Depto5)
        this.crearRentas(reservaUsuario2Casa2)
        this.crearRentas(reservaUsuario2Casa3)
        this.crearRentas(reservaUsuario3Casa4)
        this.crearRentas(reservaUsuario3Casa5)
        this.crearRentas(reservaUsuario4Casa6)
        this.crearRentas(reservaUsuario4Casa7)
        this.crearRentas(reservaUsuario1Casa7)
        this.crearRentas(reservaUsuario1Casa8)
        this.crearRentas(reservaUsuario4Casa1v1)
        this.crearRentas(reservaUsuario3Casa1)
        this.crearRentas(reservaUsuario4Casa1v2)
    }

    fun crearRentas(reserva : Renta){
        reservasRepository.save(reserva)
    }

    override fun afterPropertiesSet() {
        iniciarUsuarios()
        iniciarEspacios()
        iniciarRentas()
    }
}