package com.example.PharmacyManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "branch_id")
    private long branchId;
    @Column(name="medicine")
    private String medicine;
    @Column(name="quantity")
    private int qty;
    @Column(name="price")
    private double price;

    public Stock(Long id, long branchId, String medicine, int qty, double price) {
        this.id = id;
        this.branchId = branchId;
        this.medicine = medicine;
        this.qty = qty;
        this.price = price;
    }

    public Stock(){

    }
    public Stock(long branchId, String medicine, int qty, double price) {
        this.branchId = branchId;
        this.medicine = medicine;
        this.qty = qty;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
