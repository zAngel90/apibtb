package org.com.ar.api.btb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class FacturaDetalleId implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "empresa", nullable = false)
    private Short empresa;
    
    @Column(name = "nrooperacion", nullable = false)
    private Integer nroOperacion;
    
    @Column(name = "renglon", nullable = false)
    private Short renglon;
} 