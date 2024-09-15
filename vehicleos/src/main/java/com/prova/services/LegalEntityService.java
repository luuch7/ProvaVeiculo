package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.LegalEntity;
import com.prova.domains.dtos.LegalEntityDTO;
import com.prova.repositories.LegalEntityRepository;
import com.prova.services.exceptions.DataIntegrityViolationException;
import com.prova.services.exceptions.ObjectNotFoundException;

@Service
public class LegalEntityService {
    
    @Autowired
    private LegalEntityRepository legalRepo;

    public List<LegalEntityDTO> findAll(){
        return legalRepo.findAll().stream().map(obj -> new LegalEntityDTO(obj)).collect(Collectors.toList());
    }

    public LegalEntity findById(UUID id){
        Optional<LegalEntity> obj = legalRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
    }

    public LegalEntity findByCpfCnpj(String cpfCnpj){
        Optional<LegalEntity> obj = legalRepo.findByCpfCnpj(cpfCnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+cpfCnpj));
    }

    public LegalEntity create(LegalEntityDTO objDto){
        objDto.setId(null);
        ValidarPorCpfCnpjeEmail(objDto);
        LegalEntity newObj = new LegalEntity(objDto);
        return legalRepo.save(newObj);
    }

    public LegalEntity findByEmail(String email) {
        Optional<LegalEntity> obj = legalRepo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Email: "+email));
    }

    private void ValidarPorCpfCnpjeEmail(LegalEntityDTO objDto){
        Optional<LegalEntity> obj = legalRepo.findByCpfCnpj(objDto.getCpfCnpj());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("CPF/CNPJ ja ta cadastrado no sistema");
        }

        Optional<LegalEntity> obj2 = legalRepo.findByEmail(objDto.getEmail());
            if(obj2.isPresent() && obj2.get().getId() != objDto.getId()){
                throw new DataIntegrityViolationException("Email já cadastrado no sistema");
            
        }
    }

    public LegalEntity update(UUID id, LegalEntityDTO objDto){
        objDto.setId(id);
        LegalEntity oldObj = findById(id);
        ValidarPorCpfCnpjeEmail(objDto);
        oldObj = new LegalEntity(objDto);
        return legalRepo.save(oldObj);
    }

    public void delete(UUID id){
        //NaturalPerson obj = findById(id);
        legalRepo.deleteById(id);
    }
}