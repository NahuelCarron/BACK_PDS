package ar.edu.unsam.pds.services

import ar.edu.unsam.pds.repositories.AssetsRepositorio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ByteArrayResource
import org.springframework.stereotype.Service

@Service
class AssetsService {

    @Autowired
    lateinit var assetsRepositorio: AssetsRepositorio

    fun obtenerAsset(assetName: String): ByteArrayResource {
        // TODO: validar si el nombre es correcto
        return this.assetsRepositorio.obtenerAsset(assetName)
    }

}