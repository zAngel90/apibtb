package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(description = "DTO for Stock")
public class ProdDepoDTO {
    
    @Schema(description = "Número de depósito", example = "1")
    private Integer depositoNumero;
    
    @Schema(description = "Descripción del depósito", example = "Depósito Central")
    private String depositoDescripcion;
    
    @Schema(description = "SKU del producto", example = "PRD001")
    private String sku;
    
    @Schema(description = "Stock actual", example = "100.000")
    private BigDecimal stockActual;
    
    @Schema(description = "Stock inmovilizado", example = "5.000")
    private BigDecimal stockInmovilizado;
    
    @Schema(description = "Stock disponible", example = "95.000")
    private BigDecimal stockDisponible;
} 