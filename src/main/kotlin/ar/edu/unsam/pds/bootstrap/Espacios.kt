package ar.edu.unsam.pds.bootstrap
import ar.edu.unsam.pds.domains.*
import java.util.*



val VillaSerenity = Espacio(
                titulo ="Villa Serenity",
                descripcion = "Descubre la elegancia y el lujo en nuestra Casa Moderna y Amplia. Con su diseño contemporáneo, espacios abiertos y comodidades de primera clase, esta casa es perfecta para una estancia sofisticada y relajante. Disfruta de interiores elegantes, una cocina gourmet, una suite principal de ensueño y un jardín impresionante.",
                detalleAlojamiento = "Este elegante refugio contemporáneo ofrece una experiencia de vida verdaderamente excepcional. Con sus líneas limpias, espacios abiertos y comodidades de lujo, esta casa es perfecta para aquellos que buscan un alojamiento sofisticado y confortable.\n" +
                        "\n" +
                        "Al ingresar a la casa, te recibirán amplios espacios llenos de luz natural que realzan la arquitectura moderna y los interiores elegantes. Los detalles de diseño cuidadosamente seleccionados, como los pisos de madera de roble y los techos altos, crean una sensación de elegancia y amplitud. La sala de estar principal es el lugar ideal para relajarse y disfrutar de momentos de tranquilidad junto a la chimenea o para entretener a amigos y familiares.",
                servicios = mutableListOf(Servicio.LIMPIEZA, Servicio.BAÑO, Servicio.COCINA, Servicio.TV),
                ubicacion = "Ayacucho 152, Buenos Aires",
                costo_hora = 500.0,
                dimensiones = 43.0,
                duenio = eminem,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.VIVIENDA, Uso.OFICINA, Uso.RECREATIVO, Uso.REUNION)
)


val GarageEnPlenoCentro = Espacio(
                titulo ="Garage en pleno centro!",
                descripcion = "Excelente garage en una buenisima ubicacion",
                detalleAlojamiento = "Garage apto para 1 auto o motos. Ideal para aparcar el auto mientras trabajas. Excelente zona ya que no se encuentra lugar para estacionar los días de semana.",
                servicios = mutableListOf(),
                ubicacion = "Sarmiento 1190, Buenos Aires",
                duenio = solari,
                costo_hora = 1700.0,
                dimensiones = 4.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.GARAGE, Uso.DEPOSITO)
            )
