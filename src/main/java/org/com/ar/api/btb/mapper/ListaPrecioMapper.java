package org.com.ar.api.btb.mapper;

import org.com.ar.api.btb.dto.response.ListaPrecioResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class ListaPrecioMapper {
    
    public ListaPrecioResponse toResponse(Object[] row) {
        if (row == null) return null;
        
        ListaPrecioResponse response = new ListaPrecioResponse();
        int i = 0;
        
        response.setListaPrecioNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setListaPrecioDescripcion((String) row[i++]);
        response.setProductoSku((String) row[i++]);
        response.setProductoDescripcion((String) row[i++]);
        response.setPrecio(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setMoneda(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setMonedaDescripcion((String) row[i++]);
        response.setCotizacion(row[i] != null ? (BigDecimal) row[i] : null); i++;
        
        return response;
    }
} 