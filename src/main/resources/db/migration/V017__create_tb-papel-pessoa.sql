CREATE TABLE IF NOT EXISTS TB_PAPEL_PESSOA (
    CODIGO SERIAL NOT NULL,
    ID_PESSOA INTEGER NOT NULL,
    ID_PAPEL INTEGER NOT NULL,
    CONSTRAINT PK_PAPEL_PESSOA PRIMARY KEY (CODIGO),
    CONSTRAINT FK_ID_PESSOA FOREIGN KEY (ID_PESSOA) REFERENCES TB_PESSOA (CODIGO),
    CONSTRAINT FK_PAPEL FOREIGN KEY (ID_PAPEL) REFERENCES TB_PAPEL (CODIGO)
);