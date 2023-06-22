package ar.edu.unsam.pds.bootstrap
import ar.edu.unsam.pds.domains.*

val espacioCasa1 = Espacio(
                titulo ="Casa de diseño moderno y amplio",
                descripcion = "Es un lugar hermoso ubicado en Buenos aires.",
                capacidad = 4,
                detalleAlojamiento = "Las habitaciones disponen de aire acondicionado, escritorio, caja fuerte, TV de pantalla plana, patio y baño privado con ducha. Las habitaciones incluyen nevera. Sirve un desayuno americano todas las mañanas.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Ayacucho 152, Buenos Aires",
                costo_hora = 31500.0,
                costo_dia = 110000.0,
                costo_mes = 500000.0,
                dimensiones = 12.0,
                uso = mutableListOf<Uso>(Uso.VIVIENDA, Uso.OFICINA),
                duenio = eminem,
                otrosAspectos = "Hay bañera de hidromasaje. Se puede jugar al billar y al ping pong. La zona es ideal para practicar ciclismo.",
                pais = Pais.ARG
)


val espacioCasa2 = Espacio(
                titulo ="Duplex de madera con 4 ambientes",
                descripcion = "Muy linda casa para descanzar.",
                capacidad = 5,
                detalleAlojamiento = "Casa muy comoda con cuatro ambientes.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Rivadavia 623, Santa Fe",
                duenio = eminem,
                costo_hora = 17000.0,
                otrosAspectos = "Tiene mesa de metegol, patio con reposeras.",
                pais = Pais.ARG
            )
