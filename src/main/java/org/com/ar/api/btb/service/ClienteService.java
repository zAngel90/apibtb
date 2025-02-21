package org.com.ar.api.btb.service;

import org.com.ar.api.btb.dto.request.ClienteSearchRequest;
import org.com.ar.api.btb.dto.response.ClienteResponse;
import org.com.ar.api.btb.mapper.ClienteMapper;
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
public class ClienteService {

    @PersistenceContext
    private EntityManager entityManager;

    private final ClienteMapper clienteMapper;

    public PaginadoResponse<ClienteResponse> buscarClientes(ClienteSearchRequest request) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  l.idcrm as idCrm, ");
        sql.append("  l.legajo as legajoNumero, ");
        sql.append("  l.inactivo as inactivo, ");
        sql.append("  l.apellido as apellido, ");
        sql.append("  l.nombre as nombre, ");
        sql.append("  l.domicilio as domicilioCompletoPrincipal, ");
        sql.append("  l.localidad as localidadPrincipal, ");
        sql.append("  l.nuevocodpostal as codigoPostalPrincipal, ");
        sql.append("  l.jurisdiccion as provinciaPrincipal, ");
        sql.append("  j.nombre as provinciaPrincipalDescripcion, ");
        sql.append("  l.pais as paisPrincipal, ");
        sql.append("  p.nombre as paisPrincipalDescripcion, ");
        sql.append("  l.telefono as telefonoPrincipal, ");
        sql.append("  l.celular as celularPrincipal, ");
        sql.append("  l.email as emailPrincipal, ");
        sql.append("  l.enviofacturaemail as envioFacturaEmailEstado, ");
        sql.append("  l.enviofacturaemailnombre as envioFacturaEmailNombre, ");
        sql.append("  l.enviofacturaemail as envioFacturaEmail, ");
        sql.append("  l.sitimpositiva as situacionIvaNumero, ");
        sql.append("  si.nombre as situacionIvaDescripcion, ");
        sql.append("  l.documento as documentoTipo, ");
        sql.append("  td.nombre as documentoDescripcion, ");
        sql.append("  l.cuit as documentoNumero, ");
        sql.append("  l.formapago as formaPagoNumero, ");
        sql.append("  fp.nombre as formaPagoDescripcion, ");
        sql.append("  l.fechaalta as fechaAlta, ");
        sql.append("  l.nombrefantasia as nombreFantasia, ");
        sql.append("  l.listaprecios as listaPrecioNumero, ");
        sql.append("  lp.nombre as listaPrecioDescripcion, ");
        sql.append("  l.descuento as descuento, ");
        sql.append("  l.entrega as domicilioCompletoLugarEntrega, ");
        sql.append("  l.expreso as expresoNumero, ");
        sql.append("  e.nombre as expresoDescripcion, ");
        sql.append("  l.vendedor as vendedorNumero, ");
        sql.append("  v.nombre as vendedorDescripcion, ");
        sql.append("  l.legajoexportacion as legajoDeExportacionEstado, ");
        sql.append("  l.generarpedidosexportacion as generaPedidosExportacionEstado, ");
        sql.append("  l.omitircontrolexportacionblock as omitirControlExportacionBlockEstado, ");
        sql.append("  l.noexportapedidosblock as noExportaPedidosBlockEstado, ");
        sql.append("  l.detallarpesopedidosblock as detallarPesoPedidosBlockEstado, ");
        sql.append("  l.bloqueotipo as bloqueoTipo, ");
        sql.append("  l.bloqueomotivo as bloqueoMotivo ");
        sql.append("FROM winners.legajos l ");
        sql.append("LEFT JOIN winners.jurisdiccion j ON j.codigo = l.jurisdiccion ");
        sql.append("LEFT JOIN winners.pais p ON p.codigo = l.pais ");
        sql.append("LEFT JOIN winners.sitimpositiva si ON si.codigo = l.sitimpositiva ");
        sql.append("LEFT JOIN winners.tipodocumento td ON td.codigo = l.documento ");
        sql.append("LEFT JOIN winners.formapago fp ON fp.codigo = l.formapago ");
        sql.append("LEFT JOIN winners.listaprecios lp ON lp.codigo = l.listaprecios ");
        sql.append("LEFT JOIN winners.expreso e ON e.codigo = l.expreso ");
        sql.append("LEFT JOIN winners.vendedor v ON v.codigo = l.vendedor ");
        sql.append("WHERE l.clipro = 'CL' ");
        
        List<Object> params = new ArrayList<>();
        int paramIndex = 1;
        
        if (request.getLegajoNumero() != null) {
            sql.append("AND l.legajo = ? ");
            params.add(request.getLegajoNumero());
            paramIndex++;
        }
        
        if (request.getNombre() != null && !request.getNombre().trim().isEmpty()) {
            sql.append("AND UPPER(l.nombre) LIKE UPPER(?) ");
            params.add("%" + request.getNombre() + "%");
            paramIndex++;
        }
        
        if (request.getApellido() != null && !request.getApellido().trim().isEmpty()) {
            sql.append("AND UPPER(l.apellido) LIKE UPPER(?) ");
            params.add("%" + request.getApellido() + "%");
            paramIndex++;
        }
        
        if (request.getDocumento() != null && !request.getDocumento().trim().isEmpty()) {
            sql.append("AND l.cuit = ? ");
            params.add(request.getDocumento());
            paramIndex++;
        }
        
        if (request.getIncluirInactivos() == null || !request.getIncluirInactivos()) {
            sql.append("AND l.inactivo = 0 ");
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
        sql.append("ORDER BY l.apellido, l.nombre ");
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
        
        List<ClienteResponse> clientes = new ArrayList<>();
        for (Object[] row : results) {
            clientes.add(clienteMapper.toResponse(row));
        }
        
        return new PaginadoResponse<>(
            new PageImpl<>(clientes, PageRequest.of(request.getPage(), request.getLimit()), total)
        );
    }
} 