package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.domains.*
import java.time.LocalDate

class VariablesTest {
}

val eminem = Usuario(
    username = "eminem",
    contrasenia = "abc123",
    nombre = "Marshall Bruce",
    apellido = "Mathers III",
    fecha_nacimiento = LocalDate.of(1972, 10, 17),
    pais = Pais.USA,
    saldo = 50000.0,
    foto_perfil = "http://localhost:9000/api/v0/assets/3ce66d74-6f90-4219-ae6f-be3ef24b163e.jpg",
)

val solari = Usuario(
    username = "indio",
    contrasenia = "abc123",
    nombre = "Carlos Alberto",
    apellido = "Solari",
    fecha_nacimiento = LocalDate.now(),
    pais = Pais.ARG,
    saldo = 34000.0,
    foto_perfil = "http://localhost:9000/api/v0/assets/513c8ff4-2911-4736-b2f4-5707982b70e2.jpg",
)

val hospedaje1 = Espacio(
    titulo ="Piso de diseño moderno y amplio", descripcion = "Es un lugar hermoso ubicado en Buenos aires",
    capacidad = 4, habitaciones = 2, banios = 1, detalleAlojamiento = "Las habitaciones disponen de aire acondicionado, escritorio, caja fuerte, TV de pantalla plana, patio y baño privado con ducha. Las habitaciones incluyen nevera. Sirve un desayuno americano todas las mañanas.",
    servicios = mutableListOf(Servicio.LIMPIEZA), ubicacion = "Ayacucho 152",
    duenio = solari, costo_hora = 25360.0,
    hospedajeTipo = tiposHospedajes[0], otrosAspectos = "Hay bañera de hidromasaje. Se puede jugar al billar y al ping pong. La zona es ideal para practicar ciclismo."
)

val hospedaje2 = Espacio(
    titulo ="departamento moderno de tres ambientes", descripcion = "",
    capacidad = 5, habitaciones = 3, banios = 1, detalleAlojamiento = "",
    servicios = mutableListOf(Servicio.WIFI), ubicacion = "Rivadavia 623",
    duenio = solari, costo_hora = 28720.0,
    hospedajeTipo = tiposHospedajes[1], otrosAspectos = ""
)

val hospedaje3 = Espacio(
    titulo ="departamento moderno de tres ambientes", descripcion = "",
    capacidad = 5, habitaciones = 3, banios = 1, detalleAlojamiento = "",
    servicios = mutableListOf(Servicio.LIMPIEZA), ubicacion = "Rivadavia 623",
    duenio = solari, costo_hora = 22400.0,
    hospedajeTipo = tiposHospedajes[2], otrosAspectos = ""
)


val reserva1 = Renta(
    usuario = eminem,
    espacio = hospedaje1,
    fecha_desde = LocalDate.of(2023, 3, 20),
    fecha_hasta = LocalDate.of(2023, 3, 21),
    cantPasajeros = 3
)
val reserva2 = Renta(
    usuario = eminem,
    espacio = hospedaje2,
    fecha_desde = LocalDate.of(2023, 3, 23),
    fecha_hasta = LocalDate.of(2023, 3, 27),
    cantPasajeros = 2
)
val reserva3 = Renta(
    usuario = eminem,
    espacio = hospedaje3,
    fecha_desde = LocalDate.of(2023, 3, 29),
    fecha_hasta = LocalDate.of(2023, 4, 3),
    cantPasajeros = 4
)