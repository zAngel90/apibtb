package org.com.ar.api.btb.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Schema(description = "Respuesta con información de factura")
public class FacturaResponse {
    
    @Schema(description = "Empresa", example = "1")
    private Short empresa;
    
    @Schema(description = "Número de operación", example = "1001")
    private Integer nroOperacion;
    
    @Schema(description = "Tipo de operación", example = "VE")
    private String tipoOperacion;
    
    @Schema(description = "Tipo de movimiento", example = "FACT")
    private String tipoMovimiento;
    
    @Schema(description = "Fecha de factura", example = "2024-02-21")
    private LocalDate fecha;
    
    @Schema(description = "Origen", example = "FACT")
    private String origen;
    
    @Schema(description = "Tipo de factura", example = "A")
    private String tipoFactura;
    
    @Schema(description = "Letra de factura", example = "A")
    private String letraFactura;
    
    @Schema(description = "Punto de venta", example = "1")
    private Integer puntoVentaFactura;
    
    @Schema(description = "Número de factura", example = "12345")
    private Integer numeroFactura;
    
    @Schema(description = "Número de legajo", example = "1234")
    private Integer legajoNumero;
    
    @Schema(description = "Nombre del legajo", example = "Juan Pérez")
    private String legajoNombre;
    
    @Schema(description = "Sucursal del legajo", example = "1")
    private Integer legajoSucursal;
    
    @Schema(description = "Domicilio", example = "Av. Corrientes 1234")
    private String domicilio;
    
    @Schema(description = "Localidad", example = "Ciudad Autónoma de Buenos Aires")
    private String localidad;
    
    @Schema(description = "Código postal", example = "C1043AAZ")
    private String codigoPostal;
    
    @Schema(description = "Número de provincia", example = "1")
    private Short provinciaNumero;
    
    @Schema(description = "Número de país", example = "1")
    private Short paisNumero;
    
    @Schema(description = "Tipo de documento", example = "80")
    private Short documentoTipo;
    
    @Schema(description = "Número de documento", example = "30-12345678-9")
    private String documentoNumero;
    
    @Schema(description = "Número de vendedor", example = "1")
    private Integer vendedorNumero;
    
    @Schema(description = "Número de depósito", example = "1")
    private Integer depositoNumero;
    
    @Schema(description = "Número de lista de precio", example = "1")
    private Short listaPrecioNumero;
    
    @Schema(description = "Porcentaje de descuento", example = "10.00")
    private BigDecimal descuento;
    
    @Schema(description = "Número de expreso", example = "1")
    private Short expresoNumero;
    
    @Schema(description = "Domicilio de entrega", example = "Av. Corrientes 1234")
    private String domicilioEntrega;
    
    @Schema(description = "Importe neto", example = "1000.00")
    private BigDecimal importeNeto;
    
    @Schema(description = "Importe de descuentos", example = "100.00")
    private BigDecimal importeDescuentos;
    
    @Schema(description = "Importe total", example = "900.00")
    private BigDecimal importeTotal;
    
    @Schema(description = "Fecha de vencimiento", example = "2024-03-21")
    private LocalDate vencimiento;
    
    @Schema(description = "Moneda", example = "1")
    private Short moneda;
    
    @Schema(description = "Cotización", example = "1.0000")
    private BigDecimal cotizacion;
    
    @Schema(description = "Fecha de CAE", example = "20240221")
    private Integer caeFecha;
    
    @Schema(description = "Número de CAE", example = "12345678901234")
    private String caeNumero;
    
    @Schema(description = "Nombre del archivo PDF", example = "FA-A-0001-00012345.pdf")
    private String facturaPdfNombre;
    
    @Schema(description = "Forma de pago", example = "1")
    private Short formaPago;
    
    @Schema(description = "Situación impositiva", example = "1")
    private Short situacionImpositiva;
    
    @Schema(description = "Estado de anulación", example = "0")
    private Short anulado;
    
    @Schema(description = "Estado de cancelación", example = "0")
    private Short cancelado;
    
    @Schema(description = "Detalles de la factura")
    private List<FacturaDetalleResponse> detalles;
} 