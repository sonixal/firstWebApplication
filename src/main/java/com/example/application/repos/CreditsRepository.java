package com.example.application.repos;

import com.example.application.model.Credits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditsRepository extends JpaRepository<Credits, Long> {
    List<Credits> findByIdCustomers(Long idCustomers);

    Iterable<Credits> findByIdDocument(Long idDocument);
}
