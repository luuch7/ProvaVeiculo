package com.prova.domains.dtos;

import java.time.LocalDate;
import java.util.UUID;

import com.prova.domains.Purchase;
import com.prova.domains.Vehicle;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class PurchaseDTO {
    
    protected UUID id;
    @NotNull(message = "o Campo Sale code não pode ser nulo")
    @NotBlank(message = "O campo Sale code não pode ser vazio")
    protected String saleCode;
    @NotNull(message = "o Campo Transaction Method não pode ser nulo")
    @NotBlank(message = "O campo Transaction Method não pode ser vazio")
    protected String transactionMethod;
    @NotNull(message = "o Campo Observation não pode ser nulo")
    @NotBlank(message = "O campo Observation não pode ser vazio")
    protected String observation;
    @NotNull(message = "o Campo Local date não pode ser nulo")
    @NotBlank(message = "O campo Local date não podeLocal date")
    protected LocalDate date = LocalDate.now();
    @NotNull(message = "o Campo Vehicle não pode ser nulo")
    @NotBlank(message = "O campo Vehicle não pode ser vazio")
    protected Vehicle vehicle;

    public PurchaseDTO() {
    }

    //refazer os construtor
    public PurchaseDTO(Purchase obj) {
        this.id = obj.getId();
        this.saleCode = obj.getSaleCode();
        this.transactionMethod = obj.getTransactionMethod();
        this.observation = obj.getObservation();
        this.date = obj.getDate();
        this.vehicle = obj.getVehicle();
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