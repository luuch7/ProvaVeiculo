package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.NaturalPerson;
import com.prova.domains.dtos.NaturalPersonDTO;
import com.prova.repositories.NaturalPersonRepository;
import com.prova.services.exceptions.DataIntegrityViolationException;
import com.prova.services.exceptions.ObjectNotFoundException;

@Service
public class NaturalPersonService {
    
    @Autowired
    private NaturalPersonRepository natRepo;

    public List<NaturalPersonDTO> findAll(){
        return natRepo.findAll().stream().map(obj -> new NaturalPersonDTO(obj)).collect(Collectors.toList());
    }

    public NaturalPerson findById(UUID id){
        Optional<NaturalPerson> obj = natRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
    }

    public NaturalPerson findByCpfCnpj(String cpfCnpj){
        Optional<NaturalPerson> obj = natRepo.findByCpfCnpj(cpfCnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+cpfCnpj));
    }

    public NaturalPerson findByEmail(String email) {
        Optional<NaturalPerson> obj = natRepo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Email: "+email));
    }

    public NaturalPerson create(NaturalPersonDTO objDto){
        objDto.setId(null);
        ValidarPorCpfCnpjeEmail(objDto);
        NaturalPerson newObj = new NaturalPerson(objDto);
        return natRepo.save(newObj);
    }

    private void ValidarPorCpfCnpjeEmail(NaturalPersonDTO objDto){
        Optional<NaturalPerson> obj = natRepo.findByCpfCnpj(objDto.getCpfCnpj());
        if(obj.isPresent() && obj.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("CPF/CNPJ ja ta cadastrado no sistema");
        }

        Optional<NaturalPerson> obj2 = natRepo.findByEmail(objDto.getEmail());
            if(obj2.isPresent() && obj2.get().getId() != objDto.getId()){
                throw new DataIntegrityViolationException("Email já cadastrado no sistema");
            
        }
    }

    public NaturalPerson update(UUID id, NaturalPersonDTO objDto){
        objDto.setId(id);
        NaturalPerson oldObj = findById(id);
        ValidarPorCpfCnpjeEmail(objDto);
        oldObj = new NaturalPerson(objDto);
        return natRepo.save(oldObj);
    }

    public void delete(UUID id){
        //NaturalPerson obj = findById(id);
        natRepo.deleteById(id);
    }
}