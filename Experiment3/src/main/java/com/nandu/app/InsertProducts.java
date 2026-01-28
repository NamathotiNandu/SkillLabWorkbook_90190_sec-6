package com.nandu.app;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nandu.entity.Product;
import com.nandu.util.HibernateUtil;

public class InsertProducts {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop", "Electronics", 60000, 5));
        session.save(new Product("Mobile", "Electronics", 30000, 10));
        session.save(new Product("Table", "Furniture", 5000, 3));
        session.save(new Product("Chair", "Furniture", 2500, 8));
        session.save(new Product("Pen", "Stationery", 20, 100));
        session.save(new Product("Notebook", "Stationery", 80, 50));

        tx.commit();
        session.close();

        System.out.println("Products inserted successfully");
    }
}
