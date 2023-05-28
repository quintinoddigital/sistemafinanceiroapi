CREATE TABLE IF NOT EXISTS TB_TIPO_DOCUMENTO (
    CODIGO SERIAL NOT NULL,
    SIGLA VARCHAR(10) NOT NULL UNIQUE,
    DESCRICAO VARCHAR(85) NULL,
    CONSTRAINT PK_TIPO_DOCUMENTO PRIMARY KEY (CODIGO)
);