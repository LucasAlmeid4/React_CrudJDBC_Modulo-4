create database clientes;

use clientes;

create table cliente(
cpf int(11) not null primary key,
nome varchar(40),
idade int(3),
email varchar(40),
destino varchar(40),
localAtual varchar(40),
dataCadastro date)


