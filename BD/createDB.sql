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
	id INT PRIMARY KEY AUTO_INCREMENT,
    fid_persona INT NOT NULL,
    correo VARCHAR(40) NOT NULL UNIQUE,
    `password` VARCHAR(40) NOT NULL,
    activo TINYINT NOT NULL DEFAULT TRUE,
    FOREIGN KEY (fid_persona) REFERENCES persona(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS especialidad(
	id INT PRIMARY KEY AUTO_INCREMENT,
    abreviatura VARCHAR(10) NOT NULL,
    nombre VARCHAR(70) NOT NULL,
    activo TINYINT NOT NULL DEFAULT TRUE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS estudiante(
	id INT PRIMARY KEY,
    estado TINYINT NOT NULL DEFAULT TRUE,
    ciclo_estudio INT NOT NULL,
    FOREIGN KEY (id) REFERENCES persona(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS estudiante_x_especialidad(
	fid_estudiante INT,
    fid_especialidad INT,
	activo TINYINT NOT NULL DEFAULT TRUE,
    PRIMARY KEY (fid_estudiante, fid_especialidad),
	FOREIGN KEY (fid_estudiante) REFERENCES estudiante(id),
	FOREIGN KEY (fid_especialidad) REFERENCES especialidad(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS profesor(
	id INT PRIMARY KEY,
    tipo ENUM('TPA', 'DTC') NOT NULL,
    estado TINYINT NOT NULL DEFAULT TRUE,
    area_especializacion VARCHAR(100) NOT NULL,
    FOREIGN KEY (id) REFERENCES persona(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS profesor_x_especialidad(
	fid_profesor INT,
    fid_especialidad INT,
	activo TINYINT NOT NULL DEFAULT TRUE,
    PRIMARY KEY (fid_profesor, fid_especialidad),
	FOREIGN KEY (fid_profesor) REFERENCES profesor(id),
	FOREIGN KEY (fid_especialidad) REFERENCES especialidad(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS curso(
	id INT PRIMARY KEY AUTO_INCREMENT,
    abreviatura VARCHAR(10) NOT NULL,
    nombre VARCHAR(70) NOT NULL,
    estado TINYINT NOT NULL DEFAULT TRUE
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS curso_x_especialidad(
	fid_curso INT,
    fid_especialidad INT,
	activo TINYINT NOT NULL DEFAULT TRUE,
    PRIMARY KEY (fid_curso, fid_especialidad),
	FOREIGN KEY (fid_curso) REFERENCES curso(id),
	FOREIGN KEY (fid_especialidad) REFERENCES especialidad(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS curso_x_profesor(
	fid_curso INT,
    fid_profesor INT,
	activo TINYINT NOT NULL DEFAULT TRUE,
    PRIMARY KEY (fid_curso, fid_profesor),
	FOREIGN KEY (fid_curso) REFERENCES curso(id),
	FOREIGN KEY (fid_profesor) REFERENCES profesor(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS horario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    fid_curso INT NOT NULL,
    nombre VARCHAR(70) NOT NULL,
    estado TINYINT NOT NULL DEFAULT TRUE,
    FOREIGN KEY (fid_curso) REFERENCES curso(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS horario_x_estudiante(
	fid_horario INT,
    fid_estudiante INT,
	activo TINYINT NOT NULL DEFAULT TRUE,
    PRIMARY KEY (fid_horario, fid_estudiante),
	FOREIGN KEY (fid_horario) REFERENCES horario(id),
	FOREIGN KEY (fid_estudiante) REFERENCES estudiante(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS horario_x_profesor(
	fid_horario INT,
    fid_profesor INT,
	activo TINYINT NOT NULL DEFAULT TRUE,
    PRIMARY KEY (fid_horario, fid_profesor),
	FOREIGN KEY (fid_horario) REFERENCES horario(id),
	FOREIGN KEY (fid_profesor) REFERENCES profesor(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS nota(
	id INT PRIMARY KEY AUTO_INCREMENT,
    fid_horario INT NOT NULL,
    fid_estudiante INT NOT NULL,
    tipo ENUM('PC', 'LAB', 'EX') NOT NULL,
    descripcion VARCHAR(50),
    fecha_de_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (fid_horario) REFERENCES horario(id),
    FOREIGN KEY (fid_estudiante) REFERENCES estudiante(id)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS asistencia(
	id INT PRIMARY KEY AUTO_INCREMENT,
    fid_horario INT NOT NULL,
    fid_estudiante INT NOT NULL,
    tipo ENUM('Clase', 'PC', 'LAB', 'EX') NOT NULL,
    estado ENUM('Presente', 'Tardanza', 'Ausente') NOT NULL,
    descripcion VARCHAR(50),
    fecha_de_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (fid_horario) REFERENCES horario(id),
    FOREIGN KEY (fid_estudiante) REFERENCES estudiante(id)
)ENGINE=INNODB;


