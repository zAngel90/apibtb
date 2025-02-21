package org.com.ar.api.btb.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
@Table(name = "producto", schema = "winners")
public class Producto {

    @Id
    @Column(name = "codigo", length = 14, nullable = false)
    private String codigo;

    @Column(name = "codigo_1")
    private Integer codigo1;

    @Column(name = "codigo_2")
    private Integer codigo2;

    @Column(name = "codigo_3")
    private Integer codigo3;

    @Column(name = "codigo_4")
    private Integer codigo4;

    @Column(name = "codigo_5")
    private Integer codigo5;

    @Column(name = "nombreventa", length = 70)
    private String nombreVenta;

    @Column(name = "nombrecompra", length = 70)
    private String nombreCompra;

    @Column(name = "codigobarrasventa", length = 14)
    private String codigoBarrasVenta;

    @Column(name = "codigobarrascompra", length = 14)
    private String codigoBarrasCompra;

    @Column(name = "unidadmedidaventa", length = 10)
    private String unidadMedidaVenta;

    @Column(name = "unidadmedidacompra", length = 10)
    private String unidadMedidaCompra;

    @Column(name = "preciocompra", precision = 12, scale = 4)
    private BigDecimal precioCompra;

    @Column(name = "preciobase", precision = 12, scale = 4)
    private BigDecimal precioBase;

    @Column(name = "inactivo")
    private Short inactivo;

    @Column(name = "noventa")
    private Short noVenta;

    @Column(name = "observ1", length = 60)
    private String observ1;

    @Column(name = "observ2", length = 60)
    private String observ2;

    @Column(name = "exportadoalblock")
    private LocalDate exportadoAlBlock;

    @Column(name = "codigogtin", length = 13)
    private String codigoGtin;

    @Column(name = "pagaiva")
    private Short pagaIva;

    @Column(name = "imprimeetiqueta")
    private Short imprimeEtiqueta;

    @Column(name = "publicarweb")
    private Short publicarWeb;

    @Column(name = "pedidominimo", precision = 7, scale = 2)
    private BigDecimal pedidoMinimo;

    @Column(name = "unidadesporbulto", precision = 7, scale = 2)
    private BigDecimal unidadesPorBulto;

    @Column(name = "long1")
    private Integer long1;

    @Column(name = "proveedorunico")
    private Integer proveedorUnico;

    @Column(name = "modelcode", length = 10)
    private String modelCode;

    @Column(name = "modelgroup", length = 10)
    private String modelGroup;

    @Column(name = "modeldescription", length = 30)
    private String modelDescription;

    @Column(name = "articlecode", length = 14)
    private String articleCode;

    @Column(name = "sizewin", length = 8)
    private String sizeWin;

    @Column(name = "productodescription", length = 30)
    private String productoDescription;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "colororiginal", length = 50)
    private String colorOriginal;

    @Column(name = "color1", length = 25)
    private String color1;

    @Column(name = "color2", length = 25)
    private String color2;

    @Column(name = "color3", length = 25)
    private String color3;

    @Column(name = "commercialcolor", length = 25)
    private String commercialColor;

    @Column(name = "brand", length = 25)
    private String brand;

    @Column(name = "family", length = 25)
    private String family;

    @Column(name = "typewin", length = 25)
    private String typeWin;

    @Column(name = "activity", length = 25)
    private String activity;

    @Column(name = "stage", length = 30)
    private String stage;

    @Column(name = "lastseasoncatalog", length = 30)
    private String lastSeasonCatalog;

    @Column(name = "segmentation", length = 30)
    private String segmentation;

    @Column(name = "lastyearcatalog", length = 30)
    private String lastYearCatalog;

    @Column(name = "familiaproducto", length = 1)
    private String familiaProducto;

    @Column(name = "paisorigen")
    private Short paisOrigen;
} 