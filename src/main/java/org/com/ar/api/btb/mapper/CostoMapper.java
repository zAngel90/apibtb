package org.com.ar.api.btb.mapper;

import org.com.ar.api.btb.dto.response.CostoDTO;
import org.com.ar.api.btb.entities.Costo;
import org.springframework.stereotype.Component;

@Component
public class CostoMapper {
    
    public CostoDTO toDto(Costo entity) {
        if (entity == null) return null;
        
        CostoDTO dto = new CostoDTO();
        dto.setFecha(entity.getFecha());
        dto.setSku(entity.getSku());
        dto.setCostoNacional(entity.getCostoNacional());
        dto.setCostoZonaFranca(entity.getCostoZonaFranca());
        
        return dto;
    }
    
    public Costo toEntity(CostoDTO dto) {
        if (dto == null) return null;
        
        Costo entity = new Costo();
        entity.setFecha(dto.getFecha());
        entity.setSku(dto.getSku());
        entity.setCostoNacional(dto.getCostoNacional());
        entity.setCostoZonaFranca(dto.getCostoZonaFranca());
        
        return entity;
    }
} 