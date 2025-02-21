package org.com.ar.api.btb.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.com.ar.api.btb.dto.ClienteSucursalDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClienteSucursalService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ClienteSucursalDTO> findByLegajo(Short legajo) {
        String sql = """
            SELECT 
                s.legajo as legajoNumero,
                s.sublegajo as sucursalNumero,
                s.nombre as sucursalNombre,
                s.domicilio as domicilioCompletoPrincipal,
                s.localidad as localidadPrincipal,
                s.nuevocodpostal as codigoPostalPrincipal,
                s.jurisdiccion as provinciaPrincipal,
                j.nombre as provinciaPrincipalDescripcion,
                s.pais as paisPrincipal,
                p.nombre as paisPrincipalDescripcion,
                s.telefono as telefonoPrincipal,
                s.email as emailPrincipal,
                s.sitimpositiva as situacionIvaNumero,
                si.nombre as situacionIvaDescripcion,
                s.documento as documentoTipo,
                td.nombre as documentoDescripcion,
                s.cuit as documentoNumero,
                s.formapago as formaPagoNumero,
                fp.nombre as formaPagoDescripcion,
                s.descuento as descuento,
                s.entrega as domicilioCompletoLugarEntrega,
                s.localidadentrega as localidadLugarEntrega,
                s.codpostalentrega as codigoPostalLugarEntrega,
                s.jurisdiccionentrega as provinciaLugarEntrega,
                je.nombre as provinciaLugarEntregaDescripcion,
                s.paisentrega as paisLugarEntrega,
                pe.nombre as paisLugarEntregaDescripcion,
                s.expreso as expresoNumero,
                e.nombre as expresoDescripcion,
                s.vendedor as vendedorNumero,
                v.nombre as vendedorDescripcion,
                s.familia as familiaProducto,
                s.inactivo as inactivo
            FROM winners.sublegajo s
            LEFT JOIN winners.jurisdiccion j ON j.codigo = s.jurisdiccion
            LEFT JOIN winners.pais p ON p.codigo = s.pais
            LEFT JOIN winners.sitimpositiva si ON si.codigo = s.sitimpositiva
            LEFT JOIN winners.tipodocumento td ON td.codigo = s.documento
            LEFT JOIN winners.formapago fp ON fp.codigo = s.formapago
            LEFT JOIN winners.jurisdiccion je ON je.codigo = s.jurisdiccionentrega
            LEFT JOIN winners.pais pe ON pe.codigo = s.paisentrega
            LEFT JOIN winners.expreso e ON e.codigo = s.expreso
            LEFT JOIN winners.vendedor v ON v.codigo = s.vendedor
            WHERE s.legajo = :legajo
            ORDER BY s.sublegajo
        """;

        Query query = entityManager.createNativeQuery(sql)
            .setParameter("legajo", legajo);

        List<Object[]> results = query.getResultList();
        List<ClienteSucursalDTO> sucursales = new ArrayList<>();

        for (Object[] row : results) {
            ClienteSucursalDTO dto = new ClienteSucursalDTO();
            int i = 0;
            
            dto.setLegajoNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setSucursalNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setSucursalNombre((String) row[i++]);
            dto.setDomicilioCompletoPrincipal((String) row[i++]);
            dto.setLocalidadPrincipal((String) row[i++]);
            dto.setCodigoPostalPrincipal((String) row[i++]);
            dto.setProvinciaPrincipal(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            dto.setProvinciaPrincipalDescripcion((String) row[i++]);
            dto.setPaisPrincipal(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            dto.setPaisPrincipalDescripcion((String) row[i++]);
            dto.setTelefonoPrincipal((String) row[i++]);
            dto.setEmailPrincipal((String) row[i++]);
            dto.setSituacionIvaNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setSituacionIvaDescripcion((String) row[i++]);
            dto.setDocumentoTipo(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setDocumentoDescripcion((String) row[i++]);
            dto.setDocumentoNumero((String) row[i++]);
            dto.setFormaPagoNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setFormaPagoDescripcion((String) row[i++]);
            dto.setDescuento(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setDomicilioCompletoLugarEntrega((String) row[i++]);
            dto.setLocalidadLugarEntrega((String) row[i++]);
            dto.setCodigoPostalLugarEntrega((String) row[i++]);
            dto.setProvinciaLugarEntrega(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            dto.setProvinciaLugarEntregaDescripcion((String) row[i++]);
            dto.setPaisLugarEntrega(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            dto.setPaisLugarEntregaDescripcion((String) row[i++]);
            dto.setExpresoNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setExpresoDescripcion((String) row[i++]);
            dto.setVendedorNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            dto.setVendedorDescripcion((String) row[i++]);
            dto.setFamiliaProducto((String) row[i++]);
            dto.setInactivo(row[i] != null && ((Number) row[i]).shortValue() == 1);
            
            sucursales.add(dto);
        }

        return sucursales;
    }

    public Optional<ClienteSucursalDTO> findById(Short legajo, Short codigo) {
        String sql = """
            SELECT 
                s.legajo as legajoNumero,
                s.sublegajo as sucursalNumero,
                s.nombre as sucursalNombre,
                s.domicilio as domicilioCompletoPrincipal,
                s.localidad as localidadPrincipal,
                s.nuevocodpostal as codigoPostalPrincipal,
                s.jurisdiccion as provinciaPrincipal,
                j.nombre as provinciaPrincipalDescripcion,
                s.pais as paisPrincipal,
                p.nombre as paisPrincipalDescripcion,
                s.telefono as telefonoPrincipal,
                s.email as emailPrincipal,
                s.sitimpositiva as situacionIvaNumero,
                si.nombre as situacionIvaDescripcion,
                s.documento as documentoTipo,
                td.nombre as documentoDescripcion,
                s.cuit as documentoNumero,
                s.formapago as formaPagoNumero,
                fp.nombre as formaPagoDescripcion,
                s.descuento as descuento,
                s.entrega as domicilioCompletoLugarEntrega,
                s.localidadentrega as localidadLugarEntrega,
                s.codpostalentrega as codigoPostalLugarEntrega,
                s.jurisdiccionentrega as provinciaLugarEntrega,
                je.nombre as provinciaLugarEntregaDescripcion,
                s.paisentrega as paisLugarEntrega,
                pe.nombre as paisLugarEntregaDescripcion,
                s.expreso as expresoNumero,
                e.nombre as expresoDescripcion,
                s.vendedor as vendedorNumero,
                v.nombre as vendedorDescripcion,
                s.familia as familiaProducto,
                s.inactivo as inactivo
            FROM winners.sublegajo s
            LEFT JOIN winners.jurisdiccion j ON j.codigo = s.jurisdiccion
            LEFT JOIN winners.pais p ON p.codigo = s.pais
            LEFT JOIN winners.sitimpositiva si ON si.codigo = s.sitimpositiva
            LEFT JOIN winners.tipodocumento td ON td.codigo = s.documento
            LEFT JOIN winners.formapago fp ON fp.codigo = s.formapago
            LEFT JOIN winners.jurisdiccion je ON je.codigo = s.jurisdiccionentrega
            LEFT JOIN winners.pais pe ON pe.codigo = s.paisentrega
            LEFT JOIN winners.expreso e ON e.codigo = s.expreso
            LEFT JOIN winners.vendedor v ON v.codigo = s.vendedor
            WHERE s.legajo = :legajo AND s.sublegajo = :codigo
        """;

        Query query = entityManager.createNativeQuery(sql)
            .setParameter("legajo", legajo)
            .setParameter("codigo", codigo);

        try {
            Object[] row = (Object[]) query.getSingleResult();
            ClienteSucursalDTO dto = new ClienteSucursalDTO();
            int i = 0;
            
            dto.setLegajoNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setSucursalNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setSucursalNombre((String) row[i++]);
            dto.setDomicilioCompletoPrincipal((String) row[i++]);
            dto.setLocalidadPrincipal((String) row[i++]);
            dto.setCodigoPostalPrincipal((String) row[i++]);
            dto.setProvinciaPrincipal(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            dto.setProvinciaPrincipalDescripcion((String) row[i++]);
            dto.setPaisPrincipal(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            dto.setPaisPrincipalDescripcion((String) row[i++]);
            dto.setTelefonoPrincipal((String) row[i++]);
            dto.setEmailPrincipal((String) row[i++]);
            dto.setSituacionIvaNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setSituacionIvaDescripcion((String) row[i++]);
            dto.setDocumentoTipo(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setDocumentoDescripcion((String) row[i++]);
            dto.setDocumentoNumero((String) row[i++]);
            dto.setFormaPagoNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setFormaPagoDescripcion((String) row[i++]);
            dto.setDescuento(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setDomicilioCompletoLugarEntrega((String) row[i++]);
            dto.setLocalidadLugarEntrega((String) row[i++]);
            dto.setCodigoPostalLugarEntrega((String) row[i++]);
            dto.setProvinciaLugarEntrega(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            dto.setProvinciaLugarEntregaDescripcion((String) row[i++]);
            dto.setPaisLugarEntrega(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            dto.setPaisLugarEntregaDescripcion((String) row[i++]);
            dto.setExpresoNumero(row[i] != null ? ((Number) row[i]).shortValue() : null); i++;
            dto.setExpresoDescripcion((String) row[i++]);
            dto.setVendedorNumero(row[i] != null ? ((Number) row[i]).intValue() : null); i++;
            dto.setVendedorDescripcion((String) row[i++]);
            dto.setFamiliaProducto((String) row[i++]);
            dto.setInactivo(row[i] != null && ((Number) row[i]).shortValue() == 1);
            
            return Optional.of(dto);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Transactional
    public ClienteSucursalDTO create(ClienteSucursalDTO sucursalDTO) {
        String sql = """
            INSERT INTO winners.sublegajo (
                legajo, sublegajo, nombre, domicilio, localidad, nuevocodpostal,
                jurisdiccion, pais, telefono, email, sitimpositiva, documento,
                cuit, formapago, descuento, entrega, localidadentrega,
                codpostalentrega, jurisdiccionentrega, paisentrega, expreso,
                vendedor, familia, inactivo
            ) VALUES (
                :legajo, :sublegajo, :nombre, :domicilio, :localidad, :codPostal,
                :jurisdiccion, :pais, :telefono, :email, :sitImpositiva, :documento,
                :cuit, :formaPago, :descuento, :entrega, :localidadEntrega,
                :codPostalEntrega, :jurisdiccionEntrega, :paisEntrega, :expreso,
                :vendedor, :familia, :inactivo
            )
        """;

        Query query = entityManager.createNativeQuery(sql)
            .setParameter("legajo", sucursalDTO.getLegajoNumero())
            .setParameter("sublegajo", sucursalDTO.getSucursalNumero())
            .setParameter("nombre", sucursalDTO.getSucursalNombre())
            .setParameter("domicilio", sucursalDTO.getDomicilioCompletoPrincipal())
            .setParameter("localidad", sucursalDTO.getLocalidadPrincipal())
            .setParameter("codPostal", sucursalDTO.getCodigoPostalPrincipal())
            .setParameter("jurisdiccion", sucursalDTO.getProvinciaPrincipal())
            .setParameter("pais", sucursalDTO.getPaisPrincipal())
            .setParameter("telefono", sucursalDTO.getTelefonoPrincipal())
            .setParameter("email", sucursalDTO.getEmailPrincipal())
            .setParameter("sitImpositiva", sucursalDTO.getSituacionIvaNumero())
            .setParameter("documento", sucursalDTO.getDocumentoTipo())
            .setParameter("cuit", sucursalDTO.getDocumentoNumero())
            .setParameter("formaPago", sucursalDTO.getFormaPagoNumero())
            .setParameter("descuento", sucursalDTO.getDescuento())
            .setParameter("entrega", sucursalDTO.getDomicilioCompletoLugarEntrega())
            .setParameter("localidadEntrega", sucursalDTO.getLocalidadLugarEntrega())
            .setParameter("codPostalEntrega", sucursalDTO.getCodigoPostalLugarEntrega())
            .setParameter("jurisdiccionEntrega", sucursalDTO.getProvinciaLugarEntrega())
            .setParameter("paisEntrega", sucursalDTO.getPaisLugarEntrega())
            .setParameter("expreso", sucursalDTO.getExpresoNumero())
            .setParameter("vendedor", sucursalDTO.getVendedorNumero())
            .setParameter("familia", sucursalDTO.getFamiliaProducto())
            .setParameter("inactivo", sucursalDTO.getInactivo() ? 1 : 0);

        query.executeUpdate();
        
        return findById(sucursalDTO.getLegajoNumero(), sucursalDTO.getSucursalNumero())
            .orElseThrow(() -> new RuntimeException("Error al crear la sucursal"));
    }

    @Transactional
    public ClienteSucursalDTO update(Short legajo, Short codigo, ClienteSucursalDTO sucursalDTO) {
        String sql = """
            UPDATE winners.sublegajo SET
                nombre = :nombre,
                domicilio = :domicilio,
                localidad = :localidad,
                nuevocodpostal = :codPostal,
                jurisdiccion = :jurisdiccion,
                pais = :pais,
                telefono = :telefono,
                email = :email,
                sitimpositiva = :sitImpositiva,
                documento = :documento,
                cuit = :cuit,
                formapago = :formaPago,
                descuento = :descuento,
                entrega = :entrega,
                localidadentrega = :localidadEntrega,
                codpostalentrega = :codPostalEntrega,
                jurisdiccionentrega = :jurisdiccionEntrega,
                paisentrega = :paisEntrega,
                expreso = :expreso,
                vendedor = :vendedor,
                familia = :familia,
                inactivo = :inactivo
            WHERE legajo = :legajo AND sublegajo = :sublegajo
        """;

        Query query = entityManager.createNativeQuery(sql)
            .setParameter("legajo", legajo)
            .setParameter("sublegajo", codigo)
            .setParameter("nombre", sucursalDTO.getSucursalNombre())
            .setParameter("domicilio", sucursalDTO.getDomicilioCompletoPrincipal())
            .setParameter("localidad", sucursalDTO.getLocalidadPrincipal())
            .setParameter("codPostal", sucursalDTO.getCodigoPostalPrincipal())
            .setParameter("jurisdiccion", sucursalDTO.getProvinciaPrincipal())
            .setParameter("pais", sucursalDTO.getPaisPrincipal())
            .setParameter("telefono", sucursalDTO.getTelefonoPrincipal())
            .setParameter("email", sucursalDTO.getEmailPrincipal())
            .setParameter("sitImpositiva", sucursalDTO.getSituacionIvaNumero())
            .setParameter("documento", sucursalDTO.getDocumentoTipo())
            .setParameter("cuit", sucursalDTO.getDocumentoNumero())
            .setParameter("formaPago", sucursalDTO.getFormaPagoNumero())
            .setParameter("descuento", sucursalDTO.getDescuento())
            .setParameter("entrega", sucursalDTO.getDomicilioCompletoLugarEntrega())
            .setParameter("localidadEntrega", sucursalDTO.getLocalidadLugarEntrega())
            .setParameter("codPostalEntrega", sucursalDTO.getCodigoPostalLugarEntrega())
            .setParameter("jurisdiccionEntrega", sucursalDTO.getProvinciaLugarEntrega())
            .setParameter("paisEntrega", sucursalDTO.getPaisLugarEntrega())
            .setParameter("expreso", sucursalDTO.getExpresoNumero())
            .setParameter("vendedor", sucursalDTO.getVendedorNumero())
            .setParameter("familia", sucursalDTO.getFamiliaProducto())
            .setParameter("inactivo", sucursalDTO.getInactivo() ? 1 : 0);

        int updated = query.executeUpdate();
        if (updated == 0) {
            throw new RuntimeException("Sucursal no encontrada");
        }
        
        return findById(legajo, codigo)
            .orElseThrow(() -> new RuntimeException("Error al actualizar la sucursal"));
    }

    @Transactional
    public void delete(Short legajo, Short codigo) {
        String sql = "DELETE FROM winners.sublegajo WHERE legajo = :legajo AND sublegajo = :codigo";
        
        Query query = entityManager.createNativeQuery(sql)
            .setParameter("legajo", legajo)
            .setParameter("codigo", codigo);

        int deleted = query.executeUpdate();
        if (deleted == 0) {
            throw new RuntimeException("Sucursal no encontrada");
        }
    }

    @Transactional
    public ClienteSucursalDTO activar(Short legajo, Short codigo) {
        String sql = "UPDATE winners.sublegajo SET inactivo = 0 WHERE legajo = :legajo AND sublegajo = :codigo";
        
        Query query = entityManager.createNativeQuery(sql)
            .setParameter("legajo", legajo)
            .setParameter("codigo", codigo);

        int updated = query.executeUpdate();
        if (updated == 0) {
            throw new RuntimeException("Sucursal no encontrada");
        }

        return findById(legajo, codigo)
            .orElseThrow(() -> new RuntimeException("Error al activar la sucursal"));
    }

    @Transactional
    public ClienteSucursalDTO desactivar(Short legajo, Short codigo) {
        String sql = "UPDATE winners.sublegajo SET inactivo = 1 WHERE legajo = :legajo AND sublegajo = :codigo";
        
        Query query = entityManager.createNativeQuery(sql)
            .setParameter("legajo", legajo)
            .setParameter("codigo", codigo);

        int updated = query.executeUpdate();
        if (updated == 0) {
            throw new RuntimeException("Sucursal no encontrada");
        }

        return findById(legajo, codigo)
            .orElseThrow(() -> new RuntimeException("Error al desactivar la sucursal"));
    }
} 