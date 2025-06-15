package com.example.simplyfly.entity;

import com.example.simplyfly.enums.SeatClass;
import com.example.simplyfly.enums.SeatStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatPojoTest {

    @Test
    void testSettersAndGetters() {
        Route route = new Route();
        Seat s = new Seat();
        s.setSeatId(1);
        s.setRoute(route);
        s.setSeatNumber("1A");
        s.setClassType(SeatClass.ECONOMY);
        s.setStatus(SeatStatus.AVAILABLE);

        assertEquals(1, s.getSeatId());
        assertEquals(route, s.getRoute());
        assertEquals("1A", s.getSeatNumber());
        assertEquals(SeatClass.ECONOMY, s.getClassType());
        assertEquals(SeatStatus.AVAILABLE, s.getStatus());
    }

    @Test
    void testAllArgsConstructor() {
        Route route = new Route();
        Seat s = new Seat(2, route, "2B", SeatClass.BUSINESS, SeatStatus.BOOKED);
        assertEquals(2, s.getSeatId());
        assertEquals("2B", s.getSeatNumber());
        assertEquals(SeatClass.BUSINESS, s.getClassType());
        assertEquals(SeatStatus.BOOKED, s.getStatus());
    }

    @Test
    void testToStringContainsAllFields() {
        Route route = new Route();
        Seat s = new Seat(3, route, "3C", SeatClass.ECONOMY, SeatStatus.BOOKED);
        String str = s.toString();
        assertTrue(str.contains("3"));
        assertTrue(str.contains("3C"));
        assertTrue(str.contains("BOOKED"));
    }
}
