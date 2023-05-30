create table if not exists tb_usuario (
	codigo serial not null,
	id_papel varchar(50) not null,
	nome varchar(100) not null,
	identificador varchar(100) not null unique,
	chave varchar(100) not null,
	imagem bytea null,
	is_ativo boolean not null,
	constraint pk_usuario primary key (codigo)
);