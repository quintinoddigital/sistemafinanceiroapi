CREATE TABLE IF NOT EXISTS TB_CONTA_BANCARIA (
    CODIGO SERIAL NOT NULL,
    ID_PESSOA_INSTITUICAO_FINANCEIRA INTEGER NOT NULL,
    ID_PESSOA_TITULAR INTEGER NOT NULL,
    NUMERO VARCHAR(80) NOT NULL,
    DATA_ABERTURA DATE NOT NULL,
    DATA_FECHAMENTO DATE NULL,
    SALDO FLOAT NOT NULL,
    CONSTRAINT PK_CONTA_BANCARIA PRIMARY KEY (CODIGO),
    CONSTRAINT FK_PESSOA_INSTITUICAO_FINANCEIRA FOREIGN KEY (ID_PESSOA_INSTITUICAO_FINANCEIRA) REFERENCES TB_PESSOA(CODIGO),
    CONSTRAINT FK_PESSOA_TITULAR FOREIGN KEY (ID_PESSOA_TITULAR) REFERENCES TB_PESSOA(CODIGO)
);