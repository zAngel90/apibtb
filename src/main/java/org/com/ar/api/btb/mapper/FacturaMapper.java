package org.com.ar.api.btb.mapper;

import org.com.ar.api.btb.dto.FacturaDTO;
import org.com.ar.api.btb.dto.response.FacturaResponse;
import org.com.ar.api.btb.dto.response.FacturaDetalleResponse;
import org.com.ar.api.btb.entities.Factura;
import org.com.ar.api.btb.entities.FacturaId;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.sql.Date;

@Component
public class FacturaMapper {
    
    public FacturaResponse toResponse(Object[] row) {
        if (row == null) return null;
        
        FacturaResponse response = new FacturaResponse();
        int i = 0;
        
        response.setEmpresa(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setNroOperacion(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setTipoOperacion((String) row[i++]);
        response.setTipoMovimiento((String) row[i++]);
        response.setFecha(row[i] != null ? ((Date) row[i]).toLocalDate() : null); i++;
        response.setOrigen((String) row[i++]);
        response.setTipoFactura((String) row[i++]);
        response.setLetraFactura((String) row[i++]);
        response.setPuntoVentaFactura(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setNumeroFactura(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setLegajoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setLegajoNombre((String) row[i++]);
        response.setLegajoSucursal(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setDomicilio((String) row[i++]);
        response.setLocalidad((String) row[i++]);
        response.setCodigoPostal((String) row[i++]);
        response.setProvinciaNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setPaisNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setDocumentoTipo(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setDocumentoNumero((String) row[i++]);
        response.setVendedorNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setDepositoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setListaPrecioNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setDescuento(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setExpresoNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setDomicilioEntrega((String) row[i++]);
        response.setImporteNeto(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setImporteDescuentos(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setImporteTotal(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setVencimiento(row[i] != null ? ((Date) row[i]).toLocalDate() : null); i++;
        response.setMoneda(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setCotizacion(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setCaeFecha(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setCaeNumero((String) row[i++]);
        response.setFacturaPdfNombre((String) row[i++]);
        response.setFormaPago(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setSituacionImpositiva(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setAnulado(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setCancelado(row[i] != null ? ((Number) row[i]).shortValue() : null);
        
        return response;
    }
    
    public FacturaDetalleResponse toDetalleResponse(Object[] row) {
        if (row == null) return null;
        
        FacturaDetalleResponse response = new FacturaDetalleResponse();
        int i = 0;
        
        response.setEmpresa(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setNroOperacion(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setRenglon(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        response.setCodigoProducto((String) row[i++]);
        response.setDescripcionProducto((String) row[i++]);
        response.setCantidad(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setPrecioUnitario(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setImporteTotal(row[i] != null ? (BigDecimal) row[i] : null); i++;
        response.setDepositoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
        response.setListaPrecioNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
        
        return response;
    }

    public FacturaDTO toDto(Factura entity) {
        if (entity == null) return null;
        
        FacturaDTO dto = new FacturaDTO();
        dto.setEmpresa(entity.getId().getEmpresa());
        dto.setNroOperacion(entity.getId().getNroOperacion());
        dto.setTipoOperacion(entity.getTipoOperacion());
        dto.setTipoMovimiento(entity.getTipoMovimiento());
        dto.setFecha(entity.getFecha());
        dto.setOrigen(entity.getOrigen());
        dto.setTipoFactura(entity.getTipoFactura());
        dto.setLetraFactura(entity.getLetraFactura());
        dto.setPuntoVentaFactura(entity.getPuntoVentaFactura());
        dto.setNumeroFactura(entity.getNumeroFactura());
        dto.setLegajoNumero(entity.getLegajoNumero());
        dto.setLegajoNombre(entity.getLegajoNombre());
        dto.setLegajoSucursal(entity.getLegajoSucursal());
        dto.setDomicilio(entity.getDomicilio());
        dto.setLocalidad(entity.getLocalidad());
        dto.setCodigoPostal(entity.getCodigoPostal());
        dto.setProvinciaNumero(entity.getProvinciaNumero());
        dto.setPaisNumero(entity.getPaisNumero());
        dto.setDocumentoTipo(entity.getDocumentoTipo());
        dto.setDocumentoNumero(entity.getDocumentoNumero());
        dto.setVendedorNumero(entity.getVendedorNumero());
        dto.setDepositoNumero(entity.getDepositoNumero());
        dto.setListaPrecioNumero(entity.getListaPrecioNumero());
        dto.setDescuento(entity.getDescuento());
        dto.setExpresoNumero(entity.getExpresoNumero());
        dto.setDomicilioEntrega(entity.getDomicilioEntrega());
        dto.setImporteNeto(entity.getImporteNeto());
        dto.setImporteDescuentos(entity.getImporteDescuentos());
        dto.setImporteTotal(entity.getImporteTotal());
        dto.setVencimiento(entity.getVencimiento());
        dto.setMoneda(entity.getMoneda());
        dto.setCotizacion(entity.getCotizacion());
        dto.setCaeFecha(entity.getCaeFecha());
        dto.setCaeNumero(entity.getCaeNumero());
        dto.setFacturaPdfNombre(entity.getFacturaPdfNombre());
        dto.setFormaPago(entity.getFormaPago());
        dto.setSituacionImpositiva(entity.getSituacionImpositiva());
        dto.setAnulado(entity.getAnulado());
        dto.setCancelado(entity.getCancelado());
        
        return dto;
    }

    public Factura toEntity(FacturaDTO dto) {
        if (dto == null) return null;
        
        Factura entity = new Factura();
        
        // Crear y establecer el ID compuesto
        FacturaId id = new FacturaId();
        id.setEmpresa(dto.getEmpresa());
        id.setNroOperacion(dto.getNroOperacion());
        entity.setId(id);
        
        entity.setTipoOperacion(dto.getTipoOperacion());
        entity.setTipoMovimiento(dto.getTipoMovimiento());
        entity.setFecha(dto.getFecha());
        entity.setOrigen(dto.getOrigen());
        entity.setTipoFactura(dto.getTipoFactura());
        entity.setLetraFactura(dto.getLetraFactura());
        entity.setPuntoVentaFactura(dto.getPuntoVentaFactura());
        entity.setNumeroFactura(dto.getNumeroFactura());
        entity.setLegajoNumero(dto.getLegajoNumero());
        entity.setLegajoNombre(dto.getLegajoNombre());
        entity.setLegajoSucursal(dto.getLegajoSucursal());
        entity.setDomicilio(dto.getDomicilio());
        entity.setLocalidad(dto.getLocalidad());
        entity.setCodigoPostal(dto.getCodigoPostal());
        entity.setProvinciaNumero(dto.getProvinciaNumero());
        entity.setPaisNumero(dto.getPaisNumero());
        entity.setDocumentoTipo(dto.getDocumentoTipo());
        entity.setDocumentoNumero(dto.getDocumentoNumero());
        entity.setVendedorNumero(dto.getVendedorNumero());
        entity.setDepositoNumero(dto.getDepositoNumero());
        entity.setListaPrecioNumero(dto.getListaPrecioNumero());
        entity.setDescuento(dto.getDescuento());
        entity.setExpresoNumero(dto.getExpresoNumero());
        entity.setDomicilioEntrega(dto.getDomicilioEntrega());
        entity.setImporteNeto(dto.getImporteNeto());
        entity.setImporteDescuentos(dto.getImporteDescuentos());
        entity.setImporteTotal(dto.getImporteTotal());
        entity.setVencimiento(dto.getVencimiento());
        entity.setMoneda(dto.getMoneda());
        entity.setCotizacion(dto.getCotizacion());
        entity.setCaeFecha(dto.getCaeFecha());
        entity.setCaeNumero(dto.getCaeNumero());
        entity.setFacturaPdfNombre(dto.getFacturaPdfNombre());
        entity.setFormaPago(dto.getFormaPago());
        entity.setSituacionImpositiva(dto.getSituacionImpositiva());
        entity.setAnulado(dto.getAnulado());
        entity.setCancelado(dto.getCancelado());
        
        return entity;
    }
} 