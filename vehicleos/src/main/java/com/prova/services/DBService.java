package com.prova.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.Address;
import com.prova.domains.Client;
import com.prova.domains.NaturalPerson;
import com.prova.domains.Purchase;
import com.prova.domains.Vehicle;
import com.prova.domains.enums.VehicleType;
import com.prova.repositories.AdressRepository;
import com.prova.repositories.ClientRepository;
import com.prova.repositories.PurchaseRepository;
import com.prova.repositories.VehicleRepository;

@Service
public class DBService {
    
    //Dados gerados automatico
    
    @Autowired
    private AdressRepository adressRepo;

    @Autowired
    private NaturalPerson natuRepo;

    @Autowired
    private VehicleRepository vehicleRepo;

    @Autowired
    private PurchaseRepository purchaseRepo;

    public void initDB(){
        
        Address ad1 = new Address(1, "Rua Tal", 67, "Estado tal", "123.456-11", "Bairro Tal", "País tal");

        NaturalPerson natu1 = new NaturalPerson(null, "Fulano de Tal", "12345678", "fulano@email.com", "admin", "01/01/2001", "11 1111-1111");
        
        Vehicle vehicle1 = new Vehicle(1, "Carro tal", "Marca tal", "123", 1999, "Branco Escuro", "456", "Gasolina", 1999, VehicleType.CAR);

        Purchase purchase1 = new Purchase(null, "codigo tal", "Observação Tal", null, vehicle1);

        adressRepo.save(ad1);
        vehicleRepo.save(vehicle1);
        purchaseRepo.save(purchase1);
        //natuRepo.save(natu1);
    }
}