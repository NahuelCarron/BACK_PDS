package ar.edu.unsam.phm.bootstrap

import ar.edu.unsam.phm.domains.Comentario
import ar.edu.unsam.phm.domains.Reserva
import java.time.LocalDate

var comentarioReservaUsuario1Casa1 = Comentario(
    comentario = "el inodoro estaba tapado",
    puntaje = 2,
    fechaPublicacion = LocalDate.of(2023, 3, 28),
)
val reservaUsuario1Casa1 = Reserva(
            usuario = eminem,
            hospedaje = hospedajeCasa1,
            inicio = LocalDate.of(2023, 3, 20),
            fin = LocalDate.of(2023, 3, 23),
            cantPasajeros = 2,
            comentario = comentarioReservaUsuario1Casa1
)
var comentarioReservaUsuario1Casa2 = Comentario(
    comentario = "Recomiendo, muy cómodo el duplex.",
    puntaje = 2,
    fechaPublicacion = LocalDate.of(2023, 4, 30),
)
val reservaUsuario1Casa2 = Reserva(
            usuario = eminem,
            hospedaje = hospedajeCasa2,
            inicio = LocalDate.of(2023, 4, 22),
            fin = LocalDate.of(2023, 4, 29),
            comentario = comentarioReservaUsuario1Casa2,
            cantPasajeros = 2
)

val reservaUsuario1Depto5 = Reserva(
            usuario = eminem,
            hospedaje = hospedajeDepartamento5,
            inicio = LocalDate.of(2023, 5, 22),
            fin = LocalDate.of(2023, 5, 29),
            cantPasajeros = 2
)
var comentarioReservaUsuario2Casa2 = Comentario(
    comentario = "Buenisimo!!!!! Voy a volver",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
)
val reservaUsuario2Casa2 = Reserva(
            usuario = solari,
            hospedaje = hospedajeCasa2,
            inicio = LocalDate.of(2023, 4, 3),
            fin = LocalDate.of(2023, 4, 5),
            comentario = comentarioReservaUsuario2Casa2,
            cantPasajeros = 2
)
var comentarioReservaUsuario2Casa3 = Comentario(
    comentario = "Casa recomendable y muy comoda",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
)
 val reservaUsuario2Casa3 = Reserva(
            usuario = solari,
            hospedaje = hospedajeCasa3,
            inicio = LocalDate.of(2023, 4, 10),
            fin = LocalDate.of(2023, 4, 15),
            comentario = comentarioReservaUsuario2Casa3,
            cantPasajeros = 2
)
var comentarioReservaUsuario3Casa4 = Comentario(
    comentario = "Buena Casa",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
)
val reservaUsuario3Casa4 = Reserva(
            usuario = michaelJackson,
            hospedaje = hospedajeCasa4,
            inicio = LocalDate.of(2023, 4, 20),
            fin = LocalDate.of(2023, 4, 21),
            comentario = comentarioReservaUsuario3Casa4,
            cantPasajeros = 2
)
var comentarioReservaUsuario3Casa5 = Comentario(
    comentario = "el inodoro estaba tapado",
    puntaje = 2,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
)
val reservaUsuario3Casa5 = Reserva(
            usuario = michaelJackson,
            hospedaje = hospedajeCasa5,
            inicio = LocalDate.of(2023, 4, 23),
            fin = LocalDate.of(2023, 4, 27),
            comentario = comentarioReservaUsuario3Casa5,
            cantPasajeros = 2
)
var comentarioReservaUsuario4Casa6 = Comentario(
    comentario = "me encanto",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 5, 5),
)
val reservaUsuario4Casa6 = Reserva(
            usuario = karolg,
            hospedaje = hospedajeCasa6,
            inicio = LocalDate.of(2023, 5, 1),
            fin = LocalDate.of(2023, 5, 3),
            comentario = comentarioReservaUsuario4Casa6,
            cantPasajeros = 1
)

val reservaUsuario4Casa7 = Reserva(
            usuario = karolg,
            hospedaje = hospedajeCasa7,
            inicio = LocalDate.of(2023, 6, 20),
            fin = LocalDate.of(2023, 6, 21),
            cantPasajeros = 2
)

val reservaUsuario1Casa7 = Reserva(
            usuario = eminem,
            hospedaje = hospedajeCasa7,
            inicio = LocalDate.of(2022, 8, 20),
            fin = LocalDate.of(2022, 8, 21),
            cantPasajeros = 2
)

val reservaUsuario1Casa8 = Reserva(
            usuario = eminem,
            hospedaje = hospedajeCasa8,
            inicio = LocalDate.of(2022, 9, 20),
            fin = LocalDate.of(2022, 9, 21),
            cantPasajeros = 2
)
var comentarioReservaUsuario4Casa1v1 = Comentario(
    comentario = "Muy lindo lugar, tiene un patio hermoso",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 3, 2),
)
val reservaUsuario4Casa1v1 = Reserva(
            usuario = karolg,
            hospedaje = hospedajeCasa1,
            inicio = LocalDate.of(2022, 9, 20),
            fin = LocalDate.of(2022, 9, 25),
            comentario = comentarioReservaUsuario4Casa1v1,
            cantPasajeros = 4
)
var comentarioReservaUsuario3Casa1 = Comentario(
    comentario = "Todo estaba muy sucio",
    puntaje = 0,
    fechaPublicacion = LocalDate.of(2023, 1, 25),
)
val reservaUsuario3Casa1 = Reserva(
            usuario = michaelJackson,
            hospedaje = hospedajeCasa1,
            inicio = LocalDate.of(2023, 1, 20),
            fin = LocalDate.of(2023, 1, 22),
            comentario = comentarioReservaUsuario3Casa1,
            cantPasajeros = 4
)
var comentarioReservaUsuario4Casa1v2 = Comentario(
    comentario = "Fui por segunda vez, lo recomiendo",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 5, 3),
)
val reservaUsuario4Casa1v2 = Reserva(
            usuario = karolg,
            hospedaje = hospedajeCasa1,
            inicio = LocalDate.of(2023, 4, 20),
            fin = LocalDate.of(2023, 4, 29),
            comentario = comentarioReservaUsuario4Casa1v2,
            cantPasajeros = 3
)