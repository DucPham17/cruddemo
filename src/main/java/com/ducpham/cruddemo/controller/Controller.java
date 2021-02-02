package com.ducpham.cruddemo.controller;

import com.ducpham.cruddemo.dao.CustomerDAO;
import com.ducpham.cruddemo.dao.CustomerRepository;
import com.ducpham.cruddemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/")
public class Controller {

    @Autowired
    CustomerRepository customerDAO;

    @GetMapping("/customers")
    @Transactional
    public List<Customer> getListCustomer(){
        return customerDAO.findAll();
    }

    @GetMapping("/customers/{id}")
    @Transactional
    public Customer getCustomer(@PathVariable int id){
        return customerDAO.getOne(id);
    }

    @PostMapping("/customers")
    @Transactional
    public void addCustomer(@RequestBody Customer customer){
        customer.setId(0);
        customerDAO.save(customer);
    }

    @DeleteMapping("/customers")
    @Transactional
    public void deleteCustomer(@RequestBody Customer customer){
        customerDAO.delete(customer);
    }

    @PutMapping("/customers")
    @Transactional
    public void putCustomer(@RequestBody Customer customer){
        customerDAO.save(customer);
    }
}
