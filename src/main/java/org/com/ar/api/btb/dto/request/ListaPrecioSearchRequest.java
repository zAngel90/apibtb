package org.com.ar.api.btb.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.com.ar.api.core.dto.request.PaginadoRequest;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Request para búsqueda de listas de precios")
public class ListaPrecioSearchRequest extends PaginadoRequest {

    @Schema(description = "Número de lista de precio", example = "1")
    private Short listaPrecioNumero;

    @Schema(description = "SKU del producto", example = "ABC123")
    private String productoSku;

    @Schema(description = "Código de moneda", example = "1")
    private Short moneda;
} 