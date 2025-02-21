package org.com.ar.api.btb.entities;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clipro_sucursal")
@IdClass(ClienteSucursalId.class)
public class ClienteSucursal {
    
    @Id
    @Column(name = "clipro")
    private String clipro;
    
    @Id
    @Column(name = "legajo")
    private Short legajo;
    
    @Id
    @Column(name = "codigo")
    private Short codigo;
    
    @Column(name = "nombre")
    private String sucursalNombre;
    
    @Column(name = "inactivo")
    private Short inactivo;
    
    @Column(name = "domicilio")
    private String domicilioCompletoPrincipal;
    
    @Column(name = "localidad")
    private String localidadPrincipal;
    
    @Column(name = "codigo_postal")
    private String codigoPostalPrincipal;
    
    @Column(name = "jurisdiccion")
    private String jurisdiccionPrincipal;
    
    @Column(name = "pais")
    private String paisPrincipal;
    
    @Column(name = "telefono")
    private String telefonoPrincipal;
    
    @Column(name = "email")
    private String emailPrincipal;
    
    @Column(name = "familia_producto")
    private String familiaProducto;
    
    @Column(name = "descuento")
    private BigDecimal descuento;
    
    @Column(name = "id_crm")
    private String idCrm;
}