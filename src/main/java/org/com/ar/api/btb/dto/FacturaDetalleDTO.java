package org.com.ar.api.btb.dto;

import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO for FacturaDetalle")
public class FacturaDetalleDTO {
    
    @Schema(description = "Empresa", example = "1")
    private Short empresa;
    
    @Schema(description = "Número de operación", example = "1001")
    private Integer nroOperacion;
    
    @Schema(description = "Renglón", example = "1")
    private Short renglon;
    
    @Schema(description = "SKU del producto", example = "PRD001")
    private String sku;
    
    @Schema(description = "Nombre del SKU", example = "Producto 1")
    private String skuNombre;
    
    @Schema(description = "Descuento del producto", example = "5.00")
    private BigDecimal descuentoProducto;
    
    @Schema(description = "Cantidad del producto", example = "10.0000")
    private BigDecimal cantidadProducto;
    
    @Schema(description = "Precio unitario del producto", example = "100.0000000")
    private BigDecimal precioUnitarioProducto;
    
    @Schema(description = "Importe sin descuento del producto", example = "1000.00000")
    private BigDecimal importeSinDescuentoProducto;
    
    @Schema(description = "Importe de descuento del producto", example = "50.00000")
    private BigDecimal importeDescuentoProducto;
    
    @Schema(description = "Importe con descuento del producto", example = "950.00000")
    private BigDecimal importeConDescuentoProducto;
    
    @Schema(description = "Descuento/recargo del producto", example = "5.00")
    private BigDecimal descuentoRecargoProducto;
    
    @Schema(description = "Importe neto del producto", example = "950.00000")
    private BigDecimal importeNetoProducto;
    
    @Schema(description = "Importe total del producto", example = "1149.50000")
    private BigDecimal importeTotalProducto;
} 