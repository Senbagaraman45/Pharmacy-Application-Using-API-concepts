package com.example.PharmacyManagement.controller;

import com.example.PharmacyManagement.entity.Purchase;
import com.example.PharmacyManagement.exception.ApiException;
import com.example.PharmacyManagement.exception.GlobalExceptionHandler;
import com.example.PharmacyManagement.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/purchase")
public class PurchaseController {
    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }
//    @PostMapping("/store")
//    public ResponseEntity<Purchase>add_order(@RequestBody Purchase purchase){
////        return new ResponseEntity<>(purchaseService.addOrder(purchase),HttpStatus.CREATED);
//        Purchase newOrder = purchaseService.addOrder(purchase);
//        if (newOrder != null) {
//            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    //    @PostMapping("/store")
//    public ResponseEntity<?>add_order(Purchase purchase){
//        try {
//            ResponseEntity<?> response = purchaseService.addOrder(purchase);
//            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred");
//        }
//    }
    @GetMapping("/list")
    public ResponseEntity<List<Purchase>> findAllPurchase(){
        List<Purchase> purchaseList = purchaseService.findAllPurchase();
        return ResponseEntity.ok(purchaseList);
    }

    @GetMapping("/purchaseList")
    public String list_purchase(Model model) {
        List<Purchase> purchaseList = purchaseService.listPurchase();
        model.addAttribute("thePurchase", purchaseList);
        return "purchase";
    }

    @GetMapping("/addPurchase")
    public String add_purchase(Model model) {
        Purchase purchase = new Purchase();
        model.addAttribute("tempPurchase", purchase);
        return "addPurchase";
    }

    @PostMapping("/save")
    public String savePurchase(@ModelAttribute("tempPurchase") Purchase purchase){
        purchaseService.addOrder(purchase);
        return "redirect:/api/purchase/purchaseList";
    }

//    @PostMapping("/store")
//    public String savePurchase(@ModelAttribute("tempPurchase") Purchase purchase) throws ExceptionThrow{
//        String response=purchaseService.addOrder(purchase);
//        return response;
//    }

    @PostMapping("/add")
    public ResponseEntity<Object> addPurchase(@RequestBody Purchase purchase) {
        try {
            Purchase order = purchaseService.addOrder(purchase);
            return ResponseEntity.ok(order);
        } catch (ApiException ex) {
            GlobalExceptionHandler.ErrorMessage errorMessage = new GlobalExceptionHandler.ErrorMessage(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
}
