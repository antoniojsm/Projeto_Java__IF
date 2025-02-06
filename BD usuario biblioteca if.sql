CREATE DATABASE bibliotecaif;
USE bibliotecaif;
CREATE TABLE usuario_biblioteca(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
nome_usuario VARCHAR (45) NOT NULL,
senha VARCHAR (45) NOT NULL);