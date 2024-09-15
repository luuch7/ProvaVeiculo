package com.prova.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.prova.repositories.PurchaseRepository;
import com.prova.services.exceptions.ObjectNotFoundException;
import com.prova.domains.dtos.NaturalPersonDTO;
import com.prova.domains.dtos.PurchaseDTO;
import com.prova.domains.Purchase;

@Service
public class PurchaseService {

    private PurchaseRepository puRepo;

    public List<PurchaseDTO> findAll(){
        return puRepo.findAll().stream().map(obj -> new PurchaseDTO(obj)).collect(Collectors.toList());
    }

    public Purchase findById(UUID id){
        Optional<Purchase> obj =puRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
    }

    public Purchase create(Purchase objDto){
        objDto.setId(null);
        Purchase newObj = new Purchase(objDto);
        return puRepo.save(newObj);
    }
    

}
