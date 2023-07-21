package ar.edu.unsam.pds.bootstrap

import ar.edu.unsam.pds.domains.*
import ar.edu.unsam.pds.repositories.*
import ar.edu.unsam.pds.services.UserService
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate

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
    @Autowired
    private lateinit var qyaRepository: QyaRepositorio
    @Autowired
    private lateinit var UsuQyaEspRepository: UsuarioQyaEspacioRepositorio

    fun iniciarUsuarios() {
        this.usuarioService.crearUsuario(eminem)
        this.usuarioService.crearUsuario(solari)
        this.usuarioService.crearUsuario(michaelJackson)
        this.usuarioService.crearUsuario(karolg)
    }

    fun iniciarEspacios() {
        espacioRepository.save(VillaSerenity)
        espacioRepository.save(GarageEnPlenoCentro)
        espacioRepository.save(QUINCHOPARRILLERO)
        espacioRepository.save(CoworkingUrquiza)
        espacioRepository.save(CasaAmpliaCercaDelRio)
        espacioRepository.save(Iglu)
        espacioRepository.save(DepositosLuis)
        espacioRepository.save(UrquizaDental)
        espacioRepository.save(LocalALaCalle)
        espacioRepository.save(SalonLaVacaLoca)
        espacioRepository.save(OficinasPOINT)
        espacioRepository.save(CoworkingTalampayas)
        espacioRepository.save(VistaLibertador)
        espacioRepository.save(ElevaOffices)
        espacioRepository.save(departamentoConVistaAlMar)
        espacioRepository.save(DepartamentoModerno)
        espacioRepository.save(ParkSafe)
        espacioRepository.save(RefugioAlpinoSereno)
        espacioRepository.save(StudyOasis)
        espacioRepository.save(StudiZen)
    }

    fun iniciarRentas(){
        this.crearRentas(rentaVillaSerenity1)
        this.crearRentas(rentaVillaSerenity2)
        this.crearRentas(rentaGarageEnPlenoCentro1)
        this.crearRentas(rentaGarageEnPlenoCentro2)
        this.crearRentas(rentaQUINCHOPARRILLERO1)
        this.crearRentas(rentaCoworkingUrquiza1)
        this.crearRentas(rentaCoworkingUrquiza2)
        this.crearRentas(rentaCasaAmpliaCercaDelRio1)
        this.crearRentas(rentaCasaAmpliaCercaDelRio2)
        this.crearRentas(rentaCasaAmpliaCercaDelRio3)
        this.crearRentas(rentaIglu1)
        this.crearRentas(rentaDepositosLuis1)
        this.crearRentas(rentaDepositosLuis2)
        this.crearRentas(rentaUrquizaDental1)
    }

    fun crearRentas(renta: Renta){
        rentaRepository.save(renta)
    }
    fun iniciarComentarios(){
        crearComentario(comentarioRentaVillaSerenity1)
        crearComentario(comentarioRentaVillaSerenity2)
        crearComentario(comentarioRentaGarageEnPlenoCentro2)
        crearComentario(comentarioInquilinoUsuario2Casa2)
        crearComentario(comentariorentaQUINCHOPARRILLERO1)
        crearComentario(comentarioRentaCoworkingUrquiza1)
        crearComentario(comentarioRentaCoworkingUrquiza2)
        crearComentario(comentarioRentaIglu1)
        crearComentario(comentarioRentaDepositosLuis1)
        crearComentario(comentarioRentaDepositosLuis2)
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
    fun iniciarQya(){
        var qyaDepositosLuis = Qya("Quería saber si tienen seguridad 24 hrs?","Sisi! Tenemos seguridad las 24 horas", LocalDate.now())
        var qyaRelac = UsuarioQyaEspacio(eminem, qyaDepositosLuis, DepositosLuis)
        crearQYA(qyaDepositosLuis,qyaRelac)

        var qyaDepositosLuis2 = Qya("Puedo pasar a verlo antes de reservarlo??","Si, obvio. En la publicación esta la dirección, vení cuando quieras de 8 a 21 hrs.", LocalDate.now())
        var qyaRelac2 = UsuarioQyaEspacio(solari, qyaDepositosLuis2, DepositosLuis)
        crearQYA(qyaDepositosLuis2,qyaRelac2)

    }
    fun crearQYA(qya: Qya, UsuQyaEsp: UsuarioQyaEspacio){
        qyaRepository.save(qya)
        UsuQyaEspRepository.save(UsuQyaEsp)
    }
    override fun afterPropertiesSet() {
        iniciarUsuarios()
        iniciarEspacios()
        iniciarRentas()
        iniciarComentarios()
        iniciarQya()
    }
}