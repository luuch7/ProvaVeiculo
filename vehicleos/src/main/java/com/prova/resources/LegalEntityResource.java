package com.prova.resources;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova.domains.LegalEntity;
import com.prova.domains.dtos.LegalEntityDTO;
import com.prova.services.LegalEntityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/legalentity")
public class LegalEntityResource {
    
    @Autowired
    private LegalEntityService legalService;

    @GetMapping //http://localhost:8080/legalentity
    public ResponseEntity<List<LegalEntityDTO>> findAll(){
        return ResponseEntity.ok().body(legalService.findAll());
    }

    //to meio louco se der erro é aq
    @GetMapping(value = "/{id}") //http://localhost:8080/legalentity/1
    public ResponseEntity<LegalEntityDTO> findById(@PathVariable UUID id){
        LegalEntity obj = this.legalService.findById(id);
        return ResponseEntity.ok().body(new LegalEntityDTO(obj));
    }
    
    @GetMapping(value = "/cpfcnpj/{cpfCnpj}")
    public ResponseEntity<LegalEntityDTO> findByCpfCnpj(@PathVariable String cpfCnpj){
        LegalEntity obj = this.legalService.findByCpfCnpj(cpfCnpj);
        return ResponseEntity.ok().body(new LegalEntityDTO(obj));
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<LegalEntityDTO> findByEmail(@PathVariable String email){
        LegalEntity obj = this.legalService.findByEmail(email);
        return ResponseEntity.ok().body(new LegalEntityDTO(obj));
    }

    @PostMapping
    public ResponseEntity<LegalEntityDTO> create(@Valid @RequestBody LegalEntityDTO objDto){
        LegalEntity newObj = legalService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}