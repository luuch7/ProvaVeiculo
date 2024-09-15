package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.prova.repositories.AdressRepository;

@Service
public class AddressService {

    private AdressRepository AddRepo;

    public List<AdressDTO> findAll(){
        return AddRepo.findAll().stream().map(obj -> newAdressDTO(obj)).collect(Collectors.toList());
    }

    public Adress findById(int id){
        Optional<Adress>
    }

}
