CREATE TABLE IF NOT EXISTS winners.producto
(
    codigo_1 integer,
    codigo_2 integer,
    codigo_3 integer,
    codigo_4 integer,
    codigo_5 integer,
    codigo character(14) COLLATE pg_catalog."default" NOT NULL,
    habilitarcodigoabreviado smallint,
    codigoabreviado integer,
    codigobarrasventa character(14) COLLATE pg_catalog."default",
    nombreventa character(70) COLLATE pg_catalog."default",
    unidadmedidaventa character(10) COLLATE pg_catalog."default",
    monedaextranjeraventa smallint,
    monedaventa smallint,
    cuentaventas smallint,
    centrocostoventas integer,
    usasitimpespecialventas smallint,
    usadepositoventas smallint,
    depositoventas integer,
    usadatoscomprasespeciales smallint,
    codigobarrascompra character(14) COLLATE pg_catalog."default",
    nombrecompra character(70) COLLATE pg_catalog."default",
    unidadmedidacompra character(10) COLLATE pg_catalog."default",
    monedaextranjeracompra smallint,
    monedacompra smallint,
    proveedorunico integer,
    codigoproductocompra character(14) COLLATE pg_catalog."default",
    cuentacompras smallint,
    centrocostocompras integer,
    usasitimpespecialcompras smallint,
    usadepositocompras smallint,
    depositocompras integer,
    preciocompra numeric(12,4),
    calculapreciobaseseguncompra smallint,
    porcentajesobrecompra numeric(9,4),
    importefijosobrecompra numeric(12,4),
    preciobase numeric(12,4),
    importenogravado numeric(12,4),
    percepcionfija numeric(12,4),
    redondearprecios smallint,
    redondearanumero numeric(10,2),
    pedirsiempreprecio smallint,
    faltarecalcularpreciobase smallint,
    nuevopreciocompraempresa smallint,
    nuevopreciocompranrooperacion integer,
    unidadesproductoenteros smallint,
    unidadesproductodecimales smallint,
    precioproductoenteros smallint,
    precioproductodecimales smallint,
    cargarunidadesporcalculo smallint,
    posicion_1 character(5) COLLATE pg_catalog."default",
    posicion_2 character(5) COLLATE pg_catalog."default",
    posicion_3 character(5) COLLATE pg_catalog."default",
    posicion_4 character(5) COLLATE pg_catalog."default",
    integridad smallint,
    inactivo smallint,
    noventa smallint,
    productoconformula smallint,
    tipofabricacion character(1) COLLATE pg_catalog."default",
    descargarformulaautomatica smallint,
    descargaformulaautomaticaen character(1) COLLATE pg_catalog."default",
    cantidadbase numeric(16,4),
    generaresiduos smallint,
    nomanejastock smallint,
    controlarstock smallint,
    manejatalles smallint,
    manejacolores smallint,
    manejaproductounico smallint,
    usapiezas smallint,
    manejapartidas smallint,
    metododescarga character(1) COLLATE pg_catalog."default",
    usacantidadunica smallint,
    convencimiento smallint,
    manejacomponentebase smallint,
    productobase character(14) COLLATE pg_catalog."default",
    cantidadproductobase numeric(12,4),
    tieneimagen smallint,
    string1 character(20) COLLATE pg_catalog."default",
    string2 character(20) COLLATE pg_catalog."default",
    short1 smallint,
    short2 smallint,
    long1 integer,
    long2 integer,
    byte1 smallint,
    byte2 smallint,
    decimal1 numeric(12,4),
    decimal2 numeric(12,4),
    preciocomprame numeric(12,4),
    monedapreciocomprame smallint,
    monedapreciobaseseguncompra character(1) COLLATE pg_catalog."default",
    codigobase character(14) COLLATE pg_catalog."default",
    color character(6) COLLATE pg_catalog."default",
    talle character(6) COLLATE pg_catalog."default",
    genero character(1) COLLATE pg_catalog."default",
    preciofob numeric(12,4),
    fysporc numeric(7,4),
    fyscosto numeric(12,4),
    nacporc numeric(7,4),
    naccosto numeric(12,4),
    fysprecio numeric(12,4),
    nacprecio numeric(12,4),
    codigolince character(13) COLLATE pg_catalog."default",
    tallelince character(3) COLLATE pg_catalog."default",
    exportoalince smallint,
    exportadoalblock date,
    valuacioncontable numeric(12,4),
    fechavaluacioncontable date,
    solopreventa smallint,
    codigogtin character(13) COLLATE pg_catalog."default",
    publicadoafip smallint,
    paisorigen smallint,
    faltacodigogtin smallint,
    cargarpreciocostosenventas smallint,
    pagaiva smallint DEFAULT 1,
    imprimeetiqueta smallint DEFAULT 1,
    observ1 character(60) COLLATE pg_catalog."default",
    observ2 character(60) COLLATE pg_catalog."default",
    esunamanguera smallint,
    presion character(1) COLLATE pg_catalog."default",
    tipomanguera character(1) COLLATE pg_catalog."default",
    sectorfabricacion smallint,
    diametro character(1) COLLATE pg_catalog."default",
    esmangueracompleja smallint,
    productocomplejo smallint,
    tienedatostecnicos smallint,
    datostecnicos character varying(1000) COLLATE pg_catalog."default",
    incluirdatostecnicosencomprobantes smallint,
    presentacompprod smallint,
    codaceptcompprod character(17) COLLATE pg_catalog."default",
    fechacompprod date,
    vencecompprod date,
    norevisionlogistica smallint,
    importenogravado2 numeric(12,4),
    unidmedicot smallint,
    codproductocot integer,
    omitirnogravadocompras smallint,
    tienereemplazo smallint,
    notomarimportesnogravados smallint,
    modelcode character(10) COLLATE pg_catalog."default",
    modelgroup character(10) COLLATE pg_catalog."default",
    modeldescription character(30) COLLATE pg_catalog."default",
    articlecode character(14) COLLATE pg_catalog."default",
    sizewin character(8) COLLATE pg_catalog."default",
    productodescription character(30) COLLATE pg_catalog."default",
    gender character(10) COLLATE pg_catalog."default",
    colororiginal character(50) COLLATE pg_catalog."default",
    color1 character(25) COLLATE pg_catalog."default",
    color2 character(25) COLLATE pg_catalog."default",
    color3 character(25) COLLATE pg_catalog."default",
    commercialcolor character(25) COLLATE pg_catalog."default",
    brand character(25) COLLATE pg_catalog."default",
    family character(25) COLLATE pg_catalog."default",
    typewin character(25) COLLATE pg_catalog."default",
    activity character(25) COLLATE pg_catalog."default",
    stage character(30) COLLATE pg_catalog."default",
    lastseasoncatalog character(30) COLLATE pg_catalog."default",
    segmentation character(30) COLLATE pg_catalog."default",
    lastyearcatalog character(30) COLLATE pg_catalog."default",
    esecommerce smallint,
    categoriaml integer,
    codncm character(20) COLLATE pg_catalog."default",
    familiaproducto character(1) COLLATE pg_catalog."default",
    comision numeric(5,2),
    noliquidacomision smallint,
    fallado smallint,
    productooriginal character(14) COLLATE pg_catalog."default",
    nombredf character(70) COLLATE pg_catalog."default",
    proveedordf character(30) COLLATE pg_catalog."default",
    temporadadf character(30) COLLATE pg_catalog."default",
    aniodf character(30) COLLATE pg_catalog."default",
    familiadf character(30) COLLATE pg_catalog."default",
    materialdf character(30) COLLATE pg_catalog."default",
    lineadf character(30) COLLATE pg_catalog."default",
    grupodf character(30) COLLATE pg_catalog."default",
    categoriadf character(30) COLLATE pg_catalog."default",
    clasificaciondf character(30) COLLATE pg_catalog."default",
    tipodf character(30) COLLATE pg_catalog."default",
    curvatallesdf character(30) COLLATE pg_catalog."default",
    exportaradf smallint,
    exportadodf smallint,
    fechaexportaciondf date,
    exportarenexistenciasespeciales smallint DEFAULT 0,
    nograbarvaluacioncontable smallint DEFAULT 0,
    errorgtin smallint,
    publicarweb smallint,
    pedidominimo numeric(7,2),
    unidadesporbulto numeric(7,2),
    exportarpetronas smallint,
    codigopetronas character(20) COLLATE pg_catalog."default",
    insumodigip smallint,
    exportadoabelzu date,
    CONSTRAINT key01_producto PRIMARY KEY (codigo)
)