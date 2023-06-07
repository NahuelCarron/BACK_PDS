-- Conocer los alojamientos que reservó un determinado usuario.

-- Creo la funcion que recibe por parámetro el id del usuario
CREATE OR REPLACE FUNCTION hospedajes_reservados_usuario(id_usuario int)
RETURNS TABLE (
    id_hospedaje bigint,
    nombre_hospedaje character varying,
    descripcion_hospedaje character varying,
	tipo_hospedaje character varying,
	ubicacion_hospedaje character varying,
	pais_hospedaje character varying
) AS
$body$
BEGIN
	RETURN QUERY SELECT DISTINCT
                                       h.id as id_hospedaje,
                                       h.nombre as nombre_hospedaje,
                                       h.descripcion as descripcion_hospedaje,
                                       h.hospedaje_tipo as tipo_hospedaje,
                                       h.ubicacion as ubicacion_hospedaje,
                                       h.pais as pais_hospedaje

                 FROM reserva r
                          JOIN hospedaje h
                               ON h.id = r.hospedaje_id
                 WHERE r.usuario_id = id_usuario;
END;
$body$
LANGUAGE plpgsql;

-- Compruebo funcionamiento
SELECT * FROM hospedajes_reservados_usuario(1);