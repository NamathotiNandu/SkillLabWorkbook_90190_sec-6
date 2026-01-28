package com.nandu.app;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.nandu.util.HibernateUtil;
import com.nandu.entity.Product;

import java.util.List;

public class HQLDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // 1. Sort by price ASC
        Query<Product> q1 = session.createQuery(
                "FROM Product p ORDER BY p.price ASC", Product.class);
        System.out.println("Price ASC: " + q1.list());

        // 2. Sort by price DESC
        Query<Product> q2 = session.createQuery(
                "FROM Product p ORDER BY p.price DESC", Product.class);
        System.out.println("Price DESC: " + q2.list());

        // 3. Sort by quantity DESC
        Query<Product> q3 = session.createQuery(
                "FROM Product p ORDER BY p.quantity DESC", Product.class);
        System.out.println("Quantity DESC: " + q3.list());

        // 4. Pagination (first 3)
        Query<Product> q4 = session.createQuery("FROM Product", Product.class);
        q4.setFirstResult(0);
        q4.setMaxResults(3);
        System.out.println("First 3: " + q4.list());

        // 5. Pagination (next 3)
        Query<Product> q5 = session.createQuery("FROM Product", Product.class);
        q5.setFirstResult(3);
        q5.setMaxResults(3);
        System.out.println("Next 3: " + q5.list());

        // 6. Aggregate – count
        Long total = (Long) session.createQuery(
                "SELECT COUNT(p) FROM Product p").uniqueResult();
        System.out.println("Total products: " + total);

        // 7. Min & Max price
        Object[] minMax = (Object[]) session.createQuery(
                "SELECT MIN(p.price), MAX(p.price) FROM Product p").uniqueResult();
        System.out.println("Min price: " + minMax[0]);
        System.out.println("Max price: " + minMax[1]);

        session.close();
    }
}
