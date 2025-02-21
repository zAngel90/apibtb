package org.com.ar.api.btb.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "ClientResponse", description = "Represents the response  ")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LegajoResponse {

    @Schema(description = "Unique identifier for the legajo", example = "12345")
    private Integer codigo;

    @Schema(description = "Last name of the legajo", example = "Perez")
    private String apellido;

    @Schema(description = "First name of the legajo", example = "Juan")
    private String nombre;

    @Schema(description = "Address of the legajo", example = "123 Fake Street")
    private String domicilio;

    @Schema(description = "City of the legajo", example = "Buenos Aires")
    private String localidad;

    @Schema(description = "Postal code", example = "C1001")
    private String nuevoCodPostal;

    @Schema(description = "Jurisdiction of the legajo", example = "1")
    private Short jurisdiccion;

    @Schema(description = "Country of the legajo", example = "32")
    private Short pais;

    @Schema(description = "Phone number of the legajo", example = "011-1234-5678")
    private String telefono;

    @Schema(description = "Primary email address", example = "juan.perez@example.com")
    private String email;



    @Schema(description = "Taxpayer identification number (CUIT)", example = "20-12345678-9")
    private String cuit;

    @Schema(description = "Tax type", example = "RI")
    private String tipoiva;

    @Schema(description = "Date when the legajo was created", example = "2023-01-01")
    private String fechaAlta;


    @Schema(description = "Discount percentage applied", example = "10.50")
    private Double descuento;

    
    
    @Schema(description = "Branches associated with the legajo")
    private List<LegajoSucResponse> sucursales;
    
}
