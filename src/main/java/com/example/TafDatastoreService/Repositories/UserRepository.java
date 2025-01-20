package com.example.TafDatastoreService.Repositories;

import com.example.TafDatastoreService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom queries can be added here if needed
}
