package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.PedidoAlta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoAltaRepository extends JpaRepository<PedidoAlta, Long> {
    
    List<PedidoAlta> findByLegajoNumeroAndLegajoSucursalNumero(Integer legajoNumero, Integer legajoSucursalNumero);
    
    List<PedidoAlta> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    
    List<PedidoAlta> findByProcesado(Boolean procesado);
    
    List<PedidoAlta> findBySkuAndProcesado(String sku, Boolean procesado);
} 