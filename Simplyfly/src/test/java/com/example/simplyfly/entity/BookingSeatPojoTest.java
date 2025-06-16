package com.example.simplyfly.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.simplyfly.repository.BookingRepo;
import com.example.simplyfly.repository.BookingSeatRepo;
import com.example.simplyfly.repository.SeatRepo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
@SpringBootTest
class BookingSeatPojoTest {
    @Autowired
    private BookingSeatRepo bookingSeatRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private SeatRepo seatRepo;

 





    @Test
    void testDeleteById() {
        Booking booking = new Booking(); booking.setBookingId(5); bookingRepo.save(booking);
        Seat seat = new Seat(); seat.setSeatId(5); seatRepo.save(seat);

        BookingSeat bs = new BookingSeat(40, booking, seat);
        bookingSeatRepo.save(bs);

        bookingSeatRepo.deleteById(40);
        assertFalse(bookingSeatRepo.findById(40).isPresent());
    }
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