val QUINCHOPARRILLERO = Espacio(
                titulo ="QUINCHO PARRILLERO",
                detalleAlojamiento = "¡Bienvenido al hermoso patio con parrilla, perfecto para deliciosos almuerzos familiares! Este espacio al aire libre ofrece un entorno acogedor para reunirse y disfrutar de comidas bajo el sol. El patio cuenta con un área espaciosa rodeada de exuberante vegetación y flores vibrantes, creando un ambiente cálido y relajante. En el centro del patio, encontrarás una generosa parrilla, lista para cocinar deliciosas carnes y verduras a la parrilla. Un área de preparación equipada con un mostrador de trabajo y utensilios hace que la preparación de alimentos sea muy sencilla. Un área de comedor al aire libre con una mesa grande y sillas cómodas está convenientemente ubicada cerca de la parrilla, lo que permite que todos disfruten juntos de comidas recién preparadas. También hay una acogedora sala de estar con cómodos sofás y sillas, ideal para relajarse después de la comida o entablar conversaciones agradables. El patio cuenta con una sombrilla o toldo para dar sombra en los días calurosos. La iluminación adecuada está disponible para prolongar las celebraciones en noches estrelladas. El patio es un espacio seguro y adecuado para que los niños jueguen libremente, con un área de juegos designada y un amplio espacio abierto. Además, se proporciona un baño completo para la comodidad de los huéspedes. El patio está situado en un vecindario tranquilo y familiar, perfecto para crear momentos preciados con sus seres queridos. La renta incluye acceso exclusivo al patio y asador, así como el uso de utensilios y muebles de exterior. Este patio con parrilla es el lugar perfecto para crear recuerdos duraderos y disfrutar de un tiempo de calidad con su familia.",
                descripcion = "Excelente quincho para disfrutar con amigos y familia",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA),
                ubicacion = "Juan Bautista de la Salle 4998-4972, Buenos Aires",
                duenio = solari,
                costo_hora = 140.0,
                dimensiones = 3.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.REUNION, Uso.RECREATIVO, Uso.ENTRETENIMIENTO)
)
val CoworkingUrquiza = Espacio(
                titulo ="Coworking Urquiza",
                descripcion = "Excelente coworking para tener un espacio de trabajo amigable.",
                detalleAlojamiento = "Excelente espacio para trabajar con tranquilidad, buenas instalaciones. Somos un coworking muy conocido en la zona. Tenemos un ambiente muy tranquilo y funcional para que todos puedan ejercer sus actividades tranquilamente.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.PORTERIA, Servicio.LIMPIEZA, Servicio.BAÑO),
                ubicacion = "Colodrero 3272, Villa Urquiza, Buenos Aires",
                duenio = karolg,
                costo_hora = 130.0,
                dimensiones = 30.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.OFICINA, Uso.REUNION, Uso.COWORKING)
)
val CasaAmpliaCercaDelRio = Espacio(
                titulo ="Casa amplia cerca del Rio",
                descripcion = "Casa de tamaño grande.",
                detalleAlojamiento = "\n" +
                        "¡Bienvenidos al paraíso ribereño! Esta casa amplia y encantadora es el lugar perfecto para aquellos que buscan un refugio sereno y relajante cerca del río. Ubicada en un entorno idílico, esta vivienda ofrece una combinación única de amplitud, comodidad y belleza natural.\n" +
                        "\n" +
                        "Al ingresar a esta casa, serás recibido por una sensación de espacio y luminosidad. Sus generosas dimensiones y distribución inteligente crean ambientes acogedores y versátiles, ideales para adaptarse a las necesidades de tu estilo de vida. La sala de estar te invita a descansar y disfrutar de momentos inolvidables junto a la familia y amigos, mientras que la cocina moderna y equipada te inspirará a desplegar tus habilidades culinarias.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA, Servicio.ESTACIONAMIENTO, Servicio.BAÑO, Servicio.COCINA),
                ubicacion = "Costanera Luis Rocha 1859, Zárate, Buenos Aires",
                duenio = karolg,
                costo_hora = 140.0,
                dimensiones = 20.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.VIVIENDA, Uso.RECREATIVO)
)
val Iglu = Espacio(
                titulo ="Iglú",
                descripcion = "Este iglú te ofrece una experiencia de alojamiento excepcional, donde la calidez y la comodidad se encuentran con la belleza gélida del entorno.",
                detalleAlojamiento = "¡Bienvenidos a una experiencia única en un iglú mágico! Si estás buscando una escapada inolvidable y fuera de lo común, este iglú es el destino perfecto. Sumérgete en un mundo de maravilla y belleza ártica mientras te alojas en esta joya congelada..",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Huemul 106, Calafate",
                duenio = eminem,
                costo_hora = 10.0,
                dimensiones = 3.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.RECREATIVO)
)
val DepositosLuis = Espacio(
                titulo ="Depósitos Luis",
                descripcion = "Amplio y seguro depósito disponible para alquiler. Ideal para almacenar tus pertenencias con tranquilidad.",
                detalleAlojamiento = "¡Bienvenido al espacio perfecto para satisfacer tus necesidades de almacenamiento! Este depósito es la solución ideal para aquellos que buscan un espacio seguro, amplio y versátil para guardar sus pertenencias.\n" +
                        "\n" +
                        "Con un diseño inteligente y una distribución eficiente, este depósito ofrece una gran capacidad para almacenar una amplia variedad de artículos. Ya sea que necesites guardar muebles, equipos deportivos, suministros comerciales o cualquier otro tipo de mercancía, este espacio se adapta a tus necesidades.",
                servicios = mutableListOf(Servicio.SEGURIDAD, Servicio.MANTENIMIENTO),
                ubicacion = "Presidente Peron 123",
                duenio = eminem,
                costo_hora = 140.0,
                dimensiones = 5.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.DEPOSITO, Uso.BODEGA)
)
val UrquizaDental = Espacio(
                titulo ="Urquiza Dental",
                descripcion = "Moderno consultorio odontológico disponible para alquiler. Equipado con tecnología de última generación y ubicado en una zona de alta visibilidad. ",
                detalleAlojamiento = "Este espacio moderno y completamente equipado es perfecto para dentistas que buscan establecer su práctica o expandir sus servicios. Con un diseño elegante y funcional, este consultorio ofrece un ambiente profesional y acogedor para brindar atención dental de primera clase.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.PORTERIA, Servicio.BAÑO, Servicio.COCINA, Servicio.CALEFACCION),
                ubicacion = "Av. Alvarez Thomas 2790, Buenos Aires",
                duenio = michaelJackson,
                dimensiones = 10.0,
                costo_hora = 900.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.CONSULTORIO, Uso.TRABAJO)
)
val LocalALaCalle = Espacio(
                titulo ="Local a la calle",
                descripcion = "Local a la calle disponible para alquiler en ubicación privilegiada y de alto tránsito. Ideal para establecer tu negocio y atraer una amplia clientela. Amplio espacio listo para adaptarse a tus necesidades.",
                detalleAlojamiento = "Este local comercial ofrece una ubicación privilegiada y una gran visibilidad, lo que lo convierte en una oportunidad única para atraer a una amplia clientela y hacer crecer tu emprendimiento.\n" +
                        "\n" +
                        "Con una fachada atractiva y una amplia vidriera, este local a la calle destaca entre los demás y captura la atención de los transeúntes. El espacioso interior te brinda infinitas posibilidades para diseñar el ambiente que mejor se adapte a tus necesidades y a la identidad de tu negocio. Ya sea que estés planeando abrir una tienda, un café, un estudio o cualquier otro tipo de negocio, este espacio ofrece el lienzo perfecto para hacer realidad tus ideas.",
                servicios = mutableListOf(Servicio.BAÑO),
                ubicacion = "Cochabamba 5220, Buenos Aires",
                duenio = michaelJackson,
                costo_hora = 1000.0,
                dimensiones = 13.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.COMERCIAL, Uso.TRABAJO, Uso.OFICINA)
)
val SalonLaVacaLoca = Espacio(
                titulo ="Salón la Vaca Loca",
                descripcion = "Amplio y elegante salón de eventos disponible para alquiler. Versatilidad, diseño contemporáneo y ubicación estratégica son algunas de nuestras características destacadas",
                detalleAlojamiento = "¡Bienvenidos al elegante y versátil salón de eventos que hará realidad tus celebraciones más memorables! Nuestro espacio es el escenario perfecto para todo tipo de eventos, desde bodas y fiestas de cumpleaños hasta conferencias y reuniones corporativas. Con una combinación única de estilo, comodidad y funcionalidad, te ofrecemos un lugar excepcional para crear momentos inolvidables.\n" +
                        "\n" +
                        "Nuestro salón de eventos presenta un diseño sofisticado y contemporáneo, con detalles cuidadosamente seleccionados que crean un ambiente acogedor y elegante. Los amplios espacios abiertos te brindan la libertad para personalizar el diseño y la decoración según tus preferencias, asegurando que cada evento sea único y refleje tu estilo.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.COCINA, Servicio.CALEFACCION),
                ubicacion = "Menlincué 3560, Buenos Aires",
                duenio = karolg,
                dimensiones = 33.0,
                costo_hora = 3500.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.ENTRETENIMIENTO, Uso.FIESTA, Uso.RECREATIVO)
)
val OficinasPOINT = Espacio(
                titulo ="Oficinas POINT",
                descripcion = "Oficina moderna y funcional disponible para alquiler. Diseño inteligente, tecnología avanzada y ubicación estratégica. Impulsa el crecimiento de tu negocio en un entorno profesional y cómodo.",
                detalleAlojamiento = "Este espacio moderno y funcional está diseñado para brindar comodidad, productividad y profesionalismo. Con una ubicación estratégica y una amplia gama de servicios, te ofrecemos el entorno perfecto para alcanzar el éxito empresarial.\n" +
                        "\n" +
                        "Nuestra oficina presenta un diseño contemporáneo y elegante, con espacios abiertos y luminosos que fomentan la colaboración y la creatividad",
                servicios = mutableListOf(Servicio.WIFI, Servicio.CALEFACCION, Servicio.MANTENIMIENTO),
                ubicacion = "Michigan 123, San Juan",
                duenio = michaelJackson,
                costo_hora = 100.0,
                dimensiones = 9.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.OFICINA, Uso.TRABAJO, Uso.REUNION)
)
val CoworkingTalampayas = Espacio(
    titulo ="Coworking Talampayas",
    descripcion = "Excelente espacio para trabajar con tranquilidad, buenas instalaciones.",
    detalleAlojamiento = "Somos un coworking muy conocido en la zona. Tenemos un ambiente muy tranquilo y funcional para que todos puedan ejercer sus actividades tranquilamente.",
    servicios = mutableListOf(Servicio.WIFI, Servicio.PORTERIA, Servicio.LIMPIEZA, Servicio.BAÑO),
    ubicacion = "Ignacio Pedro Rivera 3272, San Juan",
    duenio = karolg,
    costo_hora = 130.0,
    dimensiones = 25.0,
    pais = Pais.ARGENTINA,
    usos = mutableListOf(Uso.OFICINA, Uso.REUNION, Uso.COWORKING)
)
val VistaLibertador = Espacio(
                titulo ="VistaLibertador Residences",
                descripcion = "Departamento de lujo con hermosa vista en Av. Libertador. Diseño moderno, comodidades exclusivas y ubicación privilegiada. ¡Reserva ahora y vive la vida en su máxima expresión en el corazón de la ciudad!",
                detalleAlojamiento = "Este exclusivo espacio ofrece una experiencia de vida excepcional, combinando lujo, comodidad y una ubicación privilegiada para aquellos que buscan lo mejor en estilo de vida urbano.\n" +
                        "\n" +
                        "Al ingresar al departamento, serás recibido por una amplia sala de estar con grandes ventanales que se abren a una vista impresionante de la ciudad. El diseño moderno y sofisticado se complementa con acabados de alta calidad y una distribución inteligente que maximiza el espacio y la luminosidad.\n" +
                        "\n" +
                        "La cocina, completamente equipada con electrodomésticos de última generación, es el lugar ideal para desatar tu pasión culinaria y disfrutar de momentos especiales con familiares y amigos. El comedor contiguo ofrece un espacio elegante para compartir comidas y crear recuerdos inolvidables.\n" +
                        "\n" +
                        "El dormitorio principal, con su propio baño privado, te brinda un refugio tranquilo y confortable. Además, hay habitaciones adicionales que se adaptan perfectamente a tus necesidades, ya sea como dormitorios, espacios de trabajo o áreas de entretenimiento.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA, Servicio.MANTENIMIENTO, Servicio.CALEFACCION, Servicio.COCINA, Servicio.SEGURIDAD, Servicio.PORTERIA, Servicio.BAÑO),
                ubicacion = "Av. Libertador 334, Buenos Aires",
                duenio = eminem,
                dimensiones = 28.0,
                costo_hora = 3000.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.VIVIENDA)
)
val ElevaOffices = Espacio(
                titulo ="ElevaOffices",
                descripcion = "No pierdas la oportunidad de establecer tu negocio en nuestra oficina de vanguardia. Te invitamos a reservar ahora y descubrir cómo podemos ayudarte a alcanzar tus metas profesionales y brindarte un entorno de trabajo excepcional.",
                detalleAlojamiento = "La oficina está equipada con tecnología de última generación, desde sistemas de telecomunicaciones y internet de alta velocidad hasta sistemas de seguridad y control de acceso, garantizando que tu negocio esté conectado y protegido en todo momento.\n" +
                        "\n" +
                        "La ubicación estratégica de nuestra oficina es otro de sus grandes beneficios. Está situada en una zona de alto crecimiento y desarrollo comercial, rodeada de servicios, restaurantes y excelentes conexiones de transporte. Además, ofrecemos estacionamiento conveniente y fácil acceso para ti y tus empleados.\n" +
                        "\n",
                servicios = mutableListOf(Servicio.WIFI, Servicio.ESTACIONAMIENTO),
                ubicacion = "Av Medrano 4455, San Juan",
                duenio = solari,
                costo_hora = 4000.0,
                dimensiones = 12.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.OFICINA, Uso.TRABAJO, Uso.REUNION)
)
 val departamentoConVistaAlMar = Espacio(
                titulo ="Excelente departamento con vista al mar",
                descripcion = "Cerca de la avenida principal.",
                detalleAlojamiento = "Excelente departamento para venir a vacacionar a mar del plata en familia.",
                servicios = mutableListOf(Servicio.LIMPIEZA),
                ubicacion = "Av la Plata 334, Buenos Aires",
                duenio = eminem,
                dimensiones = 18.0,
                costo_hora = 2500.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.VIVIENDA, Uso.TRABAJO, Uso.REUNION)
)
val DepartamentoModerno = Espacio(
                titulo ="Departamento moderno",
                descripcion = "Hermosa vista a las sierras.",
                detalleAlojamiento = "Excelente departamento para relajarse unos días, con la hermosa vista a las sierras de Córdoba.",
                servicios = mutableListOf(Servicio.ESTACIONAMIENTO, Servicio.WIFI, Servicio.TV),
                ubicacion = "Los eucaliptos 12, Cordoba",
                duenio = karolg,
                dimensiones = 12.0,
                costo_hora = 4500.0,
                usos = mutableListOf(Uso.VIVIENDA, Uso.TRABAJO, Uso.REUNION, Uso.RECREATIVO)
)
val ParkSafe = Espacio(
                titulo ="ParkSafe Estacionamiento",
                descripcion = "Estacionamiento seguro y conveniente disponible. Amplias áreas de estacionamiento, vigilancia las 24 horas y acceso controlado. Ubicación estratégica y servicios adicionales. ",
                detalleAlojamiento = "Nuestro espacio seguro y conveniente ofrece una experiencia excepcional, garantizando que tus vehículos estén protegidos y accesibles en todo momento.\n" +
                        "\n" +
                        "Nuestro estacionamiento cuenta con amplias y bien iluminadas áreas de estacionamiento, diseñadas para acomodar una variedad de vehículos, desde automóviles compactos hasta SUV y camionetas. Nuestro personal capacitado y amable está disponible para ayudarte en todo momento, asegurándose de que encuentres el lugar adecuado para estacionar y brindándote asistencia cuando lo necesites.",
                servicios = mutableListOf(Servicio.SEGURIDAD),
                ubicacion = "Panamenicana 5600, Buenos Aires",
                duenio = eminem,
                costo_hora = 1500.0,
                dimensiones = 3.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.GARAGE, Uso.DEPOSITO)
)
val RefugioAlpinoSereno = Espacio(
                titulo ="Refugio Alpino Sereno",
                descripcion = "Encantadora cabaña alpina para alquiler. Atmosfera acogedora, vistas panorámicas y ubicación natural idílica. Ideal para escapadas románticas o vacaciones familiares.",
                detalleAlojamiento = "¡Bienvenidos a nuestra encantadora cabaña alpina, un refugio acogedor y pintoresco para aquellos que buscan escapar de la rutina y sumergirse en la belleza natural de la montaña! Nuestra cabaña combina el encanto rústico con comodidades modernas, brindándote una experiencia inolvidable en un entorno idílico.\n" +
                        "\n" +
                        "Al ingresar a la cabaña, serás recibido por una atmósfera cálida y acogedora, donde la madera y la piedra se entrelazan en un diseño encantador. La sala de estar con chimenea es el lugar perfecto para relajarse y disfrutar de las vistas panorámicas de las montañas. Los muebles cómodos y la decoración cuidadosamente seleccionada crean un ambiente hogareño y relajante.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.LIMPIEZA, Servicio.ESTACIONAMIENTO, Servicio.TV, Servicio.BAÑO, Servicio.COCINA),
                ubicacion = "Rivadavia 3000, Bariloche",
                duenio = solari,
                costo_hora = 2000.0,
                dimensiones = 10.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.VIVIENDA, Uso.RECREATIVO, Uso.ENTRETENIMIENTO)
)
 val StudyOasis = Espacio(
                titulo ="Study Oasis",
                descripcion = "Salón de estudio moderno y tranquilo disponible para alquiler. Ambiente propicio para el aprendizaje y la concentración. Mesas amplias, internet de alta velocidad y ubicación conveniente.",
                detalleAlojamiento = "Nuestro espacio está diseñado pensando en estudiantes, profesionales y cualquier persona que busque un entorno tranquilo y estimulante para estudiar, trabajar o desarrollar proyectos creativos.\n" +
                        "\n" +
                        "Nuestro salón de estudio cuenta con áreas bien iluminadas y espaciosas, equipadas con mesas amplias, cómodas sillas ergonómicas y enchufes accesibles para garantizar la máxima productividad. El ambiente tranquilo y libre de distracciones te permitirá concentrarte plenamente en tus tareas y alcanzar un rendimiento óptimo.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.BAÑO),
                ubicacion = "San Martin 221, San Juan",
                duenio = eminem,
                costo_hora = 1500.0,
                pais = Pais.ARGENTINA,
                dimensiones = 7.0,
                usos = mutableListOf(Uso.OFICINA, Uso.ESTUDIO, Uso.REUNION, Uso.ENTRETENIMIENTO)
)
val StudiZen = Espacio(
                titulo ="StudiZen",
                descripcion = "Salón de estudio exclusivo y moderno. Ambiente tranquilo, acceso a internet de alta velocidad y ubicación conveniente.",
                detalleAlojamiento = "Diseñado para estudiantes, profesionales y cualquier persona que busque un espacio inspirador para estudiar, trabajar o desarrollar proyectos creativos.\n" +
                        "\n" +
                        "Nuestro salón de estudio ofrece un entorno tranquilo y estimulante, equipado con cómodas mesas, sillas ergonómicas y abundante iluminación natural. Cada detalle ha sido cuidadosamente pensado para proporcionarte un lugar propicio para el aprendizaje y la concentración.",
                servicios = mutableListOf(Servicio.WIFI, Servicio.PORTERIA),
                ubicacion = "Av. San Martin 1230, Buenos Aires",
                duenio = solari,
                costo_hora = 200.0,
                dimensiones = 3.0,
                pais = Pais.ARGENTINA,
                usos = mutableListOf(Uso.OFICINA, Uso.ESTUDIO, Uso.REUNION, Uso.ENTRETENIMIENTO)
)