package com.prova.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.domains.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,UUID> {

    Optional<Client> findByCpfCnpj(String cpfCnpj);
    Optional<Client> findByEmail(String email);
}
