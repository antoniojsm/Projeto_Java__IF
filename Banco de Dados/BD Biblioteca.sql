CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE usuario(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
usuario VARCHAR(45) NOT NULL,
senha VARCHAR (45) NOT NULL);

CREATE TABLE cadastrolivros(
id_livro INT AUTO_INCREMENT PRIMARY KEY,
titulo_livro VARCHAR (45) NOT NULL,
autor_livro VARCHAR (45) NOT NULL, 
disponibilidade INT NOT NULL);

INSERT INTO usuario VALUES 
(NULL, 'admin', 12345)