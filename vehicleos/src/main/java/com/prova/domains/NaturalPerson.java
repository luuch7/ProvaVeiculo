package com.prova.domains;

import java.util.UUID;

public class NaturalPerson extends Client {
    
    //se der bom  é o private
    private NaturalPerson naturalPerson;

    public NaturalPerson(UUID id, String name, String cpfCnpj, String email, String password, String dateBirth,
            String phoneNumber) {
        super(id, name, cpfCnpj, email, password, dateBirth, phoneNumber);
    }

    public NaturalPerson(){
        super();
    }

    public NaturalPerson getNaturalPerson() {
        return naturalPerson;
    }

    public void setNaturalPerson(NaturalPerson naturalPerson) {
        this.naturalPerson = naturalPerson;
    }

    
}