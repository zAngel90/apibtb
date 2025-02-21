package org.com.ar.api.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.com.ar.api.btb.dto.response.CostoDTO;
import org.com.ar.api.btb.service.CostoService;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/btb/costos")
@Tag(name = "Costos", description = "API para gestionar los costos de productos")
public class CostoController {

    private final CostoService costoService;

    @Autowired
    public CostoController(CostoService costoService) {
        this.costoService = costoService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los costos", description = "Retorna una lista paginada de todos los costos")
    public ResponseEntity<PaginadoResponse<CostoDTO>> findAll(
            @Parameter(description = "Parámetros de paginación") Pageable pageable) {
        return ResponseEntity.ok(costoService.findAll(pageable));
    }

    @GetMapping("/fecha/{fecha}")
    @Operation(summary = "Obtener costos por fecha", description = "Retorna una lista paginada de costos para una fecha específica")
    public ResponseEntity<PaginadoResponse<CostoDTO>> findByFecha(
            @Parameter(description = "Fecha de valuación (YYYY-MM-DD)") 
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @Parameter(description = "Parámetros de paginación") Pageable pageable) {
        return ResponseEntity.ok(costoService.findByFecha(fecha, pageable));
    }

    @GetMapping("/producto/{sku}")
    @Operation(summary = "Obtener costos por SKU", description = "Retorna una lista de costos para un SKU específico")
    public ResponseEntity<List<CostoDTO>> findBySku(
            @Parameter(description = "SKU del producto") @PathVariable String sku) {
        return ResponseEntity.ok(costoService.findBySku(sku));
    }

    @GetMapping("/producto/{sku}/ultimo")
    @Operation(summary = "Obtener último costo por SKU", description = "Retorna el último costo registrado para un SKU específico")
    public ResponseEntity<CostoDTO> findLastBySku(
            @Parameter(description = "SKU del producto") @PathVariable String sku) {
        CostoDTO costo = costoService.findLastBySku(sku);
        return costo != null ? ResponseEntity.ok(costo) : ResponseEntity.notFound().build();
    }

    @GetMapping("/fecha/between")
    @Operation(summary = "Obtener costos entre fechas", description = "Retorna una lista paginada de costos entre dos fechas")
    public ResponseEntity<PaginadoResponse<CostoDTO>> findByFechaBetween(
            @Parameter(description = "Fecha inicial (YYYY-MM-DD)") 
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @Parameter(description = "Fecha final (YYYY-MM-DD)") 
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @Parameter(description = "Parámetros de paginación") Pageable pageable) {
        return ResponseEntity.ok(costoService.findByFechaBetween(fechaInicio, fechaFin, pageable));
    }

    @PostMapping
    @Operation(summary = "Crear costo", description = "Crea un nuevo registro de costo")
    public ResponseEntity<CostoDTO> create(
            @Parameter(description = "Datos del costo") @RequestBody CostoDTO costoDTO) {
        try {
            return ResponseEntity.ok(costoService.save(costoDTO));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{fecha}/{sku}")
    @Operation(summary = "Eliminar costo", description = "Elimina un registro de costo por fecha y SKU")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Fecha de valuación (YYYY-MM-DD)") 
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @Parameter(description = "SKU del producto") @PathVariable String sku) {
        try {
            costoService.delete(fecha, sku);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
} 