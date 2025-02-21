package org.com.ar.api.btb.entities;

import java.io.Serializable;
import lombok.Data;

@Data
public class ClienteSucursalId implements Serializable {
    private String clipro;
    private Short legajo;
    private Short codigo;
    
    public ClienteSucursalId() {}
    
    public ClienteSucursalId(String clipro, Short legajo, Short codigo) {
        this.clipro = clipro;
        this.legajo = legajo;
        this.codigo = codigo;
    }
} 