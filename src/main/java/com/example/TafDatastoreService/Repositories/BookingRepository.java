package com.example.TafDatastoreService.Repositories;

import com.example.TafDatastoreService.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByFlightId(Long flightId);
}
