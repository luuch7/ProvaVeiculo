package com.prova.resources;

import java.net.URI;
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

import com.prova.domains.Address;
import com.prova.domains.dtos.AddressDTO;
import com.prova.domains.dtos.LegalEntityDTO;
import com.prova.services.AddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {
    
    @Autowired
    private AddressService adressServ;

    @GetMapping //http://localhost:8080/address
    public ResponseEntity<List<AddressDTO>> findAll(){
        return ResponseEntity.ok().body(adressServ.findAll());
    }

    @GetMapping(value = "/{id}") //http://localhost:8080/legalentity/1
    public ResponseEntity<AddressDTO> findById(@PathVariable int id){
        Address obj = this.adressServ.findById(id);
        return ResponseEntity.ok().body(new AddressDTO(obj));
    }

    @PostMapping
    public ResponseEntity<AddressDTO> create(@Valid @RequestBody AddressDTO objDto){
        Address newObj = adressServ.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable int id, @Valid @RequestBody AddressDTO objDto){
        Address obj = adressServ.update(id, objDto);
        return ResponseEntity.ok().body(new AddressDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LegalEntityDTO> delete(@PathVariable int id){
        adressServ.delete(id);
        return ResponseEntity.noContent().build();
    }
}