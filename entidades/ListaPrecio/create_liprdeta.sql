CREATE TABLE IF NOT EXISTS winners.liprdeta
(
    lista smallint NOT NULL,
    producto character(14) COLLATE pg_catalog."default" NOT NULL,
    precio numeric(12,4),
    integridad smallint,
    inactivo smallint,
    coefsobrepreciobase numeric(15,6),
    redondearprecios smallint,
    redondearanumero numeric(10,2),
    string1 character(20) COLLATE pg_catalog."default",
    short1 smallint,
    byte1 smallint,
    long1 integer,
    CONSTRAINT key01_liprdeta PRIMARY KEY (lista, producto)
)