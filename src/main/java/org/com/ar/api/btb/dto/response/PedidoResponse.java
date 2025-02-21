package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "Respuesta con información de pedido")
public class PedidoResponse {
    
    @Schema(description = "Fecha del pedido", example = "2024-02-21")
    private LocalDate fecha;
    
    @Schema(description = "Número de depósito", example = "1")
    private Integer depositoNumero;
    
    @Schema(description = "Número de legajo", example = "1234")
    private Integer legajoNumero;
    
    @Schema(description = "Nombre del legajo", example = "Juan Pérez")
    private String legajoNombre;
    
    @Schema(description = "Sucursal del legajo", example = "1")
    private Integer legajoSucursal;
    
    @Schema(description = "Código de producto", example = "PRD001")
    private String codigoProducto;
    
    @Schema(description = "Descripción del producto", example = "Producto de ejemplo")
    private String descripcionProducto;
    
    @Schema(description = "Cantidad", example = "10.000")
    private BigDecimal cantidad;
    
    @Schema(description = "Precio unitario", example = "100.00")
    private BigDecimal precioUnitario;
    
    @Schema(description = "Importe total", example = "1000.00")
    private BigDecimal importeTotal;
    
    @Schema(description = "Estado del pedido", example = "P")
    private String estado;
    
    @Schema(description = "Número de lista de precio", example = "1")
    private Short listaPrecioNumero;
    
    @Schema(description = "Observaciones", example = "Pedido urgente")
    private String observaciones;
    
    @Schema(description = "Fecha de entrega", example = "2024-02-22")
    private LocalDate fechaEntrega;
    
    @Schema(description = "Domicilio de entrega", example = "Av. Corrientes 1234")
    private String domicilioEntrega;
    
    @Schema(description = "Número de vendedor", example = "1")
    private Integer vendedorNumero;
} 