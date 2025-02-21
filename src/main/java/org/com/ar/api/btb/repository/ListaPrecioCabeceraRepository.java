package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.ListaPrecioCabecera;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ListaPrecioCabeceraRepository extends JpaRepository<ListaPrecioCabecera, Short>, JpaSpecificationExecutor<ListaPrecioCabecera> {
    
    // Buscar listas de precios activas
    Page<ListaPrecioCabecera> findByInactivo(Short inactivo, Pageable pageable);
    
    // Buscar todas las listas de precios activas sin paginación
    List<ListaPrecioCabecera> findByInactivo(Short inactivo);
} 