package org.com.ar.api.btb.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.com.ar.api.core.dto.request.PaginadoRequest;

@Data
@Schema(description = "Request para búsqueda de clientes")
public class ClienteSearchRequest extends PaginadoRequest {

    @Schema(description = "Número de legajo", example = "1234")
    private Integer legajoNumero;

    @Schema(description = "Nombre del cliente", example = "Juan")
    private String nombre;

    @Schema(description = "Apellido del cliente", example = "Pérez")
    private String apellido;

    @Schema(description = "Número de documento", example = "30123456789")
    private String documento;

    @Schema(description = "Incluir clientes inactivos", example = "false")
    private Boolean incluirInactivos;
} 