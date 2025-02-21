package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.CuentaCorriente;
import org.com.ar.api.btb.entities.CuentaCorrienteId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaCorrienteRepository extends JpaRepository<CuentaCorriente, CuentaCorrienteId> {
    
    Page<CuentaCorriente> findByFecha(LocalDate fecha, Pageable pageable);
    
    List<CuentaCorriente> findByLegajoNumero(Integer legajo);
    
    Page<CuentaCorriente> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin, Pageable pageable);
    
    Page<CuentaCorriente> findByVencimientoLessThanAndCanceladoEquals(LocalDate fecha, Short cancelado, Pageable pageable);
    
    Page<CuentaCorriente> findByVencimientoBetweenAndCanceladoEquals(LocalDate fechaInicio, LocalDate fechaFin, Short cancelado, Pageable pageable);
    
    List<CuentaCorriente> findByLegajoNumeroAndCanceladoEquals(Integer legajo, Short cancelado);
    
    Optional<CuentaCorriente> findByComprobante(String comprobante);
} 