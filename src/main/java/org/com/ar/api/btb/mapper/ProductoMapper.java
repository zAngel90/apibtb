package org.com.ar.api.btb.mapper;

import org.com.ar.api.btb.dto.response.ProductoResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class ProductoMapper {
    
    public ProductoResponse toResponse(Object[] row) {
        if (row == null) return null;
        
        ProductoResponse response = new ProductoResponse();
        int i = 0;
        
        response.setSku((String) row[i++]);
        response.setNombreVenta((String) row[i++]);
        response.setNombreTecnico((String) row[i++]);
        response.setInactivo(row[i] != null ? ((Number) row[i]).intValue() == 1 : false); i++;
        response.setFechaAlta(row[i] != null ? ((java.sql.Date) row[i]).toLocalDate() : null); i++;
        response.setFechaBaja(row[i] != null ? ((java.sql.Date) row[i]).toLocalDate() : null); i++;
        response.setFamiliaNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setFamiliaDescripcion((String) row[i++]);
        response.setSubfamiliaNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setSubfamiliaDescripcion((String) row[i++]);
        response.setMarcaNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setMarcaDescripcion((String) row[i++]);
        response.setUnidadMedidaNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setUnidadMedidaDescripcion((String) row[i++]);
        response.setUnidadMedidaVentaNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setUnidadMedidaVentaDescripcion((String) row[i++]);
        response.setFactorConversion(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setPesoNeto(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setPesoBruto(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setVolumen(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setCodigoBarras((String) row[i++]);
        response.setCodigoProveedor((String) row[i++]);
        response.setProveedorNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setProveedorNombre((String) row[i++]);
        response.setObservaciones((String) row[i++]);
        response.setImagen((String) row[i++]);
        response.setFichaTecnica((String) row[i++]);
        response.setHojaSeguridad((String) row[i++]);
        response.setEspecificacion((String) row[i++]);
        response.setPlano((String) row[i++]);
        response.setFoto((String) row[i++]);
        response.setVideo((String) row[i++]);
        response.setOtros((String) row[i++]);
        
        return response;
    }
} 