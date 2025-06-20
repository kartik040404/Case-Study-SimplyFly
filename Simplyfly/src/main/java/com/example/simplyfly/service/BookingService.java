//package com.example.simplyfly.service;
//
//import java.lang.StackWalker.Option;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.example.simplyfly.entity.Booking;
//import com.example.simplyfly.entity.Flight;
//import com.example.simplyfly.entity.User;
//import com.example.simplyfly.enums.BookingStatus;
//import com.example.simplyfly.repository.BookingRepo;
//import com.example.simplyfly.repository.FlightRepo;
//import com.example.simplyfly.repository.UserRepo;
//
//public class BookingService {
//	 @Autowired
//	    private BookingRepo bookingRepo;
//
//	    @Autowired
//	    private FlightRepo flightRepo;
//
//	    @Autowired
//	    private UserRepo userRepo;
//
//	    public void bookFlight(int userId, int flightId) {
//	        Optional<Flight> flight = flightRepo.findById(flightId);
//	             
//	        Optional<User> user = userRepo.findById(userId);
//	                
//
//	        Booking booking = new Booking();
//	        booking.set(flight);
//	        booking.setUser(user);
//	        booking.setDate(LocalDate.now());
//	        booking.setSeatsBooked(1); 
//	        booking.setTotalFare(flight.getFare() * booking.getSeatsBooked());
//	        booking.setStatus(BookingStatus.BOOKED);
//
//	        bookingRepo.save(booking);
//	    }
//
//	    
//	    public List<Booking> getByUser(int userId) {
//	        // Assumes BookingRepository has: List<Booking> findByUserUserID(int userID)
//	        return bookingRepo.findByUserUserID(userId);
//	    }
//
//	    
//	    public void cancel(int bookingId) {
//	        Booking booking = bookingRepo.findById(bookingId)
//	                .orElseThrow(() -> new IllegalArgumentException("Invalid booking ID"));
//	        booking.setStatus(BookingStatus.CANCELLED);
//	        bookingRepo.save(booking);
//	        // Optionally issue refund here
//	    }
//}
