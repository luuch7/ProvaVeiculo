package com.prova.domains.dtos;

import com.prova.domains.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddressDTO {
   
    
    protected int id;

    @NotNull(message = "o Campo street não pode ser nulo")
    @NotBlank(message = "O campo street não pode ser vazio")
    protected String street;
    @NotNull(message = "o Campo number não pode ser nulo")
    @NotBlank(message = "O campo number não pode ser vazio")
    protected int number;
    @NotNull(message = "o Campo state não pode ser nulo")
    @NotBlank(message = "O campo state não pode ser vazio")
    protected String state;
    @NotNull(message = "o Campo zipcode não pode ser nulo")
    @NotBlank(message = "O campo zipcode não pode ser vazio")
    protected String zipCode;
    @NotNull(message = "o Campo neighborhood não pode ser nulo")
    @NotBlank(message = "O campo neighborhood não pode ser vazio")
    protected String neighborhood;
    @NotNull(message = "o Campo country não pode ser nulo")
    @NotBlank(message = "O campo country não pode ser vazio")
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