/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.domain.config;

import java.sql.Connection;

/**
 *
 * @author Vazqu
 */
public abstract class TransactionDB<T> {
    
    protected T p;

    protected TransactionDB(T p) {
        this.p = p;
    }
    
    public abstract boolean execute(Connection con);
}
