package com.example.TafDatastoreService.Controller;

import com.example.TafDatastoreService.Models.Booking;
import com.example.TafDatastoreService.Models.Flight;
import com.example.TafDatastoreService.Models.User;

import com.example.TafDatastoreService.Service.TafDatastoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("datastore")
public class TafDatastoreController {

    @Autowired
    private TafDatastoreServiceImpl datastoreService;


    @GetMapping("/test")
    public String testEndpoint() {
        return "Test successful!";
    }

    // User Endpoints
    @PostMapping("/users")
    public User RegisterUser(@RequestBody User user) {
        return datastoreService.registerUser(user);
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        return datastoreService.getUser(userId);
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return datastoreService.getAllUsers();
    }


    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return datastoreService.updateUser(userId, user);
    }


    // Flight Endpoints
    @PostMapping("/flights")
    public Flight AddNewFlight(@RequestBody Flight flight) {
        return datastoreService.addNewFlight(flight);
    }
    @GetMapping("/flights")
    public List<Flight> getAllavilableflights() {
        return datastoreService.getAllAvailableFlights();
    }

    @GetMapping("/flights/{flightId}")
    public Flight getFlightById(@PathVariable Long flightId) {
        return datastoreService.getFlightById(flightId);
    }

    @PutMapping("/flights/{flightId}")
    public Flight updateFlight(@PathVariable Long flightId, @RequestBody Flight flight) {
        return datastoreService.updateFlight(flightId, flight);
    }

    @DeleteMapping("/flights/{flightId}")
    public void deleteFlight(@PathVariable Long flightId) {
        datastoreService.deleteFlight(flightId);
    }

    // Booking Endpoints
    @PostMapping("/bookings")
    public Booking createBooking(@RequestBody Booking booking) {
        return datastoreService.createBooking(booking);
    }

    @GetMapping("/bookings")
    public List<Booking>  getAllAvailableBookings() {
        return datastoreService.getAllAvailableBookings();
    }

    @GetMapping("/bookings/{bookingId}")
    public Booking getBooking(@PathVariable Long bookingId) {
        return datastoreService.getBooking(bookingId);
    }

    @DeleteMapping("/bookings/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId) {
        datastoreService.deleteBooking(bookingId);
    }
    @GetMapping("/bookings/users/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable Long userId) {
        return datastoreService.getBookingsByUserId(userId);
    }

    @GetMapping("/bookings/flight/{flightId}")
    public List<Booking> getBookingsByFlightId(@PathVariable Long flightId) {
        return datastoreService.getBookingsByFlightId(flightId);
    }
}
