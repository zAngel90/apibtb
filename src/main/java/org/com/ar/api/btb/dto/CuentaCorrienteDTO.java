package org.com.ar.api.btb.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO for CuentaCorriente")
public class CuentaCorrienteDTO {
    
    @Schema(description = "Número de operación", example = "1001")
    private Integer nroOperacion;
    
    @Schema(description = "Empresa", example = "1")
    private Short empresa;
    
    @Schema(description = "Sector", example = "1")
    private Short sector;
    
    @Schema(description = "Número de legajo", example = "1001")
    private Integer legajoNumero;
    
    @Schema(description = "Apellido del cliente", example = "Pérez")
    private String apellido;
    
    @Schema(description = "Nombre del cliente", example = "Juan")
    private String nombre;
    
    @Schema(description = "Fecha de la operación", example = "2024-02-21")
    private LocalDate fecha;
    
    @Schema(description = "Fecha de vencimiento", example = "2024-03-21")
    private LocalDate vencimiento;
    
    @Schema(description = "Descripción", example = "Factura de venta")
    private String descripcion;
    
    @Schema(description = "Número de comprobante", example = "A-0001-00000001")
    private String comprobante;
    
    @Schema(description = "Importe", example = "1000.00")
    private BigDecimal importe;
    
    @Schema(description = "Debe", example = "1000.00")
    private BigDecimal debe;
    
    @Schema(description = "Estado de cancelación", example = "0")
    private Short cancelado;
    
    @Schema(description = "Origen del movimiento", example = "FACT")
    private String origen;
} 