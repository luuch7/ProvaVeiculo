package com.prova.domains;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.prova.domains.enums.VehicleType;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String brand;
    private String palte;
    private int year;
    private String color;

    @Column(unique = true)
    private String document;
    
    private String fuelType;
    private double price;

    //se der erro é aqui :)
     @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tiposveiculos", joinColumns = @JoinColumn(name = "vehicle_id"))
    @Column(name = "vehicle_type")
    private Set<Integer> vehicleType = new HashSet<>();

    public Vehicle() {
        super();
        addVehicleType(null);
    }

    public Vehicle(long id, String name, String brand, String palte, int year, String color, String document,
            String fuelType, double price ) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.palte = palte;
        this.year = year;
        this.color = color;
        this.document = document;
        this.fuelType = fuelType;
        this.price = price;
        addVehicleType(null);
    }

    //get e set vehicletype

    public Set<VehicleType> getVehicleType() {
        return vehicleType.stream().map(x -> VehicleType.toEnum(x)).collect(Collectors.toSet());
    }

    public void addVehicleType(VehicleType vehicleType) {
        this.vehicleType.add(vehicleType.getId());
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

    //get e set

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