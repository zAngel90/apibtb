package org.com.ar.api.btb.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Request para buscar pedidos")
public class PedidoSearchRequest extends PaginadoRequest {

    @Schema(description = "Número de legajo del cliente", example = "1234")
    private Integer legajoNumero;

    @Schema(description = "SKU del producto", example = "ABC123")
    private String productoSku;

    @Schema(description = "Número de depósito", example = "1")
    private Short depositoNumero;

    @Schema(description = "Fecha desde", example = "2024-01-01")
    private LocalDate fechaDesde;

    @Schema(description = "Fecha hasta", example = "2024-12-31")
    private LocalDate fechaHasta;

    @Schema(description = "Estado del pedido", example = "1")
    private Short estado;
} 