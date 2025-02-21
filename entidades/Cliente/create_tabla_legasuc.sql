CREATE TABLE IF NOT EXISTS winners.legasuc
(
    clipro character(2) COLLATE pg_catalog."default" NOT NULL,
    legajo integer NOT NULL,
    codigo smallint NOT NULL,
    nombre character(30) COLLATE pg_catalog."default",
    domicilio character(35) COLLATE pg_catalog."default",
    localidad character(25) COLLATE pg_catalog."default",
    nuevocodpostal character(14) COLLATE pg_catalog."default",
    jurisdiccion smallint,
    pais smallint,
    telefono character(30) COLLATE pg_catalog."default",
    fax character(30) COLLATE pg_catalog."default",
    e_mail character(100) COLLATE pg_catalog."default",
    e_mail2 character(40) COLLATE pg_catalog."default",
    inactivo smallint,
    integridad smallint,
    zona smallint,
    tipovendedor character(2) COLLATE pg_catalog."default",
    vendedor integer,
    entrega character(60) COLLATE pg_catalog."default",
    expreso smallint,
    observ_1 character(60) COLLATE pg_catalog."default",
    observ_2 character(60) COLLATE pg_catalog."default",
    observ_3 character(60) COLLATE pg_catalog."default",
    string1 character(20) COLLATE pg_catalog."default",
    string2 character(20) COLLATE pg_catalog."default",
    string3 character(20) COLLATE pg_catalog."default",
    string4 character(20) COLLATE pg_catalog."default",
    long1 integer,
    long2 integer,
    long3 integer,
    long4 integer,
    byte1 smallint,
    byte2 smallint,
    byte3 smallint,
    byte4 smallint,
    decimal1 numeric(12,2),
    decimal2 numeric(12,2),
    decimal3 numeric(12,2),
    decimal4 numeric(12,2),
    descuento numeric(12,2),
    formapago smallint,
    exportadoalblock date,
    deposenconsigna integer,
    lugardeentregaigualdomicilio smallint,
    domicilioentrega character(35) COLLATE pg_catalog."default",
    localidadentrega character(25) COLLATE pg_catalog."default",
    nuevocodpostalentrega character(14) COLLATE pg_catalog."default",
    jurisdiccionentega smallint,
    paisentega smallint,
    observ_1entrega character(60) COLLATE pg_catalog."default",
    documento smallint,
    cuenta smallint,
    sitimpositiva smallint,
    cuit character(13) COLLATE pg_catalog."default",
    tipoiva character(3) COLLATE pg_catalog."default",
    familiaproducto character(1) COLLATE pg_catalog."default",
    CONSTRAINT key01_legasuc PRIMARY KEY (clipro, legajo, codigo)
)