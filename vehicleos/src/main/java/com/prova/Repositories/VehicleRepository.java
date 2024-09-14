package com.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Vehicle;

@Repository
<<<<<<< Updated upstream
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
=======
public interface VehicleRepository extends JpaRepository<Vehicle,long>{

}

>>>>>>> Stashed changes
    
}