package com.example.PharmacyManagement.repository;

import com.example.PharmacyManagement.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch,Long> {
    public Branch findBybranchPhone(String phone);
}
