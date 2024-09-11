package com.prova.domains;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "legal_entity")
public class LegalEntity extends Client{
    
    //se der bo é esse private
    private Client client;

    public LegalEntity(){
        super();
    }

    public LegalEntity(UUID id, String name, String cpfCnpj, String email, String password, String dateBirth,
            String phoneNumber, Address address) {
        super(id, name, cpfCnpj, email, password, dateBirth, phoneNumber, address);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
}