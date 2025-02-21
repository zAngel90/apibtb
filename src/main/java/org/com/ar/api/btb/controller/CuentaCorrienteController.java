package org.com.ar.api.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.com.ar.api.btb.dto.request.CuentaCorrienteSearchRequest;
import org.com.ar.api.btb.dto.response.CuentaCorrienteResponse;
import org.com.ar.api.btb.service.CuentaCorrienteService;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/btb/cuentas-corrientes")
@Tag(name = "Cuentas Corrientes", description = "API para consultar cuentas corrientes")
public class CuentaCorrienteController {

    private final CuentaCorrienteService service;

    @Autowired
    public CuentaCorrienteController(CuentaCorrienteService service) {
        this.service = service;
    }

    @GetMapping("/search")
    @Operation(summary = "Buscar movimientos", description = "Retorna una lista paginada de movimientos según los criterios de búsqueda")
    public ResponseEntity<PaginadoResponse<CuentaCorrienteResponse>> buscarMovimientos(
            @ParameterObject @ModelAttribute CuentaCorrienteSearchRequest request) {
        return ResponseEntity.ok(service.buscarCuentaCorriente(request));
    }
} 