package ar.edu.unsam.pds.bootstrap

import ar.edu.unsam.pds.domains.Pais
import ar.edu.unsam.pds.domains.Usuario
import java.time.LocalDate

val eminem = Usuario(
    username = "eminem",
    contrasenia = "abc123",
    nombre = "Marshall Bruce",
    apellido = "Mathers III",
    fechaNacimiento = LocalDate.of(1972, 10, 17),
    pais = Pais.ARGENTINA,
    fotoPerfil = "http://localhost:9000/api/v0/assets/3ce66d74-6f90-4219-ae6f-be3ef24b163e.jpg",
)
val solari = Usuario(
    username = "indio",
    contrasenia = "abc123",
    nombre = "Carlos Alberto",
    apellido = "Solari",
    fechaNacimiento = LocalDate.now(),
    pais = Pais.ARGENTINA,
    fotoPerfil = "http://localhost:9000/api/v0/assets/513c8ff4-2911-4736-b2f4-5707982b70e2.jpg",
)
val michaelJackson = Usuario(
    username = "jackie",
    contrasenia = "abc123",
    nombre = "Michael Joseph",
    apellido = "Jackson",
    fechaNacimiento = LocalDate.of(1958, 8, 29),
    pais = Pais.ARGENTINA,
    fotoPerfil = "http://localhost:9000/api/v0/assets/737b4ff8-c720-4225-9f9b-e8e785620d54.jpeg",
)
val karolg = Usuario(
    username = "karolg",
    contrasenia = "abc123",
    nombre = "Karol",
    apellido = "Gonzalez",
    fechaNacimiento = LocalDate.of(1990, 1, 1),
    pais = Pais.ARGENTINA,
    fotoPerfil = "http://localhost:9000/api/v0/assets/78a2730f-c4bd-410d-aa2d-b960c468fb16.jpg",
)