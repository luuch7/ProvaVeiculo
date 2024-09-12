package com.prova.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.LegalEntity;

@Repository
public interface LegalEntityRepository extends JpaRepository<LegalEntity, UUID>{
    
}