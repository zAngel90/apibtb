package org.com.ar.api.btb.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "legajos", schema = "winners")
@IdClass(ClienteId.class)
public class Cliente {
    
    @Id
    @Column(name = "clipro", length = 2, nullable = false)
    private String clipro = "CL";
    
    @Id
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    
    @Column(name = "apellido", length = 30)
    private String apellido;
    
    @Column(name = "nombre", length = 30)
    private String nombre;
    
    @Column(name = "nombrefantasia", length = 40)
    private String nombreFantasia;
    
    @Column(name = "domicilio", length = 35)
    private String domicilioPrincipal;
    
    @Column(name = "localidad", length = 25)
    private String localidad;
    
    @Column(name = "nuevocodpostal", length = 14)
    private String codigoPostal;
    
    @Column(name = "jurisdiccion")
    private Short jurisdiccion;
    
    @Column(name = "pais")
    private Short pais;
    
    @Column(name = "telefono", length = 30)
    private String telefono;
    
    @Column(name = "celular", length = 30)
    private String celular;
    
    @Column(name = "e_mail", length = 100)
    private String email;
    
    @Column(name = "enviofactmail")
    private Short envioFacturaEmailEstado;
    
    @Column(name = "destinatariofactmail", length = 30)
    private String envioFacturaEmailNombre;
    
    @Column(name = "emailfactmail", length = 100)
    private String envioFacturaEmail;
    
    @Column(name = "tipoiva")
    private Short tipoIva;
    
    @Column(name = "documento")
    private Short documentoTipo;
    
    @Column(name = "cuit", length = 13)
    private String documentoNumero;
    
    @Column(name = "formapago")
    private Short formaPago;
    
    @Column(name = "fechaalta")
    private LocalDate fechaAlta;
    
    @Column(name = "listaprecios")
    private Short listaPrecios;
    
    @Column(name = "descuento", precision = 5, scale = 2)
    private BigDecimal descuento;
    
    @Column(name = "entrega", length = 60)
    private String domicilioEntrega;
    
    @Column(name = "expreso")
    private Short expreso;
    
    @Column(name = "vendedor")
    private Integer vendedor;
    
    @Column(name = "inactivo")
    private Short inactivo;
    
    @Column(name = "legajodeexportacion")
    private Short legajoDeExportacionEstado;
    
    @Column(name = "generapedidosexportacion")
    private Short generaPedidosExportacionEstado;
    
    @Column(name = "omitircontrolexpblock")
    private Short omitirControlExportacionBlockEstado;
    
    @Column(name = "lejanoexpalblock")
    private Short noExportaPedidosBlockEstado;
    
    @Column(name = "detallarpesopedidos")
    private Short detallarPesoPedidosBlockEstado;
    
    @Column(name = "tipobloqueo", length = 20)
    private String bloqueoTipo;
    
    @Column(name = "motivobloqueo", length = 100)
    private String bloqueoMotivo;
}