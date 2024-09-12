package com.prova.domains;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "natural_person")
public class NaturalPerson extends Client {
    
    //se der bo é o private
    @ManyToOne
    private List<Client> clients;

    public NaturalPerson(UUID id, String name, String cpfCnpj, String email, String password, String dateBirth,
            String phoneNumber, Address address) {
        super(id, name, cpfCnpj, email, password, dateBirth, phoneNumber, address);
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