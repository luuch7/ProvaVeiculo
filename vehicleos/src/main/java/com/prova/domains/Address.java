package com.prova.domains;

public class Address {
    
    private int id;
    private String street;
    private int number;
    private String state;
    private String zipCode;
    private String neighborhood;
    private String country;
    
    public Address() {
    }

    public Address(int id, String street, int number, String state, String zipCode, String neighborhood,
            String country) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.state = state;
        this.zipCode = zipCode;
        this.neighborhood = neighborhood;
        this.country = country;
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