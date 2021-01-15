package com.example.application.repos;

import com.example.application.model.Workers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkersRepository extends JpaRepository<Workers, Long> {
    Workers findObjectById(long id);

    Workers findByIdAccount(long id);
}