val espacioCasa3 = Espacio(
                titulo ="QUINCHO PARRILLERO",
                descripcion = "¡Bienvenido al hermoso patio con parrilla, perfecto para deliciosos almuerzos familiares! Este espacio al aire libre ofrece un entorno acogedor para reunirse y disfrutar de comidas bajo el sol. El patio cuenta con un área espaciosa rodeada de exuberante vegetación y flores vibrantes, creando un ambiente cálido y relajante. En el centro del patio, encontrarás una generosa parrilla, lista para cocinar deliciosas carnes y verduras a la parrilla. Un área de preparación equipada con un mostrador de trabajo y utensilios hace que la preparación de alimentos sea muy sencilla. Un área de comedor al aire libre con una mesa grande y sillas cómodas está convenientemente ubicada cerca de la parrilla, lo que permite que todos disfruten juntos de comidas recién preparadas. También hay una acogedora sala de estar con cómodos sofás y sillas, ideal para relajarse después de la comida o entablar conversaciones agradables. El patio cuenta con una sombrilla o toldo para dar sombra en los días calurosos. La iluminación adecuada está disponible para prolongar las celebraciones en noches estrelladas. El patio es un espacio seguro y adecuado para que los niños jueguen libremente, con un área de juegos designada y un amplio espacio abierto. Además, se proporciona un baño completo para la comodidad de los huéspedes. El patio está situado en un vecindario tranquilo y familiar, perfecto para crear momentos preciados con sus seres queridos. La renta incluye acceso exclusivo al patio y asador, así como el uso de utensilios y muebles de exterior. Este patio con parrilla es el lugar perfecto para crear recuerdos duraderos y disfrutar de un tiempo de calidad con su familia.",
                capacidad = 6,
                detalleAlojamiento = "alta parri",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA),
                ubicacion = "hurlingan",
                duenio = solari,
                costo_hora = 14000.0,
                otrosAspectos = "Baños muy cómodos.",
                pais = Pais.BRA
)
val espacioCasa4 = Espacio(
                titulo ="Duplex",
                descripcion = "Hermoso duplex equipado.",
                capacidad = 4,
                detalleAlojamiento = "Es un excelente espacio para disfrutar en familia. Con patio.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Pichincha 667, Potosi",
                duenio = karolg,
                costo_hora = 13000.0,
                otrosAspectos = "Patio amplio",
                pais = Pais.BOL
)
val espacioCasa5 = Espacio(
                titulo ="Casa amplia cerca del Rio",
                descripcion = "Casa de tamaño grande.",
                capacidad = 8,
                detalleAlojamiento = "Excelente casa para disfrutar con amigos.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA, Servicio.INTERNET_DIGITAL),
                ubicacion = "Av Juan Perez 334, Corrientes",
                duenio = karolg,
                costo_hora = 14000.0,
                otrosAspectos = "Baños muy comodos.",
                pais = Pais.ARG
)
val espacioCasa6 = Espacio(
                titulo ="Iglú",
                descripcion = "Chiquito",
                capacidad = 2,
                detalleAlojamiento = "Perfecto para cucharita.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Antártida Argentina, Antártida",
                duenio = eminem,
                costo_hora = 10.0,
                otrosAspectos = "Llevate medias.",
                pais = Pais.ARG
)
val espacioCasa7 = Espacio(
                titulo ="Casa en el arbol",
                descripcion = "Re alto.",
                capacidad = 3,
                detalleAlojamiento = "No apto para menores.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Bosque en La Paz, La Paz",
                duenio = michaelJackson,
                costo_hora = 14000.0,
                otrosAspectos = "Tiene mesa de metegol",
                pais = Pais.BOL
)
val espacioCasa8 = Espacio(
                titulo ="Casa rodante",
                descripcion = "Muy cómoda para viajar.",
                capacidad = 2,
                detalleAlojamiento = "Es excelente para viajar en pareja por todo argentina!",
                servicios = mutableListOf(),
                ubicacion = "Cordoba, Cordoba",
                duenio = michaelJackson,
                costo_hora = 9000.0,
                otrosAspectos = "Tiene ducha exterior.",
                pais = Pais.ARG
)
val espacioDepartamento1 = Espacio(
                titulo ="Departamento moderno de tres ambientes",
                descripcion = "Tiene 3 ambientes, 1 cuarto, 1 baño, una cocina.",
                capacidad = 2,
                detalleAlojamiento = "Los ambientes son muy chiquitos asi que arreglate.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Bonifacini 5220, Buenos Aires",
                duenio = michaelJackson,
                costo_hora = 10000.0,
                otrosAspectos = "Le gusta tener gente dentro.",
                pais = Pais.ARG
)
val espacioDepartamento2 = Espacio(
                titulo ="DEPARTAMENTO CHETA",
                descripcion = "Esta muy cheto , todo es de oro y brillantes.",
                capacidad = 15,
                detalleAlojamiento = "Todo se hace por comando de voz.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Trujillo 1500, La Paz",
                duenio = karolg,
                costo_hora = 35000.0,
                otrosAspectos = "Tiene cuartos ocultos.",
                pais = Pais.BOL
)
val espacioDepartamento3 = Espacio(
                titulo ="Depto piso 30",
                descripcion = "Balcon con pileta de piso de cristal.",
                capacidad = 3,
                detalleAlojamiento = "No tiene ascensor.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Michigan 123, Tierra del Fuego",
                duenio = michaelJackson,
                costo_hora = 10000.0,
                otrosAspectos = "Parades finas, se escuha todo.",
                pais = Pais.ARG
)
val espacioDepartamento4 = Espacio(
                titulo ="DEPTO re cheta 2",
                descripcion = "Todo esta rebestido en obsidiana negra.",
                capacidad = 15,
                detalleAlojamiento = "Tiene un laberinto.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Coral 1514, Tupiza",
                duenio = karolg,
                costo_hora = 35000.0,
                otrosAspectos = "Tiene cuartos ocultos.",
                pais = Pais.BOL
)
val espacioDepartamento5 = Espacio(
                titulo ="Departamento con hermosa vista",
                descripcion = "Detalles muy minimalistas.",
                capacidad = 2,
                detalleAlojamiento = "Tiene vista al hipodromo de palermo. HERMOSO. Se pagan expensas.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA),
                ubicacion = "Av. Libertador 334, Buenos Aires",
                duenio = eminem,
                costo_hora = 30000.0,
                otrosAspectos = "Tiene baño en suite.",
                pais = Pais.ARG
)
val espacioDepartamento6 = Espacio(
                titulo ="Departamento buena ubicacion",
                descripcion = "Cerca del Subte B.",
                capacidad = 4,
                detalleAlojamiento = "Departamento comodo, con buenisima ubicacion cerca de la estacion medrano del subte B.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Av Medrano 4455, Formosa",
                duenio = solari,
                costo_hora = 40000.0,
                otrosAspectos = "Muy cómodo.",
                pais = Pais.ARG
)
 val espacioDepartamento7 = Espacio(
                titulo ="Excelente departamento con vista al mar",
                descripcion = "Cerca de la avenida principal.",
                capacidad = 5,
                detalleAlojamiento = "Excelente departamento para venir a vacacionar a mar del plata en familia.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Av la Plata 334, Buenos Aires",
                duenio = eminem,
                costo_hora = 25000.0,
                otrosAspectos = "Incluye cochera.",
                pais = Pais.ARG
)
val espacioDepartamento8 = Espacio(
                titulo ="Departamento moderno",
                descripcion = "Hermosa vista a las sierras.",
                capacidad = 5,
                detalleAlojamiento = "Excelente departamento para relajarse unos días, con la hermosa vista a las sierras de Córdoba.",
                servicios = mutableListOf(Servicio.INTERNET_DIGITAL),
                ubicacion = "Los eucaliptos 12, Cordoba",
                duenio = karolg,
                costo_hora = 45000.0,
                otrosAspectos = "Tiene pileta compartida con el edificio.",
)
val espacioCabania1 = Espacio(
                titulo ="castillo del conde",
                descripcion = "Castillo mediaval con fosa llena de cocodrilos.",
                capacidad = 40,
                detalleAlojamiento = "Tiene muchos cuartos bloqueados.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Panamenicana 5600, Buenos Aires",
                duenio = eminem,
                costo_hora = 15000.0,
                otrosAspectos = "Hay olor rari.",
                pais = Pais.BRA
)
val espacioCabania2 = Espacio(
                titulo ="Cabaña alpina",
                descripcion = "Hermosas cabañas comodísimas.",
                capacidad = 4,
                detalleAlojamiento = "Cabañas excelentes para descansar.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Rivadavia 3000, Tucumán",
                duenio = solari,
                costo_hora = 20000.0,
                otrosAspectos = "Pileta disponible en verano.",
                pais = Pais.ARG
)
 val espacioCabania3 = Espacio(
                titulo ="Cabañita humilde",
                descripcion = "Te cagas de frio 100 asegurado.",
                capacidad = 3,
                detalleAlojamiento = "Se ven los osos pasar por la ventana",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Montaña, San Carlos de Bariloche",
                duenio = eminem,
                costo_hora = 15000.0,
                otrosAspectos = "La chimenea esta fenomenal.",
                pais = Pais.ARG
)
val espacioCabania4 = Espacio(
                titulo ="Cabañinha",
                descripcion = "La cocina es una cosa de locos.",
                capacidad = 4,
                detalleAlojamiento = "Tiene buen baño.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Costañera 1230, Bombinhas",
                duenio = solari,
                costo_hora = 20000.0,
                otrosAspectos = "A tres cuadras de la jodita.",
                pais = Pais.BRA
)
val espacioCabania5 = Espacio(
                titulo ="Cabaña en la costa",
                descripcion = "La cocina es una cosa de locos.",
                capacidad = 6,
                detalleAlojamiento = "Tiene buen baño, ideal para grupo de amigos.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Costera 1230, Villa Gesell",
                duenio = solari,
                costo_hora = 30000.0,
                otrosAspectos = "No se aceptan menores de 22 años.",
                pais = Pais.ARG
)
val espacioCabania6 = Espacio(
                titulo ="Cabaña Chill",
                descripcion = "Excelente para relajarse.",
                capacidad = 2,
                detalleAlojamiento = "Cabaña para relajar la mente y escuchar los pajaritos.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Av Rivadavia 446, San Martin de los Andes",
                duenio = karolg,
                costo_hora = 24000.0,
                otrosAspectos = "Cerca de la ruta los 7 lagos.",
                pais = Pais.ARG
)
val espacioCabania7 = Espacio(
                titulo ="Cabaña en la selva",
                descripcion = "Para disfrutar de la naturaleza.",
                capacidad = 6,
                detalleAlojamiento = "Excelente para pasar lindos dias con amigos y hacer asaditos.",
                servicios = mutableListOf(),
                ubicacion = "Av Jose 4096, Villa Gesell",
                duenio = karolg,
                costo_hora = 22000.0,
                otrosAspectos = "Tiene PARRILLA!!!!!!!!!!!!!",
                pais = Pais.ARG
)
val espacioCabania8 = Espacio(
                titulo ="Cabaña JUJUY",
                descripcion = "Cabaña cerca de los animales norteños, paz y tranquilidad",
                capacidad = 2,
                detalleAlojamiento = "Cabaña ya no se que mas poner.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Av Rivadavia 446, Jujuy",
                duenio = karolg,
                costo_hora = 24000.0,
                otrosAspectos = "Cerca del hornocal y cerro 7 colores.",
                pais = Pais.ARG
)