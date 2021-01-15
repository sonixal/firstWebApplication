package com.example.application.repos;

import com.example.application.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    Profession findByIdCustomer(Long idCustomer);
}
