package com.example.simplyfly.restapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplyfly.entity.Booking;
import com.example.simplyfly.entity.Route;
import com.example.simplyfly.entity.User;
import com.example.simplyfly.enums.BookingStatus;
import com.example.simplyfly.repository.BookingRepo;
import com.example.simplyfly.repository.RouteRepo;
import com.example.simplyfly.repository.UserRepo;

@RestController
@RequestMapping("/api/passenger/")
public class PassengerAPI {
	@Autowired
	private RouteRepo routeRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BookingRepo bookingRepo;
	 @GetMapping("/search")
	    public ResponseEntity<List<Route>> searchRoutes(@RequestParam String origin,
	            @RequestParam String destination,
	            @RequestParam LocalDate date) {
	        LocalDateTime start = date.atStartOfDay();

	        List<Route> routes = routeRepo
	            .findByOriginAndDestinationAndDepartureTsAfter(origin, destination, start);

	        return new ResponseEntity<>(routes, HttpStatus.OK);
	    }
	 
	 @PostMapping("/bookings")
	    public ResponseEntity<Booking> bookTicket(@RequestParam int routeID,@RequestParam int userID) {
	        Optional<Route> route = routeRepo.findById(routeID);
	        if(route.isPresent()) {
	        	
	        Optional<User> user = userRepo.findById(userID);
	        if(user.isPresent()) {
	        	  Booking booking = new Booking();
	  	        booking.setRoute(route.get());
	  	        booking.setUser(user.get());
	  	        booking.setBookedAt(LocalDateTime.now());
	  	        booking.setStatus(BookingStatus.BOOKED);
	  	        Booking saved = bookingRepo.save(booking);

	  	        return new ResponseEntity<Booking>(saved,HttpStatus.CREATED);
	        }
	        else return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);

	        }else return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
	                       
	        
	      
	    }
}
