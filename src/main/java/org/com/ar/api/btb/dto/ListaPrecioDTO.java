package org.com.ar.api.btb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(description = "DTO para la vista de lista de precios según la query definitiva")
public class ListaPrecioDTO {
    
    @Schema(description = "Código de la lista de precios", example = "1")
    private Short listaPrecio;
    
    @Schema(description = "Nombre/descripción de la lista de precios", example = "Lista Mayorista")
    private String listaPrecioDescripcion;
    
    @Schema(description = "Código del producto", example = "PROD001")
    private String producto;
    
    @Schema(description = "Precio del producto", example = "100.0000")
    private BigDecimal precio;
} 