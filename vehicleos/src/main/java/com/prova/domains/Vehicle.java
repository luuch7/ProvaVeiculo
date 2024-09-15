package com.prova.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import com.prova.domains.dtos.VehicleDTO;
import com.prova.domains.enums.VehicleType;

import jakarta.persistence.Column;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String brand;
    private String plate;  // Corrigido de "palte" para "plate"
    private String yearVehicle;
    private String color;

    @Column(unique = true)
    private String document;
    
    private String fuelType;
    private double price;

    private VehicleType vehicleType;

    // Construtor padrão necessário para o Hibernate
    public Vehicle() {
        super();
    }

    public Vehicle(long id, String name, String brand, String plate, String yearVehicle, String color, String document,
            String fuelType, double price, VehicleType vehicleType) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.plate = plate;
        this.yearVehicle = yearVehicle;
        this.color = color;
        this.document = document;
        this.fuelType = fuelType;
        this.price = price;
        this.vehicleType = vehicleType;
    }

    public Vehicle(VehicleDTO obj) {
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

    // Getters e setters
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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehicle other = (Vehicle) obj;
        if (id != other.id)
            return false;
        return true;
    }

    
}
