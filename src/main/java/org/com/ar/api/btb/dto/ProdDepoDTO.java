package org.com.ar.api.btb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Schema(description = "DTO for Stock")
public class ProdDepoDTO {
    
    @Schema(description = "Código del depósito", example = "1")
    private Integer deposito;
    
    @Schema(description = "Nombre del depósito", example = "Depósito Central")
    private String depositoDescripcion;
    
    @Schema(description = "Código del producto", example = "PRD001")
    private String producto;
    
    @Schema(description = "Stock actual", example = "100.000")
    private BigDecimal stockActual;
    
    @Schema(description = "Stock mínimo", example = "10.000")
    private BigDecimal stockMinimo;
    
    @Schema(description = "Stock máximo", example = "1000.000")
    private BigDecimal stockMaximo;
    
    @Schema(description = "Punto de pedido", example = "50.000")
    private BigDecimal puntoPedido;
    
    @Schema(description = "Stock inmovilizado", example = "5.000")
    private BigDecimal stockInmovilizado;
    
    @Schema(description = "Stock reservado", example = "20.000")
    private BigDecimal stockReservado;
    
    @Schema(description = "Stock disponible", example = "95.000")
    private BigDecimal stockDisponible;
    
    @Schema(description = "Última fecha de movimiento", example = "2024-02-21T10:30:00")
    private LocalDateTime ultimoMovimiento;
    
    @Schema(description = "Ubicación en el depósito", example = "A-01-02")
    private String ubicacion;
    
    @Schema(description = "Observaciones", example = "Stock en buen estado")
    private String observaciones;
} 