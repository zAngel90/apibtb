package org.com.ar.api.btb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO para la vista de sucursal de cliente según la query definitiva")
public class ClienteSucursalDTO {
    
    @Schema(description = "ID CRM", example = "")
    private String idCrm;
    
    @Schema(description = "Número de legajo del cliente", example = "1234")
    private Short legajoNumero;
    
    @Schema(description = "Número de sucursal", example = "1")
    private Short sucursalNumero;
    
    @Schema(description = "Estado de inactividad", example = "false")
    private Boolean inactivo;
    
    @Schema(description = "Nombre de la sucursal", example = "Sucursal Centro")
    private String sucursalNombre;
    
    @Schema(description = "Domicilio completo principal", example = "Av. Corrientes 1234 3°A")
    private String domicilioCompletoPrincipal;
    
    @Schema(description = "Localidad principal", example = "Capital Federal")
    private String localidadPrincipal;
    
    @Schema(description = "Código postal principal", example = "1414")
    private String codigoPostalPrincipal;
    
    @Schema(description = "Código de provincia principal", example = "1")
    private Integer provinciaPrincipal;
    
    @Schema(description = "Descripción de provincia principal", example = "Buenos Aires")
    private String provinciaPrincipalDescripcion;
    
    @Schema(description = "Código de país principal", example = "1")
    private Integer paisPrincipal;
    
    @Schema(description = "Descripción de país principal", example = "Argentina")
    private String paisPrincipalDescripcion;
    
    @Schema(description = "Teléfono principal", example = "011-4444-5555")
    private String telefonoPrincipal;
    
    @Schema(description = "Email principal", example = "sucursal.centro@email.com")
    private String emailPrincipal;
    
    @Schema(description = "Número de situación IVA", example = "1")
    private Short situacionIvaNumero;
    
    @Schema(description = "Descripción de situación IVA", example = "Responsable Inscripto")
    private String situacionIvaDescripcion;
    
    @Schema(description = "Tipo de documento", example = "80")
    private Short documentoTipo;
    
    @Schema(description = "Descripción del tipo de documento", example = "C.U.I.T.")
    private String documentoDescripcion;
    
    @Schema(description = "Número de documento", example = "20-12345678-9")
    private String documentoNumero;
    
    @Schema(description = "Número de forma de pago", example = "1")
    private Short formaPagoNumero;
    
    @Schema(description = "Descripción de forma de pago", example = "Contado")
    private String formaPagoDescripcion;
    
    @Schema(description = "Porcentaje de descuento", example = "10")
    private Short descuento;
    
    @Schema(description = "Domicilio completo del lugar de entrega", example = "Calle Depósito 456 PB")
    private String domicilioCompletoLugarEntrega;
    
    @Schema(description = "Localidad del lugar de entrega", example = "San Justo")
    private String localidadLugarEntrega;
    
    @Schema(description = "Código postal del lugar de entrega", example = "1754")
    private String codigoPostalLugarEntrega;
    
    @Schema(description = "Provincia del lugar de entrega", example = "1")
    private Integer provinciaLugarEntrega;
    
    @Schema(description = "Descripción de provincia del lugar de entrega", example = "Buenos Aires")
    private String provinciaLugarEntregaDescripcion;
    
    @Schema(description = "País del lugar de entrega", example = "1")
    private Integer paisLugarEntrega;
    
    @Schema(description = "Descripción de país del lugar de entrega", example = "Argentina")
    private String paisLugarEntregaDescripcion;
    
    @Schema(description = "Número de expreso", example = "1")
    private Short expresoNumero;
    
    @Schema(description = "Descripción de expreso", example = "Expreso Sur")
    private String expresoDescripcion;
    
    @Schema(description = "Número de vendedor", example = "1234")
    private Integer vendedorNumero;
    
    @Schema(description = "Descripción de vendedor", example = "García, Pedro")
    private String vendedorDescripcion;
    
    @Schema(description = "Familia de producto", example = "C")
    private String familiaProducto;
} 