package org.com.ar.api.btb.service;

import org.com.ar.api.btb.dto.request.PedidoSearchRequest;
import org.com.ar.api.btb.dto.response.PedidoResponse;
import org.com.ar.api.btb.mapper.PedidoMapper;
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
public class PedidoService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    private final PedidoMapper mapper;
    
    public PaginadoResponse<PedidoResponse> buscarPedidos(PedidoSearchRequest request) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  cp.fecha as fecha, ");
        sql.append("  cp.deposito as depositoNumero, ");
        sql.append("  d.nombre as depositoDescripcion, ");
        sql.append("  cp.legajo as legajoNumero, ");
        sql.append("  l.apellido || ', ' || l.nombre as legajoNombre, ");
        sql.append("  cp.producto as productoSku, ");
        sql.append("  p.nombreventa as productoDescripcion, ");
        sql.append("  cp.cantidad as cantidad, ");
        sql.append("  cp.precio as precio, ");
        sql.append("  cp.moneda as moneda, ");
        sql.append("  m.nombre as monedaDescripcion, ");
        sql.append("  cp.cotizacion as cotizacion, ");
        sql.append("  cp.descuento as descuento, ");
        sql.append("  cp.estado as estado, ");
        sql.append("  e.nombre as estadoDescripcion, ");
        sql.append("  cp.observaciones as observaciones ");
        sql.append("FROM winners.cabeprod cp ");
        sql.append("LEFT JOIN winners.deposito d ON d.codigo = cp.deposito ");
        sql.append("LEFT JOIN winners.legajos l ON l.legajo = cp.legajo AND l.clipro = 'CL' ");
        sql.append("LEFT JOIN winners.producto p ON p.codigo = cp.producto ");
        sql.append("LEFT JOIN winners.moneda m ON m.codigo = cp.moneda ");
        sql.append("LEFT JOIN winners.estado e ON e.codigo = cp.estado ");
        sql.append("WHERE 1=1 ");
        
        List<Object> params = new ArrayList<>();
        int paramIndex = 1;
        
        if (request.getLegajoNumero() != null) {
            sql.append("AND cp.legajo = ? ");
            params.add(request.getLegajoNumero());
            paramIndex++;
        }
        
        if (request.getProductoSku() != null && !request.getProductoSku().trim().isEmpty()) {
            sql.append("AND cp.producto = ? ");
            params.add(request.getProductoSku());
            paramIndex++;
        }
        
        if (request.getDepositoNumero() != null) {
            sql.append("AND cp.deposito = ? ");
            params.add(request.getDepositoNumero());
            paramIndex++;
        }
        
        if (request.getFechaDesde() != null) {
            sql.append("AND cp.fecha >= ? ");
            params.add(request.getFechaDesde());
            paramIndex++;
        }
        
        if (request.getFechaHasta() != null) {
            sql.append("AND cp.fecha <= ? ");
            params.add(request.getFechaHasta());
            paramIndex++;
        }
        
        if (request.getEstado() != null) {
            sql.append("AND cp.estado = ? ");
            params.add(request.getEstado());
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
        sql.append("ORDER BY cp.fecha DESC, cp.legajo, cp.producto ");
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
        
        List<PedidoResponse> pedidos = new ArrayList<>();
        for (Object[] row : results) {
            pedidos.add(mapper.toResponse(row));
        }
        
        return new PaginadoResponse<>(
            new PageImpl<>(pedidos, PageRequest.of(request.getPage(), request.getLimit()), total)
        );
    }
} 