package com.prova.domains.dtos;

import com.prova.domains.Vehicle;

public class VehicleDTO {
    
    protected long id;
    protected String name;
    protected String brand;
    protected String plate;
    protected String yearVehicle;
    protected String color;
    protected String document;
    protected String fuelType;
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