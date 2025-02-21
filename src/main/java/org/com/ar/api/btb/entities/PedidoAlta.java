package org.com.ar.api.btb.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos_alta", schema = "winners")
public class PedidoAlta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "deposito_numero", nullable = false)
    private Integer depositoNumero;

    @Column(name = "punto_venta", nullable = false)
    private Integer puntoVenta;

    @Column(name = "legajo_numero", nullable = false)
    private Integer legajoNumero;

    @Column(name = "legajo_sucursal_numero", nullable = false)
    private Integer legajoSucursalNumero;

    @Column(name = "sku", nullable = false, length = 14)
    private String sku;

    @Column(name = "cantidad_sku", nullable = false, precision = 16, scale = 4)
    private BigDecimal cantidadSku;

    @Column(name = "descuento_porcentaje", precision = 5, scale = 2)
    private BigDecimal descuentoPorcentaje;

    @Column(name = "lista_precio_numero")
    private Short listaPrecioNumero;

    @Column(name = "no_inmoviliza")
    private Boolean noInmoviliza = false;

    @Column(name = "precios_congelados")
    private Boolean preciosCongelados = false;

    @Column(name = "omitir_control")
    private Boolean omitirControl = false;

    @Column(name = "no_consolidar")
    private Boolean noConsolidar = false;

    @Column(name = "presupuesto")
    private Boolean presupuesto = false;

    @Column(name = "numero_pedido_crm", length = 20)
    private String numeroPedidoCrm;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "procesado")
    private Boolean procesado = false;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        modifiedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedAt = LocalDateTime.now();
    }
} 