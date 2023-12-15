/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.domain.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Vazqu
 */
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    
    @EmbeddedId
    private DetalleVentaPK id;
    
    private Integer cantidad;
    
    private String descripcion;
    
    private Double precio;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_venta", insertable = false, updatable = false)
    private Venta venta;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto",updatable = false,insertable = false)
    private Producto producto;

    public DetalleVentaPK getId() {
        return id;
    }

    public void setId(DetalleVentaPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
    
    
}
