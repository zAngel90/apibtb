package org.com.ar.api.btb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "DTO para movimientos de cuenta corriente")
public class MCtaCteDTO {

    @Schema(description = "Empresa", example = "1")
    private Short empresa;

    @Schema(description = "Número de operación", example = "1001")
    private Integer nroOperacion;

    @Schema(description = "Sector", example = "V")
    private String sector;

    @Schema(description = "Renglón de operación", example = "1")
    private Short renglonOperacion;

    @Schema(description = "Renglón", example = "1")
    private Short renglon;

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

    @Schema(description = "Comprobante", example = "FA-A-0001-00001001")
    private String comprobante;

    @Schema(description = "Importe", example = "1000.00")
    private BigDecimal importe;

    @Schema(description = "Debe", example = "1000.00")
    private BigDecimal debe;

    @Schema(description = "Estado de cancelación (0: no, 1: sí)", example = "0")
    private Short cancelado;

    @Schema(description = "Origen del movimiento", example = "FACT")
    private String origen;
} 