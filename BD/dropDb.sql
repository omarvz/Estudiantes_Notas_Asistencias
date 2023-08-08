SET FOREIGN_KEY_CHECKS = 0;
#Eliminar las tablas
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

#Eliminar los procedures
SET GROUP_CONCAT_MAX_LEN=32768;
SET @procedures = NULL;
SELECT GROUP_CONCAT('`', routine_name, '`') INTO @procedures
  FROM information_schema.routines
  WHERE routine_type = 'PROCEDURE' AND routine_schema = (SELECT DATABASE());
SELECT IFNULL(@procedures, 'dummy') INTO @procedures;

SET @procedures = CONCAT('DROP PROCEDURE IF EXISTS ', @procedures);
PREPARE stmt FROM @procedures;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
SET FOREIGN_KEY_CHECKS = 1;