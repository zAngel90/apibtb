package org.com.ar.api.btb.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.com.ar.api.core.dto.request.PaginadoRequest;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Request para buscar stock")
public class StockSearchRequest extends PaginadoRequest {

    @Schema(description = "Número de depósito", example = "1")
    private Short depositoNumero;

    @Schema(description = "SKU del producto", example = "ABC123")
    private String productoSku;

    @Schema(description = "Incluir productos sin stock", example = "false")
    private Boolean incluirSinStock;

    @Schema(description = "Incluir productos inactivos", example = "false")
    private Boolean incluirInactivos;
    
    public Integer getOffset() {
        return getPage() * getLimit();
    }
} 