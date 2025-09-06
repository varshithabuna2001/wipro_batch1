package com.wipro.hibernet.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
 private static final SessionFactory SESSION_FACTORY = build();

 private static SessionFactory build() {
     try {
         Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
         cfg.addAnnotatedClass(com.wipro.hibernet.entity.Pan.class); // <-- important
         ServiceRegistry sr = new StandardServiceRegistryBuilder()
                 .applySettings(cfg.getProperties()).build();
         return cfg.buildSessionFactory(sr);
     } catch (Throwable ex) {
         throw new RuntimeException("SessionFactory build failed: " + ex.getMessage(), ex);
     }
 }
 public static SessionFactory getSessionFactory() { return SESSION_FACTORY; }
}
