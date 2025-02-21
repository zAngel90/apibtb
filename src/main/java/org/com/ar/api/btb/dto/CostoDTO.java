package org.com.ar.api.btb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "DTO para la vista de costos según la query definitiva")
public class CostoDTO {
    
    @Schema(description = "Fecha de valuación", example = "2024-02-21")
    private LocalDate fecha;
    
    @Schema(description = "SKU del producto", example = "PROD001")
    private String sku;
    
    @Schema(description = "Costo nacional", example = "100.0000")
    private BigDecimal costoNacional;
    
    @Schema(description = "Costo zona franca", example = "95.0000")
    private BigDecimal costoZonaFranca;
} 