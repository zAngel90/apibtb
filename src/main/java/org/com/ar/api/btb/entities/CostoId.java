package org.com.ar.api.btb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Embeddable
public class CostoId implements Serializable {
    
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @Column(name = "producto", length = 15)
    private String sku;
} 