
-- Evitar que el precio base de un alojamiento tome un valor nulo en la base (por fuera de la interfaz de usuario).
-- son reglas que se aplican a los datos en una tabla para garantizar que ciertos criterios se usen
-- En este caso lo utilizaremos para que genere error si se ingresa valor nulo en costo_base

ALTER TABLE hospedaje
ADD CONSTRAINT costo_base_no_nulo
CHECK (costo_base is not null );

-- Inserto unv alor en la tabla hospedaje

INSERT INTO hospedaje (duenio_id, banios, capacidad, costo_base, esta_activo,
                       habitaciones, ubicacion, hospedaje_tipo, nombre, otros_aspectos,
                       descripcion, detalle_alojamiento, pais)
VALUES (1, 2, 4,, true, 3, 'Ciudad X', 'Casa', 'Hotel ABC', 'Piscina', 'Este hotel es ideal para unas vacaciones relajantes.', 'El hotel cuenta con habitaciones cómodas y espaciosas', 'ARG');

-- Error que genera

-- TODO ERROR:  Failing row contains (row).new row for relation "hospedaje" violates check constraint "costo_base_no_nulo"
