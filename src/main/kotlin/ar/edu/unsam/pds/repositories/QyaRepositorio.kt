package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.domains.Qya
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QyaRepositorio: CrudRepository<Qya, Long> {

}