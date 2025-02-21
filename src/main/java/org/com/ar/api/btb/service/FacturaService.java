package org.com.ar.api.btb.service;

import lombok.RequiredArgsConstructor;
import org.com.ar.api.btb.dto.FacturaDTO;
import org.com.ar.api.btb.dto.FacturaIdDTO;
import org.com.ar.api.btb.dto.response.FacturaResponse;
import org.com.ar.api.btb.entities.Factura;
import org.com.ar.api.btb.entities.FacturaId;
import org.com.ar.api.btb.mapper.FacturaMapper;
import org.com.ar.api.btb.repository.FacturaRepository;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FacturaService {

    @PersistenceContext
    private EntityManager entityManager;
    
    private final FacturaRepository facturaRepository;
    private final FacturaMapper facturaMapper;
    private final ModelMapper modelMapper;

    public PaginadoResponse<FacturaResponse> findAll(Pageable pageable) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.empresa, f.nrooperacion, f.tipooperacion, f.tipomovimiento, ");
        sql.append("f.fecha, f.origen, f.tipocomprobante, f.letracomprobante, ");
        sql.append("f.sucursalcomprobante, f.numerocomprobante, f.legajo, f.nombre, ");
        sql.append("f.sublegajo, f.domicilio, f.localidad, f.nuevocodpostal, ");
        sql.append("f.jurisdiccion, f.pais, f.documento, f.cuit, f.vendedor, ");
        sql.append("f.deposito, f.listaprecios, f.descuento, f.expreso, f.entrega, ");
        sql.append("f.importe_neto, f.importe_descuentos, f.importe_total, ");
        sql.append("f.fechavencimiento, f.moneda, f.cotizacion, f.long1, f.string1, ");
        sql.append("f.facturapdf, f.formapago, f.sitimpositiva, f.anulado, f.cancelado ");
        sql.append("FROM winners.cabecomp f ");
        sql.append("ORDER BY f.fecha DESC, f.nrooperacion DESC ");
        sql.append("OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

        // Count total results
        String countSql = "SELECT COUNT(*) FROM winners.cabecomp";
        Query countQuery = entityManager.createNativeQuery(countSql);
        Long total = ((Number) countQuery.getSingleResult()).longValue();

        // Execute main query
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, pageable.getOffset());
        query.setParameter(2, pageable.getPageSize());

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        List<FacturaResponse> facturas = new ArrayList<>();
        for (Object[] row : results) {
            facturas.add(facturaMapper.toResponse(row));
        }

        return new PaginadoResponse<>(new PageImpl<>(
            facturas,
            PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()),
            total
        ));
    }

    public Optional<FacturaResponse> findById(FacturaIdDTO idDTO) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.empresa, f.nrooperacion, f.tipooperacion, f.tipomovimiento, ");
        sql.append("f.fecha, f.origen, f.tipocomprobante, f.letracomprobante, ");
        sql.append("f.sucursalcomprobante, f.numerocomprobante, f.legajo, f.nombre, ");
        sql.append("f.sublegajo, f.domicilio, f.localidad, f.nuevocodpostal, ");
        sql.append("f.jurisdiccion, f.pais, f.documento, f.cuit, f.vendedor, ");
        sql.append("f.deposito, f.listaprecios, f.descuento, f.expreso, f.entrega, ");
        sql.append("f.importe_neto, f.importe_descuentos, f.importe_total, ");
        sql.append("f.fechavencimiento, f.moneda, f.cotizacion, f.long1, f.string1, ");
        sql.append("f.facturapdf, f.formapago, f.sitimpositiva, f.anulado, f.cancelado ");
        sql.append("FROM winners.cabecomp f ");
        sql.append("WHERE f.empresa = ? AND f.nrooperacion = ?");

        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, idDTO.getEmpresa());
        query.setParameter(2, idDTO.getNroOperacion());

        try {
            Object[] result = (Object[]) query.getSingleResult();
            return Optional.ofNullable(facturaMapper.toResponse(result));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public PaginadoResponse<FacturaResponse> findByFecha(LocalDate fecha, Pageable pageable) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.empresa, f.nrooperacion, f.tipooperacion, f.tipomovimiento, ");
        sql.append("f.fecha, f.origen, f.tipocomprobante, f.letracomprobante, ");
        sql.append("f.sucursalcomprobante, f.numerocomprobante, f.legajo, f.nombre, ");
        sql.append("f.sublegajo, f.domicilio, f.localidad, f.nuevocodpostal, ");
        sql.append("f.jurisdiccion, f.pais, f.documento, f.cuit, f.vendedor, ");
        sql.append("f.deposito, f.listaprecios, f.descuento, f.expreso, f.entrega, ");
        sql.append("f.importe_neto, f.importe_descuentos, f.importe_total, ");
        sql.append("f.fechavencimiento, f.moneda, f.cotizacion, f.long1, f.string1, ");
        sql.append("f.facturapdf, f.formapago, f.sitimpositiva, f.anulado, f.cancelado ");
        sql.append("FROM winners.cabecomp f ");
        sql.append("WHERE f.fecha = ? ");
        sql.append("ORDER BY f.fecha DESC, f.nrooperacion DESC ");
        sql.append("OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

        // Count total results
        String countSql = "SELECT COUNT(*) FROM winners.cabecomp f WHERE f.fecha = ?";
        Query countQuery = entityManager.createNativeQuery(countSql);
        countQuery.setParameter(1, fecha);
        Long total = ((Number) countQuery.getSingleResult()).longValue();

        // Execute main query
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, fecha);
        query.setParameter(2, pageable.getOffset());
        query.setParameter(3, pageable.getPageSize());

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        List<FacturaResponse> facturas = new ArrayList<>();
        for (Object[] row : results) {
            facturas.add(facturaMapper.toResponse(row));
        }

        return new PaginadoResponse<>(new PageImpl<>(
            facturas,
            PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()),
            total
        ));
    }

    public List<FacturaResponse> findByLegajo(Integer legajo) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.empresa, f.nrooperacion, f.tipooperacion, f.tipomovimiento, ");
        sql.append("f.fecha, f.origen, f.tipocomprobante, f.letracomprobante, ");
        sql.append("f.sucursalcomprobante, f.numerocomprobante, f.legajo, f.nombre, ");
        sql.append("f.sublegajo, f.domicilio, f.localidad, f.nuevocodpostal, ");
        sql.append("f.jurisdiccion, f.pais, f.documento, f.cuit, f.vendedor, ");
        sql.append("f.deposito, f.listaprecios, f.descuento, f.expreso, f.entrega, ");
        sql.append("f.importe_neto, f.importe_descuentos, f.importe_total, ");
        sql.append("f.fechavencimiento, f.moneda, f.cotizacion, f.long1, f.string1, ");
        sql.append("f.facturapdf, f.formapago, f.sitimpositiva, f.anulado, f.cancelado ");
        sql.append("FROM winners.cabecomp f ");
        sql.append("WHERE f.legajo = ? ");
        sql.append("ORDER BY f.fecha DESC, f.nrooperacion DESC");

        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, legajo);

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        List<FacturaResponse> facturas = new ArrayList<>();
        for (Object[] row : results) {
            facturas.add(facturaMapper.toResponse(row));
        }

        return facturas;
    }

    public PaginadoResponse<FacturaResponse> findBetweenFechas(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable) {
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha fin");
        }

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.empresa, f.nrooperacion, f.tipooperacion, f.tipomovimiento, ");
        sql.append("f.fecha, f.origen, f.tipocomprobante, f.letracomprobante, ");
        sql.append("f.sucursalcomprobante, f.numerocomprobante, f.legajo, f.nombre, ");
        sql.append("f.sublegajo, f.domicilio, f.localidad, f.nuevocodpostal, ");
        sql.append("f.jurisdiccion, f.pais, f.documento, f.cuit, f.vendedor, ");
        sql.append("f.deposito, f.listaprecios, f.descuento, f.expreso, f.entrega, ");
        sql.append("f.importe_neto, f.importe_descuentos, f.importe_total, ");
        sql.append("f.fechavencimiento, f.moneda, f.cotizacion, f.long1, f.string1, ");
        sql.append("f.facturapdf, f.formapago, f.sitimpositiva, f.anulado, f.cancelado ");
        sql.append("FROM winners.cabecomp f ");
        sql.append("WHERE f.fecha BETWEEN ? AND ? ");
        sql.append("ORDER BY f.fecha DESC, f.nrooperacion DESC ");
        sql.append("OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

        // Count total results
        String countSql = "SELECT COUNT(*) FROM winners.cabecomp f WHERE f.fecha BETWEEN ? AND ?";
        Query countQuery = entityManager.createNativeQuery(countSql);
        countQuery.setParameter(1, fechaInicio);
        countQuery.setParameter(2, fechaFin);
        Long total = ((Number) countQuery.getSingleResult()).longValue();

        // Execute main query
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, fechaInicio);
        query.setParameter(2, fechaFin);
        query.setParameter(3, pageable.getOffset());
        query.setParameter(4, pageable.getPageSize());

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        List<FacturaResponse> facturas = new ArrayList<>();
        for (Object[] row : results) {
            facturas.add(facturaMapper.toResponse(row));
        }

        return new PaginadoResponse<>(new PageImpl<>(
            facturas,
            PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()),
            total
        ));
    }

    public Optional<FacturaResponse> findByComprobante(String tipo, String letra, Integer sucursal, Integer numero) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.empresa, f.nrooperacion, f.tipooperacion, f.tipomovimiento, ");
        sql.append("f.fecha, f.origen, f.tipocomprobante, f.letracomprobante, ");
        sql.append("f.sucursalcomprobante, f.numerocomprobante, f.legajo, f.nombre, ");
        sql.append("f.sublegajo, f.domicilio, f.localidad, f.nuevocodpostal, ");
        sql.append("f.jurisdiccion, f.pais, f.documento, f.cuit, f.vendedor, ");
        sql.append("f.deposito, f.listaprecios, f.descuento, f.expreso, f.entrega, ");
        sql.append("f.importe_neto, f.importe_descuentos, f.importe_total, ");
        sql.append("f.fechavencimiento, f.moneda, f.cotizacion, f.long1, f.string1, ");
        sql.append("f.facturapdf, f.formapago, f.sitimpositiva, f.anulado, f.cancelado ");
        sql.append("FROM winners.cabecomp f ");
        sql.append("WHERE f.tipocomprobante = ? AND f.letracomprobante = ? ");
        sql.append("AND f.sucursalcomprobante = ? AND f.numerocomprobante = ?");

        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, tipo);
        query.setParameter(2, letra);
        query.setParameter(3, sucursal);
        query.setParameter(4, numero);

        try {
            Object[] result = (Object[]) query.getSingleResult();
            return Optional.ofNullable(facturaMapper.toResponse(result));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public PaginadoResponse<FacturaResponse> findAnuladas(Pageable pageable) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.empresa, f.nrooperacion, f.tipooperacion, f.tipomovimiento, ");
        sql.append("f.fecha, f.origen, f.tipocomprobante, f.letracomprobante, ");
        sql.append("f.sucursalcomprobante, f.numerocomprobante, f.legajo, f.nombre, ");
        sql.append("f.sublegajo, f.domicilio, f.localidad, f.nuevocodpostal, ");
        sql.append("f.jurisdiccion, f.pais, f.documento, f.cuit, f.vendedor, ");
        sql.append("f.deposito, f.listaprecios, f.descuento, f.expreso, f.entrega, ");
        sql.append("f.importe_neto, f.importe_descuentos, f.importe_total, ");
        sql.append("f.fechavencimiento, f.moneda, f.cotizacion, f.long1, f.string1, ");
        sql.append("f.facturapdf, f.formapago, f.sitimpositiva, f.anulado, f.cancelado ");
        sql.append("FROM winners.cabecomp f ");
        sql.append("WHERE f.anulado = 1 ");
        sql.append("ORDER BY f.fecha DESC, f.nrooperacion DESC ");
        sql.append("OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

        // Count total results
        String countSql = "SELECT COUNT(*) FROM winners.cabecomp f WHERE f.anulado = 1";
        Query countQuery = entityManager.createNativeQuery(countSql);
        Long total = ((Number) countQuery.getSingleResult()).longValue();

        // Execute main query
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, pageable.getOffset());
        query.setParameter(2, pageable.getPageSize());

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        List<FacturaResponse> facturas = new ArrayList<>();
        for (Object[] row : results) {
            facturas.add(facturaMapper.toResponse(row));
        }

        return new PaginadoResponse<>(new PageImpl<>(
            facturas,
            PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()),
            total
        ));
    }

    public PaginadoResponse<FacturaResponse> findCanceladas(Pageable pageable) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.empresa, f.nrooperacion, f.tipooperacion, f.tipomovimiento, ");
        sql.append("f.fecha, f.origen, f.tipocomprobante, f.letracomprobante, ");
        sql.append("f.sucursalcomprobante, f.numerocomprobante, f.legajo, f.nombre, ");
        sql.append("f.sublegajo, f.domicilio, f.localidad, f.nuevocodpostal, ");
        sql.append("f.jurisdiccion, f.pais, f.documento, f.cuit, f.vendedor, ");
        sql.append("f.deposito, f.listaprecios, f.descuento, f.expreso, f.entrega, ");
        sql.append("f.importe_neto, f.importe_descuentos, f.importe_total, ");
        sql.append("f.fechavencimiento, f.moneda, f.cotizacion, f.long1, f.string1, ");
        sql.append("f.facturapdf, f.formapago, f.sitimpositiva, f.anulado, f.cancelado ");
        sql.append("FROM winners.cabecomp f ");
        sql.append("WHERE f.cancelado = 1 ");
        sql.append("ORDER BY f.fecha DESC, f.nrooperacion DESC ");
        sql.append("OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

        // Count total results
        String countSql = "SELECT COUNT(*) FROM winners.cabecomp f WHERE f.cancelado = 1";
        Query countQuery = entityManager.createNativeQuery(countSql);
        Long total = ((Number) countQuery.getSingleResult()).longValue();

        // Execute main query
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, pageable.getOffset());
        query.setParameter(2, pageable.getPageSize());

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        List<FacturaResponse> facturas = new ArrayList<>();
        for (Object[] row : results) {
            facturas.add(facturaMapper.toResponse(row));
        }

        return new PaginadoResponse<>(new PageImpl<>(
            facturas,
            PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()),
            total
        ));
    }

    public PaginadoResponse<FacturaResponse> findVencidas(LocalDate fecha, Pageable pageable) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.empresa, f.nrooperacion, f.tipooperacion, f.tipomovimiento, ");
        sql.append("f.fecha, f.origen, f.tipocomprobante, f.letracomprobante, ");
        sql.append("f.sucursalcomprobante, f.numerocomprobante, f.legajo, f.nombre, ");
        sql.append("f.sublegajo, f.domicilio, f.localidad, f.nuevocodpostal, ");
        sql.append("f.jurisdiccion, f.pais, f.documento, f.cuit, f.vendedor, ");
        sql.append("f.deposito, f.listaprecios, f.descuento, f.expreso, f.entrega, ");
        sql.append("f.importe_neto, f.importe_descuentos, f.importe_total, ");
        sql.append("f.fechavencimiento, f.moneda, f.cotizacion, f.long1, f.string1, ");
        sql.append("f.facturapdf, f.formapago, f.sitimpositiva, f.anulado, f.cancelado ");
        sql.append("FROM winners.cabecomp f ");
        sql.append("WHERE f.fechavencimiento < ? AND f.cancelado = 0 ");
        sql.append("ORDER BY f.fecha DESC, f.nrooperacion DESC ");
        sql.append("OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

        // Count total results
        String countSql = "SELECT COUNT(*) FROM winners.cabecomp f WHERE f.fechavencimiento < ? AND f.cancelado = 0";
        Query countQuery = entityManager.createNativeQuery(countSql);
        countQuery.setParameter(1, fecha);
        Long total = ((Number) countQuery.getSingleResult()).longValue();

        // Execute main query
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, fecha);
        query.setParameter(2, pageable.getOffset());
        query.setParameter(3, pageable.getPageSize());

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        List<FacturaResponse> facturas = new ArrayList<>();
        for (Object[] row : results) {
            facturas.add(facturaMapper.toResponse(row));
        }

        return new PaginadoResponse<>(new PageImpl<>(
            facturas,
            PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()),
            total
        ));
    }

    public PaginadoResponse<FacturaResponse> findProximasAVencer(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable) {
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha fin");
        }

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT f.empresa, f.nrooperacion, f.tipooperacion, f.tipomovimiento, ");
        sql.append("f.fecha, f.origen, f.tipocomprobante, f.letracomprobante, ");
        sql.append("f.sucursalcomprobante, f.numerocomprobante, f.legajo, f.nombre, ");
        sql.append("f.sublegajo, f.domicilio, f.localidad, f.nuevocodpostal, ");
        sql.append("f.jurisdiccion, f.pais, f.documento, f.cuit, f.vendedor, ");
        sql.append("f.deposito, f.listaprecios, f.descuento, f.expreso, f.entrega, ");
        sql.append("f.importe_neto, f.importe_descuentos, f.importe_total, ");
        sql.append("f.fechavencimiento, f.moneda, f.cotizacion, f.long1, f.string1, ");
        sql.append("f.facturapdf, f.formapago, f.sitimpositiva, f.anulado, f.cancelado ");
        sql.append("FROM winners.cabecomp f ");
        sql.append("WHERE f.fechavencimiento BETWEEN ? AND ? AND f.cancelado = 0 ");
        sql.append("ORDER BY f.fecha DESC, f.nrooperacion DESC ");
        sql.append("OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

        // Count total results
        String countSql = "SELECT COUNT(*) FROM winners.cabecomp f WHERE f.fechavencimiento BETWEEN ? AND ? AND f.cancelado = 0";
        Query countQuery = entityManager.createNativeQuery(countSql);
        countQuery.setParameter(1, fechaInicio);
        countQuery.setParameter(2, fechaFin);
        Long total = ((Number) countQuery.getSingleResult()).longValue();

        // Execute main query
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, fechaInicio);
        query.setParameter(2, fechaFin);
        query.setParameter(3, pageable.getOffset());
        query.setParameter(4, pageable.getPageSize());

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        List<FacturaResponse> facturas = new ArrayList<>();
        for (Object[] row : results) {
            facturas.add(facturaMapper.toResponse(row));
        }

        return new PaginadoResponse<>(new PageImpl<>(
            facturas,
            PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()),
            total
        ));
    }

    @Transactional
    public FacturaDTO create(FacturaDTO facturaDTO) {
        validateFactura(facturaDTO);
        Factura factura = facturaMapper.toEntity(facturaDTO);
        factura = facturaRepository.save(factura);
        return facturaMapper.toDto(factura);
    }

    @Transactional
    public FacturaDTO update(FacturaIdDTO idDTO, FacturaDTO facturaDTO) {
        validateId(idDTO);
        validateFactura(facturaDTO);
        FacturaId id = modelMapper.map(idDTO, FacturaId.class);
        if (!facturaRepository.existsById(id)) {
            throw new RuntimeException("Factura no encontrada");
        }
        Factura factura = facturaMapper.toEntity(facturaDTO);
        factura = facturaRepository.save(factura);
        return facturaMapper.toDto(factura);
    }

    @Transactional
    public void delete(FacturaIdDTO idDTO) {
        validateId(idDTO);
        FacturaId id = modelMapper.map(idDTO, FacturaId.class);
        if (!facturaRepository.existsById(id)) {
            throw new RuntimeException("Factura no encontrada");
        }
        facturaRepository.deleteById(id);
    }

    @Transactional
    public FacturaDTO anular(FacturaIdDTO idDTO) {
        validateId(idDTO);
        FacturaId id = modelMapper.map(idDTO, FacturaId.class);
        Factura factura = facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        factura.setAnulado((short)1);
        factura = facturaRepository.save(factura);
        return facturaMapper.toDto(factura);
    }

    @Transactional
    public FacturaDTO cancelar(FacturaIdDTO idDTO) {
        validateId(idDTO);
        FacturaId id = modelMapper.map(idDTO, FacturaId.class);
        Factura factura = facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        factura.setCancelado((short)1);
        factura = facturaRepository.save(factura);
        return facturaMapper.toDto(factura);
    }

    // Métodos de validación
    private void validateId(FacturaIdDTO id) {
        if (id == null) throw new IllegalArgumentException("El ID no puede ser nulo");
        if (id.getEmpresa() == null) throw new IllegalArgumentException("La empresa no puede ser nula");
        if (id.getNroOperacion() == null) throw new IllegalArgumentException("El número de operación no puede ser nulo");
    }

    private void validateFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
    }

    private void validateLegajo(Integer legajo) {
        if (legajo == null) throw new IllegalArgumentException("El legajo no puede ser nulo");
        if (legajo <= 0) throw new IllegalArgumentException("El legajo debe ser un número positivo");
    }

    private void validateComprobante(String tipo, String letra, Integer sucursal, Integer numero) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de comprobante no puede ser nulo o vacío");
        }
        if (letra == null || letra.trim().isEmpty()) {
            throw new IllegalArgumentException("La letra del comprobante no puede ser nula o vacía");
        }
        if (sucursal == null || sucursal <= 0) {
            throw new IllegalArgumentException("La sucursal debe ser un número positivo");
        }
        if (numero == null || numero <= 0) {
            throw new IllegalArgumentException("El número de comprobante debe ser un número positivo");
        }
    }

    private void validateFactura(FacturaDTO factura) {
        if (factura == null) throw new IllegalArgumentException("La factura no puede ser nula");
        if (factura.getEmpresa() == null) throw new IllegalArgumentException("La empresa no puede ser nula");
        if (factura.getNroOperacion() == null) throw new IllegalArgumentException("El número de operación no puede ser nulo");
        
        if (factura.getFecha() == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        
        if (factura.getTipoFactura() == null || factura.getTipoFactura().trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de factura no puede ser nulo o vacío");
        }
        
        if (factura.getLetraFactura() == null || factura.getLetraFactura().trim().isEmpty()) {
            throw new IllegalArgumentException("La letra de la factura no puede ser nula o vacía");
        }
        
        if (factura.getPuntoVentaFactura() == null || factura.getPuntoVentaFactura() <= 0) {
            throw new IllegalArgumentException("El punto de venta debe ser un número positivo");
        }
        
        if (factura.getNumeroFactura() == null || factura.getNumeroFactura() <= 0) {
            throw new IllegalArgumentException("El número de factura debe ser un número positivo");
        }
        
        if (factura.getImporteNeto() != null && factura.getImporteNeto().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El importe neto no puede ser negativo");
        }
        
        if (factura.getImporteTotal() != null && factura.getImporteTotal().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El importe total no puede ser negativo");
        }
        
        if (factura.getCotizacion() != null && factura.getCotizacion().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("La cotización debe ser mayor a cero");
        }
    }
} 