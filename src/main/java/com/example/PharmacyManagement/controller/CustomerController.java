package com.example.PharmacyManagement.controller;

import com.example.PharmacyManagement.entity.Branch;
import com.example.PharmacyManagement.entity.Customer;
import com.example.PharmacyManagement.exception.ApiException;
import com.example.PharmacyManagement.exception.GlobalExceptionHandler;
import com.example.PharmacyManagement.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/add")
    public ResponseEntity<Object>add_customer(@RequestBody Customer customer){
        try {
            Customer c = customerService.addCustomer(customer);
            return ResponseEntity.ok(c);
        } catch (ApiException ex) {
            GlobalExceptionHandler.ErrorMessage errorMessage = new GlobalExceptionHandler.ErrorMessage(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
    @GetMapping("/list")
    public ResponseEntity<List<Customer>>findAllCustomer(){
        List<Customer>customerList=customerService.findAllCustomer();
        return ResponseEntity.ok(customerList);
    }
    @GetMapping("customerList")
    public String list_customer(Model model){
        List<Customer> customers=customerService.listCustomer();
        model.addAttribute("customer",customers);
        return "customer";
    }
    @GetMapping("/addCustomer")
    public String add_branch(Model model){
        Customer customer=new Customer();
        model.addAttribute("tempCustomer",customer);
        return "addCustomer.html";
    }
    @PostMapping("/save")
    public String saveBranch(@ModelAttribute ("tempCustomer")Customer theCustomer){
        customerService.addCustomer(theCustomer);
        return "redirect:/api/customer/customerList";
    }
}
