CREATE DATABASE discografica;

USE discografica;

CREATE TABLE `album` ( /*Creamos la tabla album*/
	`id` INT(10) NOT NULL,
	`titulo` VARCHAR(100) NOT NULL,
	`autor` VARCHAR(100) NOT NULL,
	`fecha_lanzamiento` VARCHAR(10) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `cancion` ( /*Creamos la tabla cancion*/
`id` INT(10),
`titulo` VARCHAR(100),
`autor` VARCHAR(100),
`album` INT(10),
PRIMARY KEY (`id`)
);

INSERT INTO `album` VALUES /*Insertamos valores en la tabla album*/
(1, 'Mi Caja de Musica', 'Denom', '21-08-2020');

INSERT INTO `cancion` VALUES /*Insertamos valores en la tabla cancion*/
(1, 'En el Horno', 'Denom', '1'),
(2, 'Game Over', 'Denom', '1');