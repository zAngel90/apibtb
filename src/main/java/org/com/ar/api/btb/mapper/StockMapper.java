package org.com.ar.api.btb.mapper;

import org.com.ar.api.btb.dto.response.StockResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.sql.Date;

@Component
public class StockMapper {
    
    public StockResponse toResponse(Object[] row) {
        if (row == null) return null;
        
        StockResponse response = new StockResponse();
        int i = 0;
        
        response.setDepositoNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setDepositoDescripcion((String) row[i++]);
        response.setProductoSku((String) row[i++]);
        response.setStockActual(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setStockInmovilizado(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setStockMinimo(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setStockMaximo(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setPuntoPedido(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setStockReservado(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setProductoDescripcion((String) row[i++]);
        response.setLoteSerie((String) row[i++]);
        response.setVencimiento(row[i] != null ? ((Date) row[i]).toLocalDate() : null); i++;
        response.setObservaciones((String) row[i]);
        
        // Calcular stock disponible
        if (response.getStockActual() != null && response.getStockInmovilizado() != null) {
            response.setStockDisponible(response.getStockActual().subtract(response.getStockInmovilizado()));
        }
        
        return response;
    }
} 