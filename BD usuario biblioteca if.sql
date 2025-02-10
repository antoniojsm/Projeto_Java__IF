CREATE DATABASE bibliotecaif;
USE bibliotecaif;
CREATE TABLE usuario_biblioteca(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
nome_usuario VARCHAR (45) NOT NULL,
senha VARCHAR (45) NOT NULL);

CREATE TABLE livros(
id_livro INT PRIMARY KEY AUTO_INCREMENT,
titulo_livro VARCHAR (45) NOT NULL,
autor_livro VARCHAR (45) NOT NULL,
disponibilidade BOOLEAN NOT NULL);

SELECT * FROM livros;



