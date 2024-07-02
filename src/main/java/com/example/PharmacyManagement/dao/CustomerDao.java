package com.example.PharmacyManagement.dao;


import com.example.PharmacyManagement.entity.Customer;

public class CustomerDao {
    public static Customer add_customer(Customer customer){
        Customer cust=new Customer(
                customer.getId(),
                customer.getCustomerName(),
                customer.getCustomerPhone()
        );
        return cust;
    }
}
