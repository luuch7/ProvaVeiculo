package com.prova.domains;

import java.util.UUID;

import jakarta.persistence.Entity;
import java.util.List;

@Entity
public class LegalEntity extends Client{
    
    //se der bo é esse private
    private List<Client> clients;

    public LegalEntity(){
        super();
    }

    public LegalEntity(UUID id, String name, String cpfCnpj, String email, String password, String dateBirth,
            String phoneNumber) {
        super(id, name, cpfCnpj, email, password, dateBirth, phoneNumber);
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    
}