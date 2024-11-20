package com.prova.domains.dtos;

import java.util.UUID;

import com.prova.domains.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClientDTO {
    
    protected UUID id;
    @NotNull(message = "o Campo name não pode ser nulo")
    @NotBlank(message = "O campo name não pode ser vazio")
    protected String name;
    @NotNull(message = "o Campo cpf/cnpj não pode ser nulo")
    @NotBlank(message = "O campo cpf/cnpj não pode ser vazio")
    protected String cpfCnpj;
    @NotNull(message = "o Campo email não pode ser nulo")
    @NotBlank(message = "O campo email não pode ser vazio")
    protected String email;
    @NotNull(message = "o Campo password não pode ser nulo")
    @NotBlank(message = "O campo password não pode ser vazio")
    protected String password;
    @NotNull(message = "o Campo date Birth não pode ser nulo")
    @NotBlank(message = "O campo date Birth não pode ser vazio")
    protected String dateBirth;
    @NotNull(message = "o Campo Phone number não pode ser nulo")
    @NotBlank(message = "O campo Phone number não pode ser vazio")
    protected String phoneNumber;
    
    public ClientDTO() {
    }

    public ClientDTO(Client obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpfCnpj = obj.getCpfCnpj();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.dateBirth = obj.getDateBirth();
        this.phoneNumber = obj.getPhoneNumber();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    
}