package com.prova.domains;

import java.time.LocalDate;
import java.util.UUID;



public class Purchase {

    private UUID id;
    private String saleCode;
    private String transactionMethod;
    private String observation;
    private LocalDate date = LocalDate.now();
    private Vehicle vehicle;

    public Purchase() {
    }


    public Purchase(UUID id, String saleCode, String transactionMethod, String observation, LocalDate date,
            Vehicle vehicle) {
        this.id = id;
        this.saleCode = saleCode;
        this.transactionMethod = transactionMethod;
        this.observation = observation;
        this.date = date;
        this.vehicle = vehicle;
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


    public Vehicle getVehicle() {
        return vehicle;
    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }



}
