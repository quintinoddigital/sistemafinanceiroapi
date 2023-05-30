-- sistema de lancamento financeiro

drop table if exists tb_tipo_pessoa cascade;
drop table if exists tb_pessoa cascade;
drop table if exists tb_conta_bancaria cascade;
drop table if exists tb_periodo cascade;
drop table if exists tb_tag cascade;
drop table if exists tb_tipo_notificacao cascade;
drop table if exists tb_notificacao cascade;
drop table if exists tb_tipo_moeda cascade;
drop table if exists tb_tipo_lancamento cascade;
drop table if exists tb_anexo cascade;
drop table if exists tb_lancamento cascade;
drop table if exists tb_parcelamento cascade;
drop table if exists tb_lancamento_notificacao cascade;
drop table if exists tb_categoria_lancamento cascade;

create table if not exists tb_tipo_pessoa (
	codigo serial not null,
	descricao varchar(100) not null unique,
	constraint pk_tipo_pessoa primary key (codigo)
);

create table if not exists tb_pessoa (
	codigo serial not null,
	id_tipo_pessoa integer not null,
	nome varchar(100) not null unique,
	constraint pk_pessoa primary key (codigo),
	constraint fk_tipo_pessoa foreign key (id_tipo_pessoa) references tb_tipo_pessoa (codigo)
);

create table if not exists tb_tipo_conta_bancaria (
	codigo serial not null,
	descricao varchar(100) not null unique, -- CONTA_CORRENTE, CONTA_SALARIO, CONTA_POUPANCA
	constraint pk_tipo_conta_bancaria primary key (codigo)
);

create table if not exists tb_conta_bancaria (
	codigo serial not null,
	id_tipo_conta_bancaria integer not null,
	id_pessoa_instituicao_financeira integer not null,
	id_pessoa_titular integer not null,
	numero varchar(50) not null unique,
	data_abertura date null,
	data_encerramento date null,
	saldo float not null,
	constraint pk_conta_bancaria primary key (codigo),
	constraint fk_tipo_conta_bancaria foreign key (id_tipo_conta_bancaria) references tb_tipo_conta_bancaria (codigo),
	constraint fk_pessoa_instituicao_financeira foreign key (id_pessoa_instituicao_financeira) references tb_pessoa (codigo),
	constraint fk_pessoa_titular foreign key (id_pessoa_titular) references tb_pessoa (codigo)
);

create table if not exists tb_periodo (
	codigo serial not null,
	descricao varchar(100) not null unique,
	constraint pk_periodo primary key (codigo)
);

create table if not exists tb_tag (
	codigo serial not null,
	descricao varchar(100) not null unique,
	constraint pk_tag primary key (codigo)
);

create table if not exists tb_tipo_notificacao (
	codigo serial not null,
	descricao varchar(100) not null unique,
	constraint pk_tipo_notificacao primary key (codigo)
);

create table if not exists tb_notificacao (
	codigo serial not null,
	id_tipo_notificacao integer not null,
	data_notificacao timestamp not null,
	constraint pk_notificacao primary key (codigo),
	constraint fk_tipo_notificacao foreign key (id_tipo_notificacao) references tb_tipo_notificacao (codigo)
);

create table if not exists tb_tipo_moeda (
	codigo serial not null,
	descricao varchar(100) not null unique,
	simbolo varchar(3) not null unique,
	constraint pk_tipo_moeda primary key (codigo)
);

create table if not exists tb_tipo_lancamento (
	codigo serial not null,
	descricao varchar(100) not null unique,
	sigla varchar(10) not null unique,
	constraint pk_tipo_lancamento primary key (codigo)
);

create table if not exists tb_categoria_lancamento (
	codigo serial not null,
	descricao varchar(100) not null unique,
	constraint pk_categoria_lancamento primary key (codigo)
);

create table if not exists tb_lancamento (
	codigo serial not null,
	id_pessoa_favorecida integer not null,
	id_tipo_lancamento integer not null,
	id_categoria_lancamento integer not null,
	id_tipo_moeda integer not null,
	id_conta_bancaria integer not null,
	id_periodo integer not null,
	id_tag integer not null,
	data_pagamento date not null,
	data_cadastro date not null,
	valor float not null,
	quantidade_parcelas integer not null,
	is_lancamento_fixo boolean not null,
	is_repetir boolean not null,
	is_pago boolean not null,
	observacao varchar(255) null,
	constraint pk_lancamento primary key (codigo),
	constraint fk_pessoa_favorecida foreign key (id_pessoa_favorecida) references tb_pessoa (codigo),
	constraint fk_tipo_lancamento foreign key (id_tipo_lancamento) references tb_tipo_lancamento (codigo),
	constraint fk_categoria_lancamento foreign key (id_categoria_lancamento) references tb_categoria_lancamento (codigo),
	constraint fk_tipo_moeda foreign key (id_tipo_moeda) references tb_tipo_moeda (codigo),
	constraint fk_conta_bancaria foreign key (id_conta_bancaria) references tb_conta_bancaria (codigo),
	constraint fk_periodo foreign key (id_periodo) references tb_periodo (codigo),
	constraint fk_tag foreign key (id_tag) references tb_tag (codigo)
);

