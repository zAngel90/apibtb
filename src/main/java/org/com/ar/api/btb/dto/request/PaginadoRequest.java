package org.com.ar.api.btb.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Request base para peticiones paginadas")
public class PaginadoRequest {

    @Schema(description = "Número de página (0-based)", example = "0")
    private Integer page = 0;

    @Schema(description = "Cantidad de registros por página", example = "10")
    private Integer limit = 10;
} 