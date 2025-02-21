package org.com.ar.api.btb.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.com.ar.api.core.dto.request.PaginadoRequest;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Request para búsqueda de cuenta corriente")
public class CuentaCorrienteSearchRequest extends PaginadoRequest {
    
    @Schema(description = "Número de legajo del cliente", example = "1234")
    private Integer legajoNumero;
    
    @Schema(description = "Fecha desde", example = "2024-01-01")
    private LocalDate fechaDesde;
    
    @Schema(description = "Fecha hasta", example = "2024-12-31")
    private LocalDate fechaHasta;
    
    @Schema(description = "Incluir movimientos cancelados", example = "false")
    private Boolean incluirCancelados;
    
    @Schema(description = "Origen del movimiento", example = "FAC")
    private String origen;
} 