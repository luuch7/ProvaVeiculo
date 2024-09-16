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

import com.prova.domains.LegalEntity;
import com.prova.domains.dtos.LegalEntityDTO;
import com.prova.services.LegalEntityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/legalentity")
@Tag(name = "LegalEntity", description = "API de gerenciamento de LegalEntitys")
public class LegalEntityResource {
    
    @Autowired
    private LegalEntityService legalService;

    @Operation(summary = "Listar todos", description = "Retorna uma lista com todos os dados")
    @GetMapping //http://localhost:8080/legalentity
    public ResponseEntity<List<LegalEntityDTO>> findAll(){
        return ResponseEntity.ok().body(legalService.findAll());
    }

    //to meio louco se der erro é aq
    @Operation(summary = "Busca por ID", description = "Retorna dados com base no ID fornecido")
    @GetMapping(value = "/{id}") //http://localhost:8080/legalentity/1
    public ResponseEntity<LegalEntityDTO> findById(@PathVariable UUID id){
        LegalEntity obj = this.legalService.findById(id);
        return ResponseEntity.ok().body(new LegalEntityDTO(obj));
    }
    
    @Operation(summary = "Busca por CPF ou CNPJ", description = "Retonar dados com base no CPF ou CNPJ fornecido")
    @GetMapping(value = "/cpfcnpj/{cpfCnpj}")
    public ResponseEntity<LegalEntityDTO> findByCpfCnpj(@PathVariable String cpfCnpj){
        LegalEntity obj = this.legalService.findByCpfCnpj(cpfCnpj);
        return ResponseEntity.ok().body(new LegalEntityDTO(obj));
    }

    @Operation(summary = "Buca por Email", description = "Retorna dados com base no email fornecido")
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<LegalEntityDTO> findByEmail(@PathVariable String email){
        LegalEntity obj = this.legalService.findByEmail(email);
        return ResponseEntity.ok().body(new LegalEntityDTO(obj));
    }

    @Operation(summary = "Cria um novo item", description = "Cria um novo item com base nos dados fornecidos")
    @PostMapping
    public ResponseEntity<LegalEntityDTO> create(@Valid @RequestBody LegalEntityDTO objDto){
        LegalEntity newObj = legalService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(summary = "Atualiza dados", description = "Atualiza os dado existente com base no id fornecido")
    @PutMapping(value = "/{id}")
    public ResponseEntity<LegalEntityDTO> update(@PathVariable UUID id, @Valid @RequestBody LegalEntityDTO objDto){
        LegalEntity obj = legalService.update(id, objDto);
        return ResponseEntity.ok().body(new LegalEntityDTO(obj));
    }

    @Operation(summary = "Deleta um item", description = "Remove um item existem com base no ID fornecido")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LegalEntityDTO> delete(@PathVariable UUID id){
        legalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}