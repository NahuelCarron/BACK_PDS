package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.domains.UsuarioQyaEspacio
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioQyaEspacioRepositorio: CrudRepository<UsuarioQyaEspacio, Long> {

}