package org.com.ar.api.btb.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "proddepo", schema = "winners")
public class ProdDepo {
    
    @EmbeddedId
    private ProdDepoId id;
    
    @Column(name = "stockactual", precision = 15, scale = 3)
    private BigDecimal stockActual;
    
    @Column(name = "stockminimo", precision = 15, scale = 3)
    private BigDecimal stockMinimo;
    
    @Column(name = "stockmaximo", precision = 15, scale = 3)
    private BigDecimal stockMaximo;
    
    @Column(name = "puntopedido", precision = 15, scale = 3)
    private BigDecimal puntoPedido;
    
    @Column(name = "inmovilizado", precision = 15, scale = 3)
    private BigDecimal stockInmovilizado;
    
    @Column(name = "stockreservado", precision = 15, scale = 3)
    private BigDecimal stockReservado;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deposito", referencedColumnName = "codigo", insertable = false, updatable = false)
    private Deposito deposito;
    
    @Transient
    private BigDecimal stockDisponible;
    
    @Column(name = "ultimomovimiento")
    private LocalDateTime ultimoMovimiento;
    
    @Column(name = "ubicacion", length = 10)
    private String ubicacion;
    
    @Column(name = "observaciones", length = 100)
    private String observaciones;
    
    @PostLoad
    private void calcularStockDisponible() {
        if (stockActual != null && stockInmovilizado != null) {
            stockDisponible = stockActual.subtract(stockInmovilizado);
        }
    }
} 