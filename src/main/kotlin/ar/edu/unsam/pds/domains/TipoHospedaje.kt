package ar.edu.unsam.pds.domains

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import javax.persistence.*

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes(
        JsonSubTypes.Type(value = Casa::class, name = "Casa"), // TODO: ver como reutilizar Casa.nombre
        JsonSubTypes.Type(value = Departamento::class, name = "Departamento"), // TODO: ver como reutilizar Departamento.nombre
        JsonSubTypes.Type(value = Cabania::class, name = "Cabania"), // TODO: ver como reutilizar Cabania.nombre
)

abstract class TipoHospedaje {

    open var nombre: String = ""

    open fun calcularPlus(hospedaje: Hospedaje, cantPasajeros: Int): Double {return 0.0}
}

class Casa() : TipoHospedaje() {

    override var nombre = "Casa"

    override fun calcularPlus(hospedaje: Hospedaje, cantPasajeros: Int): Double {
        return cantPasajeros * 500.0
    }
}

class Departamento() : TipoHospedaje() {

    override var nombre = "Departamento"

    override fun calcularPlus(hospedaje: Hospedaje, cantPasajeros: Int): Double {
        return if (hospedaje.habitaciones!! < 3) 2000.0 else 1000.0 * hospedaje.habitaciones!!
    }
}

class Cabania() : TipoHospedaje() {
    override var nombre = "Cabania"

    override fun calcularPlus(hospedaje: Hospedaje, cantPasajeros: Int): Double {
        return if (hospedaje.poseeServicio(Servicio.LIMPIEZA)) 10000.0 else 0.0
    }
}


val tiposHospedajes = listOf(
        Casa(),
        Departamento(),
        Cabania(),
)


// TipoHospedaje converter for Hibernate using attribute "name"
//
// "Cabania" -> Cabania()
// Cabania() -> "Cabania"
//
class TipoHospedajeConverter : AttributeConverter<TipoHospedaje, String> {
    override fun convertToDatabaseColumn(attribute: TipoHospedaje?): String {
        return attribute?.nombre ?: ""
    }

    override fun convertToEntityAttribute(dbData: String?): TipoHospedaje {
        return tiposHospedajes.find { it.nombre == dbData } ?: throw Exception("TipoHospedajeConverter: no se encontro el tipo de hospedaje $dbData")
    }
}