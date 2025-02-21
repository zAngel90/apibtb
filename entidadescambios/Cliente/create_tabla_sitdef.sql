CREATE TABLE IF NOT EXISTS winners.sitdef
(
    orden smallint NOT NULL,
    tipoiva character(3) COLLATE pg_catalog."default",
    compras character(2) COLLATE pg_catalog."default",
    sitimpositivacompras smallint,
    ventas character(2) COLLATE pg_catalog."default",
    sitimpositivaventas smallint,
    CONSTRAINT key01_sitdef PRIMARY KEY (orden)
)