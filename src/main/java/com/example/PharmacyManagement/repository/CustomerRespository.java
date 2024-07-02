package com.example.PharmacyManagement.repository;

import com.example.PharmacyManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRespository extends JpaRepository<Customer,Long> {
    public Customer findBycustomerPhone(String phone);
}
