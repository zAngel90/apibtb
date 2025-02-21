package org.com.ar.api.btb.entities;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "liprdeta", schema = "winners")
@IdClass(ListaPrecioDetalleId.class)
public class ListaPrecioDetalle {

    @Id
    @Column(name = "lista", nullable = false)
    private Short lista;

    @Id
    @Column(name = "producto", length = 14, nullable = false)
    private String producto;

    @Column(name = "precio", precision = 12, scale = 4)
    private BigDecimal precio;

    @Column(name = "inactivo")
    private Short inactivo;

    @Column(name = "coefsobrepreciobase", precision = 15, scale = 6)
    private BigDecimal coefSobrePrecioBase;

    @Column(name = "redondearprecios")
    private Short redondearPrecios;

    @Column(name = "redondearanumero", precision = 10, scale = 2)
    private BigDecimal redondearANumero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lista", referencedColumnName = "codigo", insertable = false, updatable = false)
    private ListaPrecioCabecera listaPrecio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto", referencedColumnName = "codigo", insertable = false, updatable = false)
    private Producto productoEntity;
} 