package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "Respuesta con información de cliente")
public class ClienteResponse {
    
    @Schema(description = "ID del CRM", example = "")
    private String idCrm;
    
    @Schema(description = "Número de legajo", example = "1234")
    private Integer legajoNumero;
    
    @Schema(description = "Indica si el cliente está inactivo", example = "false")
    private Boolean inactivo;
    
    @Schema(description = "Apellido del cliente", example = "Pérez")
    private String apellido;
    
    @Schema(description = "Nombre del cliente", example = "Juan")
    private String nombre;
    
    @Schema(description = "Domicilio completo", example = "Av. Corrientes 1234")
    private String domicilioCompletoPrincipal;
    
    @Schema(description = "Localidad", example = "Ciudad Autónoma de Buenos Aires")
    private String localidadPrincipal;
    
    @Schema(description = "Código postal", example = "C1043AAZ")
    private String codigoPostalPrincipal;
    
    @Schema(description = "Número de provincia", example = "1")
    private Integer provinciaPrincipal;
    
    @Schema(description = "Nombre de provincia", example = "Buenos Aires")
    private String provinciaPrincipalDescripcion;
    
    @Schema(description = "Número de país", example = "1")
    private Integer paisPrincipal;
    
    @Schema(description = "Nombre de país", example = "Argentina")
    private String paisPrincipalDescripcion;
    
    @Schema(description = "Teléfono", example = "011-4321-5678")
    private String telefonoPrincipal;
    
    @Schema(description = "Celular", example = "011-15-4321-5678")
    private String celularPrincipal;
    
    @Schema(description = "Email", example = "juan.perez@email.com")
    private String emailPrincipal;
    
    @Schema(description = "Estado de envío de factura por email", example = "true")
    private Boolean envioFacturaEmailEstado;
    
    @Schema(description = "Nombre para envío de factura por email", example = "Juan Pérez")
    private String envioFacturaEmailNombre;
    
    @Schema(description = "Email para envío de factura", example = "facturacion@email.com")
    private String envioFacturaEmail;
    
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
    
    @Schema(description = "Fecha de alta", example = "2024-02-21")
    private LocalDate fechaAlta;
    
    @Schema(description = "Nombre de fantasía", example = "Comercio de Juan")
    private String nombreFantasia;
    
    @Schema(description = "Número de lista de precio", example = "1")
    private Integer listaPrecioNumero;
    
    @Schema(description = "Descripción de lista de precio", example = "Lista Mayorista")
    private String listaPrecioDescripcion;
    
    @Schema(description = "Porcentaje de descuento", example = "10.00")
    private BigDecimal descuento;
    
    @Schema(description = "Domicilio de entrega", example = "Av. Corrientes 1234")
    private String domicilioCompletoLugarEntrega;
    
    @Schema(description = "Número de expreso", example = "1")
    private Integer expresoNumero;
    
    @Schema(description = "Descripción de expreso", example = "Expreso ABC")
    private String expresoDescripcion;
    
    @Schema(description = "Número de vendedor", example = "1")
    private Integer vendedorNumero;
    
    @Schema(description = "Nombre de vendedor", example = "Pedro Gómez")
    private String vendedorDescripcion;
    
    @Schema(description = "Estado de legajo de exportación", example = "true")
    private Boolean legajoDeExportacionEstado;
    
    @Schema(description = "Estado de generación de pedidos de exportación", example = "true")
    private Boolean generaPedidosExportacionEstado;
    
    @Schema(description = "Estado de omisión de control de exportación", example = "false")
    private Boolean omitirControlExportacionBlockEstado;
    
    @Schema(description = "Estado de no exportación de pedidos", example = "false")
    private Boolean noExportaPedidosBlockEstado;
    
    @Schema(description = "Estado de detalle de peso en pedidos", example = "true")
    private Boolean detallarPesoPedidosBlockEstado;
    
    @Schema(description = "Tipo de bloqueo", example = "1")
    private Integer bloqueoTipo;
    
    @Schema(description = "Motivo de bloqueo", example = "Mora")
    private String bloqueoMotivo;
} 