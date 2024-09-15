package com.prova.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.Address;
import com.prova.domains.Client;
import com.prova.domains.purchase;
import com.prova.domains.Vehicle;
import com.prova.domains.dtos.PurchaseDTO;
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
    private VehicleRepository vehicleRepo;

    @Autowired
    private PurchaseRepository purchaseRepo;

    @Autowired
    private ClientRepository clientRepo;

    public void initDB(){
        
        Address ad1 = new Address(1, "Rua Tal", 67, "Estado tal", "123.456-11", "Bairro Tal", "País tal");
        
        Vehicle vehicle1 = new Vehicle(1, "Carro tal", "Marca tal", "123", "1999", "Branco Escuro", "456", "Gasolina", 1200.00, VehicleType.CAR);
        //ARRUMAR SAMERDA
        purchase purchase1 = new purchase(null, "codigo tal", "Observação Tal", null, vehicle1);

        Client client1 = new Client(null, "Fulano", "123.123.123-00", "fulano@email.com", "senha123", "11/09/199", "12345678");

        adressRepo.save(ad1);
        vehicleRepo.save(vehicle1);
        purchaseRepo.save(purchase1);
        clientRepo.save(client1);
    }
}