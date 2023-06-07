
-- Saber qué usuarios tienen más de 3 reservas:
-- Usando Vistas

CREATE OR REPLACE VIEW usuarios_con_3_reservas_o_mas as
SELECT r.usuario_id, u.nombre,u.apellido,u.fecha_nacimiento,u.pais
FROM reserva r
         LEFT JOIN usuario u ON r.usuario_id = u.id
GROUP BY r.usuario_id, u.nombre,u.apellido,u.fecha_nacimiento,u.pais
HAVING COUNT(*) > 3;

select * from usuarios_con_3_reservas_o_mas