package com.prova.domains;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prova.domains.dtos.PurchaseDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase")
public class Purchase{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String saleCode;
    private String transactionMethod;
    private String observation;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date = LocalDate.now();

    //se der erro é aqui
    @ManyToOne
    @JoinColumn(name = "vehiclee")
    private Vehicle vehicle;

    public Purchase() {
    }


    public Purchase(PurchaseDTO obj) {
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

