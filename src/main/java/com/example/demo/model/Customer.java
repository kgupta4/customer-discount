/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class Customer {
    private String name;
    private String type;
    private BigDecimal purchaseAmount;
    private BigDecimal billAmount;

    public Customer(String name, String type, BigDecimal purchaseAmount) {
        this.name = name;
        this.type = type;
        this.purchaseAmount = purchaseAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

}
