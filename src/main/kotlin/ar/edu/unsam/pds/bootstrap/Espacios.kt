package ar.edu.unsam.pds.bootstrap
import ar.edu.unsam.pds.domains.*

val espacioCasa1 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Casa de diseño moderno y amplio",
                descripcion = "Es un lugar hermoso ubicado en Buenos aires.",
                habitaciones = 2,
                banios = 1,
                detalleAlojamiento = "Las habitaciones disponen de aire acondicionado, escritorio, caja fuerte, TV de pantalla plana, patio y baño privado con ducha. Las habitaciones incluyen nevera. Sirve un desayuno americano todas las mañanas.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Ayacucho 152, Buenos Aires",
                costo_hora = 500.0,
                duenio = eminem,
                pais = Pais.ARG
)


val espacioCasa2 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Duplex de madera con 4 ambientes",
                descripcion = "Muy linda casa para descanzar.",
                habitaciones = 3,
                banios = 1,
                detalleAlojamiento = "Casa muy comoda con cuatro ambientes.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Rivadavia 623, Santa Fe",
                duenio = solari,
                costo_hora = 1700.0,
                pais = Pais.ARG
            )
val espacioCasa3 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="QUINCHO PARRILLERO",
                descripcion = "¡Bienvenido al hermoso patio con parrilla, perfecto para deliciosos almuerzos familiares! Este espacio al aire libre ofrece un entorno acogedor para reunirse y disfrutar de comidas bajo el sol. El patio cuenta con un área espaciosa rodeada de exuberante vegetación y flores vibrantes, creando un ambiente cálido y relajante. En el centro del patio, encontrarás una generosa parrilla, lista para cocinar deliciosas carnes y verduras a la parrilla. Un área de preparación equipada con un mostrador de trabajo y utensilios hace que la preparación de alimentos sea muy sencilla. Un área de comedor al aire libre con una mesa grande y sillas cómodas está convenientemente ubicada cerca de la parrilla, lo que permite que todos disfruten juntos de comidas recién preparadas. También hay una acogedora sala de estar con cómodos sofás y sillas, ideal para relajarse después de la comida o entablar conversaciones agradables. El patio cuenta con una sombrilla o toldo para dar sombra en los días calurosos. La iluminación adecuada está disponible para prolongar las celebraciones en noches estrelladas. El patio es un espacio seguro y adecuado para que los niños jueguen libremente, con un área de juegos designada y un amplio espacio abierto. Además, se proporciona un baño completo para la comodidad de los huéspedes. El patio está situado en un vecindario tranquilo y familiar, perfecto para crear momentos preciados con sus seres queridos. La renta incluye acceso exclusivo al patio y asador, así como el uso de utensilios y muebles de exterior. Este patio con parrilla es el lugar perfecto para crear recuerdos duraderos y disfrutar de un tiempo de calidad con su familia.",
                detalleAlojamiento = "alta parri",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA),
                ubicacion = "hurlingan",
                duenio = solari,
                costo_hora = 140.0,
                pais = Pais.BRA
)
val espacioCasa4 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Duplex",
                descripcion = "Hermoso duplex equipado.",
                detalleAlojamiento = "Es un excelente espacio para disfrutar en familia. Con patio.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Pichincha 667, Potosi",
                duenio = karolg,
                costo_hora = 130.0,
                pais = Pais.BOL
)
val espacioCasa5 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Casa amplia cerca del Rio",
                descripcion = "Casa de tamaño grande.",
                detalleAlojamiento = "Excelente casa para disfrutar con amigos.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA, Servicio.INTERNET_DIGITAL),
                ubicacion = "Av Juan Perez 334, Corrientes",
                duenio = karolg,
                costo_hora = 140.0,
                pais = Pais.ARG
)
val espacioCasa6 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Iglú",
                descripcion = "Chiquito",
                detalleAlojamiento = "Perfecto para cucharita.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Antártida Argentina, Antártida",
                duenio = eminem,
                costo_hora = 10.0,
                pais = Pais.ARG
)
val espacioCasa7 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Casa en el arbol",
                descripcion = "Re alto.",
                detalleAlojamiento = "No apto para menores.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Bosque en La Paz, La Paz",
                duenio = michaelJackson,
                costo_hora = 140.0,
                pais = Pais.BOL
)
val espacioCasa8 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Casa rodante",
                descripcion = "Muy cómoda para viajar.",
                detalleAlojamiento = "Es excelente para viajar en pareja por todo argentina!",
                servicios = mutableListOf(),
                ubicacion = "Cordoba, Cordoba",
                duenio = michaelJackson,
                costo_hora = 900.0,
                pais = Pais.ARG
)
val espacioDepartamento1 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Departamento moderno de tres ambientes",
                descripcion = "Tiene 3 ambientes, 1 cuarto, 1 baño, una cocina.",
                detalleAlojamiento = "Los ambientes son muy chiquitos asi que arreglate.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Bonifacini 5220, Buenos Aires",
                duenio = michaelJackson,
                costo_hora = 1000.0,
                pais = Pais.ARG
)
val espacioDepartamento2 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="DEPARTAMENTO CHETA",
                descripcion = "Esta muy cheto , todo es de oro y brillantes.",
                detalleAlojamiento = "Todo se hace por comando de voz.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Trujillo 1500, La Paz",
                duenio = karolg,
                costo_hora = 3500.0,
                pais = Pais.BOL
)
val espacioDepartamento3 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Depto piso 30",
                descripcion = "Balcon con pileta de piso de cristal.",
                detalleAlojamiento = "No tiene ascensor.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Michigan 123, Tierra del Fuego",
                duenio = michaelJackson,
                costo_hora = 100.0,
                pais = Pais.ARG
)
val espacioDepartamento4 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="DEPTO re cheta 2",
                descripcion = "Todo esta rebestido en obsidiana negra.",
                detalleAlojamiento = "Tiene un laberinto.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Coral 1514, Tupiza",
                duenio = karolg,
                costo_hora = 3500.0,
                pais = Pais.BOL
)
val espacioDepartamento5 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Departamento con hermosa vista",
                descripcion = "Detalles muy minimalistas.",
                detalleAlojamiento = "Tiene vista al hipodromo de palermo. HERMOSO. Se pagan expensas.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA),
                ubicacion = "Av. Libertador 334, Buenos Aires",
                duenio = eminem,
                costo_hora = 3000.0,
                pais = Pais.ARG
)
val espacioDepartamento6 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Departamento buena ubicacion",
                descripcion = "Cerca del Subte B.",
                detalleAlojamiento = "Departamento comodo, con buenisima ubicacion cerca de la estacion medrano del subte B.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Av Medrano 4455, Formosa",
                duenio = solari,
                costo_hora = 4000.0,
                pais = Pais.ARG
)
 val espacioDepartamento7 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Excelente departamento con vista al mar",
                descripcion = "Cerca de la avenida principal.",
                detalleAlojamiento = "Excelente departamento para venir a vacacionar a mar del plata en familia.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Av la Plata 334, Buenos Aires",
                duenio = eminem,
                costo_hora = 2500.0,
                pais = Pais.ARG
)
val espacioDepartamento8 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Departamento moderno",
                descripcion = "Hermosa vista a las sierras.",
                detalleAlojamiento = "Excelente departamento para relajarse unos días, con la hermosa vista a las sierras de Córdoba.",
                servicios = mutableListOf(Servicio.INTERNET_DIGITAL),
                ubicacion = "Los eucaliptos 12, Cordoba",
                duenio = karolg,
                costo_hora = 4500.0,
)
val espacioCabania1 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="castillo del conde",
                descripcion = "Castillo mediaval con fosa llena de cocodrilos.",
                detalleAlojamiento = "Tiene muchos cuartos bloqueados.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Panamenicana 5600, Buenos Aires",
                duenio = eminem,
                costo_hora = 1500.0,
                pais = Pais.BRA
)
val espacioCabania2 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Cabaña alpina",
                descripcion = "Hermosas cabañas comodísimas.",
                detalleAlojamiento = "Cabañas excelentes para descansar.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Rivadavia 3000, Tucumán",
                duenio = solari,
                costo_hora = 2000.0,
                pais = Pais.ARG
)
 val espacioCabania3 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Cabañita humilde",
                descripcion = "Te cagas de frio 100 asegurado.",
                detalleAlojamiento = "Se ven los osos pasar por la ventana",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Montaña, San Carlos de Bariloche",
                duenio = eminem,
                costo_hora = 1500.0,
                pais = Pais.ARG
)
val espacioCabania4 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Cabañinha",
                descripcion = "La cocina es una cosa de locos.",
                detalleAlojamiento = "Tiene buen baño.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Costañera 1230, Bombinhas",
                duenio = solari,
                costo_hora = 200.0,
                pais = Pais.BRA
)
val espacioCabania5 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Cabaña en la costa",
                descripcion = "La cocina es una cosa de locos.",
                detalleAlojamiento = "Tiene buen baño, ideal para grupo de amigos.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Costera 1230, Villa Gesell",
                duenio = solari,
                costo_hora = 300.0,
                pais = Pais.ARG
)
val espacioCabania6 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Cabaña Chill",
                descripcion = "Excelente para relajarse.",
                detalleAlojamiento = "Cabaña para relajar la mente y escuchar los pajaritos.",
                servicios = mutableListOf(Servicio.WIFI),
                ubicacion = "Av Rivadavia 446, San Martin de los Andes",
                duenio = karolg,
                costo_hora = 240.0,
                pais = Pais.ARG
)
val espacioCabania7 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Cabaña en la selva",
                descripcion = "Para disfrutar de la naturaleza.",
                detalleAlojamiento = "Excelente para pasar lindos dias con amigos y hacer asaditos.",
                servicios = mutableListOf(),
                ubicacion = "Av Jose 4096, Villa Gesell",
                duenio = karolg,
                costo_hora = 220.0,
                pais = Pais.ARG
)
val espacioCabania8 = Espacio(
                tiempoRenta = TiempoRenta.costo_hora,
                titulo ="Cabaña JUJUY",
                descripcion = "Cabaña cerca de los animales norteños, paz y tranquilidad",
                detalleAlojamiento = "Cabaña ya no se que mas poner.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Av Rivadavia 446, Jujuy",
                duenio = karolg,
                costo_hora = 240.0,
                pais = Pais.ARG
)