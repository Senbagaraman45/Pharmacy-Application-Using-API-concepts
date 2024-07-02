package com.example.PharmacyManagement.service;

import com.example.PharmacyManagement.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    List<Customer> findAllCustomer();

    List<Customer>listCustomer();

    void saveCustomer(Customer customer);
}
