package ar.edu.unsam.pds.controller

import ar.edu.unsam.pds.domains.*
import java.time.LocalDate

class VariablesTest {
}

val eminem = Usuario(
    username = "eminem",
    password = "abc123",
    nombre = "Marshall Bruce",
    apellido = "Mathers III",
    fechaNacimiento = LocalDate.of(1972, 10, 17),
    pais = Pais.USA,
    saldo = 50000.0,
    profileUrl = "http://localhost:9000/api/v0/assets/3ce66d74-6f90-4219-ae6f-be3ef24b163e.jpg",
)

val solari = Usuario(
    username = "indio",
    password = "abc123",
    nombre = "Carlos Alberto",
    apellido = "Solari",
    fechaNacimiento = LocalDate.now(),
    pais = Pais.ARG,
    saldo = 34000.0,
    profileUrl = "http://localhost:9000/api/v0/assets/513c8ff4-2911-4736-b2f4-5707982b70e2.jpg",
)

val hospedaje1 = Hospedaje(
    nombre ="Piso de diseño moderno y amplio", descripcion = "Es un lugar hermoso ubicado en Buenos aires",
    capacidad = 4, habitaciones = 2, banios = 1, detalleAlojamiento = "Las habitaciones disponen de aire acondicionado, escritorio, caja fuerte, TV de pantalla plana, patio y baño privado con ducha. Las habitaciones incluyen nevera. Sirve un desayuno americano todas las mañanas.",
    servicios = mutableListOf(Servicio.LIMPIEZA), ubicacion = "Ayacucho 152",
    duenio = solari, costoBase = 25360.0,
    hospedajeTipo = tiposHospedajes[0], otrosAspectos = "Hay bañera de hidromasaje. Se puede jugar al billar y al ping pong. La zona es ideal para practicar ciclismo."
)

val hospedaje2 = Hospedaje(
    nombre ="departamento moderno de tres ambientes", descripcion = "",
    capacidad = 5, habitaciones = 3, banios = 1, detalleAlojamiento = "",
    servicios = mutableListOf(Servicio.WIFI), ubicacion = "Rivadavia 623",
    duenio = solari, costoBase = 28720.0,
    hospedajeTipo = tiposHospedajes[1], otrosAspectos = ""
)

val hospedaje3 = Hospedaje(
    nombre ="departamento moderno de tres ambientes", descripcion = "",
    capacidad = 5, habitaciones = 3, banios = 1, detalleAlojamiento = "",
    servicios = mutableListOf(Servicio.LIMPIEZA), ubicacion = "Rivadavia 623",
    duenio = solari, costoBase = 22400.0,
    hospedajeTipo = tiposHospedajes[2], otrosAspectos = ""
)


val reserva1 = Reserva(
    usuario = eminem,
    hospedaje = hospedaje1,
    inicio = LocalDate.of(2023, 3, 20),
    fin = LocalDate.of(2023, 3, 21),
    cantPasajeros = 3
)
val reserva2 = Reserva(
    usuario = eminem,
    hospedaje = hospedaje2,
    inicio = LocalDate.of(2023, 3, 23),
    fin = LocalDate.of(2023, 3, 27),
    cantPasajeros = 2
)
val reserva3 = Reserva(
    usuario = eminem,
    hospedaje = hospedaje3,
    inicio = LocalDate.of(2023, 3, 29),
    fin = LocalDate.of(2023, 4, 3),
    cantPasajeros = 4
)