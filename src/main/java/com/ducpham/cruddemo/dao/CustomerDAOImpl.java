package com.ducpham.cruddemo.dao;

import com.ducpham.cruddemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Customer> getCustomer() {
        Session curSession = entityManager.unwrap(Session.class);
        Query<Customer> list = curSession.createQuery("from Customer",Customer.class);
        List<Customer> res = list.getResultList();
        return res;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session curSession = entityManager.unwrap(Session.class);
        curSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getTheCustomer(int id) {
        return entityManager.unwrap(Session.class).get(Customer.class,id);
    }

    @Override
    public void delete(Customer customer) {
        entityManager.unwrap(Session.class).delete(customer);
    }
}
