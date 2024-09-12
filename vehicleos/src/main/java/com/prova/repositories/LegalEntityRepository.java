package com.prova.repositories;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.LegalEntity;

@Repository
public interface LegalEntityRepository extends JpaRepository<LegalEntity, UUID>{
    
}