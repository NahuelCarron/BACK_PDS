package ar.edu.unsam.pds.repositories

import ar.edu.unsam.pds.exceptions.AssetInvalido
import org.springframework.core.io.ByteArrayResource
import org.springframework.stereotype.Repository
import java.nio.file.Files
import java.nio.file.Paths

@Repository
class AssetsRepositorio {

    fun existe(assetName: String): Boolean {
        return Files.exists(Paths.get("src/main/resources/assets/$assetName"))
    }

    fun noExiste(assetName: String): Boolean {
        return !this.existe(assetName)
    }

    fun obtenerAsset(assetName: String): ByteArrayResource {
        if (this.noExiste(assetName)) {
            throw AssetInvalido("El asset $assetName no existe")
        }
        val path = Paths.get("src/main/resources/assets/$assetName")
        val bytes = Files.readAllBytes(path)
        return ByteArrayResource(bytes)
    }

}