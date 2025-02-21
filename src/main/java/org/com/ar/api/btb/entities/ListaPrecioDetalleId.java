package org.com.ar.api.btb.entities;

import java.io.Serializable;
import java.util.Objects;
import lombok.Data;

@Data
public class ListaPrecioDetalleId implements Serializable {
    private Short lista;
    private String producto;

    public ListaPrecioDetalleId() {
    }

    public ListaPrecioDetalleId(Short lista, String producto) {
        this.lista = lista;
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaPrecioDetalleId that = (ListaPrecioDetalleId) o;
        return Objects.equals(lista, that.lista) && 
               Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lista, producto);
    }
} 