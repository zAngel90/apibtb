package org.com.ar.api.btb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class CabeProdId implements Serializable {
    
    @Column(name = "empresa")
    private Short empresa;
    
    @Column(name = "nrooperacion")
    private Integer nroOperacion;
    
    @Column(name = "renglon")
    private Short renglon;
} 