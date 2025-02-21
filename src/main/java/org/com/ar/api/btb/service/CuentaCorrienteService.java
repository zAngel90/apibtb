package org.com.ar.api.btb.service;

import lombok.RequiredArgsConstructor;
import org.com.ar.api.btb.dto.request.CuentaCorrienteSearchRequest;
import org.com.ar.api.btb.dto.response.CuentaCorrienteResponse;
import org.com.ar.api.btb.mapper.CuentaCorrienteMapper;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CuentaCorrienteService {

    @PersistenceContext
    private EntityManager entityManager;

    private final CuentaCorrienteMapper mapper;

    public PaginadoResponse<CuentaCorrienteResponse> buscarCuentaCorriente(CuentaCorrienteSearchRequest request) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT m.empresa, m.nrooperacion, m.sector, ");
        sql.append("m.legajo, c.apellido, c.nombre, ");
        sql.append("m.fecha, m.fechavencimiento, ");
        sql.append("m.descripcion, m.comprobante, ");
        sql.append("m.importe, m.debe, m.cancelado, m.origen ");
        sql.append("FROM winners.mctacte m ");
        sql.append("LEFT JOIN winners.cliente c ON m.legajo = c.legajo ");
        sql.append("WHERE 1=1 ");

        List<Object> parameters = new ArrayList<>();

        if (request.getLegajoNumero() != null) {
            sql.append("AND m.legajo = ? ");
            parameters.add(request.getLegajoNumero());
        }

        if (request.getFechaDesde() != null) {
            sql.append("AND m.fecha >= ? ");
            parameters.add(request.getFechaDesde());
        }

        if (request.getFechaHasta() != null) {
            sql.append("AND m.fecha <= ? ");
            parameters.add(request.getFechaHasta());
        }

        if (!Boolean.TRUE.equals(request.getIncluirCancelados())) {
            sql.append("AND m.cancelado = 0 ");
        }

        if (request.getOrigen() != null) {
            sql.append("AND m.origen = ? ");
            parameters.add(request.getOrigen());
        }

        // Count total results
        String countSql = "SELECT COUNT(*) FROM (" + sql.toString() + ") AS count";
        Query countQuery = entityManager.createNativeQuery(countSql);
        for (int i = 0; i < parameters.size(); i++) {
            countQuery.setParameter(i + 1, parameters.get(i));
        }
        Long total = ((Number) countQuery.getSingleResult()).longValue();

        // Add pagination
        sql.append("ORDER BY m.fecha DESC, m.nrooperacion DESC ");
        sql.append("OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        parameters.add(request.getOffset());
        parameters.add(request.getLimit());

        // Execute main query
        Query query = entityManager.createNativeQuery(sql.toString());
        for (int i = 0; i < parameters.size(); i++) {
            query.setParameter(i + 1, parameters.get(i));
        }

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        List<CuentaCorrienteResponse> movimientos = new ArrayList<>();
        for (Object[] row : results) {
            movimientos.add(mapper.toResponse(row));
        }

        PageImpl<CuentaCorrienteResponse> page = new PageImpl<>(
            movimientos,
            PageRequest.of(request.getPage(), request.getLimit()),
            total
        );

        return new PaginadoResponse<>(page);
    }

    public BigDecimal obtenerSaldoCliente(Integer legajoNumero) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COALESCE(SUM(m.debe), 0) ");
        sql.append("FROM winners.mctacte m ");
        sql.append("WHERE m.legajo = ? AND m.cancelado = 0");

        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, legajoNumero);

        return (BigDecimal) query.getSingleResult();
    }
} 