/*
	Regra: Deve vincular apenas se o Tipo do Lancamento for igual a Fixa ou Empréstimo
*/
create table if not exists tb_lancamento_notificacao (
	codigo serial not null,
	id_lancamento integer not null,
	id_notificacao integer not null,
	constraint pk_lancamento_notificacao primary key (codigo),
	constraint fk_lancamento foreign key (id_lancamento) references tb_lancamento (codigo),
	constraint fk_notificacao foreign key (id_notificacao) references tb_notificacao (codigo)
);

create table if not exists tb_anexo (
	codigo serial not null,
	id_lancamento integer not null,
	nome varchar(50) not null,
	descricao varchar(100) not null,
	tamanho varchar(50) not null,
	extencao varchar(50) not null,
	diretorio varchar(255) not null,
	constraint pk_anexo primary key (codigo),
	constraint fk_lancamento foreign key (id_lancamento) references tb_lancamento (codigo)
);

create table if not exists tb_parcelamento (
	codigo serial not null,
	id_lancamento integer not null,
	numero integer not null,
	data_vencimento date not null,
	data_pagamento date not null,
	valor float not null,
	constraint pk_parcelamento primary key (codigo),
	constraint fk_lancamento foreign key (id_lancamento) references tb_pessoa (codigo)
);

select * from tb_tipo_pessoa;
insert into tb_tipo_pessoa (descricao) values ('Pessoa Física');
insert into tb_tipo_pessoa (descricao) values ('Pessoa Jurídica');

select * from tb_pessoa;
insert into tb_pessoa (id_tipo_pessoa, nome) values (1, 'José Quintinno');
insert into tb_pessoa (id_tipo_pessoa, nome) values (2, 'Banco do Brasil');
insert into tb_pessoa (id_tipo_pessoa, nome) values (2, 'Supermercado Atacadão Dia a Dia (Vicente Pires)');

select * from tb_periodo;
insert into tb_periodo (descricao) values ('Casual');
insert into tb_periodo (descricao) values ('Diário');
insert into tb_periodo (descricao) values ('Mensal');
insert into tb_periodo (descricao) values ('Anual');

select * from tb_tag;
insert into tb_tag (descricao) values ('Supermercado Atacadão Dia a Dia');

select * from tb_tipo_notificacao;
insert into tb_tipo_notificacao (descricao) values ('Aplicativo');
insert into tb_tipo_notificacao (descricao) values ('E-mail');
insert into tb_tipo_notificacao (descricao) values ('SMS');
insert into tb_tipo_notificacao (descricao) values ('Ligação Telefônica');

select * from tb_notificacao;
insert into tb_notificacao (id_tipo_notificacao, data_notificacao) values (1, now());
insert into tb_notificacao (id_tipo_notificacao, data_notificacao) values (2, now());
insert into tb_notificacao (id_tipo_notificacao, data_notificacao) values (3, now());
insert into tb_notificacao (id_tipo_notificacao, data_notificacao) values (4, now());

select * from tb_tipo_moeda;
insert into tb_tipo_moeda (descricao, simbolo) values ('Real', 'R$');

select * from tb_categoria_lancamento;
insert into tb_categoria_lancamento (descricao) values ('Supermercado');
insert into tb_categoria_lancamento (descricao) values ('Fiat Uno 2015');

select * from tb_tipo_lancamento;
insert into tb_tipo_lancamento (descricao, sigla) values ('Receita Fixa', 'RECFIX');
insert into tb_tipo_lancamento (descricao, sigla) values ('Receita Variável', 'RECVAR');
insert into tb_tipo_lancamento (descricao, sigla) values ('Despesa Fixa', 'DESFIX');
insert into tb_tipo_lancamento (descricao, sigla) values ('Despesa Variável', 'DESVAR');
insert into tb_tipo_lancamento (descricao, sigla) values ('Empréstimo Adiquirido', 'EMPADQ');
insert into tb_tipo_lancamento (descricao, sigla) values ('Empréstimo Concedido', 'EMPCON');

select * from tb_conta_bancaria;
insert into tb_conta_bancaria (id_pessoa_instituicao_financeira, id_pessoa_titular, data_abertura, data_encerramento, saldo) values (2, 1, null, null, 5000);

select * from tb_lancamento;
insert into tb_lancamento (id_pessoa_favorecida, id_tipo_lancamento, id_categoria_lancamento, id_tipo_moeda, id_conta_bancaria, id_periodo, id_tag, data_cadastro, data_pagamento, valor, quantidade_parcelas, is_lancamento_fixo, is_repetir, is_pago, observacao) values (3, 4, 1, 1, 1, 1, 1, now(), now(), 1000, 1, false, false, true, '');

select * from tb_lancamento_notificacao;
insert into tb_lancamento_notificacao (id_lancamento, id_notificacao) values (1, 1);
insert into tb_lancamento_notificacao (id_lancamento, id_notificacao) values (1, 2);
insert into tb_lancamento_notificacao (id_lancamento, id_notificacao) values (1, 3);
insert into tb_lancamento_notificacao (id_lancamento, id_notificacao) values (1, 4);

select * from tb_parcelamento;
insert into tb_parcelamento (id_lancamento, numero, data_vencimento, data_pagamento, valor) values (1, 1, now(), now(), 1000);
