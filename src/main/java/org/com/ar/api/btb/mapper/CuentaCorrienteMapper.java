package org.com.ar.api.btb.mapper;

import org.com.ar.api.btb.dto.response.CuentaCorrienteResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.sql.Date;

@Component
public class CuentaCorrienteMapper {
    
    public CuentaCorrienteResponse toResponse(Object[] row) {
        if (row == null) return null;
        
        CuentaCorrienteResponse response = new CuentaCorrienteResponse();
        int i = 0;
        
        response.setEmpresa(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setNroOperacion(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setSector((String) row[i++]);
        response.setLegajoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setApellido((String) row[i++]);
        response.setNombre((String) row[i++]);
        response.setFecha(row[i] != null ? ((Date) row[i]).toLocalDate() : null); i++;
        response.setVencimiento(row[i] != null ? ((Date) row[i]).toLocalDate() : null); i++;
        response.setDescripcion((String) row[i++]);
        response.setComprobante((String) row[i++]);
        response.setImporte(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setDebe(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setCancelado(row[i] != null ? ((Number) row[i]).shortValue() == 1 : false); i++;
        response.setOrigen((String) row[i]);
        
        return response;
    }
} 