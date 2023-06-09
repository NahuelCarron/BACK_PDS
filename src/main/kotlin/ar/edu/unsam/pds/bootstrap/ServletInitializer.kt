package ar.edu.unsam.pds.bootstrap

import ar.edu.unsam.pds.BackendApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        print("Ejecutando ServletInitializer")
        return application.sources(BackendApplication::class.java)
    }

}
