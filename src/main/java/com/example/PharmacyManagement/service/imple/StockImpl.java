package com.example.PharmacyManagement.service.imple;

import com.example.PharmacyManagement.dao.StockDao;
import com.example.PharmacyManagement.entity.Stock;
import com.example.PharmacyManagement.exception.ApiException;
import com.example.PharmacyManagement.repository.StockRepository;
import com.example.PharmacyManagement.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockImpl implements StockService {
    private StockRepository stockRepository;


    @Autowired
    public StockImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock addStock(Stock stock) {
        stockRepository.save(stock);
        return stock;
    }

    @Override
    public Stock getBranchIdAndMedicine(Long branchId, String medicine)  {
        Stock s=stockRepository.findByBranchIdAndMedicine(branchId, medicine);
        return s;
    }

    @Override
    public List<Stock> getBranchDetails()  {
        return stockRepository.findAll();
    }

    @Override
    public List<Stock> getStockFromBranch(Long branchId){
//         Stock stock=stockRepository.findByBranchId(branchId);
//         return stock;
        return stockRepository.findByBranchId(branchId);
    }

    @Override
    public List<Stock> listStock() {
        return stockRepository.findAll();
    }

    @Override
    public void saveStock(Stock stock) {
        stockRepository.save(stock);
    }


}
