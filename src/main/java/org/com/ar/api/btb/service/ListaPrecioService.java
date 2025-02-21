package org.com.ar.api.btb.service;

import org.com.ar.api.btb.dto.request.ListaPrecioSearchRequest;
import org.com.ar.api.btb.dto.response.ListaPrecioResponse;
import org.com.ar.api.btb.mapper.ListaPrecioMapper;
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
public class ListaPrecioService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    private final ListaPrecioMapper mapper;
    
    public PaginadoResponse<ListaPrecioResponse> buscarPrecios(ListaPrecioSearchRequest request) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  l.lista as listaPrecioNumero, ");
        sql.append("  l.nombre as listaPrecioDescripcion, ");
        sql.append("  l.producto as productoSku, ");
        sql.append("  p.nombreventa as productoDescripcion, ");
        sql.append("  l.precio as precio, ");
        sql.append("  l.moneda as moneda, ");
        sql.append("  m.nombre as monedaDescripcion, ");
        sql.append("  l.cotizacion as cotizacion ");
        sql.append("FROM winners.liprcabe l ");
        sql.append("LEFT JOIN winners.producto p ON p.codigo = l.producto ");
        sql.append("LEFT JOIN winners.moneda m ON m.codigo = l.moneda ");
        sql.append("WHERE 1=1 ");
        
        List<Object> params = new ArrayList<>();
        int paramIndex = 1;
        
        if (request.getListaPrecioNumero() != null) {
            sql.append("AND l.lista = ? ");
            params.add(request.getListaPrecioNumero());
            paramIndex++;
        }
        
        if (request.getProductoSku() != null && !request.getProductoSku().trim().isEmpty()) {
            sql.append("AND l.producto = ? ");
            params.add(request.getProductoSku());
            paramIndex++;
        }
        
        if (request.getMoneda() != null) {
            sql.append("AND l.moneda = ? ");
            params.add(request.getMoneda());
            paramIndex++;
        }
        
        // Query para contar el total
        String countSql = "SELECT COUNT(*) FROM (" + sql.toString() + ") as count";
        Query countQuery = entityManager.createNativeQuery(countSql);
        
        // Setear parámetros para la query de conteo
        for (int i = 0; i < params.size(); i++) {
            countQuery.setParameter(i + 1, params.get(i));
        }
        
        Long total = ((Number) countQuery.getSingleResult()).longValue();
        
        // Agregar paginación
        sql.append("ORDER BY l.lista, l.producto ");
        sql.append("OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        
        // Query principal
        Query query = entityManager.createNativeQuery(sql.toString());
        
        // Setear parámetros
        for (int i = 0; i < params.size(); i++) {
            query.setParameter(i + 1, params.get(i));
        }
        
        // Setear parámetros de paginación
        query.setParameter(paramIndex++, request.getPage() * request.getLimit());
        query.setParameter(paramIndex, request.getLimit());
        
        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        
        List<ListaPrecioResponse> precios = new ArrayList<>();
        for (Object[] row : results) {
            precios.add(mapper.toResponse(row));
        }
        
        return new PaginadoResponse<>(
            new PageImpl<>(precios, PageRequest.of(request.getPage(), request.getLimit()), total)
        );
    }
} 