CREATE TABLE IF NOT EXISTS TB_DOCUMENTO (
    CODIGO SERIAL NOT NULL,
    ID_TIPO_DOCUMENTO INTEGER NOT NULL,
    ID_PESSOA INTEGER NOT NULL,
    NUMERO VARCHAR(85) NULL,
    DATA_EMISSAO DATE NULL,
    DATA_VENCIMENTO DATE NULL,
    IS_ATIVO BOOLEAN NOT NULL,
    CONSTRAINT PK_DOCUMENTO PRIMARY KEY (CODIGO),
    CONSTRAINT FK_TIPO_DOCUMENTO FOREIGN KEY (ID_TIPO_DOCUMENTO) REFERENCES TB_TIPO_DOCUMENTO (CODIGO),
    CONSTRAINT FK_PESSOA FOREIGN KEY (ID_PESSOA) REFERENCES TB_PESSOA (CODIGO)
);