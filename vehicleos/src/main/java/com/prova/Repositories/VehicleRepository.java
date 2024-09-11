package com.prova.Repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prova.domains.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,UUID>{

}

    


