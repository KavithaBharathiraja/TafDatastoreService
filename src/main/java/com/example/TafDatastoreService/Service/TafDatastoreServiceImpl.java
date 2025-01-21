package com.example.TafDatastoreService.Service;

import com.example.TafDatastoreService.Models.Booking;
import com.example.TafDatastoreService.Models.Flight;
import com.example.TafDatastoreService.Models.User;
import com.example.TafDatastoreService.Repositories.BookingRepository;
import com.example.TafDatastoreService.Repositories.FlightRepository;
import com.example.TafDatastoreService.Repositories.UserRepository;
import com.example.TafDatastoreService.Service.Interfaces.TafDatastoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TafDatastoreServiceImpl implements TafDatastoreService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // CRUD operations for User
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateUser(Long userId, User user) {
        if (userRepository.existsById(userId)) {
            user.setId(userId);
            return userRepository.save(user);
        }
        return null;
    }

    // CRUD operations for Flight
    @Override
    public Flight addNewFlight(Flight flight) {
        return flightRepository.save(flight);
    }


    @Override
    public Flight getFlightById(Long flightId) {
        return flightRepository.findById(flightId).orElse(null);
    }

    @Override
    public List<Flight> getAllAvailableFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight updateFlight(Long flightId, Flight flight) {
        if (flightRepository.existsById(flightId)) {
            flight.setId(flightId);
            return flightRepository.save(flight);
        }
        return null;
    }

    @Override
    public void deleteFlight(Long flightId) {
        if (flightRepository.existsById(flightId)) {
            flightRepository.deleteById(flightId);
        }
    }

    // CRUD operations for Booking
    @Override
    public Booking createBooking(Booking booking) {
        // Fetch User and Flight from the database
        User user = userRepository.findById(booking.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Flight flight = flightRepository.findById(booking.getFlight().getId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        // Set the correct user and flight objects
        booking.setUser(user);
        booking.setFlight(flight);

        // Set timestamps (if not set automatically)
        booking.setCreatedAt(LocalDateTime.now());
        booking.setUpdatedAt(LocalDateTime.now());

        // Save and return the booking
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllAvailableBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override
    public Booking updateBooking(Long bookingId, Booking booking) {
        if (bookingRepository.existsById(bookingId)) {
            booking.setId(bookingId);
            return bookingRepository.save(booking);
        }
        return null;
    }

    @Override
    public void deleteBooking(Long bookingId) {
        if (bookingRepository.existsById(bookingId)) {
            bookingRepository.deleteById(bookingId);
        }
    }

    @Override
    public List<Booking> getBookingsByFlightId(Long flightId) {
        return bookingRepository.findByFlightId(flightId);  // Assuming this method exists in the BookingRepository
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}
