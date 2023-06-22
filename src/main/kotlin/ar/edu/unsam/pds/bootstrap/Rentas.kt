package ar.edu.unsam.pds.bootstrap

import ar.edu.unsam.pds.domains.Comentario
import ar.edu.unsam.pds.domains.Renta
import java.time.LocalDate


val rentaUsuario1Casa1 = Renta(
            usuario = eminem,
            espacio = espacioCasa1,
            fecha_desde = LocalDate.of(2023, 3, 20),
            fecha_hasta = LocalDate.of(2023, 3, 23),
            cantPasajeros = 1
)
var comentarioRentaUsuario1Casa1 = Comentario(
    renta = rentaUsuario1Casa1,
    comentario = "el inodoro estaba tapado",
    puntaje = 2,
    fechaPublicacion = LocalDate.of(2023, 3, 28),
    tipoComentario = "renta"
)
val rentaUsuario1Casa2 = Renta(
            usuario = eminem,
            espacio = espacioCasa2,
            fecha_desde = LocalDate.of(2023, 4, 22),
            fecha_hasta = LocalDate.of(2023, 4, 29),
            cantPasajeros = 1
)
var comentarioRentaUsuario1Casa2 = Comentario(
    renta = rentaUsuario1Casa2,
    comentario = "Recomiendo, muy cómodo el duplex.",
    puntaje = 2,
    fechaPublicacion = LocalDate.of(2023, 4, 30),
    tipoComentario = "renta"
)
val rentaUsuario1Depto5 = Renta(
            usuario = eminem,
            espacio = espacioDepartamento5,
            fecha_desde = LocalDate.of(2023, 5, 22),
            fecha_hasta = LocalDate.of(2023, 5, 29),
            cantPasajeros = 1
)

val rentaUsuario2Casa2 = Renta(
            usuario = solari,
            espacio = espacioCasa2,
            fecha_desde = LocalDate.of(2023, 4, 3),
            fecha_hasta = LocalDate.of(2023, 4, 5),
    cantPasajeros = 1
)
var comentarioRentaUsuario2Casa2 = Comentario(
    renta= rentaUsuario2Casa2,
    comentario = "Buenisimo!!!!! Voy a volver",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
    tipoComentario = "renta"
)
var comentarioInquilinoUsuario2Casa2 = Comentario(
    comentario = "Re buen inquilino!!!!",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 5, 28),
    renta = rentaUsuario2Casa2,
    tipoComentario = "inquilino"
)
 val rentaUsuario2Casa3 = Renta(
            usuario = solari,
            espacio = espacioCasa3,
            fecha_desde = LocalDate.of(2023, 4, 10),
            fecha_hasta = LocalDate.of(2023, 4, 15),
     cantPasajeros = 1
)
var comentarioRentaUsuario3Casa4 = Comentario(
    comentario = "Buena Casa",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
)
val rentaUsuario3Casa4 = Renta(
            usuario = michaelJackson,
            espacio = espacioCasa4,
            fecha_desde = LocalDate.of(2023, 4, 20),
            fecha_hasta = LocalDate.of(2023, 4, 21),
    cantPasajeros = 1
)
var comentarioRentaUsuario3Casa5 = Comentario(
    comentario = "el inodoro estaba tapado",
    puntaje = 2,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
)
val rentaUsuario3Casa5 = Renta(
            usuario = michaelJackson,
            espacio = espacioCasa5,
            fecha_desde = LocalDate.of(2023, 4, 23),
            fecha_hasta = LocalDate.of(2023, 4, 27),
    cantPasajeros = 1
)
var comentarioRentaUsuario4Casa6 = Comentario(
    comentario = "me encanto",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 5, 5),
)
val rentaUsuario4Casa6 = Renta(
            usuario = karolg,
            espacio = espacioCasa6,
            fecha_desde = LocalDate.of(2023, 5, 1),
            fecha_hasta = LocalDate.of(2023, 5, 3),
    cantPasajeros = 1
)

val rentaUsuario4Casa7 = Renta(
            usuario = karolg,
            espacio = espacioCasa7,
            fecha_desde = LocalDate.of(2023, 6, 20),
            fecha_hasta = LocalDate.of(2023, 6, 21),
    cantPasajeros = 1
)

val rentaUsuario1Casa7 = Renta(
            usuario = eminem,
            espacio = espacioCasa7,
            fecha_desde = LocalDate.of(2022, 8, 20),
            fecha_hasta = LocalDate.of(2022, 8, 21),
    cantPasajeros = 1
)

val rentaUsuario1Casa8 = Renta(
            usuario = eminem,
            espacio = espacioCasa8,
            fecha_desde = LocalDate.of(2022, 9, 20),
            fecha_hasta = LocalDate.of(2022, 9, 21),
    cantPasajeros = 1
)
var comentarioRentaUsuario4Casa1v1 = Comentario(
    comentario = "Muy lindo lugar, tiene un patio hermoso",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 3, 2),
)
val rentaUsuario4Casa1v1 = Renta(
            usuario = karolg,
            espacio = espacioCasa1,
            fecha_desde = LocalDate.of(2022, 9, 20),
            fecha_hasta = LocalDate.of(2022, 9, 25),
    cantPasajeros = 1
)
var comentarioRentaUsuario3Casa1 = Comentario(
    comentario = "Todo estaba muy sucio",
    puntaje = 0,
    fechaPublicacion = LocalDate.of(2023, 1, 25),
)
val rentaUsuario3Casa1 = Renta(
            usuario = michaelJackson,
            espacio = espacioCasa1,
            fecha_desde = LocalDate.of(2023, 1, 20),
            fecha_hasta = LocalDate.of(2023, 1, 22),
    cantPasajeros = 1
)
var comentarioRentaUsuario4Casa1v2 = Comentario(
    comentario = "Fui por segunda vez, lo recomiendo",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 5, 3),
)
val rentaUsuario4Casa1v2 = Renta(
            usuario = karolg,
            espacio = espacioCasa1,
            fecha_desde = LocalDate.of(2023, 4, 20),
            fecha_hasta = LocalDate.of(2023, 4, 29),
    cantPasajeros = 1
)