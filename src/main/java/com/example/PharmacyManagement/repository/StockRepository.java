package com.example.PharmacyManagement.repository;

import com.example.PharmacyManagement.dao.StockDao;
import com.example.PharmacyManagement.entity.Purchase;
import com.example.PharmacyManagement.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock,Long> {
    public Stock findByBranchIdAndMedicine(Long branchId,String medicine);
    public List<Stock> findByBranchId(Long branchId);

}
