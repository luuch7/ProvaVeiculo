package com.prova.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.domains.Vehicle;
import com.prova.domains.dtos.VehicleDTO;
import com.prova.repositories.VehicleRepository;
import com.prova.services.exceptions.ObjectNotFoundException;

@Service
public class VehicleService {
    
    @Autowired
    private VehicleRepository vehicleServ;

    public List<VehicleDTO> findAll(){
        return vehicleServ.findAll().stream().map(obj -> new VehicleDTO(obj)).collect(Collectors.toList());
    }

    public Vehicle findById(long id){
        Optional<Vehicle> obj =vehicleServ.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: "+id));
    }

    public Vehicle create(VehicleDTO objDto){
        objDto.setId(+1);
        Vehicle newObj = new Vehicle(objDto);
        return vehicleServ.save(newObj);
    }
    
    public Vehicle update(long id, VehicleDTO objDto){
        objDto.setId(id);
        Vehicle oldObj = findById(id);
        oldObj = new Vehicle(objDto);
        return vehicleServ.save(oldObj);
    }

    public void delete(long id){
        //NaturalPerson obj = findById(id);
        vehicleServ.deleteById(id);
    }
}