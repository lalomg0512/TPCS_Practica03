/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.domain.repository;

import java.util.List;
import org.uv.domain.entity.Cliente;

/**
 *
 * @author Vazqu
 */
public interface DAOGenerico<T> {
    
    List<T> findAll();
    T findById(Integer id);
    Boolean save(T t);
    void update(T t);
    void delete(T t);
}
