package org.com.ar.api.btb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.com.ar.api.btb.dto.response.SucursalResponse;
import org.com.ar.api.btb.dto.request.SucursalSearchRequest;
import org.com.ar.api.btb.service.SucursalService;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/btb/sucursales")
@Tag(name = "Sucursales", description = "API para gestionar las sucursales de clientes")
public class SucursalBTBController {

    private final SucursalService sucursalService;

    @Autowired
    public SucursalBTBController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping("/search")
    @Operation(
        summary = "Buscar sucursales",
        description = "Retorna una lista paginada de sucursales según los criterios de búsqueda"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Lista de sucursales encontradas",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = SucursalResponse.class),
            examples = {
                @ExampleObject(
                    name = "SucursalesExample",
                    summary = "Ejemplo de respuesta paginada de sucursales",
                    value = """
                            {
                                "content": [
                                    {
                                        "idCrm": "",
                                        "legajoNumero": 1234,
                                        "sucursalNumero": 1,
                                        "inactivo": false,
                                        "sucursalNombre": "Sucursal Centro",
                                        "domicilioCompletoPrincipal": "Av. Corrientes 1234",
                                        "localidadPrincipal": "Ciudad Autónoma de Buenos Aires",
                                        "codigoPostalPrincipal": "C1043AAZ",
                                        "provinciaPrincipal": 1,
                                        "provinciaPrincipalDescripcion": "Buenos Aires",
                                        "paisPrincipal": 1,
                                        "paisPrincipalDescripcion": "Argentina",
                                        "telefonoPrincipal": "011-4321-5678",
                                        "emailPrincipal": "sucursal.centro@empresa.com.ar",
                                        "situacionIvaNumero": 1,
                                        "situacionIvaDescripcion": "Responsable Inscripto",
                                        "documentoTipo": 80,
                                        "documentoDescripcion": "C.U.I.T.",
                                        "documentoNumero": "30-12345678-9",
                                        "formaPagoNumero": 1,
                                        "formaPagoDescripcion": "Contado",
                                        "descuento": 0.00,
                                        "domicilioCompletoLugarEntrega": "Av. Corrientes 1234",
                                        "localidadLugarEntrega": "Ciudad Autónoma de Buenos Aires",
                                        "codigoPostalLugarEntrega": "C1043AAZ",
                                        "provinciaLugarEntrega": 1,
                                        "provinciaLugarEntregaDescripcion": "Buenos Aires",
                                        "paisLugarEntrega": 1,
                                        "paisLugarEntregaDescripcion": "Argentina",
                                        "expresoNumero": 1,
                                        "expresoDescripcion": "Expreso ABC",
                                        "vendedorNumero": 1,
                                        "vendedorDescripcion": "Juan Pérez",
                                        "familiaProducto": "FAM001"
                                    }
                                ],
                                "totalElements": 1,
                                "totalPages": 1,
                                "pageNumber": 0,
                                "pageSize": 10
                            }
                            """
                )
            }
        )
    )
    public ResponseEntity<PaginadoResponse<SucursalResponse>> buscarSucursales(
            @ParameterObject @ModelAttribute SucursalSearchRequest request) {
        return ResponseEntity.ok(sucursalService.buscarSucursales(request));
    }
}