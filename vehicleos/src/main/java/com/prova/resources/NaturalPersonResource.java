package com.prova.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.domains.dtos.NaturalPersonDTO;
import com.prova.services.NaturalPersonService;

@RestController
@RequestMapping(value = "/naturalperson")
public class NaturalPersonResource {
    
    @Autowired
    private NaturalPersonService natService;

    @GetMapping //http://localhost:8080/naturalperson
    public ResponseEntity<List<NaturalPersonDTO>> findAll(){
        return ResponseEntity.ok().body(natService.findAll());
    }
}