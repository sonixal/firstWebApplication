package com.example.application.repos;

import com.example.application.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
    Customers findByIdAccount(Long idAccount);

    Customers findObjectById(Long id);
}
