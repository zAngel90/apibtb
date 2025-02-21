package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "DTO for Costo")
public class CostoDTO {
    
    @Schema(description = "Fecha de valuación", example = "2024-02-21")
    private LocalDate fecha;
    
    @Schema(description = "SKU del producto", example = "PRD001")
    private String sku;
    
    @Schema(description = "Costo nacional", example = "1000.00")
    private BigDecimal costoNacional;
    
    @Schema(description = "Costo zona franca", example = "900.00")
    private BigDecimal costoZonaFranca;
} 