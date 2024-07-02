package com.example.PharmacyManagement.dao;

import com.example.PharmacyManagement.entity.Stock;

public class StockDao {
    public static Stock add_stock(Stock stock){
        Stock items=new Stock(
                stock.getId(),
                stock.getBranchId(),
                stock.getMedicine(),
                stock.getQty(),
                stock.getPrice()
        );
        return items;
    }
    public static Stock show_stock(Stock stock){
        Stock s=new Stock(
                stock.getId(),
                stock.getBranchId(),
                stock.getMedicine(),
                stock.getQty(),
                stock.getPrice()
        );
        return s;
    }
}
