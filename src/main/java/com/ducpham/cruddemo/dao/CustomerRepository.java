package com.ducpham.cruddemo.dao;

import com.ducpham.cruddemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
