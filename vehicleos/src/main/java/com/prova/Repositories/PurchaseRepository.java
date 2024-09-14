package com.prova.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
<<<<<<< Updated upstream

import com.prova.domains.Purchase;

=======
import com.prova.domains.Purchase;

>>>>>>> Stashed changes
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {

}
