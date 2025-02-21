CREATE TABLE IF NOT EXISTS winners.paises
(
    codigo smallint NOT NULL,
    nombre character(25) COLLATE pg_catalog."default",
    string1 character(20) COLLATE pg_catalog."default",
    long1 integer,
    byte1 smallint,
    decimal1 numeric(12,2),
    CONSTRAINT key01_paises PRIMARY KEY (codigo)
)