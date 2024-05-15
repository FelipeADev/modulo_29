create table tb_cliente (
	id bigint,
	nome varchar(50) not null,
	codigo varchar(50) not null,
	constraint pk_id_cliente primary key(id)
);

create table tb_produto (
	id bigint,
	nome varchar(50) not null,
	codigo varchar(50) not null,
	id_cliente bigint,
	constraint pk_id_produto primary key(id),
	constraint fk_id_cliente_produto foreign key (id_cliente) references tb_cliente(id)
);

create sequence sq_cliente
start 1
increment 1

create sequence sq_produto
start 1
increment 1

select * from tb_cliente;
select * from tb_produto;

delete from tb_cliente where codigo = '20';