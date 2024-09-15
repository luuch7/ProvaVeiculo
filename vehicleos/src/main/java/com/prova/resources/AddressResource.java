package com.prova.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova.domains.dtos.AddressDTO;
import com.prova.domains.dtos.LegalEntityDTO;
import com.prova.services.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {
    
    @Autowired
    private AddressService adressServ;

    @GetMapping //http://localhost:8080/address
    public ResponseEntity<List<AddressDTO>> findAll(){
        return ResponseEntity.ok().body(adressServ.findAll());
    }

}