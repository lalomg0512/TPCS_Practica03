/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dto;

import java.util.Date;

/**
 *
 * @author Vazqu
 */
public class VentaDTO {
    private Integer idVenta;
    private Integer idCliente;
    private Date fecha;
    
    public VentaDTO(Integer ventaId, String fecha1) {
    }
    
    public VentaDTO(Integer idVenta, Integer idCliente, Date fecha) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.fecha = fecha;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
