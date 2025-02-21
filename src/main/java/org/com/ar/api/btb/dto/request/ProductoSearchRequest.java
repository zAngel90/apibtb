package org.com.ar.api.btb.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Request para buscar productos")
public class ProductoSearchRequest extends PaginadoRequest {

    @Schema(description = "SKU del producto", example = "ABC123")
    private String sku;

    @Schema(description = "Nombre del producto (busca en nombre de venta y nombre técnico)", example = "Tornillo")
    private String nombre;

    @Schema(description = "Incluir productos inactivos", example = "false")
    private Boolean incluirInactivos;
} 