alter table usuario drop email; 
alter table cliente add column email varchar unique;
alter table fabricante drop column cnpj;
alter table fabricante add column cnpj varchar unique;
alter table usuario drop column repeteSenha;
alter table usuario add column repeteSenha varchar (20);
alter table cliente drop column pedido;

insert into fabricante(id, descricao, sigla, cnpj)
values(nextval('seq_fabricante'),'Molin','Mo','12. 147. 111/0001-07'),
(nextval('seq_fabricante'),'Faber Castell','FC','12. 146. 111/0001-06'),
(nextval('seq_fabricante'),'Chamequinho','CHA','15. 145. 111/0001-05'),
(nextval('seq_fabricante'),'CIS','CIS','14. 14. 111/0001-04'),
(nextval('seq_fabricante'),'Tilibra','Til','18. 148. 111/0001-08')

insert into usuario (id, nome, cpf, senha, repeteSenha)
values(nextval('seq_usuario'),'Maria','162.258.987-47','M@ria2021','M@ria2021'),
(nextval('seq_usuario'),'Pedro','232.171.982-31','P&dr02021','M@ria2021')


drop table funcionario

create table funcionario(
	id serial primary key,
	sobrenome varchar(30),
	registro int unique,
	
	constraint fk_funcionario_usuario1_idx foreign key (id) references usuario(id)
);

insert into funcionario (id,sobrenome,registro)
values(nextval('seq_funcionario'),'Gomes',147),
(nextval('seq_funcionario'),'Silva',108)

Select u.id, u.nome, f.sobrenome, f.registro, u.cpf
from  funcionario as f, usuario as u

create table Papelaria;
create table endereco( 
	id serial primary key, 
	cep decimal(10,0),
	uf varchar(3),
	cidade varchar(50),
	bairro varchar(50),
	logradouro varchar(50),
	numero decimal(10),
	complemento varchar(50)
);
create table usuario(
	id serial primary key,
	nome varchar(30),
	cpf varchar(15),
	senha varchar(20),
	repeteSenha varchar(8)
);

create table fabricante(
	id serial primary key,
	descricao varchar(100),
	sigla varchar(4),
	cnpj decimal(20)
);

insert into fabricante(id, descricao, sigla, cnpj)
values(1,'FaberCastell','fc',123456)

create table funcionario(
	id serial primary key,
	sobrenome varchar(30),
	registro int unique,
	
	constraint fk_funcionario_usuario1_idx foreign key (registro) references usuario(id)
);

create table cliente(
	id serial primary key,
	telefone decimal(10,0),
	endereco int,
	usuario int,
	carrinho int,
	pedido int, 
	email varchar(50) unique,
	
	constraint fk_cliente_endereco1_idx foreign key (endereco) references endereco(id),
	constraint fk_cliente_usuario1_idx foreign key (usuario) references usuario(id),
	constraint fk_cliente_carrinho1_idx foreign key (carrinho) references carrinho(id),
	constraint fk_cliente_pedido1_idx foreign key (pedido) references pedido(id)
);

create table carrinho(
	id serial primary key,
	valor float,
	emailCli varchar(50),
	item int,
	
	constraint fk_carrinho_item1_idx foreign key (item) references item(id)
);

create table pedido(
	id serial primary key,
	data_compra date,
	data_entrega date,
	status boolean,
	carrinho int,
	cliente int,
	funcionario int,
	
	constraint fk_pedido_carrinho1_idx foreign key (carrinho) references carrinho(id),
	constraint fk_pedido_funcionario1_idx foreign key (funcionario) references funcionario(id)
);

create table categoria(
	id serial primary key,
	descricao varchar(100),
	sigla varchar(4)	
);
create table item(
	id serial primary key,
	qtdd int,	
	produto int,
	valor float,	
	
	constraint fk_item_produto1_idx foreign key (produto) references produto(id)
);

create table produto(
	id serial primary key,
	descricao varchar(100),
	DataEntrada date,
	quantidade int,
	preco float,
	categoria int,
	fabricante int,	
	
	constraint fk_produto_fabricante1_idx foreign key (fabricante) references fabricante(id),
	constraint fk_produto_categoria1_idx foreign key (categoria) references categoria(id)
	
);

create sequence seq_carrrinho;
create sequence seq_categoria;
create sequence seq_cliente;
create sequence seq_endereco;
create sequence seq_fabricante;
create sequence seq_funcionario;
create sequence seq_item;
create sequence seq_pedido;
create sequence seq_produto;
create sequence seq_usuario
