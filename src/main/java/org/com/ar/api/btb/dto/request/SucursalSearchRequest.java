package org.com.ar.api.btb.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.com.ar.api.core.dto.request.PaginadoRequest;

@Data
@Schema(description = "Request para búsqueda de sucursales")
public class SucursalSearchRequest extends PaginadoRequest {
    
    @Schema(description = "Número de legajo", example = "1234")
    private Integer legajoNumero;
    
    @Schema(description = "Número de sucursal", example = "1")
    private Integer sucursalNumero;
    
    @Schema(description = "Nombre de la sucursal", example = "Sucursal Centro")
    private String sucursalNombre;
    
    @Schema(description = "Localidad", example = "Ciudad Autónoma de Buenos Aires")
    private String localidad;
    
    @Schema(description = "Código postal", example = "C1043AAZ")
    private String codigoPostal;
    
    @Schema(description = "Provincia", example = "1")
    private Integer provincia;
    
    @Schema(description = "País", example = "1")
    private Integer pais;
    
    @Schema(description = "Número de vendedor", example = "1")
    private Integer vendedorNumero;
    
    @Schema(description = "Incluir inactivos", example = "false")
    private Boolean incluirInactivos;
} 