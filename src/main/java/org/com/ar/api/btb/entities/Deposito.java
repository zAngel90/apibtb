package org.com.ar.api.btb.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "deposito", schema = "winners")
public class Deposito {
    
    @Id
    @Column(name = "codigo")
    private Integer codigo;
    
    @Column(name = "nombre", length = 30)
    private String nombre;
} 