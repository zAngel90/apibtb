package org.com.ar.api.btb.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cabeprod", schema = "winners")
public class CabeProd {
    
    @EmbeddedId
    private CabeProdId id;
    
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @Column(name = "legajo")
    private Integer legajoNumero;
    
    @Column(name = "nombre", length = 30)
    private String legajoNombre;
    
    @Column(name = "sublegajo")
    private Integer legajoSucursal;
    
    @Column(name = "codigo", length = 15)
    private String codigoProducto;
    
    @Column(name = "descripcion", length = 40)
    private String descripcionProducto;
    
    @Column(name = "cantidad", precision = 15, scale = 3)
    private BigDecimal cantidad;
    
    @Column(name = "precio", precision = 15, scale = 2)
    private BigDecimal precioUnitario;
    
    @Column(name = "importe", precision = 15, scale = 2)
    private BigDecimal importeTotal;
    
    @Column(name = "estado", length = 1)
    private String estado;
    
    @Column(name = "deposito")
    private Integer depositoNumero;
    
    @Column(name = "listaprecios")
    private Short listaPrecioNumero;
    
    @Column(name = "observaciones", length = 100)
    private String observaciones;
    
    @Column(name = "fechaentrega")
    private LocalDate fechaEntrega;
    
    @Column(name = "domicilioentrega", length = 60)
    private String domicilioEntrega;
    
    @Column(name = "vendedor")
    private Integer vendedorNumero;
} 