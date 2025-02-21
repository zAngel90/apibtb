package org.com.ar.api.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.com.ar.api.btb.dto.request.PedidoSearchRequest;
import org.com.ar.api.btb.dto.response.PedidoResponse;
import org.com.ar.api.btb.service.PedidoService;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/btb/pedidos")
@Tag(name = "Pedidos", description = "API para consultar pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @GetMapping("/search")
    @Operation(summary = "Buscar pedidos", description = "Retorna una lista paginada de pedidos según los criterios de búsqueda")
    public ResponseEntity<PaginadoResponse<PedidoResponse>> buscarPedidos(
            @ParameterObject @ModelAttribute PedidoSearchRequest request) {
        return ResponseEntity.ok(service.buscarPedidos(request));
    }
} 