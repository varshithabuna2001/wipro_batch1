package com.wipro.hibernet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.hibernet.entity.Pan;
import com.wipro.hibernet.util.HibernateUtil;

public class PanApp {
    public static void main(String[] args) {
        Pan p1 = new Pan("Aarav Sharma", "ABCDE1234F");
        Pan p2 = new Pan("Diya Nair",   "PQRSX5678Z");
        Pan p3 = new Pan("Rahul Verma", "LMNOP9012Q");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(p1);
            session.persist(p2);
            session.persist(p3);
            tx.commit();
        }

       
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.createQuery("from Pan", Pan.class)
                   .getResultList()
                   .forEach(System.out::println);
        }

        HibernateUtil.getSessionFactory().close();
    }
}
