package ar.edu.unsam.phm.bootstrap

import ar.edu.unsam.phm.domains.Pais
import ar.edu.unsam.phm.domains.Usuario
import java.time.LocalDate

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
val michaelJackson = Usuario(
    username = "jackie",
    password = "abc123",
    nombre = "Michael Joseph",
    apellido = "Jackson",
    fechaNacimiento = LocalDate.of(1958, 8, 29),
    pais = Pais.BOL,
    saldo = 4500.0,
    profileUrl = "http://localhost:9000/api/v0/assets/737b4ff8-c720-4225-9f9b-e8e785620d54.jpeg",
)
val karolg = Usuario(
    username = "karolg",
    password = "abc123",
    nombre = "Karol",
    apellido = "Gonzalez",
    fechaNacimiento = LocalDate.of(1990, 1, 1),
    pais = Pais.BRA,
    saldo = 10000.0,
    profileUrl = "http://localhost:9000/api/v0/assets/78a2730f-c4bd-410d-aa2d-b960c468fb16.jpg",
)