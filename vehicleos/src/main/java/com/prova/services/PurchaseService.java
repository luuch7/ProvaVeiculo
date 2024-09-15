package com.prova.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.prova.repositories.PurchaseRepository;
import com.prova.services.exceptions.ObjectNotFoundException;
import com.prova.domains.dtos.PurchaseDTO;
import com.prova.domains.Purchase;

@Service
public class PurchaseService {
        //erro no Purchase AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    private PurchaseRepository puRepo;

    public List<PurchaseDTO> findAll(){
        return puRepo.findAll().stream().map(obj -> new PurchaseDTO(obj)).collect(Collectors.toList());
    }

    public Purchase findById(UUID id){
        Optional<Purchase> obj =puRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
    }

    public Purchase create(PurchaseDTO objDto){
        objDto.setId(null);
        Purchase newObj = new Purchase(objDto);
        return puRepo.save(newObj);
    }
    
    public Purchase update(UUID id, PurchaseDTO objDto){
        objDto.setId(id);
        Purchase oldObj = findById(id);
        oldObj = new Purchase(objDto);
        return puRepo.save(oldObj);
    }

    public void delete(UUID id){
        //NaturalPerson obj = findById(id);
        puRepo.deleteById(id);
    }
}
