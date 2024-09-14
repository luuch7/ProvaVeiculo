package com.prova.domains;

import java.util.UUID;

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

    
    
}