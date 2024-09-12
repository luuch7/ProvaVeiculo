package com.prova.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prova.domains.Client;

@Repository
private interface ClientRepository extends JpaRepository<Client,UUID> {

    
}
