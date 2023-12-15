/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.controller;

import java.util.ArrayList;
import java.util.List;
import org.uv.domain.entity.Producto;
import org.uv.domain.repository.ProductoDAO;
import org.uv.dto.ProductoDTO;

/**
 *
 * @author Vazqu
 */
    public class ProductoController {
    private ProductoDAO productoDAO = new ProductoDAO();

    public Boolean registrarProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setIdProducto(productoDTO.getIdProducto());
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());

        try {
            productoDAO.save(producto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ProductoDTO> obtenerTodosLosProductos() {
        List<Producto> productos = productoDAO.findAll();
        List<ProductoDTO> productosDTO = new ArrayList<>();

        for (Producto producto : productos) {
            ProductoDTO productoDTO;
            productoDTO = new ProductoDTO(producto.getIdProducto(), producto.getNombre(),producto.getDescripcion(), producto.getExistencia(), producto.getPrecio());
            productosDTO.add(productoDTO);
        }

        return productosDTO;
    }
}
