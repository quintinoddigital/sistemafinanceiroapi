create table if not exists tb_tipo_pessoa (
	codigo serial not null,
	descricao varchar(100) not null unique,
	constraint pk_tipo_pessoa primary key (codigo)
);