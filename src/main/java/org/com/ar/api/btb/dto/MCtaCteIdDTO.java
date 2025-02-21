package org.com.ar.api.btb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO para el ID compuesto de movimientos de cuenta corriente")
public class MCtaCteIdDTO {

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
} 