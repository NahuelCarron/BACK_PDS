
-- Llevar un control de las veces que un usuario modifica su saldo, de manera de saber:
-- 	a) la fecha en la que se modificó,
-- 	b) el nuevo saldo y el anterior saldo.

-- Creo la tabla en donde se van a guardar los datos

CREATE TABLE saldo_changes(
                              id SERIAL PRIMARY KEY,
                              id_usuario int REFERENCES usuario(id),
                              saldo_nuevo double precision NOT NULL,
                              saldo_anterior double precision NOT NULL,
                              changed_on timestamp without time zone
);
-- Creo la funcion que va a usar el trigger
CREATE OR REPLACE FUNCTION saldo_usuario_changes()
  RETURNS trigger AS
$BODY$
BEGIN
    IF NEW.saldo<>OLD.saldo THEN
INSERT INTO saldo_changes(id_usuario, saldo_nuevo, saldo_anterior, changed_on)
VALUES(OLD.id, NEW.saldo, OLD.saldo, now());
END IF;
RETURN NEW;
END;
$BODY$
language plpgsql;

-- Creo el trigger
CREATE TRIGGER trigger_saldo_usuario_changes
    BEFORE UPDATE
    ON usuario
    FOR EACH ROW
    EXECUTE PROCEDURE saldo_usuario_changes();

-- Compruebo funcionamiento
UPDATE usuario SET saldo=1000 WHERE id=1;

SELECT * FROM usuario
WHERE id = 1;

SELECT * FROM saldo_changes
ORDER BY id_usuario ASC;