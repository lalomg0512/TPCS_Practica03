/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.domain.config;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Vazqu
 */
public abstract class SelectionDB<T> {
    
    protected T p;

    protected SelectionDB(T p) {
        this.p = p;
    }
    
    public abstract List<T> select(Connection con);
    
    
}