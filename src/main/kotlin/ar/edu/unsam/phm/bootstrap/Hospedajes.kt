package ar.edu.unsam.phm.bootstrap
import ar.edu.unsam.phm.domains.*

val hospedajeCasa1 = Hospedaje(
                nombre ="Casa de diseño moderno y amplio",
                descripcion = "Es un lugar hermoso ubicado en Buenos aires.",
                capacidad = 4,
                habitaciones = 2,
                banios = 1,
                detalleAlojamiento = "Las habitaciones disponen de aire acondicionado, escritorio, caja fuerte, TV de pantalla plana, patio y baño privado con ducha. Las habitaciones incluyen nevera. Sirve un desayuno americano todas las mañanas.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Ayacucho 152, Buenos Aires",
                costoBase = 31500.0,
                duenio = eminem,
                hospedajeTipo = tiposHospedajes[0],
                otrosAspectos = "Hay bañera de hidromasaje. Se puede jugar al billar y al ping pong. La zona es ideal para practicar ciclismo.",
                pais = Pais.ARG
)
val hospedajeCasa2 = Hospedaje(
                nombre ="Duplex de madera con 4 ambientes",
                descripcion = "Muy linda casa para descanzar.",
                capacidad = 5,
                habitaciones = 3,
                banios = 1,
                detalleAlojamiento = "Casa muy comoda con cuatro ambientes.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Rivadavia 623, Santa Fe",
                duenio = solari,
                costoBase = 17000.0,
                hospedajeTipo = tiposHospedajes[0],
                otrosAspectos = "Tiene mesa de metegol, patio con reposeras.",
                pais = Pais.ARG
            )
