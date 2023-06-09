package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.services.AssetsService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ByteArrayResource
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("*")
class AssetsController {

    @Autowired
    lateinit var assetsService: AssetsService

    @GetMapping("/assets/{assetName}")
    @Operation(summary = "Retorna un asset")
    fun obtenerAsset(@PathVariable assetName: String): ByteArrayResource {
        return this.assetsService.obtenerAsset(assetName)
    }

}
