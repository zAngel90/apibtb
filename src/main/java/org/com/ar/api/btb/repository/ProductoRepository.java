package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String>, JpaSpecificationExecutor<Producto> {
    
    // Buscar por nombre de venta (ignorando mayúsculas/minúsculas)
    Page<Producto> findByNombreVentaContainingIgnoreCase(String nombreVenta, Pageable pageable);
    
    // Buscar productos activos (no inactivos y no marcados como no venta)
    Page<Producto> findByInactivoAndNoVenta(Short inactivo, Short noVenta, Pageable pageable);
} 