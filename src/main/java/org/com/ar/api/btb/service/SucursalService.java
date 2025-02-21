package org.com.ar.api.btb.service;

import org.com.ar.api.btb.dto.request.SucursalSearchRequest;
import org.com.ar.api.btb.dto.response.SucursalResponse;
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
public class SucursalService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public PaginadoResponse<SucursalResponse> buscarSucursales(SucursalSearchRequest request) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT '' as id_crm, ");
        sql.append("c.legajo as legajo_numero, ");
        sql.append("c.codigo as sucursal_numero, ");
        sql.append("c.inactivo, ");
        sql.append("c.nombre as sucursal_nombre, ");
        sql.append("'' as domicilio_calle_principal, ");
        sql.append("'' as domicilio_numero_principal, ");
        sql.append("'' as domicilio_piso_principal, ");
        sql.append("'' as domicilio_dpto_principal, ");
        sql.append("c.domicilio as domicilio_completo_principal, ");
        sql.append("c.localidad as localidad_principal, ");
        sql.append("c.nuevocodpostal as codigo_postal_principal, ");
        sql.append("c.jurisdiccion as provincia_principal, ");
        sql.append("j.nombre as provincia_principal_descripcion, ");
        sql.append("c.pais as pais_principal, ");
        sql.append("p.nombre as pais_principal_descripcion, ");
        sql.append("c.telefono as telefono_principal, ");
        sql.append("c.e_mail as email_principal, ");
        sql.append("c.tipoiva as situacion_iva_numero, ");
        sql.append("simp.nombre as situacion_iva_descripcion, ");
        sql.append("c.documento as documento_tipo, ");
        sql.append("CASE ");
        sql.append("    WHEN c.documento = 0 THEN 'C.I. Policia Federal' ");
        sql.append("    WHEN c.documento = 99 THEN 'Venta Global Diaria/Sin Identificacion' ");
        sql.append("    WHEN c.documento = 96 THEN 'D.N.I.' ");
        sql.append("    WHEN c.documento = 80 THEN 'C.U.I.T.' ");
        sql.append("    ELSE 'Desconocido' ");
        sql.append("END as documento_descripcion, ");
        sql.append("c.cuit as documento_numero, ");
        sql.append("c.formapago as forma_pago_numero, ");
        sql.append("fp.nombre as forma_pago_descripcion, ");
        sql.append("c.descuento, ");
        sql.append("'' as domicilio_calle_lugar_entrega, ");
        sql.append("'' as domicilio_numero_lugar_entrega, ");
        sql.append("'' as domicilio_piso_lugar_entrega, ");
        sql.append("'' as domicilio_dpto_lugar_entrega, ");
        sql.append("c.domicilioentrega as domicilio_completo_lugar_entrega, ");
        sql.append("c.localidadentrega as localidad_lugar_entrega, ");
        sql.append("c.nuevocodpostalentrega as codigo_postal_lugar_entrega, ");
        sql.append("c.jurisdiccionentega as provincia_lugar_entrega, ");
        sql.append("j2.nombre as provincia_lugar_entrega_descripcion, ");
        sql.append("c.paisentega as pais_lugar_entrega, ");
        sql.append("p2.nombre as pais_lugar_entrega_descripcion, ");
        sql.append("c.expreso as expreso_numero, ");
        sql.append("e.nombre as expreso_descripcion, ");
        sql.append("c.vendedor as vendedor_numero, ");
        sql.append("lv.apellido as vendedor_descripcion, ");
        sql.append("c.familiaproducto ");
        sql.append("FROM winners.legasuc c ");
        sql.append("LEFT JOIN winners.jurisdic j ON c.jurisdiccion = j.codigo ");
        sql.append("LEFT JOIN winners.jurisdic j2 ON c.jurisdiccionentega = j2.codigo ");
        sql.append("LEFT JOIN winners.paises p ON c.pais = p.codigo ");
        sql.append("LEFT JOIN winners.paises p2 ON c.paisentega = p2.codigo ");
        sql.append("LEFT JOIN winners.sitdef sdef ON c.tipoiva = sdef.tipoiva ");
        sql.append("LEFT JOIN winners.sitimp simp ON sdef.sitimpositivaventas = simp.codigo AND simp.libroiva = 'VE' ");
        sql.append("LEFT JOIN winners.forpago fp ON c.formapago = fp.codigo ");
        sql.append("LEFT JOIN winners.expresos e ON c.expreso = e.codigo ");
        sql.append("LEFT JOIN winners.legajos lv ON c.vendedor = lv.codigo AND lv.clipro = 'VE' ");
        sql.append("WHERE c.clipro = 'CL' ");

        List<Object> parameters = new ArrayList<>();
        int parameterIndex = 1;

        if (request.getLegajoNumero() != null) {
            sql.append("AND c.legajo = ? ");
            parameters.add(request.getLegajoNumero());
            parameterIndex++;
        }

        if (request.getSucursalNumero() != null) {
            sql.append("AND c.codigo = ? ");
            parameters.add(request.getSucursalNumero());
            parameterIndex++;
        }

        if (request.getSucursalNombre() != null && !request.getSucursalNombre().trim().isEmpty()) {
            sql.append("AND UPPER(c.nombre) LIKE UPPER(?) ");
            parameters.add("%" + request.getSucursalNombre().trim() + "%");
            parameterIndex++;
        }

        if (request.getLocalidad() != null && !request.getLocalidad().trim().isEmpty()) {
            sql.append("AND UPPER(c.localidad) LIKE UPPER(?) ");
            parameters.add("%" + request.getLocalidad().trim() + "%");
            parameterIndex++;
        }

        if (request.getCodigoPostal() != null && !request.getCodigoPostal().trim().isEmpty()) {
            sql.append("AND c.nuevocodpostal = ? ");
            parameters.add(request.getCodigoPostal().trim());
            parameterIndex++;
        }

        if (request.getProvincia() != null) {
            sql.append("AND c.jurisdiccion = ? ");
            parameters.add(request.getProvincia());
            parameterIndex++;
        }

        if (request.getPais() != null) {
            sql.append("AND c.pais = ? ");
            parameters.add(request.getPais());
            parameterIndex++;
        }

        if (request.getVendedorNumero() != null) {
            sql.append("AND c.vendedor = ? ");
            parameters.add(request.getVendedorNumero());
            parameterIndex++;
        }

        if (request.getIncluirInactivos() == null || !request.getIncluirInactivos()) {
            sql.append("AND c.inactivo = 0 ");
        }

        // Count query
        String countSql = "SELECT COUNT(*) FROM (" + sql.toString() + ") x";
        Query countQuery = entityManager.createNativeQuery(countSql);
        
        // Set parameters for count query
        for (int i = 0; i < parameters.size(); i++) {
            countQuery.setParameter(i + 1, parameters.get(i));
        }
        
        Long total = ((Number) countQuery.getSingleResult()).longValue();

        // Add pagination
        sql.append("ORDER BY c.legajo, c.codigo ");
        sql.append("OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
        
        Query query = entityManager.createNativeQuery(sql.toString());
        
        // Set parameters for main query
        for (int i = 0; i < parameters.size(); i++) {
            query.setParameter(i + 1, parameters.get(i));
        }
        
        // Set pagination parameters
        query.setParameter(parameterIndex++, request.getOffset());
        query.setParameter(parameterIndex, request.getLimit());

        @SuppressWarnings("unchecked")
        List<Object[]> results = query.getResultList();
        
        List<SucursalResponse> sucursales = new ArrayList<>();
        
        for (Object[] row : results) {
            SucursalResponse sucursal = new SucursalResponse();
            int i = 0;
            
            sucursal.setIdCrm((String) row[i++]);
            sucursal.setLegajoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            sucursal.setSucursalNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            sucursal.setInactivo(row[i] != null ? ((Number) row[i]).intValue() == 1 : false); i++;
            sucursal.setSucursalNombre((String) row[i++]);
            sucursal.setDomicilioCallePrincipal((String) row[i++]);
            sucursal.setDomicilioNumeroPrincipal((String) row[i++]);
            sucursal.setDomicilioPisoPrincipal((String) row[i++]);
            sucursal.setDomicilioDptoPrincipal((String) row[i++]);
            sucursal.setDomicilioCompletoPrincipal((String) row[i++]);
            sucursal.setLocalidadPrincipal((String) row[i++]);
            sucursal.setCodigoPostalPrincipal((String) row[i++]);
            sucursal.setProvinciaPrincipal(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            sucursal.setProvinciaPrincipalDescripcion((String) row[i++]);
            sucursal.setPaisPrincipal(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            sucursal.setPaisPrincipalDescripcion((String) row[i++]);
            sucursal.setTelefonoPrincipal((String) row[i++]);
            sucursal.setEmailPrincipal((String) row[i++]);
            sucursal.setSituacionIvaNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            sucursal.setSituacionIvaDescripcion((String) row[i++]);
            sucursal.setDocumentoTipo(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            sucursal.setDocumentoDescripcion((String) row[i++]);
            sucursal.setDocumentoNumero((String) row[i++]);
            sucursal.setFormaPagoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            sucursal.setFormaPagoDescripcion((String) row[i++]);
            sucursal.setDescuento(row[i] != null ? (BigDecimal) row[i] : null); i++;
            sucursal.setDomicilioCalleLugarEntrega((String) row[i++]);
            sucursal.setDomicilioNumeroLugarEntrega((String) row[i++]);
            sucursal.setDomicilioPisoLugarEntrega((String) row[i++]);
            sucursal.setDomicilioDptoLugarEntrega((String) row[i++]);
            sucursal.setDomicilioCompletoLugarEntrega((String) row[i++]);
            sucursal.setLocalidadLugarEntrega((String) row[i++]);
            sucursal.setCodigoPostalLugarEntrega((String) row[i++]);
            sucursal.setProvinciaLugarEntrega(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            sucursal.setProvinciaLugarEntregaDescripcion((String) row[i++]);
            sucursal.setPaisLugarEntrega(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            sucursal.setPaisLugarEntregaDescripcion((String) row[i++]);
            sucursal.setExpresoNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            sucursal.setExpresoDescripcion((String) row[i++]);
            sucursal.setVendedorNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            sucursal.setVendedorDescripcion((String) row[i++]);
            sucursal.setFamiliaProducto((String) row[i]);
            
            sucursales.add(sucursal);
        }

        return new PaginadoResponse<>(
            new PageImpl<>(sucursales, PageRequest.of(request.getPage(), request.getLimit()), total)
        );
    }
} 