val hospedajeCasa3 = Hospedaje(
                nombre ="QUINCHO PARRILLERO",
                descripcion = "¡Bienvenido al hermoso patio con parrilla, perfecto para deliciosos almuerzos familiares! Este espacio al aire libre ofrece un entorno acogedor para reunirse y disfrutar de comidas bajo el sol. El patio cuenta con un área espaciosa rodeada de exuberante vegetación y flores vibrantes, creando un ambiente cálido y relajante. En el centro del patio, encontrarás una generosa parrilla, lista para cocinar deliciosas carnes y verduras a la parrilla. Un área de preparación equipada con un mostrador de trabajo y utensilios hace que la preparación de alimentos sea muy sencilla. Un área de comedor al aire libre con una mesa grande y sillas cómodas está convenientemente ubicada cerca de la parrilla, lo que permite que todos disfruten juntos de comidas recién preparadas. También hay una acogedora sala de estar con cómodos sofás y sillas, ideal para relajarse después de la comida o entablar conversaciones agradables. El patio cuenta con una sombrilla o toldo para dar sombra en los días calurosos. La iluminación adecuada está disponible para prolongar las celebraciones en noches estrelladas. El patio es un espacio seguro y adecuado para que los niños jueguen libremente, con un área de juegos designada y un amplio espacio abierto. Además, se proporciona un baño completo para la comodidad de los huéspedes. El patio está situado en un vecindario tranquilo y familiar, perfecto para crear momentos preciados con sus seres queridos. La renta incluye acceso exclusivo al patio y asador, así como el uso de utensilios y muebles de exterior. Este patio con parrilla es el lugar perfecto para crear recuerdos duraderos y disfrutar de un tiempo de calidad con su familia.",
                capacidad = 6,
                habitaciones = 3,
                banios = 2,
                detalleAlojamiento = "alta parri",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA),
                ubicacion = "hurlingan",
                duenio = solari,
                costoBase = 14000.0,
                hospedajeTipo = tiposHospedajes[0],
                otrosAspectos = "Baños muy cómodos.",
                pais = Pais.BRA
)
val hospedajeCasa4 = Hospedaje(
                nombre ="Duplex",
                descripcion = "Hermoso duplex equipado.",
                capacidad = 4,
                habitaciones = 2,
                banios = 1,
                detalleAlojamiento = "Es un excelente espacio para disfrutar en familia. Con patio.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Pichincha 667, Potosi",
                duenio = karolg,
                costoBase = 13000.0,
                hospedajeTipo = tiposHospedajes[0],
                otrosAspectos = "Patio amplio",
                pais = Pais.BOL
)
val hospedajeCasa5 = Hospedaje(
                nombre ="Casa amplia cerca del Rio",
                descripcion = "Casa de tamaño grande.",
                capacidad = 8,
                habitaciones = 5,
                banios = 3,
                detalleAlojamiento = "Excelente casa para disfrutar con amigos.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA, Servicio.INTERNET_DIGITAL),
                ubicacion = "Av Juan Perez 334, Corrientes",
                duenio = karolg,
                costoBase = 14000.0,
                hospedajeTipo = tiposHospedajes[0],
                otrosAspectos = "Baños muy comodos.",
                pais = Pais.ARG
)
val hospedajeCasa6 = Hospedaje(
                nombre ="Iglú",
                descripcion = "Chiquito",
                capacidad = 2,
                habitaciones = 1,
                banios = 0,
                detalleAlojamiento = "Perfecto para cucharita.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Antártida Argentina, Antártida",
                duenio = eminem,
                costoBase = 10.0,
                hospedajeTipo = tiposHospedajes[0],
                otrosAspectos = "Llevate medias.",
                pais = Pais.ARG
)
val hospedajeCasa7 = Hospedaje(
                nombre ="Casa en el arbol",
                descripcion = "Re alto.",
                capacidad = 3,
                habitaciones = 2,
                banios = 0,
                detalleAlojamiento = "No apto para menores.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Bosque en La Paz, La Paz",
                duenio = michaelJackson,
                costoBase = 14000.0,
                hospedajeTipo = tiposHospedajes[0],
                otrosAspectos = "Tiene mesa de metegol",
                pais = Pais.BOL
)
val hospedajeCasa8 = Hospedaje(
                nombre ="Casa rodante",
                descripcion = "Muy cómoda para viajar.",
                capacidad = 2,
                habitaciones = 1,
                banios = 1,
                detalleAlojamiento = "Es excelente para viajar en pareja por todo argentina!",
                servicios = mutableListOf(),
                ubicacion = "Cordoba, Cordoba",
                duenio = michaelJackson,
                costoBase = 9000.0,
                hospedajeTipo = tiposHospedajes[0],
                otrosAspectos = "Tiene ducha exterior.",
                pais = Pais.ARG
)
val hospedajeDepartamento1 = Hospedaje(
                nombre ="Departamento moderno de tres ambientes",
                descripcion = "Tiene 3 ambientes, 1 cuarto, 1 baño, una cocina.",
                capacidad = 2,
                habitaciones = 1,
                banios = 1,
                detalleAlojamiento = "Los ambientes son muy chiquitos asi que arreglate.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Bonifacini 5220, Buenos Aires",
                duenio = michaelJackson,
                costoBase = 10000.0,
                hospedajeTipo = tiposHospedajes[1],
                otrosAspectos = "Le gusta tener gente dentro.",
                pais = Pais.ARG
)
val hospedajeDepartamento2 = Hospedaje(
                nombre ="DEPARTAMENTO CHETA",
                descripcion = "Esta muy cheto , todo es de oro y brillantes.",
                capacidad = 15,
                habitaciones = 10,
                banios = 4,
                detalleAlojamiento = "Todo se hace por comando de voz.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Trujillo 1500, La Paz",
                duenio = karolg,
                costoBase = 35000.0,
                hospedajeTipo = tiposHospedajes[1],
                otrosAspectos = "Tiene cuartos ocultos.",
                pais = Pais.BOL
)
val hospedajeDepartamento3 = Hospedaje(
                nombre ="Depto piso 30",
                descripcion = "Balcon con pileta de piso de cristal.",
                capacidad = 3,
                habitaciones = 3,
                banios = 1,
                detalleAlojamiento = "No tiene ascensor.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Michigan 123, Tierra del Fuego",
                duenio = michaelJackson,
                costoBase = 10000.0,
                hospedajeTipo = tiposHospedajes[1],
                otrosAspectos = "Parades finas, se escuha todo.",
                pais = Pais.ARG
)
val hospedajeDepartamento4 = Hospedaje(
                nombre ="DEPTO re cheta 2",
                descripcion = "Todo esta rebestido en obsidiana negra.",
                capacidad = 15,
                habitaciones = 10,
                banios = 4,
                detalleAlojamiento = "Tiene un laberinto.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Coral 1514, Tupiza",
                duenio = karolg,
                costoBase = 35000.0,
                hospedajeTipo = tiposHospedajes[1],
                otrosAspectos = "Tiene cuartos ocultos.",
                pais = Pais.BOL
)
val hospedajeDepartamento5 = Hospedaje(
                nombre ="Departamento con hermosa vista",
                descripcion = "Detalles muy minimalistas.",
                capacidad = 2,
                habitaciones = 2,
                banios = 2,
                detalleAlojamiento = "Tiene vista al hipodromo de palermo. HERMOSO. Se pagan expensas.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA),
                ubicacion = "Av. Libertador 334, Buenos Aires",
                duenio = eminem,
                costoBase = 30000.0,
                hospedajeTipo = tiposHospedajes[1],
                otrosAspectos = "Tiene baño en suite.",
                pais = Pais.ARG
)
val hospedajeDepartamento6 = Hospedaje(
                nombre ="Departamento buena ubicacion",
                descripcion = "Cerca del Subte B.",
                capacidad = 4,
                habitaciones = 3,
                banios = 1,
                detalleAlojamiento = "Departamento comodo, con buenisima ubicacion cerca de la estacion medrano del subte B.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Av Medrano 4455, Formosa",
                duenio = solari,
                costoBase = 40000.0,
                hospedajeTipo = tiposHospedajes[1],
                otrosAspectos = "Muy cómodo.",
                pais = Pais.ARG
)
 val hospedajeDepartamento7 = Hospedaje(
                nombre ="Excelente departamento con vista al mar",
                descripcion = "Cerca de la avenida principal.",
                capacidad = 5,
                habitaciones = 3,
                banios = 2,
                detalleAlojamiento = "Excelente departamento para venir a vacacionar a mar del plata en familia.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Av la Plata 334, Buenos Aires",
                duenio = eminem,
                costoBase = 25000.0,
                hospedajeTipo = tiposHospedajes[1],
                otrosAspectos = "Incluye cochera.",
                pais = Pais.ARG
)
val hospedajeDepartamento8 = Hospedaje(
                nombre ="Departamento moderno",
                descripcion = "Hermosa vista a las sierras.",
                capacidad = 5,
                habitaciones = 3,
                banios = 2,
                detalleAlojamiento = "Excelente departamento para relajarse unos días, con la hermosa vista a las sierras de Córdoba.",
                servicios = mutableListOf(Servicio.INTERNET_DIGITAL),
                ubicacion = "Los eucaliptos 12, Cordoba",
                duenio = karolg,
                costoBase = 45000.0,
                hospedajeTipo = tiposHospedajes[1],
                otrosAspectos = "Tiene pileta compartida con el edificio.",
)
val hospedajeCabania1 = Hospedaje(
                nombre ="castillo del conde",
                descripcion = "Castillo mediaval con fosa llena de cocodrilos.",
                capacidad = 40,
                habitaciones = 20,
                banios = 10,
                detalleAlojamiento = "Tiene muchos cuartos bloqueados.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Panamenicana 5600, Buenos Aires",
                duenio = eminem,
                costoBase = 15000.0,
                hospedajeTipo = tiposHospedajes[2],
                otrosAspectos = "Hay olor rari.",
                pais = Pais.BRA
)
val hospedajeCabania2 = Hospedaje(
                nombre ="Cabaña alpina",
                descripcion = "Hermosas cabañas comodísimas.",
                capacidad = 4,
                habitaciones = 2,
                banios = 1,
                detalleAlojamiento = "Cabañas excelentes para descansar.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Rivadavia 3000, Tucumán",
                duenio = solari,
                costoBase = 20000.0,
                hospedajeTipo = tiposHospedajes[2],
                otrosAspectos = "Pileta disponible en verano.",
                pais = Pais.ARG
)
 val hospedajeCabania3 = Hospedaje(
                nombre ="Cabañita humilde",
                descripcion = "Te cagas de frio 100 asegurado.",
                capacidad = 3,
                habitaciones = 1,
                banios = 0,
                detalleAlojamiento = "Se ven los osos pasar por la ventana",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Montaña, San Carlos de Bariloche",
                duenio = eminem,
                costoBase = 15000.0,
                hospedajeTipo = tiposHospedajes[2],
                otrosAspectos = "La chimenea esta fenomenal.",
                pais = Pais.ARG
)
val hospedajeCabania4 = Hospedaje(
                nombre ="Cabañinha",
                descripcion = "La cocina es una cosa de locos.",
                capacidad = 4,
                habitaciones = 3,
                banios = 1,
                detalleAlojamiento = "Tiene buen baño.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Costañera 1230, Bombinhas",
                duenio = solari,
                costoBase = 20000.0,
                hospedajeTipo = tiposHospedajes[2],
                otrosAspectos = "A tres cuadras de la jodita.",
                pais = Pais.BRA
)
val hospedajeCabania5 = Hospedaje(
                nombre ="Cabaña en la costa",
                descripcion = "La cocina es una cosa de locos.",
                capacidad = 6,
                habitaciones = 3,
                banios = 2,
                detalleAlojamiento = "Tiene buen baño, ideal para grupo de amigos.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Costera 1230, Villa Gesell",
                duenio = solari,
                costoBase = 30000.0,
                hospedajeTipo = tiposHospedajes[2],
                otrosAspectos = "No se aceptan menores de 22 años.",
                pais = Pais.ARG
)
val hospedajeCabania6 = Hospedaje(
                nombre ="Cabaña Chill",
                descripcion = "Excelente para relajarse.",
                capacidad = 2,
                habitaciones = 1,
                banios = 1,
                detalleAlojamiento = "Cabaña para relajar la mente y escuchar los pajaritos.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Av Rivadavia 446, San Martin de los Andes",
                duenio = karolg,
                costoBase = 24000.0,
                hospedajeTipo = tiposHospedajes[2],
                otrosAspectos = "Cerca de la ruta los 7 lagos.",
                pais = Pais.ARG
)
val hospedajeCabania7 = Hospedaje(
                nombre ="Cabaña en la selva",
                descripcion = "Para disfrutar de la naturaleza.",
                capacidad = 6,
                habitaciones = 3,
                banios = 3,
                detalleAlojamiento = "Excelente para pasar lindos dias con amigos y hacer asaditos.",
                servicios = mutableListOf(),
                ubicacion = "Av Jose 4096, Villa Gesell",
                duenio = karolg,
                costoBase = 22000.0,
                hospedajeTipo = tiposHospedajes[2],
                otrosAspectos = "Tiene PARRILLA!!!!!!!!!!!!!",
                pais = Pais.ARG
)
val hospedajeCabania8 = Hospedaje(
                nombre ="Cabaña JUJUY",
                descripcion = "Cabaña cerca de los animales norteños, paz y tranquilidad",
                capacidad = 2,
                habitaciones = 1,
                banios = 1,
                detalleAlojamiento = "Cabaña ya no se que mas poner.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Av Rivadavia 446, Jujuy",
                duenio = karolg,
                costoBase = 24000.0,
                hospedajeTipo = tiposHospedajes[2],
                otrosAspectos = "Cerca del hornocal y cerro 7 colores.",
                pais = Pais.ARG
)