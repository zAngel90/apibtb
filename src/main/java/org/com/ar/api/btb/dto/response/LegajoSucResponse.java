package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "SucursalResponse", description = "Represents the branch (sucursal) of a legajo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LegajoSucResponse {

    @Schema(description = "Branch code", example = "1")
    private Short codigo;

    @Schema(description = "Name of the branch", example = "Sucursal Norte")
    private String nombre;

    @Schema(description = "Branch address", example = "123 Fake Street")
    private String domicilio;

    @Schema(description = "City of the branch", example = "Buenos Aires")
    private String localidad;

    @Schema(description = "Postal code of the branch", example = "C1001")
    private String nuevoCodPostal;

    @Schema(description = "Phone number of the branch", example = "011-1234-5678")
    private String telefono;
}
