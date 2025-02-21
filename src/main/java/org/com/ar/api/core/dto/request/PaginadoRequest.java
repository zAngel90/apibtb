package org.com.ar.api.core.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PaginadoRequest {
    
    @Schema(description = "Número de página (0-based)", example = "0")
    private Integer page = 0;
    
    @Schema(description = "Tamaño de página", example = "10")
    private Integer limit = 10;
    
    public Integer getOffset() {
        return page * limit;
    }
} 