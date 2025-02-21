package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(description = "Respuesta con información de lista de precios")
public class ListaPrecioResponse {
    
    @Schema(description = "Número de lista de precio", example = "1")
    private Short listaPrecioNumero;
    
    @Schema(description = "Descripción de la lista de precio", example = "Lista Mayorista")
    private String listaPrecioDescripcion;
    
    @Schema(description = "SKU del producto", example = "PRD001")
    private String productoSku;
    
    @Schema(description = "Descripción del producto", example = "Producto de ejemplo")
    private String productoDescripcion;
    
    @Schema(description = "Precio", example = "100.00")
    private BigDecimal precio;
    
    @Schema(description = "Moneda", example = "1")
    private Short moneda;
    
    @Schema(description = "Descripción de la moneda", example = "Pesos")
    private String monedaDescripcion;
    
    @Schema(description = "Cotización", example = "1.0000")
    private BigDecimal cotizacion;
} 