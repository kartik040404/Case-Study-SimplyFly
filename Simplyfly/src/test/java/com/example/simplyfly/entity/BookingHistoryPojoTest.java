package com.example.simplyfly.entity;

import com.example.simplyfly.enums.HistoryAction;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingHistoryPojoTest {

    @Test
    void testSettersAndGetters() {
        Booking booking = new Booking();
        BookingHistory h = new BookingHistory();
        h.setHistoryId(1);
        h.setBooking(booking);
        h.setAction(HistoryAction.BOOKED);
        LocalDateTime now = LocalDateTime.now();
        h.setActionDate(now);

        assertEquals(1, h.getHistoryId());
        assertEquals(booking, h.getBooking());
        assertEquals(HistoryAction.BOOKED, h.getAction());
        assertEquals(now, h.getActionDate());
    }

    @Test
    void testAllArgsConstructor() {
        Booking booking = new Booking();
        LocalDateTime now = LocalDateTime.now();
        BookingHistory h = new BookingHistory(2, booking, HistoryAction.CANCELLED, now);
        assertEquals(2, h.getHistoryId());
        assertEquals(HistoryAction.CANCELLED, h.getAction());
    }

    @Test
    void testToStringContainsAllFields() {
        Booking booking = new Booking();
        LocalDateTime now = LocalDateTime.of(2025,7,1,15,0);
        BookingHistory h = new BookingHistory(3, booking, HistoryAction.BOOKED, now);
        String str = h.toString();
        assertTrue(str.contains("3"));
        assertTrue(str.contains("BOOKED"));
    }
}
