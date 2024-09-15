package com.prova.domains;

import java.util.UUID;

import com.prova.domains.dtos.LegalEntityDTO;
import com.prova.domains.enums.ClientType;

import jakarta.persistence.Entity;

@Entity
public class LegalEntity extends Client{

    public LegalEntity(){
        super();
        addClientType(ClientType.LEGAL_ENTITY);
    }

    public LegalEntity(UUID id, String name, String cpfCnpj, String email, String password, String dateBirth,
            String phoneNumber) {
        super(id, name, cpfCnpj, email, password, dateBirth, phoneNumber);
        addClientType(ClientType.LEGAL_ENTITY);
    }
    
    public LegalEntity(LegalEntityDTO obj){
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