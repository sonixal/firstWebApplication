package com.example.application.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.application.model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
