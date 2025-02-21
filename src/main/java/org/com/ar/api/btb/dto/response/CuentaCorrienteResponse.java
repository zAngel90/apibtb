package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "Respuesta de movimiento de cuenta corriente")
public class CuentaCorrienteResponse {
    
    @Schema(description = "Empresa", example = "1")
    private Short empresa;
    
    @Schema(description = "Número de operación", example = "123456")
    private Integer nroOperacion;
    
    @Schema(description = "Sector", example = "VTA")
    private String sector;
    
    @Schema(description = "Número de legajo del cliente", example = "1234")
    private Integer legajoNumero;
    
    @Schema(description = "Apellido del cliente", example = "Pérez")
    private String apellido;
    
    @Schema(description = "Nombre del cliente", example = "Juan")
    private String nombre;
    
    @Schema(description = "Fecha del movimiento", example = "2024-01-01")
    private LocalDate fecha;
    
    @Schema(description = "Fecha de vencimiento", example = "2024-02-01")
    private LocalDate vencimiento;
    
    @Schema(description = "Descripción del movimiento", example = "Factura de venta")
    private String descripcion;
    
    @Schema(description = "Comprobante", example = "FAC-A-0001-00000123")
    private String comprobante;
    
    @Schema(description = "Importe total", example = "1000.00")
    private BigDecimal importe;
    
    @Schema(description = "Importe pendiente", example = "500.00")
    private BigDecimal debe;
    
    @Schema(description = "Indica si está cancelado", example = "false")
    private Boolean cancelado;
    
    @Schema(description = "Origen del movimiento", example = "FAC")
    private String origen;
} 