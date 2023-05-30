-- CARGA BASICA

INSERT INTO TB_TIPO_PESSOA (DESCRICAO) values ('Pessoa Física');
INSERT INTO TB_TIPO_PESSOA (DESCRICAO) values ('Pessoa Jurídica');

INSERT INTO TB_PESSOA (ID_TIPO_PESSOA, NOME) values (1, 'José Quintino');
INSERT INTO TB_PESSOA (ID_TIPO_PESSOA, NOME) values (2, 'Banco do Brasil');
INSERT INTO TB_PESSOA (ID_TIPO_PESSOA, NOME) values (2, 'Amazon Brasil');

INSERT INTO TB_TIPO_LANCAMENTO (IDENTIFICADOR, DESCRICAO) VALUES
	('RECEITA_FIXA', 'Receita Fixa'),
	('RECEITA_VARIAVEL', 'Receita Variável'),
	('DESPESA_FIXA', 'Despesa Fixa'),
	('DESPESA_VARIAVEL', 'Despesa Variável'),
	('EMPRESTIMO_CONCESSAO','Empréstimo'),
	('EMPRESTIMO_ADQUIRICAO','Empréstimo');

INSERT INTO TB_PRODUTO_SERVICO (DESCRICAO) VALUES ('IPHONE 13 128GB');

INSERT INTO TB_LANCAMENTO (ID_PESSOA_FAVORECIDA, ID_PESSOA_RESPONSAVEL_LANCAMENTO, ID_TIPO_LANCAMENTO, IDENTIFICADOR, DATA_LANCAMENTO) VALUES (
	(select CODIGO from TB_PESSOA where NOME like 'Amazon Brasil'),
	(select CODIGO from TB_PESSOA where NOME like 'José Quintino'),
	(select CODIGO from TB_TIPO_LANCAMENTO where IDENTIFICADOR like 'DESPESA_VARIAVEL'),
	'LANCAMENTO-23052023-DESPESA-VARIAVEL',
	NOW()
);

INSERT INTO TB_LANCAMENTO_PRODUTO_SERVICO (ID_LANCAMENTO, ID_PRODUTO_SERVICO, VALOR) VALUES (
	(select CODIGO from TB_LANCAMENTO where identificador like 'LANCAMENTO-23052023-DESPESA-VARIAVEL'),
	(select CODIGO from TB_PRODUTO_SERVICO where DESCRICAO like 'IPHONE 13 128GB'),
	4364.10
);

INSERT INTO TB_CONTA_BANCARIA (ID_PESSOA_INSTITUICAO_FINANCEIRA, ID_PESSOA_TITULAR, NUMERO, DATA_ABERTURA, DATA_FECHAMENTO, SALDO) VALUES (
	(select CODIGO from TB_PESSOA where NOME like 'Banco do Brasil'),
	(select CODIGO from TB_PESSOA where NOME like 'José Quintino'),
	'00000000',
	now(),
	null,
	5000
);

INSERT INTO TB_FORMA_PAGAMENTO (DESCRICAO) VALUES ('Dinheiro');

INSERT INTO TB_PAGAMENTO (ID_CONTA_BANCARIA, ID_FORMA_PAGAMENTO, DATA_PAGAMENTO) VALUES (
	1, 1, now()
);

INSERT INTO TB_LANCAMENTO_PAGAMENTO (ID_LANCAMENTO, ID_PAGAMENTO, VALOR) VALUES (
	1, 1, 4364.10
);

INSERT INTO TB_PARCELAMENTO (ID_PAGAMENTO, NUMERO, VALOR) VALUES (
	1, 1, 2182.05
);

INSERT INTO TB_PARCELAMENTO (ID_PAGAMENTO, NUMERO, VALOR) VALUES (
	1, 2, 2182.05
);

INSERT INTO TB_ARQUIVO (NOME, DESCRICAO, FORMATO, CAMINHO, TAMANHO, DATA_CADASTRO, DATA_ATUALIZACAO) VALUES (
	'CUPOM FISCAL', '', 'PDF', '', null, now(), now()
);

INSERT INTO TB_ARQUIVO (NOME, DESCRICAO, FORMATO, CAMINHO, TAMANHO, DATA_CADASTRO, DATA_ATUALIZACAO) VALUES (
	'COMPROVANTE CARTAO DE CREDITO', '', 'PNG', '', null, now(), now()
);

INSERT INTO TB_LANCAMENTO_ARQUIVO (ID_LANCAMENTO, ID_ARQUIVO) VALUES (
	1, 1
);

INSERT INTO TB_LANCAMENTO_ARQUIVO (ID_LANCAMENTO, ID_ARQUIVO) VALUES (
	1, 2
);

/*
	"DIRETOR_FINANCEIRO", -- Pessoa que tem acesso a todo o sistema
	"ADMINISTRADOR_FINANCEIRO", -- Pessoa que pode ou nao ter acesso a lancamentos de outras pessoas
	"CONSULTOR_FINANCEIRO" -- Pessoa convidada. Usado para consultorias (Relatorios etc)
*/
INSERT INTO TB_PAPEL (NOME) VALUES ('DIRETOR_FINANCEIRO');
INSERT INTO TB_PAPEL (NOME) VALUES ('ADMINISTRADOR_FINANCEIRO');
INSERT INTO TB_PAPEL (NOME) VALUES ('CONSULTOR_FINANCEIRO');

INSERT INTO TB_PAPEL_PESSOA (ID_PESSOA, ID_PAPEL) VALUES (1, 1);
INSERT INTO TB_PAPEL_PESSOA (ID_PESSOA, ID_PAPEL) VALUES (1, 2);
INSERT INTO TB_PAPEL_PESSOA (ID_PESSOA, ID_PAPEL) VALUES (1, 3);

INSERT INTO TB_TIPO_DOCUMENTO (SIGLA, DESCRICAO) VALUES ('CPF', '');
INSERT INTO TB_TIPO_DOCUMENTO (SIGLA, DESCRICAO) VALUES ('CNPJ', '');
INSERT INTO TB_TIPO_DOCUMENTO (SIGLA, DESCRICAO) VALUES ('RG', 'Registro Geral');