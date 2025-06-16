package com.example.simplyfly.entity;

import com.example.simplyfly.enums.HistoryAction;
import com.example.simplyfly.repository.BookingHistoryRepo;
import com.example.simplyfly.repository.BookingRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookingHistoryPojoTest {
	  @Autowired
	    private BookingHistoryRepo bookingHistoryRepo;

	    @Autowired
	    private BookingRepo bookingRepo;

	    @Test
	    void testSave() {
	        Booking booking = new Booking();
	        booking.setBookingId(1);
	        bookingRepo.save(booking);

	        LocalDateTime now = LocalDateTime.of(2025, 7, 1, 15, 0);
	        BookingHistory h = new BookingHistory(10, booking, HistoryAction.BOOKED, now);
	        BookingHistory saved = bookingHistoryRepo.save(h);

	        assertNotNull(saved);
	        assertEquals(10, saved.getHistoryId());
	        assertEquals(HistoryAction.BOOKED, saved.getAction());
	        assertEquals(now, saved.getActionDate());
	    }

	    @Test
	    void testFindById() {
	        Booking booking = new Booking(); booking.setBookingId(2); bookingRepo.save(booking);
	        BookingHistory h = new BookingHistory(20, booking, HistoryAction.CANCELLED, LocalDateTime.now());
	        bookingHistoryRepo.save(h);

	        Optional<BookingHistory> opt = bookingHistoryRepo.findById(20);
	        assertTrue(opt.isPresent());
	        assertEquals(HistoryAction.CANCELLED, opt.get().getAction());
	    }


	    @Test
	    void testDeleteById() {
	        Booking booking = new Booking(); booking.setBookingId(5); bookingRepo.save(booking);
	        BookingHistory h = new BookingHistory(40, booking, HistoryAction.BOOKED, LocalDateTime.now());
	        bookingHistoryRepo.save(h);

	        bookingHistoryRepo.deleteById(40);
	        assertFalse(bookingHistoryRepo.findById(40).isPresent());
	    }
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
