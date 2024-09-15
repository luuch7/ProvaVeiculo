package com.prova.domains.dtos;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.prova.domains.NaturalPerson;
import com.prova.domains.enums.ClientType;

public class NaturalPersonDTO {
    
    protected UUID id;
    protected String name;
    protected String cpfCnpj;
    protected String email;
    protected String password;
    protected String dateBirth;
    protected String phoneNumber;
    protected Set<Integer> clientType = new HashSet<>();
    
    public NaturalPersonDTO() {
    }

    public NaturalPersonDTO(NaturalPerson obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpfCnpj = obj.getCpfCnpj();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.dateBirth = obj.getDateBirth();
        this.phoneNumber = obj.getPhoneNumber();
        this.clientType = obj.getClientType().stream().map(x -> x.getId()).collect(Collectors.toSet());
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

    public Set<ClientType> getClientType() {
        return clientType.stream().map(x -> ClientType.toEnum(x)).collect(Collectors.toSet());
    }

    public void addClientType(ClientType clientType) {
        this.clientType.add(clientType.getId());
    }
}