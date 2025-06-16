package com.example.simplyfly.entity;

import com.example.simplyfly.enums.PaymentMethod;
import com.example.simplyfly.enums.PaymentStatus;
import com.example.simplyfly.repository.BookingRepo;
import com.example.simplyfly.repository.PaymentRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PaymentPojoTest {
	   @Autowired
	    private PaymentRepo paymentRepo;

	    @Autowired
	    private BookingRepo bookingRepo;

	    @Test
	    void testSave() {
	        // Prepare Booking
	        Booking booking = new Booking();
	        booking.setBookingId(1);
	        bookingRepo.save(booking);

	        // Create and save Payment
	        LocalDateTime now = LocalDateTime.of(2025, 6, 16, 10, 0);
	        Payment p = new Payment(10, booking, PaymentMethod.UPI, PaymentStatus.PAID, 5500, now);
	        Payment saved = paymentRepo.save(p);

	        assertNotNull(saved, "Saved payment should not be null");
	        assertEquals(10, saved.getPaymentId());
	        assertEquals(PaymentMethod.UPI, saved.getPaymentMethod());
	        assertEquals(PaymentStatus.PAID, saved.getPaymentStatus());
	        assertEquals(5500, saved.getAmountPaid());
	        assertEquals(now, saved.getPaymentDate());
	    }

	    @Test
	    void testFindById() {
	        Booking booking = new Booking();
	        booking.setBookingId(2);
	        bookingRepo.save(booking);

	        Payment p = new Payment(20, booking, PaymentMethod.CARD, PaymentStatus.FAILED, 6500, LocalDateTime.now());
	        paymentRepo.save(p);

	        Optional<Payment> found = paymentRepo.findById(20);
	        assertTrue(found.isPresent(), "Payment should be found");
	        assertEquals(PaymentMethod.CARD, found.get().getPaymentMethod());
	    }

	    @Test
	    void testFindAll() {
	        paymentRepo.deleteAll();
	        bookingRepo.deleteAll();

	        Booking b1 = new Booking(); b1.setBookingId(3); bookingRepo.save(b1);
	        Booking b2 = new Booking(); b2.setBookingId(4); bookingRepo.save(b2);

	        paymentRepo.save(new Payment(30, b1, PaymentMethod.NETBANKING, PaymentStatus.PENDING, 7000, LocalDateTime.now()));
	        paymentRepo.save(new Payment(31, b2, PaymentMethod.UPI, PaymentStatus.PAID, 8000, LocalDateTime.now()));

	        List<Payment> list = paymentRepo.findAll();
	        assertEquals(2, list.size(), "Should retrieve two payments");
	    }

	    @Test
	    void testDeleteById() {
	        Booking booking = new Booking();
	        booking.setBookingId(5);
	        bookingRepo.save(booking);

	        Payment p = new Payment(40, booking, PaymentMethod.CARD, PaymentStatus.PAID, 9000, LocalDateTime.now());
	        paymentRepo.save(p);

	        paymentRepo.deleteById(40);
	        assertFalse(paymentRepo.findById(40).isPresent(), "Payment should be deleted");
	    }
    @Test
    void testSettersAndGetters() {
        Booking booking = new Booking();
        Payment p = new Payment();
        p.setPaymentId(1);
        p.setBooking(booking);
        p.setPaymentMethod(PaymentMethod.UPI);
        p.setPaymentStatus(PaymentStatus.PAID);
        p.setAmountPaid(5500);
        LocalDateTime now = LocalDateTime.now();
        p.setPaymentDate(now);

        assertEquals(1, p.getPaymentId());
        assertEquals(booking, p.getBooking());
        assertEquals(PaymentMethod.UPI, p.getPaymentMethod());
        assertEquals(PaymentStatus.PAID, p.getPaymentStatus());
        assertEquals(5500, p.getAmountPaid());
        assertEquals(now, p.getPaymentDate());
    }

    @Test
    void testAllArgsConstructor() {
        Booking booking = new Booking();
        LocalDateTime now = LocalDateTime.now();
        Payment p = new Payment(2, booking, PaymentMethod.CARD, PaymentStatus.FAILED, 6500, now);
        assertEquals(2, p.getPaymentId());
        assertEquals(PaymentMethod.CARD, p.getPaymentMethod());
        assertEquals(PaymentStatus.FAILED, p.getPaymentStatus());
        assertEquals(6500, p.getAmountPaid());
    }

    @Test
    void testToStringContainsAllFields() {
        Booking booking = new Booking();
        LocalDateTime now = LocalDateTime.of(2025,6,1,12,0);
        Payment p = new Payment(3, booking, PaymentMethod.NETBANKING, PaymentStatus.PENDING, 7000, now);
        String str = p.toString();
        assertTrue(str.contains("3"));
        assertTrue(str.contains("7000"));
        assertTrue(str.contains("PENDING"));
    }
}
