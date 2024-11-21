package com.prova.services;

import com.prova.domains.*;
import com.prova.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.prova.domains.enums.VehicleType;

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

    @Autowired
    private NaturalPersonRepository natuRepo;

    @Autowired LegalEntityRepository legalRepo;

    @Autowired
    private PasswordEncoder encoder;

    public void initDB(){
        
        Address ad1 = new Address(1, "Rua Tal", 67, "Estado tal", "123.456-11", "Bairro Tal", "País tal");
        
        Vehicle vehicle1 = new Vehicle(1, "Carro tal", "Marca tal", "123", "1999", "Branco Escuro", "456", "Gasolina", 1200.00, VehicleType.CAR);
        //ARRUMAR SAMERDA
        Purchase purchase1 = new Purchase(null, "codigo tal", "Observação Tal", null, vehicle1);

        Client client1 = new Client(null, "Fulano", "123.123.123-00", "fulano@email.com", encoder.encode("senha123"), "11/09/199", "12345678");

        NaturalPerson natu1 = new NaturalPerson(null, "Alberto", "456.456.456-78", "alberto@email.com", encoder.encode("super@123"), "11/09/2001", "17 123451234");
        LegalEntity leg1 = new LegalEntity(null, "Yuri", "789.789.789-99", "yuri@email.com", encoder.encode("super@456"), "17/09/1999", "12 1234-1234");
        adressRepo.save(ad1);
        vehicleRepo.save(vehicle1);
        purchaseRepo.save(purchase1);
        clientRepo.save(client1);
        natuRepo.save(natu1);
        legalRepo.save(leg1);
    }
}