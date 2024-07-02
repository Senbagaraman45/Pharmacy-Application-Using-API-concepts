package com.example.PharmacyManagement.service.imple;

import com.example.PharmacyManagement.dao.BranchDao;
import com.example.PharmacyManagement.entity.Branch;
import com.example.PharmacyManagement.exception.ApiException;
import com.example.PharmacyManagement.repository.BranchRepository;
import com.example.PharmacyManagement.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchImpl implements BranchService {
    private BranchRepository branchRepository;

    @Autowired
    public BranchImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch addBranch(Branch branch){
        Branch branches=branchRepository.findBybranchPhone(branch.getBranchPhone());
        if(branches==null){
            branchRepository.save(branch);
            return branch;
        }else{
            throw new ApiException("Branch Id already assigned", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Branch> getAllBranchDetails(){
        return branchRepository.findAll();
    }

    @Override
    public void deleteBranch(Long id) {
        Optional<Branch> branch=branchRepository.findById(id);
        if(branch.isEmpty()){
            throw new ApiException("Invalid Branch Id",HttpStatus.BAD_REQUEST);
        }else{
            branchRepository.deleteById(id);
        }
    }

    @Override
    public List<Branch> listBranch() {
        return branchRepository.findAll();
    }

    @Override
    public void saveBranch(Branch branch) {
        Branch branch1=BranchDao.add_branch(branch);
        branchRepository.save(branch1);
    }
}
