package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.ProductoValuacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoValuacionRepository extends JpaRepository<ProductoValuacion, String> {
    
    List<ProductoValuacion> findByFecha(LocalDate fecha);
    
    Optional<ProductoValuacion> findBySkuAndFecha(String sku, LocalDate fecha);
    
    List<ProductoValuacion> findBySkuIn(List<String> skus);
} 