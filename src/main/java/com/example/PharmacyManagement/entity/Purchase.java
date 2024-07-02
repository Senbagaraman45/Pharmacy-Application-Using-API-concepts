package com.example.PharmacyManagement.entity;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name="purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    @Column(name="customer_id")
    private Long customerId;
    @Column(name = "branch_id")
    private Long branchId;
    @Column(name="medicine")
    private String medicine;
    @Column(name="quantity")
    private int qty;
    @Column(name="purchase_amount")
    private double amount;

    public Purchase(Long order_id, Long customerId, Long branchId, String medicine, int qty,double amount) {
        this.order_id = order_id;
        this.customerId = customerId;
        this.branchId = branchId;
        this.medicine = medicine;
        this.qty = qty;
        this.amount=amount;
    }
    public Purchase(Long customerId, Long branchId, String medicine, int qty) {
        this.customerId = customerId;
        this.branchId = branchId;
        this.medicine = medicine;
        this.qty = qty;
    }
    public Purchase(){

    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
