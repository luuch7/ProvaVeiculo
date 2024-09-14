package com.prova.domains;

import java.util.UUID;

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
    
}