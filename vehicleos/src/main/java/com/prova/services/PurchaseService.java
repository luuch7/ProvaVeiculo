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
import com.prova.domains.purchase;

@Service
public class PurchaseService {
        //erro no Purchase AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    private PurchaseRepository puRepo;

    public List<PurchaseDTO> findAll(){
        return puRepo.findAll().stream().map(obj -> new PurchaseDTO(obj)).collect(Collectors.toList());
    }

    public purchase findById(UUID id){
        Optional<purchase> obj =puRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
    }

    public purchase create(PurchaseDTO objDto){
        objDto.setId(null);
        purchase newObj = new purchase(objDto);
        return puRepo.save(newObj);
    }
    

}
