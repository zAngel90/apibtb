package org.com.ar.api.btb.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "liprcabe", schema = "winners")
public class ListaPrecioCabecera {

    @Id
    @Column(name = "codigo", nullable = false)
    private Short codigo;

    @Column(name = "nombre", length = 40)
    private String nombre;

    @Column(name = "nombrecorto", length = 15)
    private String nombreCorto;

    @Column(name = "incluyeimpuestos")
    private Short incluyeImpuestos;

    @Column(name = "inactivo")
    private Short inactivo;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "vigenciaespecial")
    private Short vigenciaEspecial;

    @Column(name = "vigenciadesde")
    private LocalDate vigenciaDesde;

    @Column(name = "vigenciahasta")
    private LocalDate vigenciaHasta;

    @Column(name = "usamonedaextranjera")
    private Short usaMonedaExtranjera;

    @Column(name = "moneda")
    private Short moneda;

    @Column(name = "calculardesde", length = 1)
    private String calcularDesde;

    @Column(name = "porcentaje", precision = 18, scale = 4)
    private BigDecimal porcentaje;

    @Column(name = "redondearprecios")
    private Short redondearPrecios;

    @Column(name = "redondearanumero", precision = 10, scale = 2)
    private BigDecimal redondearANumero;

    @OneToMany(mappedBy = "listaPrecio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ListaPrecioDetalle> detalles = new ArrayList<>();
} 