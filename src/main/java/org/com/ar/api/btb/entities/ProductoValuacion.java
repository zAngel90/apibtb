package org.com.ar.api.btb.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "prodval", schema = "winners")
public class ProductoValuacion {
    
    @Id
    @Column(name = "producto", length = 14)
    private String sku;
    
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @Column(name = "valuacion", precision = 12, scale = 4)
    private BigDecimal costoNacional;
    
    @Column(name = "valuaciondepfis", precision = 12, scale = 4)
    private BigDecimal costoZonaFranca;
} 