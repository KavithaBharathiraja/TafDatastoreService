package com.example.TafDatastoreService.Repositories;

import com.example.TafDatastoreService.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Custom queries can be added here if needed
}
