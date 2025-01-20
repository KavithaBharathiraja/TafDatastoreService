package com.example.TafDatastoreService.Service.Interfaces;

import com.example.TafDatastoreService.Models.Booking;
import com.example.TafDatastoreService.Models.Flight;
import com.example.TafDatastoreService.Models.User;

import java.util.List;

public interface TafDatastoreService {

    User registerUser(User user);
    List<User> getAllUsers();
    User getUser(Long userId);
    User updateUser(Long userId, User user);



    Flight addNewFlight(Flight flight);
    Flight getFlightById(Long flightId);
    List<Flight> getAllAvailableFlights();

    Flight updateFlight(Long flightId, Flight flight);
    void deleteFlight(Long flightId);

    Booking createBooking(Booking booking);
    List<Booking> getBookingsByFlightId(Long flightId);
    List<Booking> getAllAvailableBookings();
    Booking getBooking(Long bookingId);
    Booking updateBooking (Long bookingId, Booking booking);
    void deleteBooking(Long bookingId);

}
