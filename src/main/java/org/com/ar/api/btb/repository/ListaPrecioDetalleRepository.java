package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.ListaPrecioDetalle;
import org.com.ar.api.btb.entities.ListaPrecioDetalleId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaPrecioDetalleRepository extends JpaRepository<ListaPrecioDetalle, ListaPrecioDetalleId>, JpaSpecificationExecutor<ListaPrecioDetalle> {
    
    // Buscar detalles por lista
    Page<ListaPrecioDetalle> findByLista(Short lista, Pageable pageable);
    
    // Buscar detalles activos por lista
    Page<ListaPrecioDetalle> findByListaAndInactivo(Short lista, Short inactivo, Pageable pageable);
} 