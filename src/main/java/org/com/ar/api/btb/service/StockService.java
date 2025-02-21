package org.com.ar.api.btb.service;

import org.com.ar.api.btb.dto.request.StockSearchRequest;
import org.com.ar.api.btb.dto.response.StockResponse;
import org.com.ar.api.btb.mapper.StockMapper;
import org.com.ar.api.core.dto.response.PaginadoResponse;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StockService {

    @PersistenceContext
    private EntityManager entityManager;
    
    private final StockMapper mapper;
    
    public PaginadoResponse<StockResponse> buscarStock(StockSearchRequest request) {
        StringBuilder sql = new StringBuilder();
        List<Object> parameters = new ArrayList<>();
        
        // Count query
        StringBuilder countSql = new StringBuilder();
        countSql.append("SELECT COUNT(*) FROM winners.proddepo p ");
        countSql.append("LEFT JOIN winners.deposito d ON p.deposito = d.codigo ");
        countSql.append("LEFT JOIN winners.producto pr ON p.producto = pr.codigo ");
        countSql.append("WHERE 1=1 ");

        // Main query
        sql.append("SELECT p.deposito, d.nombre, p.producto, p.stockactual, p.inmovilizado, ");
        sql.append("p.stockminimo, p.stockmaximo, p.puntopedido, p.stockreservado, ");
        sql.append("pr.descripcion, p.loteserie, p.vencimiento, p.observaciones ");
        sql.append("FROM winners.proddepo p ");
        sql.append("LEFT JOIN winners.deposito d ON p.deposito = d.codigo ");
        sql.append("LEFT JOIN winners.producto pr ON p.producto = pr.codigo ");
        sql.append("WHERE 1=1 ");

        // Add filters
        if (request.getDepositoNumero() != null) {
            sql.append("AND p.deposito = ? ");
            countSql.append("AND p.deposito = ? ");
            parameters.add(request.getDepositoNumero());
        }

        if (request.getProductoSku() != null && !request.getProductoSku().trim().isEmpty()) {
            sql.append("AND p.producto = ? ");
            countSql.append("AND p.producto = ? ");
            parameters.add(request.getProductoSku().trim());
        }

        if (!Boolean.TRUE.equals(request.getIncluirSinStock())) {
            sql.append("AND p.stockactual > 0 ");
            countSql.append("AND p.stockactual > 0 ");
        }

        if (!Boolean.TRUE.equals(request.getIncluirInactivos())) {
            sql.append("AND pr.inactivo = 0 ");
            countSql.append("AND pr.inactivo = 0 ");
        }

        // Execute count query
        Query countQuery = entityManager.createNativeQuery(countSql.toString());
        for (int i = 0; i < parameters.size(); i++) {
            countQuery.setParameter(i + 1, parameters.get(i));
        }
        Long total = ((Number) countQuery.getSingleResult()).longValue();

        // Add pagination
        sql.append("ORDER BY p.deposito, p.producto ");
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
        List<StockResponse> stocks = new ArrayList<>();
        for (Object[] row : results) {
            stocks.add(mapper.toResponse(row));
        }

        PageImpl<StockResponse> page = new PageImpl<>(
            stocks,
            PageRequest.of(request.getPage(), request.getLimit()),
            total
        );

        return new PaginadoResponse<>(page);
    }
} 