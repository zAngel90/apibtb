package org.com.ar.api.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.com.ar.api.btb.dto.request.StockSearchRequest;
import org.com.ar.api.btb.dto.response.StockResponse;
import org.com.ar.api.btb.service.StockService;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/btb/stock")
@Tag(name = "Stock", description = "API para consultar stock de productos")
@RequiredArgsConstructor
public class StockController {

    private final StockService service;

    @GetMapping("/search")
    @Operation(summary = "Buscar stock", description = "Retorna una lista paginada de stock según los criterios de búsqueda")
    public ResponseEntity<PaginadoResponse<StockResponse>> buscarStock(
            @ParameterObject @ModelAttribute StockSearchRequest request) {
        return ResponseEntity.ok(service.buscarStock(request));
    }
} 