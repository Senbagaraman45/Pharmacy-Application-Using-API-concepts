package com.example.PharmacyManagement.service;

import com.example.PharmacyManagement.entity.Stock;

import java.util.List;

public interface StockService {
    Stock addStock(Stock stock) ;

    public Stock getBranchIdAndMedicine(Long branchId,String medicine);

    List<Stock> getBranchDetails();
    
    public List<Stock> getStockFromBranch(Long branchId);

    List<Stock> listStock();

    void saveStock(Stock stock);

}
