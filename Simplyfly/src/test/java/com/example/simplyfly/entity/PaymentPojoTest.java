package com.example.simplyfly.entity;

import com.example.simplyfly.enums.PaymentMethod;
import com.example.simplyfly.enums.PaymentStatus;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PaymentPojoTest {

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
