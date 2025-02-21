package org.com.ar.api.btb.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vw_m_ctacte", schema = "winners")
@IdClass(CuentaCorrienteId.class)
public class CuentaCorriente {
    
    @Id
    @Column(name = "empresa")
    private Short empresa;
    
    @Id
    @Column(name = "nrooperacion")
    private Integer nroOperacion;
    
    @Id
    @Column(name = "sector")
    private String sector;
    
    @Id
    @Column(name = "renglonoperacion")
    private Short renglonOperacion;
    
    @Id
    @Column(name = "renglon")
    private Short renglon;
    
    @Column(name = "legajo")
    private Integer legajoNumero;
    
    @Column(name = "apellido", length = 30)
    private String apellido;
    
    @Column(name = "nombre", length = 30)
    private String nombre;
    
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @Column(name = "vencimiento")
    private LocalDate vencimiento;
    
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    @Column(name = "comprobante", length = 20)
    private String comprobante;
    
    @Column(name = "importe", precision = 15, scale = 2)
    private BigDecimal importe;
    
    @Column(name = "debe", precision = 15, scale = 2)
    private BigDecimal debe;
    
    @Column(name = "cancelado")
    private Short cancelado;
    
    @Column(name = "origen", length = 4)
    private String origen;
    
    @Column(name = "clipro", length = 2)
    private String clipro = "CL";
    
    @Column(name = "cuenta")
    private Short cuenta = 55;
} 