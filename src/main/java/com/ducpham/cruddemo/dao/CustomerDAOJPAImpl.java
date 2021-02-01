package com.ducpham.cruddemo.dao;

import com.ducpham.cruddemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CustomerDAOJPAImpl implements CustomerDAO{

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Customer> getCustomer() {
        TypedQuery<Customer> listCus = entityManager.createQuery("from Customer",Customer.class);
        return listCus.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public Customer getTheCustomer(int id) {
        return entityManager.find(Customer.class,id);
    }

    @Override
    public void delete(Customer customer) {
        entityManager.remove(customer);
    }
}
