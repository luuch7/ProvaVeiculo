package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.prova.domains.Address;
import com.prova.domains.dtos.AddressDTO;
import com.prova.repositories.AdressRepository;
import com.prova.services.exceptions.ObjectNotFoundException;

@Service
public class AddressService {

    private AdressRepository AddRepo;

    public List<AddressDTO> findAll(){
        return AddRepo.findAll().stream().map(obj -> new AddressDTO(obj)).collect(Collectors.toList());
    }

    public Address findById(int id){
        Optional<Address> obj = AddRepo.findById(id); //acho q ta certo
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
    }

    public Address create(AddressDTO objDto){
        objDto.setId(+1);//isso aqui foi baianagem mais se der certo boa
        Address newObj = new Address(objDto);
        return AddRepo.save(newObj);
    }
}
