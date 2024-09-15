package com.prova.domains.dtos;

public class VehicleDTO {
    
    protected long id;
    protected String name;
    protected String brand;
    protected String palte;
    protected int year;
    protected String color;
    protected String document;
    protected String fuelType;
    protected double price;
    
    
    public VehicleDTO() {
    }


    public VehicleDTO(long id, String name, String brand, String palte, int year, String color, String document,
            String fuelType, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.palte = palte;
        this.year = year;
        this.color = color;
        this.document = document;
        this.fuelType = fuelType;
        this.price = price;
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


    public String getPalte() {
        return palte;
    }


    public void setPalte(String palte) {
        this.palte = palte;
    }


    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
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