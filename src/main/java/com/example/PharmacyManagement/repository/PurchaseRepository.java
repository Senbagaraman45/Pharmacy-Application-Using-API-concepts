package com.example.PharmacyManagement.repository;

import com.example.PharmacyManagement.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

}
