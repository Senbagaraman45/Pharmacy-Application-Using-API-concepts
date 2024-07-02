package com.example.PharmacyManagement.dao;

import com.example.PharmacyManagement.entity.Branch;

public class BranchDao {

    public static Branch add_branch(Branch branch){
        Branch branch1=new Branch(
                branch.getId(),
                branch.getBranchLocation(),
                branch.getBranchPhone()
        );
        return branch1;
    }
}
