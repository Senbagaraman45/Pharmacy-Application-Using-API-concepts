package com.example.PharmacyManagement.dao;

import com.example.PharmacyManagement.entity.Purchase;

public class PurchaseDao {
    public static Purchase add_purchase(Purchase purchase){
        Purchase order=new Purchase(
                purchase.getOrder_id(),
                purchase.getCustomerId(),
                purchase.getBranchId(),
                purchase.getMedicine(),
                purchase.getQty(),
                purchase.getAmount()
        );
        return order;
    }
}
