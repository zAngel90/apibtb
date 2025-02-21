package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "Respuesta con información de producto")
public class ProductoResponse {
    
    @Schema(description = "SKU del producto", example = "PRD001")
    private String sku;
    
    @Schema(description = "Nombre comercial", example = "Producto de ejemplo")
    private String nombreVenta;
    
    @Schema(description = "Nombre técnico", example = "Especificación técnica del producto")
    private String nombreTecnico;
    
    @Schema(description = "Indica si el producto está inactivo", example = "false")
    private Boolean inactivo;
    
    @Schema(description = "Fecha de alta", example = "2024-02-21")
    private LocalDate fechaAlta;
    
    @Schema(description = "Fecha de baja", example = "2024-02-21")
    private LocalDate fechaBaja;
    
    @Schema(description = "Número de familia", example = "1")
    private Short familiaNumero;
    
    @Schema(description = "Descripción de la familia", example = "Familia de ejemplo")
    private String familiaDescripcion;
    
    @Schema(description = "Número de subfamilia", example = "1")
    private Short subfamiliaNumero;
    
    @Schema(description = "Descripción de la subfamilia", example = "Subfamilia de ejemplo")
    private String subfamiliaDescripcion;
    
    @Schema(description = "Número de marca", example = "1")
    private Short marcaNumero;
    
    @Schema(description = "Descripción de la marca", example = "Marca de ejemplo")
    private String marcaDescripcion;
    
    @Schema(description = "Número de unidad de medida", example = "1")
    private Short unidadMedidaNumero;
    
    @Schema(description = "Descripción de la unidad de medida", example = "Unidad")
    private String unidadMedidaDescripcion;
    
    @Schema(description = "Número de unidad de medida de venta", example = "1")
    private Short unidadMedidaVentaNumero;
    
    @Schema(description = "Descripción de la unidad de medida de venta", example = "Caja")
    private String unidadMedidaVentaDescripcion;
    
    @Schema(description = "Factor de conversión", example = "12.000")
    private BigDecimal factorConversion;
    
    @Schema(description = "Peso neto", example = "1.000")
    private BigDecimal pesoNeto;
    
    @Schema(description = "Peso bruto", example = "1.200")
    private BigDecimal pesoBruto;
    
    @Schema(description = "Volumen", example = "0.001")
    private BigDecimal volumen;
    
    @Schema(description = "Código de barras", example = "7790001000100")
    private String codigoBarras;
    
    @Schema(description = "Código de proveedor", example = "PROV001")
    private String codigoProveedor;
    
    @Schema(description = "Número de proveedor", example = "1")
    private Integer proveedorNumero;
    
    @Schema(description = "Nombre del proveedor", example = "Proveedor de ejemplo")
    private String proveedorNombre;
    
    @Schema(description = "Observaciones", example = "Observaciones del producto")
    private String observaciones;
    
    @Schema(description = "URL de la imagen", example = "https://ejemplo.com/imagen.jpg")
    private String imagen;
    
    @Schema(description = "URL de la ficha técnica", example = "https://ejemplo.com/ficha.pdf")
    private String fichaTecnica;
    
    @Schema(description = "URL de la hoja de seguridad", example = "https://ejemplo.com/seguridad.pdf")
    private String hojaSeguridad;
    
    @Schema(description = "URL de la especificación", example = "https://ejemplo.com/especificacion.pdf")
    private String especificacion;
    
    @Schema(description = "URL del plano", example = "https://ejemplo.com/plano.pdf")
    private String plano;
    
    @Schema(description = "URL de la foto", example = "https://ejemplo.com/foto.jpg")
    private String foto;
    
    @Schema(description = "URL del video", example = "https://ejemplo.com/video.mp4")
    private String video;
    
    @Schema(description = "URL de otros archivos", example = "https://ejemplo.com/otros.zip")
    private String otros;
} 