package com.prova.domains.dtos;

import com.prova.domains.Address;

public class AddressDTO {
    
    protected int id;
    protected String street;
    protected int number;
    protected String state;
    protected String zipCode;
    protected String neighborhood;
    protected String country;
    
    public AddressDTO() {
    }

    public AddressDTO(Address obj) {
        this.id = obj.getId();
        this.street = obj.getStreet();
        this.number = obj.getNumber();
        this.state = obj.getState();
        this.zipCode = obj.getZipCode();
        this.neighborhood = obj.getNeighborhood();
        this.country = obj.getCountry();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
}