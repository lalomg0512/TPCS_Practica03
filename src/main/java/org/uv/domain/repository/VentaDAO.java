/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.domain.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.uv.domain.config.HibernateUtil;
import org.uv.domain.entity.Venta;

/**
 *
 * @author Vazqu
 */
public class VentaDAO {

    public void save(Venta venta) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(venta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Venta> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Venta", Venta.class).list();
        }
    }
}
