package org.com.ar.api.btb.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cabecomp", schema = "winners")
public class Factura {
    
    @EmbeddedId
    private FacturaId id;
    
    @Column(name = "tipooperacion", length = 2)
    private String tipoOperacion;
    
    @Column(name = "tipomovimiento", length = 4)
    private String tipoMovimiento;
    
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @Column(name = "origen", length = 4)
    private String origen;
    
    @Column(name = "tipocomprobante", length = 2)
    private String tipoFactura;
    
    @Column(name = "letracomprobante", length = 1)
    private String letraFactura;
    
    @Column(name = "sucursalcomprobante")
    private Integer puntoVentaFactura;
    
    @Column(name = "numerocomprobante")
    private Integer numeroFactura;
    
    @Column(name = "legajo")
    private Integer legajoNumero;
    
    @Column(name = "nombre", length = 30)
    private String legajoNombre;
    
    @Column(name = "sublegajo")
    private Integer legajoSucursal;
    
    @Column(name = "domicilio", length = 35)
    private String domicilio;
    
    @Column(name = "localidad", length = 25)
    private String localidad;
    
    @Column(name = "nuevocodpostal", length = 14)
    private String codigoPostal;
    
    @Column(name = "jurisdiccion")
    private Short provinciaNumero;
    
    @Column(name = "pais")
    private Short paisNumero;
    
    @Column(name = "documento")
    private Short documentoTipo;
    
    @Column(name = "cuit", length = 13)
    private String documentoNumero;
    
    @Column(name = "vendedor")
    private Integer vendedorNumero;
    
    @Column(name = "deposito")
    private Integer depositoNumero;
    
    @Column(name = "listaprecios")
    private Short listaPrecioNumero;
    
    @Column(name = "descuento", precision = 5, scale = 2)
    private BigDecimal descuento;
    
    @Column(name = "expreso")
    private Short expresoNumero;
    
    @Column(name = "entrega", length = 60)
    private String domicilioEntrega;
    
    @Column(name = "importe_neto", precision = 15, scale = 2)
    private BigDecimal importeNeto;
    
    @Column(name = "importe_descuentos", precision = 15, scale = 2)
    private BigDecimal importeDescuentos;
    
    @Column(name = "importe_total", precision = 15, scale = 2)
    private BigDecimal importeTotal;
    
    @Column(name = "fechavencimiento")
    private LocalDate vencimiento;
    
    @Column(name = "moneda")
    private Short moneda;
    
    @Column(name = "cotizacion", precision = 10, scale = 4)
    private BigDecimal cotizacion;
    
    @Column(name = "long1")
    private Integer caeFecha;
    
    @Column(name = "string1", length = 20)
    private String caeNumero;
    
    @Column(name = "facturapdf", length = 100)
    private String facturaPdfNombre;
    
    @Column(name = "formapago")
    private Short formaPago;
    
    @Column(name = "sitimpositiva")
    private Short situacionImpositiva;
    
    @Column(name = "anulado")
    private Short anulado = 0;
    
    @Column(name = "cancelado")
    private Short cancelado = 0;
    
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaDetalle> detalles = new ArrayList<>();
} 