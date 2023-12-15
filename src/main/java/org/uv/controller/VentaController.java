/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.controller;

import java.util.ArrayList;
import java.util.List;
import org.uv.domain.entity.Cliente;
import org.uv.domain.entity.Venta;
import org.uv.domain.repository.ClienteDAO;
import org.uv.domain.repository.VentaDAO;
import org.uv.dto.VentaDTO;


/**
 *
 * @author Vazqu
 */
public class VentaController {

    private VentaDAO ventaDAO = new VentaDAO();
    private ClienteDAO clienteDAO = new ClienteDAO(); 

    public Boolean registrarVenta(VentaDTO ventaDTO) {
        Venta venta = new Venta();
        venta.setIdVenta(ventaDTO.getIdVenta());

        
        Cliente cliente = clienteDAO.findById(ventaDTO.getIdCliente());
        venta.setCliente(cliente);

        venta.setFecha(ventaDTO.getFecha());

        try {
            ventaDAO.save(venta);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<VentaDTO> obtenerTodasLasVentas() {
        List<Venta> ventas = ventaDAO.findAll();
        List<VentaDTO> ventasDTO = new ArrayList<>();

        for (Venta venta : ventas) {
            VentaDTO ventaDTO = new VentaDTO(venta.getIdVenta(), venta.getCliente().getIdCliente(), venta.getFecha());
            ventasDTO.add(ventaDTO);
        }

        return ventasDTO;
    }

}
