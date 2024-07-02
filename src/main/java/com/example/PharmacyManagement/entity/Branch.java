package com.example.PharmacyManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name="branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "branch_location")
    private String branchLocation;
    @Column(name="branch_phone")
    private String branchPhone;

    public Branch(){

    }

    public Branch(String branchLocation, String branchPhone) {
        this.branchLocation = branchLocation;
        this.branchPhone = branchPhone;
    }

    public Branch(Long id,String branchLocation, String branchPhone) {
        this.id=id;
        this.branchLocation=branchLocation;
        this.branchPhone=branchPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getBranchPhone() {
        return branchPhone;
    }

    public void setBranchPhone(String branchPhone) {
        this.branchPhone = branchPhone;
    }


}
