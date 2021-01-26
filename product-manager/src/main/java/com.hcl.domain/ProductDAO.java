package com.hcl.domain;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAO implements DAO<Product>{

    private SessionFactory factory;

    public ProductDAO() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Product> getAll() {
        return factory.openSession().createQuery("from Product").list();
    }

    @Override
    public Product get(Long id) {
        String query = "FROM Product P WHERE P.id =" + id;
        List<Product> products = factory.openSession().createQuery(query).list();
        if (!products.isEmpty()) {
            return products.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Product add(Product product) {
        Session session = factory.openSession();
        session.beginTransaction();
        Long id = (Long)session.save(product);
        session.getTransaction().commit();
        session.close();
        /**
        String query = "INSERT INTO Product (name, price) VALUES (" + product.getName() +", " + product.getPrice() + ")";
        int result = factory.openSession().createQuery(query).executeUpdate();
        if(result > 0) {
            return true;
        } else {
            return false;
        }
         **/
        return get(id);
    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public List<Long> getIds() {
        return factory.openSession().createQuery("SELECT P.id FROM Product P").list();
    }
}