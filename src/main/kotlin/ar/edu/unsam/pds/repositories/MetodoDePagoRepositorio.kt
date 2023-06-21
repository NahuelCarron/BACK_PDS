package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.domains.MetodoDePago
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MetodoDePagoRepositorio: CrudRepository<MetodoDePago, Long> {

}