package org.com.ar.api.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.com.ar.api.btb.dto.FacturaDTO;
import org.com.ar.api.btb.dto.FacturaIdDTO;
import org.com.ar.api.btb.dto.response.FacturaResponse;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.com.ar.api.btb.service.FacturaService;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/btb/facturas")
@Tag(name = "Gestión de Facturas", description = "API para gestionar facturas. Permite crear, consultar, actualizar, anular y cancelar facturas. Incluye operaciones para búsqueda por fecha, cliente, comprobante y estado.")
@RequiredArgsConstructor
public class FacturaController {

    private final FacturaService service;

    @GetMapping
    @Operation(
        summary = "Listar Facturas",
        description = "Obtiene un listado paginado de todas las facturas en el sistema. Los resultados se ordenan por fecha de forma descendente."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de facturas encontrada"),
        @ApiResponse(responseCode = "204", description = "No hay facturas")
    })
    public ResponseEntity<PaginadoResponse<FacturaResponse>> findAll(Pageable pageable) {
        PaginadoResponse<FacturaResponse> result = service.findAll(pageable);
        return result.getContent().isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/{empresa}/{nroOperacion}")
    @Operation(
        summary = "Buscar Factura por ID",
        description = "Obtiene una factura específica utilizando el ID compuesto por empresa y número de operación. Incluye todos los detalles de la factura."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Factura encontrada"),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<FacturaResponse> findById(
            @Parameter(description = "Empresa") @PathVariable Short empresa,
            @Parameter(description = "Número de operación") @PathVariable Integer nroOperacion) {
        
        FacturaIdDTO id = new FacturaIdDTO();
        id.setEmpresa(empresa);
        id.setNroOperacion(nroOperacion);
        
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/fecha/{fecha}")
    @Operation(summary = "Obtener facturas por fecha")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de facturas encontrada"),
        @ApiResponse(responseCode = "204", description = "No hay facturas para la fecha especificada")
    })
    public ResponseEntity<PaginadoResponse<FacturaResponse>> findByFecha(
            @Parameter(description = "Fecha (formato: yyyy-MM-dd)") 
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            Pageable pageable) {
        PaginadoResponse<FacturaResponse> result = service.findByFecha(fecha, pageable);
        return result.getContent().isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/cliente/{legajo}")
    @Operation(summary = "Obtener facturas por legajo de cliente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de facturas encontrada"),
        @ApiResponse(responseCode = "204", description = "No hay facturas para el cliente especificado")
    })
    public ResponseEntity<List<FacturaResponse>> findByLegajo(
            @Parameter(description = "Legajo del cliente") @PathVariable Integer legajo) {
        List<FacturaResponse> result = service.findByLegajo(legajo);
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/fecha/{fechaInicio}/{fechaFin}")
    @Operation(summary = "Obtener facturas entre fechas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de facturas encontrada"),
        @ApiResponse(responseCode = "204", description = "No hay facturas para el rango de fechas especificado")
    })
    public ResponseEntity<PaginadoResponse<FacturaResponse>> findBetweenFechas(
            @Parameter(description = "Fecha inicial (formato: yyyy-MM-dd)") 
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @Parameter(description = "Fecha final (formato: yyyy-MM-dd)") 
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Pageable pageable) {
        PaginadoResponse<FacturaResponse> result = service.findBetweenFechas(fechaInicio, fechaFin, pageable);
        return result.getContent().isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/comprobante/{tipo}/{letra}/{sucursal}/{numero}")
    @Operation(summary = "Obtener factura por comprobante")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Factura encontrada"),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<FacturaResponse> findByComprobante(
            @Parameter(description = "Tipo de comprobante") @PathVariable String tipo,
            @Parameter(description = "Letra del comprobante") @PathVariable String letra,
            @Parameter(description = "Sucursal del comprobante") @PathVariable Integer sucursal,
            @Parameter(description = "Número del comprobante") @PathVariable Integer numero) {
        return service.findByComprobante(tipo, letra, sucursal, numero)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/anuladas")
    @Operation(summary = "Obtener facturas anuladas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de facturas anuladas encontrada"),
        @ApiResponse(responseCode = "204", description = "No hay facturas anuladas")
    })
    public ResponseEntity<PaginadoResponse<FacturaResponse>> findAnuladas(Pageable pageable) {
        PaginadoResponse<FacturaResponse> result = service.findAnuladas(pageable);
        return result.getContent().isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/canceladas")
    @Operation(summary = "Obtener facturas canceladas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de facturas canceladas encontrada"),
        @ApiResponse(responseCode = "204", description = "No hay facturas canceladas")
    })
    public ResponseEntity<PaginadoResponse<FacturaResponse>> findCanceladas(Pageable pageable) {
        PaginadoResponse<FacturaResponse> result = service.findCanceladas(pageable);
        return result.getContent().isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/vencidas/{fecha}")
    @Operation(summary = "Obtener facturas vencidas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de facturas vencidas encontrada"),
        @ApiResponse(responseCode = "204", description = "No hay facturas vencidas")
    })
    public ResponseEntity<PaginadoResponse<FacturaResponse>> findVencidas(
            @Parameter(description = "Fecha de corte (formato: yyyy-MM-dd)") 
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            Pageable pageable) {
        PaginadoResponse<FacturaResponse> result = service.findVencidas(fecha, pageable);
        return result.getContent().isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    @GetMapping("/proximas-a-vencer/{fechaInicio}/{fechaFin}")
    @Operation(summary = "Obtener facturas próximas a vencer")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de facturas próximas a vencer encontrada"),
        @ApiResponse(responseCode = "204", description = "No hay facturas próximas a vencer")
    })
    public ResponseEntity<PaginadoResponse<FacturaResponse>> findProximasAVencer(
            @Parameter(description = "Fecha inicial (formato: yyyy-MM-dd)") 
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @Parameter(description = "Fecha final (formato: yyyy-MM-dd)") 
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            Pageable pageable) {
        PaginadoResponse<FacturaResponse> result = service.findProximasAVencer(fechaInicio, fechaFin, pageable);
        return result.getContent().isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

    @PostMapping
    @Operation(
        summary = "Crear Factura",
        description = "Crea una nueva factura en el sistema. Requiere todos los datos obligatorios de la factura incluyendo detalles de productos, cliente y valores."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Factura creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos o incompletos")
    })
    public ResponseEntity<FacturaDTO> create(@Valid @RequestBody FacturaDTO facturaDTO) {
        return ResponseEntity.ok(service.create(facturaDTO));
    }

    @PutMapping("/{empresa}/{nroOperacion}")
    @Operation(
        summary = "Actualizar Factura",
        description = "Actualiza una factura existente. Permite modificar datos de la factura manteniendo el mismo ID (empresa y número de operación)."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Factura actualizada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos o incompletos")
    })
    public ResponseEntity<FacturaDTO> update(
            @Parameter(description = "Empresa") @PathVariable Short empresa,
            @Parameter(description = "Número de operación") @PathVariable Integer nroOperacion,
            @Valid @RequestBody FacturaDTO facturaDTO) {
        
        FacturaIdDTO id = new FacturaIdDTO();
        id.setEmpresa(empresa);
        id.setNroOperacion(nroOperacion);
        
        return ResponseEntity.ok(service.update(id, facturaDTO));
    }

    @DeleteMapping("/{empresa}/{nroOperacion}")
    @Operation(summary = "Eliminar una factura")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Factura eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "Empresa") @PathVariable Short empresa,
            @Parameter(description = "Número de operación") @PathVariable Integer nroOperacion) {
        
        FacturaIdDTO id = new FacturaIdDTO();
        id.setEmpresa(empresa);
        id.setNroOperacion(nroOperacion);
        
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{empresa}/{nroOperacion}/anular")
    @Operation(
        summary = "Anular Factura",
        description = "Anula una factura existente. La factura quedará marcada como anulada y no podrá ser modificada posteriormente."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Factura anulada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<FacturaDTO> anular(
            @Parameter(description = "Empresa") @PathVariable Short empresa,
            @Parameter(description = "Número de operación") @PathVariable Integer nroOperacion) {
        
        FacturaIdDTO id = new FacturaIdDTO();
        id.setEmpresa(empresa);
        id.setNroOperacion(nroOperacion);
        
        return ResponseEntity.ok(service.anular(id));
    }

    @PatchMapping("/{empresa}/{nroOperacion}/cancelar")
    @Operation(
        summary = "Cancelar Factura",
        description = "Cancela una factura existente. La factura quedará marcada como cancelada, indicando que ha sido pagada o saldada."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Factura cancelada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada")
    })
    public ResponseEntity<FacturaDTO> cancelar(
            @Parameter(description = "Empresa") @PathVariable Short empresa,
            @Parameter(description = "Número de operación") @PathVariable Integer nroOperacion) {
        
        FacturaIdDTO id = new FacturaIdDTO();
        id.setEmpresa(empresa);
        id.setNroOperacion(nroOperacion);
        
        return ResponseEntity.ok(service.cancelar(id));
    }
} 