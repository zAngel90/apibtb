package org.com.ar.api.btb.mapper;

import org.com.ar.api.btb.dto.response.ClienteResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.sql.Date;

@Component
public class ClienteMapper {
    
    public ClienteResponse toResponse(Object[] row) {
        if (row == null) return null;
        
        ClienteResponse response = new ClienteResponse();
        int i = 0;
        
        response.setIdCrm((String) row[i++]);
        response.setLegajoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setInactivo(row[i] != null ? ((Number) row[i]).intValue() == 1 : false); i++;
        response.setApellido((String) row[i++]);
        response.setNombre((String) row[i++]);
        response.setDomicilioCompletoPrincipal((String) row[i++]);
        response.setLocalidadPrincipal((String) row[i++]);
        response.setCodigoPostalPrincipal((String) row[i++]);
        response.setProvinciaPrincipal(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setProvinciaPrincipalDescripcion((String) row[i++]);
        response.setPaisPrincipal(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setPaisPrincipalDescripcion((String) row[i++]);
        response.setTelefonoPrincipal((String) row[i++]);
        response.setCelularPrincipal((String) row[i++]);
        response.setEmailPrincipal((String) row[i++]);
        response.setEnvioFacturaEmailEstado(row[i] != null ? ((Number) row[i]).intValue() == 1 : false); i++;
        response.setEnvioFacturaEmailNombre((String) row[i++]);
        response.setEnvioFacturaEmail((String) row[i++]);
        response.setSituacionIvaNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setSituacionIvaDescripcion((String) row[i++]);
        response.setDocumentoTipo(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setDocumentoDescripcion((String) row[i++]);
        response.setDocumentoNumero((String) row[i++]);
        response.setFormaPagoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setFormaPagoDescripcion((String) row[i++]);
        response.setFechaAlta(row[i] != null ? ((Date) row[i]).toLocalDate() : null); i++;
        response.setNombreFantasia((String) row[i++]);
        response.setListaPrecioNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setListaPrecioDescripcion((String) row[i++]);
        response.setDescuento(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setDomicilioCompletoLugarEntrega((String) row[i++]);
        response.setExpresoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setExpresoDescripcion((String) row[i++]);
        response.setVendedorNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setVendedorDescripcion((String) row[i++]);
        response.setLegajoDeExportacionEstado(row[i] != null ? ((Number) row[i]).intValue() == 1 : false); i++;
        response.setGeneraPedidosExportacionEstado(row[i] != null ? ((Number) row[i]).intValue() == 1 : false); i++;
        response.setOmitirControlExportacionBlockEstado(row[i] != null ? ((Number) row[i]).intValue() == 1 : false); i++;
        response.setNoExportaPedidosBlockEstado(row[i] != null ? ((Number) row[i]).intValue() == 1 : false); i++;
        response.setDetallarPesoPedidosBlockEstado(row[i] != null ? ((Number) row[i]).intValue() == 1 : false); i++;
        response.setBloqueoTipo(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setBloqueoMotivo((String) row[i]);
        
        return response;
    }
} 