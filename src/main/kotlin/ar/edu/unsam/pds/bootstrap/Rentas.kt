package ar.edu.unsam.pds.bootstrap

import ar.edu.unsam.pds.domains.Comentario
import ar.edu.unsam.pds.domains.Renta
import java.time.LocalDate

var comentarioReservaUsuario1Casa1 = Comentario(
    comentario = "el inodoro estaba tapado",
    puntaje = 2,
    fechaPublicacion = LocalDate.of(2023, 3, 28),
)
val reservaUsuario1Casa1 = Renta(
            usuario = eminem,
            espacio = hospedajeCasa1,
            fecha_desde = LocalDate.of(2023, 3, 20),
            fecha_hasta = LocalDate.of(2023, 3, 23),
)
var comentarioReservaUsuario1Casa2 = Comentario(
    comentario = "Recomiendo, muy cómodo el duplex.",
    puntaje = 2,
    fechaPublicacion = LocalDate.of(2023, 4, 30),
)
val reservaUsuario1Casa2 = Renta(
            usuario = eminem,
            espacio = hospedajeCasa2,
            fecha_desde = LocalDate.of(2023, 4, 22),
            fecha_hasta = LocalDate.of(2023, 4, 29),
)

val reservaUsuario1Depto5 = Renta(
            usuario = eminem,
            espacio = hospedajeDepartamento5,
            fecha_desde = LocalDate.of(2023, 5, 22),
            fecha_hasta = LocalDate.of(2023, 5, 29),
)
var comentarioReservaUsuario2Casa2 = Comentario(
    comentario = "Buenisimo!!!!! Voy a volver",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
)
val reservaUsuario2Casa2 = Renta(
            usuario = solari,
            espacio = hospedajeCasa2,
            fecha_desde = LocalDate.of(2023, 4, 3),
            fecha_hasta = LocalDate.of(2023, 4, 5),
)
var comentarioReservaUsuario2Casa3 = Comentario(
    comentario = "Casa recomendable y muy comoda",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
)
 val reservaUsuario2Casa3 = Renta(
            usuario = solari,
            espacio = hospedajeCasa3,
            fecha_desde = LocalDate.of(2023, 4, 10),
            fecha_hasta = LocalDate.of(2023, 4, 15),
)
var comentarioReservaUsuario3Casa4 = Comentario(
    comentario = "Buena Casa",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
)
val reservaUsuario3Casa4 = Renta(
            usuario = michaelJackson,
            espacio = hospedajeCasa4,
            fecha_desde = LocalDate.of(2023, 4, 20),
            fecha_hasta = LocalDate.of(2023, 4, 21),
)
var comentarioReservaUsuario3Casa5 = Comentario(
    comentario = "el inodoro estaba tapado",
    puntaje = 2,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
)
val reservaUsuario3Casa5 = Renta(
            usuario = michaelJackson,
            espacio = hospedajeCasa5,
            fecha_desde = LocalDate.of(2023, 4, 23),
            fecha_hasta = LocalDate.of(2023, 4, 27),
)
var comentarioReservaUsuario4Casa6 = Comentario(
    comentario = "me encanto",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 5, 5),
)
val reservaUsuario4Casa6 = Renta(
            usuario = karolg,
            espacio = hospedajeCasa6,
            fecha_desde = LocalDate.of(2023, 5, 1),
            fecha_hasta = LocalDate.of(2023, 5, 3),
)

val reservaUsuario4Casa7 = Renta(
            usuario = karolg,
            espacio = hospedajeCasa7,
            fecha_desde = LocalDate.of(2023, 6, 20),
            fecha_hasta = LocalDate.of(2023, 6, 21),
)

val reservaUsuario1Casa7 = Renta(
            usuario = eminem,
            espacio = hospedajeCasa7,
            fecha_desde = LocalDate.of(2022, 8, 20),
            fecha_hasta = LocalDate.of(2022, 8, 21),
)

val reservaUsuario1Casa8 = Renta(
            usuario = eminem,
            espacio = hospedajeCasa8,
            fecha_desde = LocalDate.of(2022, 9, 20),
            fecha_hasta = LocalDate.of(2022, 9, 21),
)
var comentarioReservaUsuario4Casa1v1 = Comentario(
    comentario = "Muy lindo lugar, tiene un patio hermoso",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 3, 2),
)
val reservaUsuario4Casa1v1 = Renta(
            usuario = karolg,
            espacio = hospedajeCasa1,
            fecha_desde = LocalDate.of(2022, 9, 20),
            fecha_hasta = LocalDate.of(2022, 9, 25),
)
var comentarioReservaUsuario3Casa1 = Comentario(
    comentario = "Todo estaba muy sucio",
    puntaje = 0,
    fechaPublicacion = LocalDate.of(2023, 1, 25),
)
val reservaUsuario3Casa1 = Renta(
            usuario = michaelJackson,
            espacio = hospedajeCasa1,
            fecha_desde = LocalDate.of(2023, 1, 20),
            fecha_hasta = LocalDate.of(2023, 1, 22),
)
var comentarioReservaUsuario4Casa1v2 = Comentario(
    comentario = "Fui por segunda vez, lo recomiendo",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 5, 3),
)
val reservaUsuario4Casa1v2 = Renta(
            usuario = karolg,
            espacio = hospedajeCasa1,
            fecha_desde = LocalDate.of(2023, 4, 20),
            fecha_hasta = LocalDate.of(2023, 4, 29),
)