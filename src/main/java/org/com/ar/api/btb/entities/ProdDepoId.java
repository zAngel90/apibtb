package org.com.ar.api.btb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class ProdDepoId implements Serializable {
    
    @Column(name = "deposito")
    private Integer deposito;
    
    @Column(name = "producto", length = 15)
    private String producto;
} 