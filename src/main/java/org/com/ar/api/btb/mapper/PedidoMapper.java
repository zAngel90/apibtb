package org.com.ar.api.btb.mapper;

import org.com.ar.api.btb.dto.response.PedidoResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class PedidoMapper {
    
    public PedidoResponse toResponse(Object[] row) {
        if (row == null) return null;
        
        PedidoResponse response = new PedidoResponse();
        int i = 0;
        
        response.setFecha(row[i] != null ? ((java.sql.Date) row[i]).toLocalDate() : null); i++;
        response.setDepositoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setLegajoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setLegajoNombre((String) row[i++]);
        response.setLegajoSucursal(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setCodigoProducto((String) row[i++]);
        response.setDescripcionProducto((String) row[i++]);
        response.setCantidad(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setPrecioUnitario(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setImporteTotal(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setEstado((String) row[i++]);
        response.setListaPrecioNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setObservaciones((String) row[i++]);
        response.setFechaEntrega(row[i] != null ? ((java.sql.Date) row[i]).toLocalDate() : null); i++;
        response.setDomicilioEntrega((String) row[i++]);
        response.setVendedorNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        
        return response;
    }
} 