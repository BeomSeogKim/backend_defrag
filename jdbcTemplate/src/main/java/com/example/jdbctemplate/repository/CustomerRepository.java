package com.example.jdbctemplate.repository;

import com.example.jdbctemplate.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Customer save(Customer customer);

    void update(Long customerId, CustomerUpdateDto updateParam);

    Optional<Customer> findById(Long customerId);

    List<Customer> findAll();



}
