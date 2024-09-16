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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/address")
@Tag(name = "Address", description = "API de gerenciamento de Address")
public class AddressResource {
    
    @Autowired
    private AddressService adressServ;

    @Operation(summary = "Listar todos", description = "Retorna uma lista com todos os dados")
    @GetMapping //http://localhost:8080/address
    public ResponseEntity<List<AddressDTO>> findAll(){
        return ResponseEntity.ok().body(adressServ.findAll());
    }

    @Operation(summary = "Busca por ID", description = "Retorna dados com base no ID fornecido")
    @GetMapping(value = "/{id}") //http://localhost:8080/legalentity/1
    public ResponseEntity<AddressDTO> findById(@PathVariable int id){
        Address obj = this.adressServ.findById(id);
        return ResponseEntity.ok().body(new AddressDTO(obj));
    }

    @Operation(summary = "Cria um novo item", description = "Cria um novo item com base nos dados fornecidos")
    @PostMapping
    public ResponseEntity<AddressDTO> create(@Valid @RequestBody AddressDTO objDto){
        Address newObj = adressServ.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualiza dados", description = "Atualiza os dado existente com base no id fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable int id, @Valid @RequestBody AddressDTO objDto){
        Address obj = adressServ.update(id, objDto);
        return ResponseEntity.ok().body(new AddressDTO(obj));
    }

    @Operation(summary = "Deleta um item", description = "Remove um item existem com base no ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LegalEntityDTO> delete(@PathVariable int id){
        adressServ.delete(id);
        return ResponseEntity.noContent().build();
    }
}