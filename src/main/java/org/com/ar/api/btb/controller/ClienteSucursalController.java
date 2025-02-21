package org.com.ar.api.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.com.ar.api.btb.dto.ClienteSucursalDTO;
import org.com.ar.api.btb.service.ClienteSucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/btb/clientes/sucursales")
@Tag(name = "Sucursales de Cliente", description = "API para gestionar las sucursales de clientes")
public class ClienteSucursalController {

    private final ClienteSucursalService sucursalService;

    @Autowired
    public ClienteSucursalController(ClienteSucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("/cliente/{legajo}")
    @Operation(summary = "Obtener todas las sucursales de un cliente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucursales encontradas"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    public ResponseEntity<List<ClienteSucursalDTO>> findByLegajo(
            @Parameter(description = "Número de legajo del cliente") 
            @PathVariable Short legajo) {
        List<ClienteSucursalDTO> sucursales = sucursalService.findByLegajo(legajo);
        return ResponseEntity.ok(sucursales);
    }

    @GetMapping("/{legajo}/{codigo}")
    @Operation(summary = "Obtener una sucursal específica")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucursal encontrada"),
        @ApiResponse(responseCode = "404", description = "Sucursal no encontrada")
    })
    public ResponseEntity<ClienteSucursalDTO> findById(
            @Parameter(description = "Número de legajo del cliente") 
            @PathVariable Short legajo,
            @Parameter(description = "Código de la sucursal") 
            @PathVariable Short codigo) {
        return sucursalService.findById(legajo, codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear una nueva sucursal")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucursal creada"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<ClienteSucursalDTO> create(
            @Parameter(description = "Datos de la sucursal") 
            @RequestBody ClienteSucursalDTO sucursalDTO) {
        try {
            return ResponseEntity.ok(sucursalService.create(sucursalDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{legajo}/{codigo}")
    @Operation(summary = "Actualizar una sucursal existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucursal actualizada"),
        @ApiResponse(responseCode = "404", description = "Sucursal no encontrada"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<ClienteSucursalDTO> update(
            @Parameter(description = "Número de legajo del cliente") 
            @PathVariable Short legajo,
            @Parameter(description = "Código de la sucursal") 
            @PathVariable Short codigo,
            @Parameter(description = "Datos actualizados de la sucursal") 
            @RequestBody ClienteSucursalDTO sucursalDTO) {
        try {
            return ResponseEntity.ok(sucursalService.update(legajo, codigo, sucursalDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{legajo}/{codigo}")
    @Operation(summary = "Eliminar una sucursal")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucursal eliminada"),
        @ApiResponse(responseCode = "404", description = "Sucursal no encontrada")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "Número de legajo del cliente") 
            @PathVariable Short legajo,
            @Parameter(description = "Código de la sucursal") 
            @PathVariable Short codigo) {
        try {
            sucursalService.delete(legajo, codigo);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{legajo}/{codigo}/activar")
    @Operation(summary = "Activar una sucursal")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucursal activada"),
        @ApiResponse(responseCode = "404", description = "Sucursal no encontrada")
    })
    public ResponseEntity<ClienteSucursalDTO> activar(
            @Parameter(description = "Número de legajo del cliente") 
            @PathVariable Short legajo,
            @Parameter(description = "Código de la sucursal") 
            @PathVariable Short codigo) {
        try {
            return ResponseEntity.ok(sucursalService.activar(legajo, codigo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{legajo}/{codigo}/desactivar")
    @Operation(summary = "Desactivar una sucursal")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucursal desactivada"),
        @ApiResponse(responseCode = "404", description = "Sucursal no encontrada")
    })
    public ResponseEntity<ClienteSucursalDTO> desactivar(
            @Parameter(description = "Número de legajo del cliente") 
            @PathVariable Short legajo,
            @Parameter(description = "Código de la sucursal") 
            @PathVariable Short codigo) {
        try {
            return ResponseEntity.ok(sucursalService.desactivar(legajo, codigo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
} 