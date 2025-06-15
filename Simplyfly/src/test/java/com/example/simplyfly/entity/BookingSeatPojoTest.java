package com.example.simplyfly.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingSeatPojoTest {

    @Test
    void testSettersAndGetters() {
        Booking booking = new Booking();
        Seat seat = new Seat();
        BookingSeat bs = new BookingSeat();
        bs.setId(1);
        bs.setBooking(booking);
        bs.setSeat(seat);

        assertEquals(1, bs.getId());
        assertEquals(booking, bs.getBooking());
        assertEquals(seat, bs.getSeat());
    }

    @Test
    void testAllArgsConstructor() {
        Booking booking = new Booking();
        Seat seat = new Seat();
        BookingSeat bs = new BookingSeat(2, booking, seat);
        assertEquals(2, bs.getId());
        assertEquals(booking, bs.getBooking());
        assertEquals(seat, bs.getSeat());
    }

    @Test
    void testToStringContainsAllFields() {
        Booking booking = new Booking();
        Seat seat = new Seat();
        BookingSeat bs = new BookingSeat(3, booking, seat);
        String str = bs.toString();
        assertTrue(str.contains("3"));
    }
}
