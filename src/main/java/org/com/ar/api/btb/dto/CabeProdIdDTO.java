package org.com.ar.api.btb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO for Pedido ID")
public class CabeProdIdDTO {
    
    @Schema(description = "Empresa", example = "1")
    private Short empresa;
    
    @Schema(description = "Número de operación", example = "1001")
    private Integer nroOperacion;
    
    @Schema(description = "Número de renglón", example = "1")
    private Short renglon;
} 