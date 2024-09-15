package com.prova.domains.dtos;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PurchaseDTO {
    
    protected UUID id;
    protected String saleCode;
    protected String transactionMethod;
    protected String observation;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate date = LocalDate.now();
    
    public PurchaseDTO() {
    }

    public PurchaseDTO(UUID id, String saleCode, String transactionMethod, String observation, LocalDate date) {
        this.id = id;
        this.saleCode = saleCode;
        this.transactionMethod = transactionMethod;
        this.observation = observation;
        this.date = date;
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