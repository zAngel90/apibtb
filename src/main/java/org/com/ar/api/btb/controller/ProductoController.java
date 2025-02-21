package org.com.ar.api.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.com.ar.api.btb.dto.request.ProductoSearchRequest;
import org.com.ar.api.btb.dto.response.ProductoResponse;
import org.com.ar.api.btb.service.ProductoService;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/btb/productos")
@Tag(name = "Productos", description = "API para consultar productos")
public class ProductoController {

    private final ProductoService service;

    @Autowired
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar productos", description = "Retorna una lista paginada de productos según los criterios de búsqueda")
    public ResponseEntity<PaginadoResponse<ProductoResponse>> buscarProductos(
            @ParameterObject @ModelAttribute ProductoSearchRequest request) {
        return ResponseEntity.ok(service.buscarProductos(request));
    }
} 