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

import com.prova.domains.Purchase;
import com.prova.domains.dtos.PurchaseDTO;
import com.prova.services.PurchaseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseResource {
    
    @Autowired
    private PurchaseService purchServ;

    @GetMapping //http://localhost:8080/address
    public ResponseEntity<List<PurchaseDTO>> findAll(){
        return ResponseEntity.ok().body(purchServ.findAll());
    }

    @GetMapping(value = "/{id}") //http://localhost:8080/legalentity/1
    public ResponseEntity<PurchaseDTO> findById(@PathVariable UUID id){
        Purchase obj = this.purchServ.findById(id);
        return ResponseEntity.ok().body(new PurchaseDTO(obj));
    }

    @PostMapping
    public ResponseEntity<PurchaseDTO> create(@Valid @RequestBody PurchaseDTO objDto){
        Purchase newObj = purchServ.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PurchaseDTO> update(@PathVariable UUID id, @Valid @RequestBody PurchaseDTO objDto){
        Purchase obj = purchServ.update(id, objDto);
        return ResponseEntity.ok().body(new PurchaseDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PurchaseDTO> delete(@PathVariable UUID id){
        purchServ.delete(id);
        return ResponseEntity.noContent().build();
    }
}