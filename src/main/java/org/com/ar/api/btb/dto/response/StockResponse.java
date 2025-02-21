package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "Response de stock")
public class StockResponse {

    @Schema(description = "Número de depósito", example = "1")
    private Short depositoNumero;

    @Schema(description = "Descripción del depósito", example = "Depósito Central")
    private String depositoDescripcion;

    @Schema(description = "SKU del producto", example = "ABC123")
    private String productoSku;

    @Schema(description = "Descripción del producto", example = "Tornillo hexagonal 1/4")
    private String productoDescripcion;

    @Schema(description = "Stock actual", example = "100.00")
    private BigDecimal stockActual;

    @Schema(description = "Stock inmovilizado", example = "10.00")
    private BigDecimal stockInmovilizado;

    @Schema(description = "Stock reservado", example = "20.00")
    private BigDecimal stockReservado;

    @Schema(description = "Stock disponible", example = "70.00")
    private BigDecimal stockDisponible;

    @Schema(description = "Stock mínimo", example = "50.00")
    private BigDecimal stockMinimo;

    @Schema(description = "Stock máximo", example = "200.00")
    private BigDecimal stockMaximo;

    @Schema(description = "Punto de pedido", example = "75.00")
    private BigDecimal puntoPedido;

    @Schema(description = "Lote/Serie", example = "LOT123")
    private String loteSerie;

    @Schema(description = "Fecha de vencimiento", example = "2024-12-31")
    private LocalDate vencimiento;

    @Schema(description = "Observaciones", example = "Stock en buen estado")
    private String observaciones;
} 