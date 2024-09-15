package com.prova.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.domains.dtos.LegalEntityDTO;
import com.prova.services.LegalEntityService;

@RestController
@RequestMapping(value = "/legalentity")
public class LegalEntityResource {
    
    @Autowired
    private LegalEntityService legalService;

    @GetMapping //http://localhost:8080/legalentity
    public ResponseEntity<List<LegalEntityDTO>> findAll(){
        return ResponseEntity.ok().body(legalService.findAll());
    }
}