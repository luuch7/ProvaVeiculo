package com.prova.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prova.domains.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {

}
