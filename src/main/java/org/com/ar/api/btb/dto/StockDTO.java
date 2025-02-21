package org.com.ar.api.btb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(description = "DTO para la vista de stock según la query definitiva")
public class StockDTO {
    
    @Schema(description = "Número de depósito", example = "1")
    private Integer depositoNumero;
    
    @Schema(description = "Descripción del depósito", example = "Depósito Central")
    private String depositoDescripcion;
    
    @Schema(description = "SKU del producto", example = "PROD001")
    private String sku;
    
    @Schema(description = "Stock actual", example = "100.0000")
    private BigDecimal stockActual;
    
    @Schema(description = "Stock inmovilizado", example = "10.0000")
    private BigDecimal stockInmovilizado;
    
    @Schema(description = "Stock disponible (stockActual - stockInmovilizado)", example = "90.0000")
    private BigDecimal stockDisponible;
} 