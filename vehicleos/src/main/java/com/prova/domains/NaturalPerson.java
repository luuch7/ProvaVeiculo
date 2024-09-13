package com.prova.domains;

import java.util.UUID;

import jakarta.persistence.Entity;
import java.util.List;

@Entity
public class NaturalPerson extends Client {
    
    //se der bo é o private
    private List<Client> clients;

    public NaturalPerson(UUID id, String name, String cpfCnpj, String email, String password, String dateBirth,
            String phoneNumber) {
        super(id, name, cpfCnpj, email, password, dateBirth, phoneNumber);
    }

    public NaturalPerson(){
        super();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    
    
}