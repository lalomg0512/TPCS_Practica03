/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.domain.config;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.uv.domain.entity.Cliente;
import org.uv.domain.entity.DetalleVenta;
import org.uv.domain.entity.Producto;
import org.uv.domain.entity.Venta;

/**
 *
 * @author Vazqu
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public  static SessionFactory getSessionFactory() {
        if (sessionFactory == null){   
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/practicaTres");
            settings.put(Environment.USER, "postgres");
            settings.put(Environment.PASS, "postgres");
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(Cliente.class);
            configuration.addAnnotatedClass(DetalleVenta.class);
            configuration.addAnnotatedClass(Producto.class);
            configuration.addAnnotatedClass(Venta.class);
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }    
}