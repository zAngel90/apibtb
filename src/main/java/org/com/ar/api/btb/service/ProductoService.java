package org.com.ar.api.btb.service;

import org.com.ar.api.btb.dto.request.ProductoSearchRequest;
import org.com.ar.api.btb.dto.response.ProductoResponse;
import org.com.ar.api.btb.mapper.ProductoMapper;
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
public class ProductoService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    private final ProductoMapper mapper;
    
    public PaginadoResponse<ProductoResponse> buscarProductos(ProductoSearchRequest request) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  p.codigo as sku, ");
        sql.append("  p.nombreventa as nombreVenta, ");
        sql.append("  p.nombretecnico as nombreTecnico, ");
        sql.append("  p.inactivo as inactivo, ");
        sql.append("  p.fechaalta as fechaAlta, ");
        sql.append("  p.fechabaja as fechaBaja, ");
        sql.append("  p.familia as familiaNumero, ");
        sql.append("  f.nombre as familiaDescripcion, ");
        sql.append("  p.subfamilia as subfamiliaNumero, ");
        sql.append("  sf.nombre as subfamiliaDescripcion, ");
        sql.append("  p.marca as marcaNumero, ");
        sql.append("  m.nombre as marcaDescripcion, ");
        sql.append("  p.unidadmedida as unidadMedidaNumero, ");
        sql.append("  um.nombre as unidadMedidaDescripcion, ");
        sql.append("  p.unidadmedidaventa as unidadMedidaVentaNumero, ");
        sql.append("  umv.nombre as unidadMedidaVentaDescripcion, ");
        sql.append("  p.factorconversion as factorConversion, ");
        sql.append("  p.pesoneto as pesoNeto, ");
        sql.append("  p.pesobruto as pesoBruto, ");
        sql.append("  p.volumen as volumen, ");
        sql.append("  p.codigobarras as codigoBarras, ");
        sql.append("  p.codigoproveedor as codigoProveedor, ");
        sql.append("  p.proveedor as proveedorNumero, ");
        sql.append("  pv.nombre as proveedorNombre, ");
        sql.append("  p.observaciones as observaciones, ");
        sql.append("  p.imagen as imagen, ");
        sql.append("  p.fichatecnica as fichaTecnica, ");
        sql.append("  p.hojaseguridad as hojaSeguridad, ");
        sql.append("  p.especificacion as especificacion, ");
        sql.append("  p.plano as plano, ");
        sql.append("  p.foto as foto, ");
        sql.append("  p.video as video, ");
        sql.append("  p.otros as otros ");
        sql.append("FROM winners.producto p ");
        sql.append("LEFT JOIN winners.familia f ON f.codigo = p.familia ");
        sql.append("LEFT JOIN winners.subfamilia sf ON sf.codigo = p.subfamilia ");
        sql.append("LEFT JOIN winners.marca m ON m.codigo = p.marca ");
        sql.append("LEFT JOIN winners.unidadmedida um ON um.codigo = p.unidadmedida ");
        sql.append("LEFT JOIN winners.unidadmedida umv ON umv.codigo = p.unidadmedidaventa ");
        sql.append("LEFT JOIN winners.legajos pv ON pv.clipro = 'PR' AND pv.legajo = p.proveedor ");
        sql.append("WHERE 1=1 ");
        
        List<Object> params = new ArrayList<>();
        int paramIndex = 1;
        
        if (request.getSku() != null && !request.getSku().trim().isEmpty()) {
            sql.append("AND p.codigo = ? ");
            params.add(request.getSku());
            paramIndex++;
        }
        
        if (request.getNombre() != null && !request.getNombre().trim().isEmpty()) {
            sql.append("AND (UPPER(p.nombreventa) LIKE UPPER(?) OR UPPER(p.nombretecnico) LIKE UPPER(?)) ");
            params.add("%" + request.getNombre() + "%");
            params.add("%" + request.getNombre() + "%");
            paramIndex += 2;
        }
        
        if (request.getIncluirInactivos() == null || !request.getIncluirInactivos()) {
            sql.append("AND p.inactivo = 0 ");
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
        sql.append("ORDER BY p.nombreventa ");
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
        
        List<ProductoResponse> productos = new ArrayList<>();
        for (Object[] row : results) {
            productos.add(mapper.toResponse(row));
        }
        
        return new PaginadoResponse<>(
            new PageImpl<>(productos, PageRequest.of(request.getPage(), request.getLimit()), total)
        );
    }
} 