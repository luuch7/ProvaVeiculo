package com.prova.services;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.prova.repositories.ClientRepository;
import com.prova.services.exceptions.ObjectNotFoundException;
import com.prova.domains.Client;
import com.prova.domains.dtos.ClientDTO;

@Service
public class ClientService {

    private ClientRepository cliRy;

    public List<ClientDTO> findAll() {
        return cliRy.findAll().stream().map(obj -> new ClientDTO(obj)).collect(Collectors.toList());
    }

    public Client findById(UUID id) {
        Optional<Client> obj =cliRy.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
    }

        public Client create(ClientDTO objDto){ 
        objDto.setId(null);
        Client newObj = new Client(objDto); //PROBLEMA AQUI Ò HIHIHIHHIHIHHI
        return cliRy.save(newObj);
    }


}
