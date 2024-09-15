package com.prova.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.dtos.LegalEntityDTO;
import com.prova.repositories.LegalEntityRepository;

@Service
public class LegalEntityService {
    
    @Autowired
    private LegalEntityRepository legalRepo;

    public List<LegalEntityDTO> findAll(){
        return legalRepo.findAll().stream().map(obj -> new LegalEntityDTO(obj)).collect(Collectors.toList());
    }
}