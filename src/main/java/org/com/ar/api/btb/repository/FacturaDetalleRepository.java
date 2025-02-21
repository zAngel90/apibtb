package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.FacturaDetalle;
import org.com.ar.api.btb.entities.FacturaDetalleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle, FacturaDetalleId> {
    
    List<FacturaDetalle> findByIdEmpresaAndIdNroOperacion(Short empresa, Integer nroOperacion);
    
    List<FacturaDetalle> findBySku(String sku);
} 