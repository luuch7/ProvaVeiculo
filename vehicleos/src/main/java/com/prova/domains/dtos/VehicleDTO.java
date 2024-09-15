package com.prova.domains.dtos;

import com.prova.domains.Vehicle;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VehicleDTO {
    
    protected long id;
        @NotNull(message = "o Campo name não pode ser nulo")
    @NotBlank(message = "O campo name não pode ser vazio")
    protected String name;
    @NotNull(message = "o Campo brand não pode ser nulo")
    @NotBlank(message = "O campo brand não pode ser vazio")
    protected String brand;
    @NotNull(message = "o Campo plate não pode ser nulo")
    @NotBlank(message = "O campo plate não pode ser vazio")
    protected String plate;
    @NotNull(message = "o Campo Year Vehicle não pode ser nulo")
    @NotBlank(message = "O campo Year Vehicle não pode ser vazio")
    protected String yearVehicle;
    @NotNull(message = "o Campo Color não pode ser nulo")
    @NotBlank(message = "O campo Color não pode ser vazio")
    protected String color;
    @NotNull(message = "o Campo Document não pode ser nulo")
    @NotBlank(message = "O campo Document não pode ser vazio")
    protected String document;
    @NotNull(message = "o Campo FuelType não pode ser nulo")
    @NotBlank(message = "O campo FuelType não pode ser vazio")
    protected String fuelType;
    @NotNull(message = "o Campo price não pode ser nulo")
    @NotBlank(message = "O campo price não pode ser vazio")
    protected double price;
    
    
    public VehicleDTO() {
    }


    public VehicleDTO(Vehicle obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.brand = obj.getBrand();
        this.plate = obj.getPlate();
        this.yearVehicle = obj.getYearVehicle();
        this.color = obj.getColor();
        this.document = obj.getDocument();
        this.fuelType = obj.getFuelType();
        this.price = obj.getPrice();
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getPlate() {
        return plate;
    }


    public void setPlate(String plate) {
        this.plate = plate;
    }


    public String getYearVehicle() {
        return yearVehicle;
    }


    public void setYearVehicle(String yearVehicle) {
        this.yearVehicle = yearVehicle;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public String getDocument() {
        return document;
    }


    public void setDocument(String document) {
        this.document = document;
    }


    public String getFuelType() {
        return fuelType;
    }


    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}