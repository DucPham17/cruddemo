package com.ducpham.cruddemo.dao;

import com.ducpham.cruddemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomer();

    public void saveCustomer(Customer customer);

    public Customer getTheCustomer(int id);

    public void delete(Customer customer);
}
