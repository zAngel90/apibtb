package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(description = "Respuesta con información de sucursal")
public class SucursalResponse {
    
    @Schema(description = "ID del CRM", example = "")
    private String idCrm;
    
    @Schema(description = "Número de legajo", example = "1234")
    private Integer legajoNumero;
    
    @Schema(description = "Número de sucursal", example = "1")
    private Integer sucursalNumero;
    
    @Schema(description = "Indica si la sucursal está inactiva", example = "false")
    private Boolean inactivo;
    
    @Schema(description = "Nombre de la sucursal", example = "Sucursal Centro")
    private String sucursalNombre;
    
    @Schema(description = "Calle del domicilio principal", example = "")
    private String domicilioCallePrincipal;
    
    @Schema(description = "Número del domicilio principal", example = "")
    private String domicilioNumeroPrincipal;
    
    @Schema(description = "Piso del domicilio principal", example = "")
    private String domicilioPisoPrincipal;
    
    @Schema(description = "Departamento del domicilio principal", example = "")
    private String domicilioDptoPrincipal;
    
    @Schema(description = "Domicilio completo principal", example = "Av. Corrientes 1234")
    private String domicilioCompletoPrincipal;
    
    @Schema(description = "Localidad principal", example = "Ciudad Autónoma de Buenos Aires")
    private String localidadPrincipal;
    
    @Schema(description = "Código postal principal", example = "C1043AAZ")
    private String codigoPostalPrincipal;
    
    @Schema(description = "Código de provincia principal", example = "1")
    private Integer provinciaPrincipal;
    
    @Schema(description = "Descripción de provincia principal", example = "Buenos Aires")
    private String provinciaPrincipalDescripcion;
    
    @Schema(description = "Código de país principal", example = "1")
    private Integer paisPrincipal;
    
    @Schema(description = "Descripción de país principal", example = "Argentina")
    private String paisPrincipalDescripcion;
    
    @Schema(description = "Teléfono principal", example = "011-4321-5678")
    private String telefonoPrincipal;
    
    @Schema(description = "Email principal", example = "sucursal.centro@empresa.com.ar")
    private String emailPrincipal;
    
    @Schema(description = "Número de situación IVA", example = "1")
    private Integer situacionIvaNumero;
    
    @Schema(description = "Descripción de situación IVA", example = "Responsable Inscripto")
    private String situacionIvaDescripcion;
    
    @Schema(description = "Tipo de documento", example = "80")
    private Integer documentoTipo;
    
    @Schema(description = "Descripción del tipo de documento", example = "C.U.I.T.")
    private String documentoDescripcion;
    
    @Schema(description = "Número de documento", example = "30-12345678-9")
    private String documentoNumero;
    
    @Schema(description = "Número de forma de pago", example = "1")
    private Integer formaPagoNumero;
    
    @Schema(description = "Descripción de forma de pago", example = "Contado")
    private String formaPagoDescripcion;
    
    @Schema(description = "Porcentaje de descuento", example = "0.00")
    private BigDecimal descuento;
    
    @Schema(description = "Calle del domicilio de entrega", example = "")
    private String domicilioCalleLugarEntrega;
    
    @Schema(description = "Número del domicilio de entrega", example = "")
    private String domicilioNumeroLugarEntrega;
    
    @Schema(description = "Piso del domicilio de entrega", example = "")
    private String domicilioPisoLugarEntrega;
    
    @Schema(description = "Departamento del domicilio de entrega", example = "")
    private String domicilioDptoLugarEntrega;
    
    @Schema(description = "Domicilio completo de entrega", example = "Av. Corrientes 1234")
    private String domicilioCompletoLugarEntrega;
    
    @Schema(description = "Localidad de entrega", example = "Ciudad Autónoma de Buenos Aires")
    private String localidadLugarEntrega;
    
    @Schema(description = "Código postal de entrega", example = "C1043AAZ")
    private String codigoPostalLugarEntrega;
    
    @Schema(description = "Código de provincia de entrega", example = "1")
    private Integer provinciaLugarEntrega;
    
    @Schema(description = "Descripción de provincia de entrega", example = "Buenos Aires")
    private String provinciaLugarEntregaDescripcion;
    
    @Schema(description = "Código de país de entrega", example = "1")
    private Integer paisLugarEntrega;
    
    @Schema(description = "Descripción de país de entrega", example = "Argentina")
    private String paisLugarEntregaDescripcion;
    
    @Schema(description = "Número de expreso", example = "1")
    private Integer expresoNumero;
    
    @Schema(description = "Descripción de expreso", example = "Expreso ABC")
    private String expresoDescripcion;
    
    @Schema(description = "Número de vendedor", example = "1")
    private Integer vendedorNumero;
    
    @Schema(description = "Descripción de vendedor", example = "Juan Pérez")
    private String vendedorDescripcion;
    
    @Schema(description = "Familia de producto", example = "FAM001")
    private String familiaProducto;
} 