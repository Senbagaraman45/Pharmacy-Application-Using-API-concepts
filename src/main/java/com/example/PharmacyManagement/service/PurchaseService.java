package com.example.PharmacyManagement.service;

import com.example.PharmacyManagement.entity.Purchase;

import java.util.List;


public interface PurchaseService {
    Purchase addOrder(Purchase purchase);
    List<Purchase> findAllPurchase();

    List<Purchase>listPurchase();

//    void saveOrder(Purchase purchase);

//    ResponseEntity<?>addOrder(Purchase purchase);
}
