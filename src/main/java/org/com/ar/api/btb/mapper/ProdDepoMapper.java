package org.com.ar.api.btb.mapper;

import org.com.ar.api.btb.dto.response.ProdDepoDTO;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class ProdDepoMapper {
    
    public ProdDepoDTO toResponse(Object[] row) {
        if (row == null) return null;
        
        ProdDepoDTO response = new ProdDepoDTO();
        int i = 0;
        
        response.setDepositoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setDepositoDescripcion((String) row[i++]);
        response.setSku((String) row[i++]);
        response.setStockActual(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setStockInmovilizado(row[i] != null ? (BigDecimal) row[i] : null); i++;
        
        // Calcular stock disponible
        if (response.getStockActual() != null && response.getStockInmovilizado() != null) {
            response.setStockDisponible(response.getStockActual().subtract(response.getStockInmovilizado()));
        }
        
        return response;
    }
} 