CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE usuario(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
usuario VARCHAR(45) NOT NULL,
senha VARCHAR (45) NOT NULL);

CREATE TABLE cadastrolivros(
id_livro INT AUTO_INCREMENT PRIMARY KEY,
titulo_livro VARCHAR (45) NOT NULL ,
autor_livro VARCHAR (45) NOT NULL, 
disponibilidade INT NOT NULL);

CREATE TABLE cadastroalunos(
id_aluno INT PRIMARY KEY AUTO_INCREMENT,
cpf CHAR(11) NOT NULL UNIQUE,
nome_aluno VARCHAR (45) NOT NULL,
email_aluno VARCHAR (50) NOT NULL,
emprestimo VARCHAR (15) NOT NULL,
entrega VARCHAR (15) NOT NULL);


INSERT INTO usuario VALUES 
(NULL, 'admin', 12345)