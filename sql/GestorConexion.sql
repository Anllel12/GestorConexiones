CREATE DATABASE discografica;

USE discografica;

CREATE TABLE `album` (
	`id` INT(10) NOT NULL,
	`titulo` VARCHAR(100) NOT NULL,
	`autor` VARCHAR(100) NOT NULL,
	`fecha_lanzamiento` VARCHAR(10) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `cancion` (
`id` INT(10),
`titulo` VARCHAR(100),
`autor` VARCHAR(100),
`album` INT(10),
PRIMARY KEY (`id`)
);

INSERT INTO `album` VALUES 
(1, 'Mi Caja de Musica', 'Denom', '21-08-2020');

INSERT INTO `cancion` VALUES 
(1, 'En el Horno', 'Denom', '1'),
(2, 'Game Over', 'Denom', '1');

SELECT * FROM album;
SELECT * FROM cancion;

DROP DATABASE discografica;