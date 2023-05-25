INSERT INTO TB_TIPO_PESSOA (DESCRICAO) values ('Pessoa Física');
INSERT INTO TB_TIPO_PESSOA (DESCRICAO) values ('Pessoa Jurídica');

INSERT INTO TB_PESSOA (ID_TIPO_PESSOA, NOME) values (1, 'Usuário de Desenvolvimento');

INSERT INTO TB_TIPO_LANCAMENTO (IDENTIFICADOR, DESCRICAO) VALUES
	('RECEITA_FIXA', 'Receita Fixa'),
	('RECEITA_VARIAVEL', 'Receita Variável'),
	('DESPESA_FIXA', 'Despesa Fixa'),
	('DESPESA_VARIAVEL', 'Despesa Variável'),
	('EMPRESTIMO_CONCESSAO','Empréstimo'),
	('EMPRESTIMO_ADQUIRICAO','Empréstimo');