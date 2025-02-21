package org.com.ar.api.btb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class CuentaCorrienteId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "empresa")
    private Short empresa;

    @Column(name = "nrooperacion")
    private Integer nroOperacion;

    @Column(name = "sector")
    private String sector;

    @Column(name = "renglonoperacion")
    private Short renglonOperacion;

    @Column(name = "renglon")
    private Short renglon;

    public CuentaCorrienteId() {}

    public CuentaCorrienteId(Short empresa, Integer nroOperacion, String sector, Short renglonOperacion, Short renglon) {
        this.empresa = empresa;
        this.nroOperacion = nroOperacion;
        this.sector = sector;
        this.renglonOperacion = renglonOperacion;
        this.renglon = renglon;
    }
} 