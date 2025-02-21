package org.com.ar.api.btb.entities;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cabeprod", schema = "winners")
public class FacturaDetalle {
    
    @EmbeddedId
    private FacturaDetalleId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "empresa", referencedColumnName = "empresa", insertable = false, updatable = false),
        @JoinColumn(name = "nrooperacion", referencedColumnName = "nrooperacion", insertable = false, updatable = false)
    })
    private Factura factura;
    
    @Column(name = "producto", length = 14)
    private String sku;
    
    @Column(name = "nombre", length = 70)
    private String skuNombre;
    
    @Column(name = "descuento", precision = 5, scale = 2)
    private BigDecimal descuentoProducto;
    
    @Column(name = "cantidad", precision = 16, scale = 4)
    private BigDecimal cantidadProducto;
    
    @Column(name = "preciounitario", precision = 19, scale = 7)
    private BigDecimal precioUnitarioProducto;
    
    @Column(name = "importesindescuento", precision = 15, scale = 5)
    private BigDecimal importeSinDescuentoProducto;
    
    @Column(name = "importedescuento", precision = 15, scale = 5)
    private BigDecimal importeDescuentoProducto;
    
    @Column(name = "importecondescuento", precision = 15, scale = 5)
    private BigDecimal importeConDescuentoProducto;
    
    @Column(name = "descuentorecargo", precision = 5, scale = 2)
    private BigDecimal descuentoRecargoProducto;
    
    @Column(name = "importe_neto", precision = 15, scale = 5)
    private BigDecimal importeNetoProducto;
    
    @Column(name = "importe_total", precision = 15, scale = 5)
    private BigDecimal importeTotalProducto;
}