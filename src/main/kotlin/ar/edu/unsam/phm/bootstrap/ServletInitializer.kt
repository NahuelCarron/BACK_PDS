package ar.edu.unsam.phm.bootstrap

import ar.edu.unsam.phm.BackendApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        print("Ejecutando ServletInitializer")
        return application.sources(BackendApplication::class.java)
    }

}
