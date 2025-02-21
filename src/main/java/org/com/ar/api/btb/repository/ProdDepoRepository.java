package org.com.ar.api.btb.repository;

import org.com.ar.api.btb.entities.ProdDepo;
import org.com.ar.api.btb.entities.ProdDepoId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdDepoRepository extends JpaRepository<ProdDepo, ProdDepoId> {
    
    Page<ProdDepo> findById_Deposito(Integer deposito, Pageable pageable);
    
    List<ProdDepo> findById_Producto(String producto);
    
    @Query("SELECT p FROM ProdDepo p WHERE p.stockActual <= p.puntoPedido")
    Page<ProdDepo> findStockBajoPuntoPedido(Pageable pageable);
    
    @Query("SELECT p FROM ProdDepo p WHERE p.stockActual <= p.stockMinimo")
    Page<ProdDepo> findStockBajoMinimo(Pageable pageable);
    
    @Query("SELECT p FROM ProdDepo p WHERE p.stockActual > p.stockMaximo")
    Page<ProdDepo> findStockSobreMaximo(Pageable pageable);
    
    @Query("SELECT p FROM ProdDepo p WHERE p.stockInmovilizado / p.stockActual >= :porcentaje")
    Page<ProdDepo> findStockAltamenteInmovilizado(@Param("porcentaje") BigDecimal porcentaje, Pageable pageable);
    
    @Query("SELECT p FROM ProdDepo p WHERE p.stockActual = 0")
    Page<ProdDepo> findStockAgotado(Pageable pageable);
    
    @Query("SELECT p FROM ProdDepo p WHERE p.id.deposito = :deposito AND (p.stockActual - p.stockInmovilizado) > 0")
    Page<ProdDepo> findProductosDisponiblesEnDeposito(@Param("deposito") Integer deposito, Pageable pageable);
} 