package org.com.ar.api.btb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "DTO para la vista de cliente según la query definitiva")
public class ClienteDTO {
    
    @Schema(description = "ID CRM", example = "")
    private String idCrm;
    
    @Schema(description = "Número de legajo del cliente", example = "1234")
    private Integer legajoNumero;
    
    @Schema(description = "Estado de inactividad (0: activo, 1: inactivo)", example = "0")
    private Short inactivo;
    
    @Schema(description = "Apellido del cliente", example = "Pérez")
    private String apellido;
    
    @Schema(description = "Nombre del cliente", example = "Juan")
    private String nombre;
    
    @Schema(description = "Domicilio completo principal", example = "Av. Rivadavia 1234 4°B")
    private String domicilioCompletoPrincipal;
    
    @Schema(description = "Localidad principal", example = "Capital Federal")
    private String localidadPrincipal;
    
    @Schema(description = "Código postal principal", example = "1406")
    private String codigoPostalPrincipal;
    
    @Schema(description = "Código de provincia principal", example = "1")
    private Short provinciaPrincipal;
    
    @Schema(description = "Descripción de provincia principal", example = "Buenos Aires")
    private String provinciaPrincipalDescripcion;
    
    @Schema(description = "Código de país principal", example = "1")
    private Short paisPrincipal;
    
    @Schema(description = "Descripción de país principal", example = "Argentina")
    private String paisPrincipalDescripcion;
    
    @Schema(description = "Teléfono principal", example = "011-4444-5555")
    private String telefonoPrincipal;
    
    @Schema(description = "Celular principal", example = "11-1234-5678")
    private String celularPrincipal;
    
    @Schema(description = "Email principal", example = "juan.perez@email.com")
    private String emailPrincipal;
    
    @Schema(description = "Estado de envío de factura por email (0: no, 1: sí)", example = "1")
    private Short envioFacturaEmailEstado;
    
    @Schema(description = "Nombre para envío de factura por email", example = "Juan Pérez")
    private String envioFacturaEmailNombre;
    
    @Schema(description = "Email para envío de factura", example = "facturas@email.com")
    private String envioFacturaEmail;
    
    @Schema(description = "Número de situación IVA", example = "1")
    private String situacionIvaNumero;
    
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
    
    @Schema(description = "Fecha de alta", example = "2024-01-01")
    private LocalDate fechaAlta;
    
    @Schema(description = "Nombre de fantasía", example = "Comercio de Juan")
    private String nombreFantasia;
    
    @Schema(description = "Número de lista de precio", example = "1")
    private Short listaPrecioNumero;
    
    @Schema(description = "Descripción de lista de precio", example = "Lista Mayorista")
    private String listaPrecioDescripcion;
    
    @Schema(description = "Porcentaje de descuento", example = "10.00")
    private BigDecimal descuento;
    
    @Schema(description = "Domicilio completo del lugar de entrega", example = "Calle Entrega 789 2°A")
    private String domicilioCompletoLugarEntrega;
    
    @Schema(description = "Número de expreso", example = "1")
    private Short expresoNumero;
    
    @Schema(description = "Descripción de expreso", example = "Expreso Sur")
    private String expresoDescripcion;
    
    @Schema(description = "Número de vendedor", example = "1234")
    private Integer vendedorNumero;
    
    @Schema(description = "Descripción de vendedor", example = "García, Pedro")
    private String vendedorDescripcion;
    
    @Schema(description = "Estado de legajo de exportación (0: no, 1: sí)", example = "0")
    private Short legajoDeExportacionEstado;
    
    @Schema(description = "Estado de generación de pedidos de exportación (0: no, 1: sí)", example = "0")
    private Short generaPedidosExportacionEstado;
    
    @Schema(description = "Estado de omisión de control de exportación block (0: no, 1: sí)", example = "0")
    private Short omitirControlExportacionBlockEstado;
    
    @Schema(description = "Estado de no exportación de pedidos block (0: no, 1: sí)", example = "0")
    private Short noExportaPedidosBlockEstado;
    
    @Schema(description = "Estado de detalle de peso en pedidos block (0: no, 1: sí)", example = "0")
    private Short detallarPesoPedidosBlockEstado;
    
    @Schema(description = "Tipo de bloqueo", example = "MOROSO")
    private String bloqueoTipo;
    
    @Schema(description = "Motivo de bloqueo", example = "Factura vencida")
    private String bloqueoMotivo;
} 