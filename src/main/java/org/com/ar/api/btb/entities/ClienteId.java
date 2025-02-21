package org.com.ar.api.btb.entities;

import java.io.Serializable;
import lombok.Data;

@Data
public class ClienteId implements Serializable {
    private String clipro;
    private Integer codigo;
    
    public ClienteId() {}
    
    public ClienteId(String clipro, Integer codigo) {
        this.clipro = clipro;
        this.codigo = codigo;
    }
} 