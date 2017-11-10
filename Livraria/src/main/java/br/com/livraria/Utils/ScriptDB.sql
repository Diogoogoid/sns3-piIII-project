/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  bruno.falmeida
 * Created: 06/11/2017
 */

create table cliente (
    IdCli int generated always as identity (start with 1, increment by 1) primary key,
    Cli_Nome varchar(100) not null,
    Sexo varchar (20),
    Status boolean,
    DataNasc Date not null,
    EstadoCivil varchar(30) not null,
    CPF varchar (30) not null,
    Tel varchar (30),
    Cel varchar (30),
    Email varchar(30),
    Logradouro varchar(50) not null,
    Numero varchar(30) not null,
    Complemento varchar(30),
    CEP varchar(10) not null,
    Bairro varchar(100) not null,
    Cidade varchar(100) not null,
    Estado varchar(100) not null
);

create table filial (
    IdFilial int generated always as identity (start with 1, increment by 1) primary key,
    Filial_Nome varchar(100) not null,
    Estado varchar(100) not null,
    Cidade Varchar(100) not null,
    Status boolean
);

create table setor (
    IdSetor int generated always as identity (start with 1, increment by 1) primary key,
    Setor_Nome varchar(100) not null,
    Descricao varchar(200),
    Status boolean
);

create table cargo (
    IdCargo int generated always as identity (start with 1, increment by 1) primary key,
    IdSetor int unique not null,
    Cargo_Nome varchar(100) not null,
    Descricao varchar(200),
    Status boolean,
    foreign key (IdSetor) references setor(IdSetor)
);

create table funcionario (
    IdFunc int generated always as identity (start with 1, increment by 1) primary key,
    IdFilial int unique not null,
    IdCargo int unique not null,
    Func_Nome varchar(100) not null,
    Sexo varchar (20),
    Status boolean,
    DataNasc Date not null,
    EstadoCivil varchar(30) not null,
    CPF varchar (30) not null,
    Tel varchar (30),
    Cel varchar (30),
    Email varchar(30),
    Logradouro varchar(50) not null,
    Numero varchar(30) not null,
    Complemento varchar(30),
    CEP varchar(10) not null,
    Bairro varchar(100) not null,
    Cidade varchar(100) not null,
    Estado varchar(100) not null,
    Login varchar(100) unique not null,
    Senha varchar(100) not null,
    foreign key (IdFilial) references filial(IdFilial),
    foreign key (IdCargo) references cargo(IdCargo)
);

create table produto (
    IdProd int generated always as identity (start with 1, increment by 1) primary key,
    Prod_Nome varchar(100) not null,
    Fabricante varchar(100) not null,
    TipoProd varchar(100) not null,
    Descricao varchar(200) not null,
    Quantidade int,
    Status boolean,
    Valor float,
    Garantia int,
    DataFab Date
);

create table pedido (
    IdPedido int generated always as identity (start with 1, increment by 1) primary key,
    IdCli int unique not null,
    IdFilial int unique not null,
    DataComp Date,
    Valor float,
    foreign key (IdCli) references cliente(IdCli),
    foreign key (IdFilial) references filial(IdFilial)
);

create table itensPedidos (
    IdItem int generated always as identity (start with 1, increment by 1) primary key,
    IdProd int unique not null,
    IdPedido int unique not null,
    Quantidade int,
    SubTotal float,
    foreign key (IdProd) references produto(IdProd),
    foreign key (IdPedido) references pedido(IdPedido)
);

create table modulo (
    IdModulo int generated always as identity (start with 1, increment by 1) primary key,
    Modulo_Nome varchar(100) not null,
    Sub_Nome varchar(100)
);

create table permissao (
    IdPerm int generated always as identity (start with 1, increment by 1) primary key,
    IdModulo int unique not null,
    IdCargo int unique not null,
    foreign key (IdModulo) references modulo(IdModulo),
    foreign key (IdCargo) references cargo(IdCargo)
);