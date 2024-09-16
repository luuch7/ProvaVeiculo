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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/purchase")
@Tag(name = "Purchase", description = "API de gerenciamento de Purchase")
public class PurchaseResource {
    
    @Autowired
    private PurchaseService purchServ;

    @Operation(summary = "Listar todos", description = "Retorna uma lista com todos os dados")
    @GetMapping //http://localhost:8080/address
    public ResponseEntity<List<PurchaseDTO>> findAll(){
        return ResponseEntity.ok().body(purchServ.findAll());
    }

    @Operation(summary = "Busca por ID", description = "Retorna dados com base no ID fornecido")
    @GetMapping(value = "/{id}") //http://localhost:8080/legalentity/1
    public ResponseEntity<PurchaseDTO> findById(@PathVariable UUID id){
        Purchase obj = this.purchServ.findById(id);
        return ResponseEntity.ok().body(new PurchaseDTO(obj));
    }

    @Operation(summary = "Cria um novo item", description = "Cria um novo item com base nos dados fornecidos")
    @PostMapping
    public ResponseEntity<PurchaseDTO> create(@Valid @RequestBody PurchaseDTO objDto){
        Purchase newObj = purchServ.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualiza dados", description = "Atualiza os dado existente com base no id fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<PurchaseDTO> update(@PathVariable UUID id, @Valid @RequestBody PurchaseDTO objDto){
        Purchase obj = purchServ.update(id, objDto);
        return ResponseEntity.ok().body(new PurchaseDTO(obj));
    }

    @Operation(summary = "Deleta um item", description = "Remove um item existem com base no ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PurchaseDTO> delete(@PathVariable UUID id){
        purchServ.delete(id);
        return ResponseEntity.noContent().build();
    }
}