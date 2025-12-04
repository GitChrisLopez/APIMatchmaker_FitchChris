DROP DATABASE IF EXISTS MatchMaker;
CREATE DATABASE MatchMaker;
USE MatchMaker;

CREATE TABLE profile (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido_paterno VARCHAR(100),
    apellido_materno VARCHAR(100),
    fecha_nacimiento DATE,
    foto VARCHAR(255),
    email VARCHAR(100),
    genero VARCHAR(20),
    pais VARCHAR(50),
    telefono VARCHAR(20),
    celular VARCHAR(20),
    direccion VARCHAR(255),
    edad INT
);

INSERT INTO profile 
(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, foto, email, genero, pais, telefono, celular, direccion, edad)
VALUES
("Chris", "Lopez", "Picasso", "2004-09-03", "https://static.wikia.nocookie.net/memes-pedia/images/6/63/Polite_Cat.jpeg/revision/latest?cb=20211113003020&path-prefix=es", 
	"chrisTrolo@gmail.com", "Male", "Canada", "29389232", "(222)297328", "Calle 1 #100", 25);

INSERT INTO profile 
(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, foto, email, genero, pais, telefono, celular, direccion, edad)
VALUES
("Luis", "Antonio", "Lopez", "2003-01-01", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8vpf8o-86RZrNLL3EZ_2Y3hDkS2wEtASjzg&s", 
	"LuisTralalelo@hotmail.com", "Male", "Mexico", "(222)297328", "453345345", "Calle falsa #123", 25);

INSERT INTO profile 
(nombre, apellido_paterno, apellido_materno, fecha_nacimiento, foto, email, genero, pais, telefono, celular, direccion, edad)
VALUES
("Olivia", "Hacibe", "Sanchez", "2003-12-12", "https://i.pinimg.com/originals/1d/40/0e/1d400e79e924b844848049f3e52172b2.jpg", 
	"OliviaPelona@yahoo.com.mx", "Female", "Brasil", "(333)356828", "44545646", "Calle super real #321", 25);
