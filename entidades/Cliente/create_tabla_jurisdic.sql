CREATE TABLE IF NOT EXISTS winners.jurisdic
(
    codigo smallint NOT NULL,
    nombre character(20) COLLATE pg_catalog."default",
    convenio smallint,
    activa smallint,
    string1 character(20) COLLATE pg_catalog."default",
    long1 integer,
    byte1 smallint,
    decimal1 numeric(12,2),
    cuentaretensifmult smallint,
    cuentapercepsifmult smallint,
    cuentapercepsifadua smallint,
    CONSTRAINT key01_jurisdic PRIMARY KEY (codigo)
)