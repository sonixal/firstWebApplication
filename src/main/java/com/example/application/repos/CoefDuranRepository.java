package com.example.application.repos;

import com.example.application.model.CoefDuran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoefDuranRepository extends JpaRepository<CoefDuran, Long> {
    CoefDuran findByIdCustomer(Long idCustomer);
}
