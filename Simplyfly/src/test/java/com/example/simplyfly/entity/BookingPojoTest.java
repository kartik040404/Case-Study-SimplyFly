package com.example.simplyfly.entity;

import com.example.simplyfly.enums.BookingStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingPojoTest {

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
