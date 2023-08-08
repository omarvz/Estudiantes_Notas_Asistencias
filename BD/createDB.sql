-- ------------------------------------------------------------------------------------------------
-- Eliminacion de tablas                                                                          |
-- ------------------------------------------------------------------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
SET GROUP_CONCAT_MAX_LEN=32768;
SET @tables = NULL;
SELECT GROUP_CONCAT('`', table_name, '`') INTO @tables
  FROM information_schema.tables
  WHERE table_schema = (SELECT DATABASE());
SELECT IFNULL(@tables,'dummy') INTO @tables;

SET @tables = CONCAT('DROP TABLE IF EXISTS ', @tables);
PREPARE stmt FROM @tables;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
-- ------------------------------------------------------------------------------------------------
-- Creacion de tablas                                                                             |
-- ------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS persona(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(70) NOT NULL,
    apellido_paterno VARCHAR(70),
    DNI VARCHAR(8) NOT NULL UNIQUE,
    fecha_de_nacimiento DATETIME NOT NULL,
    activo TINYINT NOT NULL DEFAULT TRUE,
    codigo VARCHAR(8) NOT NULL UNIQUE 
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS cuenta(

)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS estudiante(
	id INT PRIMARY KEY,
    estado TINYINT NOT NULL DEFAULT TRUE,
    ciclo_estudio INT NOT NULL,
    FOREIGN KEY (id) REFERENCES persona(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS profesor(
	id INT PRIMARY KEY,
    tipo ENUM('TPA', 'DTC') NOT NULL,
    estado TINYINT NOT NULL DEFAULT TRUE,
    area_especializacion VARCHAR(100) NOT NULL,
    FOREIGN KEY (id) REFERENCES persona(id)
)ENGINE=INNODB;








