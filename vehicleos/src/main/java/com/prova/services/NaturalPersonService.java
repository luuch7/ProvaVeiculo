package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.NaturalPerson;
import com.prova.domains.dtos.NaturalPersonDTO;
import com.prova.repositories.NaturalPersonRepository;
import com.prova.services.exceptions.ObjectNotFoundException;

@Service
public class NaturalPersonService {
    
    @Autowired
    private NaturalPersonRepository natRepo;

    public List<NaturalPersonDTO> findAll(){
        return natRepo.findAll().stream().map(obj -> new NaturalPersonDTO(obj)).collect(Collectors.toList());
    }

    public NaturalPerson findById(UUID id){
        Optional<NaturalPerson> obj = natRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
    }

    public NaturalPerson findByCpfCnpj(String cpfCnpj){
        Optional<NaturalPerson> obj = natRepo.findByCpfCnpj(cpfCnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+cpfCnpj));
    }

    public NaturalPerson create(NaturalPersonDTO objDto){
        objDto.setId(null);
        NaturalPerson newObj = new NaturalPerson(objDto);
        return natRepo.save(newObj);
    }
}