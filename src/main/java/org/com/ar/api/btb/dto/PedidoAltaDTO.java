package org.com.ar.api.btb.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO for PedidoAlta")
public class PedidoAltaDTO {
    
    @Schema(description = "ID del pedido", example = "1")
    private Long id;

    @Schema(description = "Fecha del pedido", example = "2024-02-21T10:30:00")
    private LocalDateTime fecha;

    @Schema(description = "Número de depósito", example = "1")
    private Integer depositoNumero;

    @Schema(description = "Punto de venta", example = "1")
    private Integer puntoVenta;

    @Schema(description = "Número de legajo del cliente", example = "1001")
    private Integer legajoNumero;

    @Schema(description = "Número de sucursal del cliente", example = "1")
    private Integer legajoSucursalNumero;

    @Schema(description = "SKU del producto", example = "PRD001")
    private String sku;

    @Schema(description = "Cantidad del SKU", example = "10.0000")
    private BigDecimal cantidadSku;

    @Schema(description = "Porcentaje de descuento", example = "5.00")
    private BigDecimal descuentoPorcentaje;

    @Schema(description = "Número de lista de precio", example = "1")
    private Short listaPrecioNumero;

    @Schema(description = "No inmoviliza stock", example = "false")
    private Boolean noInmoviliza;

    @Schema(description = "Precios congelados", example = "false")
    private Boolean preciosCongelados;

    @Schema(description = "Omitir control", example = "false")
    private Boolean omitirControl;

    @Schema(description = "No consolidar", example = "false")
    private Boolean noConsolidar;

    @Schema(description = "Es presupuesto", example = "false")
    private Boolean presupuesto;

    @Schema(description = "Número de pedido en CRM", example = "CRM001")
    private String numeroPedidoCrm;

    @Schema(description = "Fecha de creación", example = "2024-02-21T10:30:00")
    private LocalDateTime createdAt;

    @Schema(description = "Fecha de modificación", example = "2024-02-21T10:30:00")
    private LocalDateTime modifiedAt;

    @Schema(description = "Pedido procesado", example = "false")
    private Boolean procesado;
} 