package com.example.PharmacyManagement.controller;

import com.example.PharmacyManagement.entity.Purchase;
import com.example.PharmacyManagement.entity.Stock;
import com.example.PharmacyManagement.exception.ApiException;
import com.example.PharmacyManagement.exception.GlobalExceptionHandler;
import com.example.PharmacyManagement.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/stock")
public class StockController {
    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    @PostMapping("/add")
    public ResponseEntity<Object>add_stock(@RequestBody Stock stock){
        try {
            Stock stock1 = stockService.addStock(stock);
            return ResponseEntity.ok(stock1);
        } catch (ApiException ex) {
            GlobalExceptionHandler.ErrorMessage errorMessage = new GlobalExceptionHandler.ErrorMessage(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

//    @GetMapping("/{branchId}")
//    public ResponseEntity<Optional<Stock>>get_stock_from_id(@PathVariable Long branchId){
//        return new ResponseEntity<>(stockService.getBranchbyId(branchId),HttpStatus.CREATED);
//    }
    @GetMapping("/{branchId}/{medicine}")
    public ResponseEntity<Stock>getBranchAndMedicine(Long branchId,String medicine){
        Stock stock=stockService.getBranchIdAndMedicine(branchId, medicine);
        return ResponseEntity.ok(stock);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Stock>>get_all_branch(){
        List<Stock>branchList=stockService.getBranchDetails();
        return ResponseEntity.ok(branchList);
    }
    @GetMapping("/stocks/{branchId}")
    public ResponseEntity<List<Stock>> get_stock_from_branchId(@PathVariable Long branchId){
        List<Stock>stock=stockService.getStockFromBranch(branchId);
        if(stock!=null){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        return ResponseEntity.ok(stock);
    }

    @GetMapping("/stockList")
    public String listStock(Model model){
        List<Stock>stockList=stockService.listStock();
        model.addAttribute("stock",stockList);
        return "stock";
    }
    @GetMapping("/addStock")
    public String add_branch(Model model){
        Stock theStock=new Stock();
        model.addAttribute("tempStock",theStock);
        return "addStock";
    }
    @PostMapping("/save")
    public String saveBranch(@ModelAttribute ("tempStock")Stock theStock){
        stockService.addStock(theStock);
        return "redirect:/api/stock/stockList";
    }
}
