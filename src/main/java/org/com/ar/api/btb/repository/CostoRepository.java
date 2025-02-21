package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.Costo;
import org.com.ar.api.btb.entities.CostoId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CostoRepository extends JpaRepository<Costo, CostoId> {
    Page<Costo> findByFecha(LocalDate fecha, Pageable pageable);
    
    @Query("SELECT c FROM Costo c WHERE c.id.sku = :sku")
    List<Costo> findBySku(@Param("sku") String sku);
    
    @Query("SELECT c FROM Costo c WHERE c.id.sku = :sku ORDER BY c.id.fecha DESC")
    Optional<Costo> findFirstBySkuOrderByFechaDesc(@Param("sku") String sku);
    
    Page<Costo> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable);
} 