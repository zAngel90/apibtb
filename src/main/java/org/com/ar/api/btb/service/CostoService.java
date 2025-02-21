package org.com.ar.api.btb.service;

import org.com.ar.api.btb.dto.response.CostoDTO;
import org.com.ar.api.btb.entities.Costo;
import org.com.ar.api.btb.entities.CostoId;
import org.com.ar.api.btb.mapper.CostoMapper;
import org.com.ar.api.btb.repository.CostoRepository;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CostoService {

    private final CostoRepository costoRepository;
    private final CostoMapper costoMapper;

    @Autowired
    public CostoService(CostoRepository costoRepository, CostoMapper costoMapper) {
        this.costoRepository = costoRepository;
        this.costoMapper = costoMapper;
    }

    @Transactional(readOnly = true)
    public PaginadoResponse<CostoDTO> findAll(Pageable pageable) {
        Page<Costo> page = costoRepository.findAll(pageable);
        return new PaginadoResponse<>(page.map(costoMapper::toDto));
    }

    @Transactional(readOnly = true)
    public PaginadoResponse<CostoDTO> findByFecha(LocalDate fecha, Pageable pageable) {
        Page<Costo> page = costoRepository.findByFecha(fecha, pageable);
        return new PaginadoResponse<>(page.map(costoMapper::toDto));
    }

    @Transactional(readOnly = true)
    public List<CostoDTO> findBySku(String sku) {
        return costoRepository.findBySku(sku).stream()
                .map(costoMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public CostoDTO findLastBySku(String sku) {
        return costoRepository.findFirstBySkuOrderByFechaDesc(sku)
                .map(costoMapper::toDto)
                .orElse(null);
    }

    @Transactional(readOnly = true)
    public PaginadoResponse<CostoDTO> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable) {
        Page<Costo> page = costoRepository.findByFechaBetween(fechaInicio, fechaFin, pageable);
        return new PaginadoResponse<>(page.map(costoMapper::toDto));
    }

    @Transactional
    public CostoDTO save(CostoDTO costoDTO) {
        validateCosto(costoDTO);
        Costo costo = costoMapper.toEntity(costoDTO);
        costo = costoRepository.save(costo);
        return costoMapper.toDto(costo);
    }

    @Transactional
    public void delete(LocalDate fecha, String sku) {
        CostoId id = new CostoId();
        id.setFecha(fecha);
        id.setSku(sku);
        
        if (!costoRepository.existsById(id)) {
            throw new RuntimeException("Costo no encontrado");
        }
        costoRepository.deleteById(id);
    }

    private void validateCosto(CostoDTO costo) {
        if (costo == null) throw new IllegalArgumentException("El costo no puede ser nulo");
        if (costo.getFecha() == null) throw new IllegalArgumentException("La fecha no puede ser nula");
        if (costo.getSku() == null || costo.getSku().trim().isEmpty()) {
            throw new IllegalArgumentException("El SKU no puede ser nulo o vacío");
        }
        if (costo.getCostoNacional() == null) {
            throw new IllegalArgumentException("El costo nacional no puede ser nulo");
        }
        if (costo.getCostoZonaFranca() == null) {
            throw new IllegalArgumentException("El costo zona franca no puede ser nulo");
        }
    }
} 