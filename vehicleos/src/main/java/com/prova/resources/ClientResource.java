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

import com.prova.domains.Client;
import com.prova.domains.LegalEntity;
import com.prova.domains.dtos.ClientDTO;
import com.prova.domains.dtos.LegalEntityDTO;
import com.prova.services.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

    @Autowired
    private ClientService clientServ;

     @GetMapping //http://localhost:8080/legalentity
    public ResponseEntity<List<ClientDTO>> findAll(){
        return ResponseEntity.ok().body(clientServ.findAll());
    }

    //to meio louco se der erro é aq
    @GetMapping(value = "/{id}") //http://localhost:8080/legalentity/1
    public ResponseEntity<ClientDTO> findById(@PathVariable UUID id){
        Client obj = this.clientServ.findById(id);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO objDto){
        Client newObj = clientServ.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable UUID id, @Valid @RequestBody ClientDTO objDto){
        Client obj = clientServ.update(id, objDto);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable UUID id){
        clientServ.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}