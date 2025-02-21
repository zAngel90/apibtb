package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.Factura;
import org.com.ar.api.btb.entities.FacturaId;
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
public interface FacturaRepository extends JpaRepository<Factura, FacturaId> {
    
    Page<Factura> findByFecha(LocalDate fecha, Pageable pageable);
    
    List<Factura> findByLegajoNumero(Integer legajoNumero);
    
    Page<Factura> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable);
    
    Optional<Factura> findByTipoFacturaAndLetraFacturaAndPuntoVentaFacturaAndNumeroFactura(
        String tipoFactura, String letraFactura, Integer puntoVentaFactura, Integer numeroFactura);
    
    Page<Factura> findByAnulado(Short anulado, Pageable pageable);
    
    Page<Factura> findByCancelado(Short cancelado, Pageable pageable);
    
    @Query("SELECT f FROM Factura f WHERE f.vencimiento < :fecha AND f.cancelado = 0")
    Page<Factura> findVencidas(@Param("fecha") LocalDate fecha, Pageable pageable);
    
    @Query("SELECT f FROM Factura f WHERE f.vencimiento BETWEEN :fechaInicio AND :fechaFin AND f.cancelado = 0")
    Page<Factura> findProximasAVencer(
        @Param("fechaInicio") LocalDate fechaInicio, 
        @Param("fechaFin") LocalDate fechaFin, 
        Pageable pageable);
    
    List<Factura> findByLegajoNumeroAndLegajoSucursal(Integer legajoNumero, Integer legajoSucursal);
} 