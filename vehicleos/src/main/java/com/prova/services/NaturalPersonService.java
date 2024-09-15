package com.prova.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.dtos.NaturalPersonDTO;
import com.prova.repositories.NaturalPersonRepository;

@Service
public class NaturalPersonService {
    
    @Autowired
    private NaturalPersonRepository natRepo;

    public List<NaturalPersonDTO> findAll(){
        return natRepo.findAll().stream().map(obj -> new NaturalPersonDTO(obj)).collect(Collectors.toList());
    }
}