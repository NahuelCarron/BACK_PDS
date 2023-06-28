package ar.edu.unsam.pds.bootstrap

import ar.edu.unsam.pds.domains.Comentario
import ar.edu.unsam.pds.domains.Renta
import java.time.LocalDate


val rentaVillaSerenity1 = Renta(
            usuario = eminem,
            espacio = VillaSerenity,
            fecha_desde = LocalDate.of(2023, 3, 20),
            fecha_hasta = LocalDate.of(2023, 3, 23),
)
var comentarioRentaVillaSerenity1 = Comentario(
    renta = rentaVillaSerenity1,
    comentario = "Excelente casa, pero el wifi funcionaba bastante mal.",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 3, 28),
    tipoComentario = "renta"
)
val rentaVillaSerenity2 = Renta(
            usuario = eminem,
            espacio = VillaSerenity,
            fecha_desde = LocalDate.of(2023, 4, 22),
            fecha_hasta = LocalDate.of(2023, 4, 29),
)
var comentarioRentaVillaSerenity2= Comentario(
    renta = rentaVillaSerenity2,
    comentario = "Recomiendo, muy cómoda y elegante. Hermosa arquitectura. ME ENCANTO!!!",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 4, 30),
    tipoComentario = "renta"
)
val rentaGarageEnPlenoCentro1 = Renta(
            usuario = eminem,
            espacio = GarageEnPlenoCentro,
            fecha_desde = LocalDate.of(2023, 5, 22),
            fecha_hasta = LocalDate.of(2023, 5, 29),
)

val rentaGarageEnPlenoCentro2 = Renta(
            usuario = solari,
            espacio = GarageEnPlenoCentro,
            fecha_desde = LocalDate.of(2023, 4, 3),
            fecha_hasta = LocalDate.of(2023, 4, 5),
)
var comentarioRentaGarageEnPlenoCentro2 = Comentario(
    renta= rentaGarageEnPlenoCentro2,
    comentario = "Buenisimo!!!!! Excelente atención",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
    tipoComentario = "renta"
)
var comentarioInquilinoUsuario2Casa2 = Comentario(
    comentario = "Re buen inquilino!!!!",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 5, 28),
    renta = rentaGarageEnPlenoCentro2,
    tipoComentario = "inquilino"
)
 val rentaQUINCHOPARRILLERO1 = Renta(
            usuario = solari,
            espacio = QUINCHOPARRILLERO,
            fecha_desde = LocalDate.of(2023, 4, 10),
            fecha_hasta = LocalDate.of(2023, 4, 15),
)
var comentariorentaQUINCHOPARRILLERO1 = Comentario(
    renta = rentaQUINCHOPARRILLERO1,
    comentario = "Excelente quincho para compartir con amigos y familia. Volvere!!",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
    tipoComentario = "renta"
)
val rentaCoworkingUrquiza1 = Renta(
            usuario = michaelJackson,
            espacio = CoworkingUrquiza,
            fecha_desde = LocalDate.of(2023, 4, 20),
            fecha_hasta = LocalDate.of(2023, 4, 21),
)
var comentarioRentaCoworkingUrquiza1 = Comentario(
    renta= rentaCoworkingUrquiza1,
    comentario = "No me gustó el ambiente del lugar, la gente medio mala onda",
    puntaje = 2,
    fechaPublicacion = LocalDate.of(2023, 4, 28),
    tipoComentario = "renta"
)
val rentaCoworkingUrquiza2 = Renta(
            usuario = michaelJackson,
            espacio = CoworkingUrquiza,
            fecha_desde = LocalDate.of(2023, 4, 23),
            fecha_hasta = LocalDate.of(2023, 4, 27),
)
var comentarioRentaCoworkingUrquiza2 = Comentario(
    renta= rentaCoworkingUrquiza2,
    comentario = "Muy linda arquitectura del lugar!",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 5, 5),
    tipoComentario = "renta"
)
val rentaCasaAmpliaCercaDelRio1 = Renta(
            usuario = karolg,
            espacio = CasaAmpliaCercaDelRio,
            fecha_desde = LocalDate.of(2023, 5, 1),
            fecha_hasta = LocalDate.of(2023, 5, 3),
)

val rentaCasaAmpliaCercaDelRio2 = Renta(
            usuario = karolg,
            espacio = CasaAmpliaCercaDelRio,
            fecha_desde = LocalDate.of(2023, 6, 20),
            fecha_hasta = LocalDate.of(2023, 6, 21),
)

val rentaCasaAmpliaCercaDelRio3 = Renta(
            usuario = eminem,
            espacio = CasaAmpliaCercaDelRio,
            fecha_desde = LocalDate.of(2022, 8, 20),
            fecha_hasta = LocalDate.of(2022, 8, 21),
)

val rentaIglu1= Renta(
            usuario = eminem,
            espacio = Iglu,
            fecha_desde = LocalDate.of(2022, 9, 20),
            fecha_hasta = LocalDate.of(2022, 9, 21),
)
var comentarioRentaIglu1= Comentario(
    renta = rentaIglu1,
    comentario = "Muy lindo lugar, tiene uns vista al lago hermosa",
    puntaje = 4,
    fechaPublicacion = LocalDate.of(2023, 3, 2),
    tipoComentario = "renta"
)
val rentaDepositosLuis1 = Renta(
            usuario = karolg,
            espacio = DepositosLuis,
            fecha_desde = LocalDate.of(2022, 9, 20),
            fecha_hasta = LocalDate.of(2022, 9, 25),
)
var comentarioRentaDepositosLuis1 = Comentario(
    renta = rentaDepositosLuis1,
    comentario = "Todo estaba muy sucio",
    puntaje = 0,
    fechaPublicacion = LocalDate.of(2023, 1, 25),
    tipoComentario = "renta"
)
val rentaDepositosLuis2 = Renta(
            usuario = michaelJackson,
            espacio = DepositosLuis,
            fecha_desde = LocalDate.of(2023, 1, 20),
            fecha_hasta = LocalDate.of(2023, 1, 22),
)
var comentarioRentaDepositosLuis2 = Comentario(
    renta = rentaDepositosLuis2,
    comentario = "Fui por segunda vez, lo recomiendo",
    puntaje = 5,
    fechaPublicacion = LocalDate.of(2023, 5, 3),
    tipoComentario = "renta"
)
val rentaUrquizaDental1 = Renta(
            usuario = karolg,
            espacio = UrquizaDental,
            fecha_desde = LocalDate.of(2023, 4, 20),
            fecha_hasta = LocalDate.of(2023, 4, 29),
)