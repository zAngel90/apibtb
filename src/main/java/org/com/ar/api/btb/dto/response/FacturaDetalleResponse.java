package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(description = "Respuesta con información de detalle de factura")
public class FacturaDetalleResponse {
    
    @Schema(description = "Empresa", example = "1")
    private Short empresa;
    
    @Schema(description = "Número de operación", example = "1001")
    private Integer nroOperacion;
    
    @Schema(description = "Número de renglón", example = "1")
    private Short renglon;
    
    @Schema(description = "Código de producto", example = "PRD001")
    private String codigoProducto;
    
    @Schema(description = "Descripción del producto", example = "Producto de ejemplo")
    private String descripcionProducto;
    
    @Schema(description = "Cantidad", example = "10.000")
    private BigDecimal cantidad;
    
    @Schema(description = "Precio unitario", example = "100.00")
    private BigDecimal precioUnitario;
    
    @Schema(description = "Importe total", example = "1000.00")
    private BigDecimal importeTotal;
    
    @Schema(description = "Número de depósito", example = "1")
    private Integer depositoNumero;
    
    @Schema(description = "Número de lista de precio", example = "1")
    private Short listaPrecioNumero;
} 