package com.prova.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

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

import com.prova.domains.NaturalPerson;
import com.prova.domains.dtos.NaturalPersonDTO;
import com.prova.services.NaturalPersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/naturalperson")
public class NaturalPersonResource {
    
    @Autowired
    private NaturalPersonService natService;

    @GetMapping //http://localhost:8080/naturalperson
    public ResponseEntity<List<NaturalPersonDTO>> findAll(){
        return ResponseEntity.ok().body(natService.findAll());
    }

    @GetMapping(value = "/{id}") //http://localhost:8080/naturalperson/1
    public ResponseEntity<NaturalPersonDTO> findById(@PathVariable UUID id){
        NaturalPerson obj = this.natService.findById(id);
        return ResponseEntity.ok().body(new NaturalPersonDTO(obj));
    }

    @GetMapping(value = "/cpfcnpj/{cpfcnpj}") //http://localhost:8080/naturalperson/cpfcnpj/(numero do cpfCnpj)
    public ResponseEntity<NaturalPersonDTO> findByCpfCnpj(@PathVariable String cpfcnpj){
        NaturalPerson obj = this.natService.findByCpfCnpj(cpfcnpj);
        return ResponseEntity.ok().body(new NaturalPersonDTO(obj));
    }

    //Estou ficando louco HAHAHAHAHAHAYHHAHAHAAHAHHAAHAHA
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<NaturalPersonDTO> findByEmail(@PathVariable String email){
        NaturalPerson obj = this.natService.findByEmail(email);
        return ResponseEntity.ok().body(new NaturalPersonDTO(obj));
    }
    
    @PostMapping
    public ResponseEntity<NaturalPersonDTO> create(@Valid @RequestBody NaturalPersonDTO objDto){
        NaturalPerson newObj = natService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<NaturalPersonDTO> update(@PathVariable UUID id, @Valid @RequestBody NaturalPersonDTO objDto){
        NaturalPerson obj = natService.update(id, objDto);
        return ResponseEntity.ok().body(new NaturalPersonDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<NaturalPersonDTO> delete(@PathVariable UUID id){
        natService.delete(id);
        return ResponseEntity.noContent().build();
    }
}