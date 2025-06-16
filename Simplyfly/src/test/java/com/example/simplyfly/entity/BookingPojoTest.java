package com.example.simplyfly.entity;

import com.example.simplyfly.enums.BookingStatus;
import com.example.simplyfly.repository.BookingRepo;
import com.example.simplyfly.repository.RouteRepo;
import com.example.simplyfly.repository.UserRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookingPojoTest {
	  @Autowired
	    private BookingRepo bookingRepo;

	    @Autowired
	    private UserRepo userRepo;

	    @Autowired
	    private RouteRepo routeRepo;

	    @Test
	    void testSave() {
	        // Prepare User and Route
	        User user = new User(); user.setUserID(1); user.setName("U1"); userRepo.save(user);
	        Route route = new Route(); route.setRouteId(1); routeRepo.save(route);

	        // Create and save Booking
	        LocalDateTime now = LocalDateTime.of(2025, 6, 16, 14, 0);
	        Booking b = new Booking(10, user, route, 5000, now, BookingStatus.BOOKED);
	        Booking saved = bookingRepo.save(b);

	        assertNotNull(saved);
	        assertEquals(10, saved.getBookingId());
	        assertEquals(5000, saved.getTotalAmount());
	        assertEquals(BookingStatus.BOOKED, saved.getStatus());
	        assertEquals(now, saved.getBookedAt());
	    }

	    @Test
	    void testFindById() {
	        User user = new User(); user.setUserID(2); user.setName("U2"); userRepo.save(user);
	        Route route = new Route(); route.setRouteId(2); routeRepo.save(route);

	        Booking b = new Booking(20, user, route, 6000, LocalDateTime.now(), BookingStatus.CANCELLED);
	        bookingRepo.save(b);

	        Optional<Booking> opt = bookingRepo.findById(20);
	        assertTrue(opt.isPresent());
	        assertEquals(BookingStatus.CANCELLED, opt.get().getStatus());
	    }



	    @Test
	    void testDeleteById() {
	        User user = new User(); user.setUserID(5); user.setName("U5"); userRepo.save(user);
	        Route route = new Route(); route.setRouteId(5); routeRepo.save(route);

	        Booking b = bookingRepo.save(new Booking(40, user, route, 9000, LocalDateTime.now(), BookingStatus.BOOKED));
	        bookingRepo.deleteById(40);
	        assertFalse(bookingRepo.findById(40).isPresent());
	    }
    @Test
    void testSettersAndGetters() {
        User user = new User();
        Route route = new Route();
        Booking b = new Booking();
        b.setBookingId(1);
        b.setUser(user);
        b.setRoute(route);
        b.setTotalAmount(5000);
        b.setStatus(BookingStatus.BOOKED);
        LocalDateTime now = LocalDateTime.now();
        b.setBookedAt(now);

        assertEquals(1, b.getBookingId());
        assertEquals(user, b.getUser());
        assertEquals(route, b.getRoute());
        assertEquals(5000, b.getTotalAmount());
        assertEquals(BookingStatus.BOOKED, b.getStatus());
        assertEquals(now, b.getBookedAt());
    }

    @Test
    void testAllArgsConstructor() {
        User user = new User();
        Route route = new Route();
        LocalDateTime now = LocalDateTime.now();
        Booking b = new Booking(2, user, route, 6000, now,BookingStatus.CANCELLED);
        assertEquals(2, b.getBookingId());
        assertEquals(BookingStatus.CANCELLED, b.getStatus());
        assertEquals(6000, b.getTotalAmount());
    }

    @Test
    void testToStringContainsAllFields() {
        User user = new User();
        Route route = new Route();
        LocalDateTime now = LocalDateTime.of(2025,5,1,9,0);
        Booking b = new Booking(3, user, route, 7000, now,BookingStatus.BOOKED);
        String str = b.toString();
        assertTrue(str.contains("3"));
        assertTrue(str.contains("7000"));
        assertTrue(str.contains("BOOKED"));
    }
}
