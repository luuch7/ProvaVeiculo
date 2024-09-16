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

import com.prova.domains.Vehicle;
import com.prova.domains.dtos.VehicleDTO;
import com.prova.services.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/vehicle")
@Tag(name = "Vehicle", description = "API de gerenciamento de Vehicle")
public class VehicleResource {
    
    @Autowired
    private VehicleService vService;

    @Operation(summary = "Listar todos", description = "Retorna uma lista com todos os dados")
    @GetMapping //http://localhost:8080/vehicle
    public ResponseEntity<List<VehicleDTO>> findAll(){
        return ResponseEntity.ok().body(vService.findAll());
    }

    @Operation(summary = "Busca por ID", description = "Retorna dados com base no ID fornecido")
    @GetMapping(value = "/{id}") //http://localhost:8080/legalentity/1
    public ResponseEntity<VehicleDTO> findById(@PathVariable long id){
        Vehicle obj = this.vService.findById(id);
        return ResponseEntity.ok().body(new VehicleDTO(obj));
    }

    @Operation(summary = "Cria um novo item", description = "Cria um novo item com base nos dados fornecidos")
    @PostMapping
    public ResponseEntity<VehicleDTO> create(@Valid @RequestBody VehicleDTO objDto){
        Vehicle newObj = vService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualiza dados", description = "Atualiza os dado existente com base no id fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<VehicleDTO> update(@PathVariable long id, @Valid @RequestBody VehicleDTO objDto){
        Vehicle obj = vService.update(id, objDto);
        return ResponseEntity.ok().body(new VehicleDTO(obj));
    }

    @Operation(summary = "Deleta um item", description = "Remove um item existem com base no ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VehicleDTO> delete(@PathVariable long id){
        vService.delete(id);
        return ResponseEntity.noContent().build();
    }
}