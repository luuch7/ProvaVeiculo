package com.prova.domains.dtos;

import java.time.LocalDate;
import java.util.UUID;

import com.prova.domains.Purchase;


public class PurchaseDTO {
    
    protected UUID id;
    protected String saleCode;
    protected String transactionMethod;
    protected String observation;
    protected LocalDate date = LocalDate.now();
    
    public PurchaseDTO() {
    }

    //refazer os construtor
    public PurchaseDTO(Purchase obj) {
        this.id = obj.getId();
        this.saleCode = obj.getSaleCode();
        this.transactionMethod = obj.getTransactionMethod();
        this.observation = obj.getObservation();
        this.date = obj.getDate();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public String getTransactionMethod() {
        return transactionMethod;
    }

    public void setTransactionMethod(String transactionMethod) {
        this.transactionMethod = transactionMethod;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    

}