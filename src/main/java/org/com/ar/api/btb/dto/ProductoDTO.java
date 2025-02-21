package org.com.ar.api.btb.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO para la vista de producto según la query definitiva")
public class ProductoDTO {
    
    @Schema(description = "ID CRM", example = "")
    private String idCrm;
    
    @Schema(description = "SKU del producto", example = "PROD001")
    private String sku;
    
    @Schema(description = "Nombre de venta del producto", example = "Zapatilla Running")
    private String nombreVenta;
    
    @Schema(description = "Estado de inactividad (0: activo, 1: inactivo)", example = "0")
    private Short inactivo;
    
    @Schema(description = "Fecha de alta del producto", example = "1234567890")
    private Integer fechaAlta;
    
    @Schema(description = "Código de barras del producto", example = "7790001234567")
    private String codigoBarra;
    
    @Schema(description = "Código del proveedor", example = "1234")
    private Integer proveedor;
    
    @Schema(description = "Descripción del proveedor", example = "Proveedor S.A.")
    private String proveedorDescripcion;
    
    @Schema(description = "Código del modelo", example = "MOD001")
    private String modelCode;
    
    @Schema(description = "Grupo del modelo", example = "RUNNING")
    private String modelGroup;
    
    @Schema(description = "Descripción del modelo", example = "Running Performance")
    private String modelDescription;
    
    @Schema(description = "Código del artículo", example = "ART001")
    private String articleCode;
    
    @Schema(description = "Talle del producto", example = "42")
    private String size;
    
    @Schema(description = "Descripción del producto", example = "Zapatilla Running Performance")
    private String productoDescription;
    
    @Schema(description = "Género del producto", example = "M")
    private String gender;
    
    @Schema(description = "Color original", example = "Navy Blue")
    private String colorOriginal;
    
    @Schema(description = "Color 1", example = "Navy")
    private String color1;
    
    @Schema(description = "Color 2", example = "Blue")
    private String color2;
    
    @Schema(description = "Color 3", example = "White")
    private String color3;
    
    @Schema(description = "Color comercial", example = "Azul Marino")
    private String commercialColor;
    
    @Schema(description = "Marca del producto", example = "Nike")
    private String brand;
    
    @Schema(description = "Familia del producto", example = "Calzado")
    private String family;
    
    @Schema(description = "Tipo de producto", example = "Running")
    private String type;
    
    @Schema(description = "Actividad del producto", example = "Running")
    private String activity;
    
    @Schema(description = "Etapa del producto", example = "Current")
    private String stage;
    
    @Schema(description = "Última temporada del catálogo", example = "SS24")
    private String lastSeasonCatalog;
    
    @Schema(description = "Segmentación del producto", example = "Performance")
    private String segmentation;
    
    @Schema(description = "Último año del catálogo", example = "2024")
    private String lastYearCatalog;
    
    @Schema(description = "Familia del producto", example = "C")
    private String familiaProducto;
    
    @Schema(description = "País de origen", example = "1")
    private Short paisOrigen;
} 