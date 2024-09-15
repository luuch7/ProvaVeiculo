package com.prova.domains;

import java.util.UUID;

import com.prova.domains.dtos.NaturalPersonDTO;
import com.prova.domains.enums.ClientType;

import jakarta.persistence.Entity;

@Entity
public class NaturalPerson extends Client {

    public NaturalPerson(UUID id, String name, String cpfCnpj, String email, String password, String dateBirth,
            String phoneNumber) {
        super(id, name, cpfCnpj, email, password, dateBirth, phoneNumber);
        addClientType(ClientType.NATURAL_PERSON);
    }

    public NaturalPerson(){
        super();
        addClientType(ClientType.NATURAL_PERSON);
    }

    public NaturalPerson(NaturalPersonDTO obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpfCnpj = obj.getCpfCnpj();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.dateBirth = obj.getDateBirth();
        this.phoneNumber = obj.getPhoneNumber();
        addClientType(ClientType.NATURAL_PERSON);
        addClientType(ClientType.LEGAL_ENTITY);
    }
    
}