package com.example.PharmacyManagement.service;

import com.example.PharmacyManagement.entity.Branch;

import java.util.List;


public interface BranchService {

    Branch addBranch(Branch branch);

    List<Branch> getAllBranchDetails();
    void deleteBranch(Long id);

    List<Branch>listBranch();

    void saveBranch(Branch branch);
}
