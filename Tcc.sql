create database banco;

use banco;

create table Cliente (

	codigo int primary key,
    cpf int,
    nome varchar(100),
    Endereco varchar(100),
    Telefone int
    
);