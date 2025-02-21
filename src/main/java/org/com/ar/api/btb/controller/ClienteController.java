package org.com.ar.api.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.com.ar.api.btb.dto.request.ClienteSearchRequest;
import org.com.ar.api.btb.dto.response.ClienteResponse;
import org.com.ar.api.btb.service.ClienteService;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/btb/clientes")
@Tag(name = "Clientes", description = "API para gestionar clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping("/search")
    @Operation(summary = "Buscar clientes", description = "Permite buscar clientes aplicando diferentes filtros")
    public PaginadoResponse<ClienteResponse> buscarClientes(
            @Parameter(description = "Número de legajo del cliente") 
            @RequestParam(required = false) Integer legajoNumero,
            
            @Parameter(description = "Nombre del cliente") 
            @RequestParam(required = false) String nombre,
            
            @Parameter(description = "Apellido del cliente") 
            @RequestParam(required = false) String apellido,
            
            @Parameter(description = "Número de documento del cliente") 
            @RequestParam(required = false) String documento,
            
            @Parameter(description = "Indica si se deben incluir los clientes inactivos") 
            @RequestParam(required = false) Boolean incluirInactivos,
            
            @Parameter(description = "Número de página (0-based)") 
            @RequestParam(defaultValue = "0") Integer page,
            
            @Parameter(description = "Cantidad de registros por página") 
            @RequestParam(defaultValue = "10") Integer limit) {

        ClienteSearchRequest request = new ClienteSearchRequest();
        request.setLegajoNumero(legajoNumero);
        request.setNombre(nombre);
        request.setApellido(apellido);
        request.setDocumento(documento);
        request.setIncluirInactivos(incluirInactivos);
        request.setPage(page);
        request.setLimit(limit);

        return service.buscarClientes(request);
    }
} 