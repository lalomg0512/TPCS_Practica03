/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.controller;

import java.util.ArrayList;
import java.util.List;
import org.uv.domain.entity.Cliente;
import org.uv.domain.repository.ClienteDAO;
import org.uv.dto.ClienteDTO;
import org.uv.domain.repository.DAOGenerico;

/**
 *
 * @author Vazqu
 */
public class ClienteController {

    private final DAOGenerico clienteDAO = new ClienteDAO();

    public Boolean crearNuevoCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteDTO.getIdCliente());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setRfc(clienteDTO.getRfc());

        return clienteDAO.save(cliente);
    }

    public ClienteDTO obtenerClientePorID(Integer id) {
        Cliente cliente = (Cliente) clienteDAO.findById(id);

        if (cliente == null) {
            return null;
        }

        return new ClienteDTO(cliente.getNombre(), cliente.getRfc());
    }
    
    public Boolean actualizarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteDTO.getIdCliente());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setRfc(clienteDTO.getRfc());

        try {
            clienteDAO.update(cliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean eliminarCliente(Integer id) {
        Cliente cliente = (Cliente) clienteDAO.findById(id);

        if (cliente == null) {
            return false;
        }

        try {
            clienteDAO.delete(cliente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<ClienteDTO> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteDAO.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();

        for (Cliente cliente : clientes) {
            ClienteDTO clienteDTO = new ClienteDTO(cliente.getNombre(), cliente.getRfc());
            clientesDTO.add(clienteDTO);
        }

        return clientesDTO;
    }




}
