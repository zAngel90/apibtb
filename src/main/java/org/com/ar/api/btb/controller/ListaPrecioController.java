package org.com.ar.api.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.com.ar.api.btb.dto.request.ListaPrecioSearchRequest;
import org.com.ar.api.btb.dto.response.ListaPrecioResponse;
import org.com.ar.api.btb.service.ListaPrecioService;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/btb/listas-precios")
@Tag(name = "Listas de Precios", description = "API para consultar listas de precios")
public class ListaPrecioController {

    private final ListaPrecioService service;

    @Autowired
    public ListaPrecioController(ListaPrecioService service) {
        this.service = service;
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar precios", description = "Retorna una lista paginada de precios según los criterios de búsqueda")
    public ResponseEntity<PaginadoResponse<ListaPrecioResponse>> buscarPrecios(
            @ParameterObject @ModelAttribute ListaPrecioSearchRequest request) {
        return ResponseEntity.ok(service.buscarPrecios(request));
    }
} 