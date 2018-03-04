drop database hospital;

create database hospital;
use hospital;

create table medico(
	id bigint auto_increment primary key,
	nome varchar(255),
    email varchar(255) not null unique,
    senha varchar(20) not null,
    cpf char(14) not null unique,
    telefone char(9),
    crm varchar(4) not null unique,
    especialidade varchar(255),
    dataNascimento date);
    
insert into medico(nome, email, senha, cpf, telefone, crm, especialidade, dataNascimento) values
	("Missiele Victor","missiele@gmail.com","123", "123.114.336-00","999665108","1234","Clínico geral",'1990-01-01'),
	("José Félix", "felix@hotmail.com", "123","001.225.669-11","996445669", "1235", "Odontologista", '1990-02-01'),
    ("Jose Messias", "messias@hotmail.com", "123","781.925.669-61","988554462", "1236", "Urologista", '1990-03-01'),
    ("Helaine de Castro", "helaine@hotmail.com", "123","001.228.699-81","996445666", "1237", "Ginecologista", '1990-04-01');
     
create table paciente(
	id bigint auto_increment primary key,
    nome varchar(255),
    email varchar(255) not null unique,
    senha varchar(20) not null,
    cpf char(14) not null unique,
    telefone char(9),
    dataNascimento date,
    planoSaude boolean);
    
insert into paciente(nome, email, senha, cpf, telefone, dataNascimento, planoSaude) values
    ("Diana Andrade", "dm12@hotmail.com", "123", "126.558.669-02", "996554124", '1995-08-01', true);
    
    
create table consultas(
	id bigint auto_increment primary key,
    cpf varchar(14),
    crm varchar(4),
    dataCon date,
    foreign key (crm) references medico(crm),
    foreign key (cpf) references paciente(cpf)
    );
    
insert into consultas(cpf, crm, dataCon) values

    ("126.558.669-02","1237",'2018-02-25');
    