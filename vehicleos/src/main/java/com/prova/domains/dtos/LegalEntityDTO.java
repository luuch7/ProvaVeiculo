package com.prova.domains.dtos;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.prova.domains.LegalEntity;
import com.prova.domains.enums.ClientType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LegalEntityDTO {
    
    protected UUID id;
        @NotNull(message = "o campo name não pode ser nulo")
    @NotBlank(message = "O campo name não pode ser vazio")
    protected String name;
    @NotNull(message = "o Campo Cpf/Cnpj não pode ser nulo")
    @NotBlank(message = "O campo Cpf/Cnpj não pode ser vazio")
    protected String cpfCnpj;
    @NotNull(message = "o Campo email não pode ser nulo")
    @NotBlank(message = "O campo email não pode ser vazio")
    protected String email;
    @NotNull(message = "o Campo Password não pode ser nulo")
    @NotBlank(message = "O campo Password não podePassword")
    protected String password;
    @NotNull(message = "o Campo Date Birth não pode ser nulo")
    @NotBlank(message = "O campo Date Birth não pode ser vazio")
    protected String dateBirth;
    @NotNull(message = "o Campo Phone Number não pode ser nulo")
    @NotBlank(message = "O campo Phone Number não pode ser vazio")
    protected String phoneNumber;
    @NotNull(message = "o Campo client type não pode ser nulo")
    @NotBlank(message = "O campo client type não pode ser vazio")
    protected Set<Integer> clientType = new HashSet<>();
    
    public LegalEntityDTO() {
    }

    public LegalEntityDTO(LegalEntity obj) {
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