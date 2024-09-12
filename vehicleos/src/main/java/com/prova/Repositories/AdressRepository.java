package com.prova.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prova.domains.Address;

@Repository
public interface AdressRepository extends JpaRepository<Address,Integer>{
    
}
