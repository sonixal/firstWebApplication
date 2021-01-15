package com.example.application.repos;

import com.example.application.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DocumentRepository extends JpaRepository<Document, Long>, CrudRepository<Document, Long> {
    List<Document> findByIdCustomer(Long idCustomers);

    Document findObjectById(Long id);
}
