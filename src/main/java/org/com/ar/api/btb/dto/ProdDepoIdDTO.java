package org.com.ar.api.btb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO for Stock ID")
public class ProdDepoIdDTO {
    
    @Schema(description = "Código del depósito", example = "1")
    private Integer deposito;
    
    @Schema(description = "Código del producto", example = "PRD001")
    private String producto;
} 