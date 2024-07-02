package com.example.PharmacyManagement.controller;

import com.example.PharmacyManagement.entity.Branch;
import com.example.PharmacyManagement.entity.Purchase;
import com.example.PharmacyManagement.exception.ApiException;
import com.example.PharmacyManagement.exception.GlobalExceptionHandler;
import com.example.PharmacyManagement.service.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/branch")
public class  BranchController {
    private BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }
    //Add Branch
    @PostMapping("/add")
    public ResponseEntity<Object> add_Branch(@RequestBody Branch branch) {
        try {
            Branch branch1 = branchService.addBranch(branch);
            return ResponseEntity.ok(branch1);
        } catch (ApiException ex) {
            GlobalExceptionHandler.ErrorMessage errorMessage = new GlobalExceptionHandler.ErrorMessage(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
    @GetMapping("/list")
    public ResponseEntity<List<Branch>>get_all_branch(){
        List<Branch>branchList=branchService.getAllBranchDetails();
        return ResponseEntity.ok(branchList);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deletedAccount(@PathVariable Long id){
        branchService.deleteBranch(id);
        return ResponseEntity.ok("Account Deleted");
    }

    @GetMapping("/branchList")
    public String list_branch(Model model) {
        List<Branch> branchList=branchService.listBranch();
        model.addAttribute("theBranch",branchList);
        return "branch";
    }
    @GetMapping("/addBranch")
    public String add_branch(Model model){
        Branch branch=new Branch();
        model.addAttribute("tempBranch",branch);
        return "addBranch.html";
    }
    @PostMapping("/save")
    public String saveBranch(@ModelAttribute ("tempBranch")Branch theBranch){
        branchService.addBranch(theBranch);
        return "redirect:/api/branch/branchList";
    }
}
