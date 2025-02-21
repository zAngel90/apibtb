package org.com.ar.api.btb.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "prodval", schema = "winners")
public class Costo {
    
    @EmbeddedId
    private CostoId id;
    
    @Column(name = "valuacion", precision = 15, scale = 2)
    private BigDecimal costoNacional;
    
    @Column(name = "valuaciondepfis", precision = 15, scale = 2)
    private BigDecimal costoZonaFranca;
    
    @PostLoad
    @PostPersist
    @PostUpdate
    private void updateFields() {
        if (id != null) {
            this.fecha = id.getFecha();
            this.sku = id.getSku();
        }
    }
    
    @Transient
    private LocalDate fecha;
    
    @Transient
    private String sku;
    
    @PrePersist
    @PreUpdate
    private void updateId() {
        if (id == null) {
            id = new CostoId();
        }
        id.setFecha(this.fecha);
        id.setSku(this.sku);
    }
} 