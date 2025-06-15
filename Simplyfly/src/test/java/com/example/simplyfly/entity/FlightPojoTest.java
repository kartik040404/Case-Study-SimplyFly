package com.example.simplyfly.entity;

import com.example.simplyfly.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightPojoTest {

    @Test
    void testSettersAndGetters() {
        User owner = new User();
        Flight f = new Flight();
        f.setFlightId(1);
        f.setOwner(owner);
        f.setFlightNumber("SF101");
        f.setFlightName("Express");
        f.setTotalSeats(180);
        f.setCheckinKg(15);
        f.setCabinKg(7);

        assertEquals(1, f.getFlightId());
        assertEquals(owner, f.getOwner());
        assertEquals("SF101", f.getFlightNumber());
        assertEquals("Express", f.getFlightName());
        assertEquals(180, f.getTotalSeats());
        assertEquals(15, f.getCheckinKg());
        assertEquals(7, f.getCabinKg());
    }

    @Test
    void testAllArgsConstructor() {
        User owner = new User();
        Flight f = new Flight(2, owner, "SF202", "Max", 150, 20, 8);
        assertEquals(2, f.getFlightId());
        assertEquals("SF202", f.getFlightNumber());
        assertEquals("Max", f.getFlightName());
        assertEquals(150, f.getTotalSeats());
        assertEquals(20, f.getCheckinKg());
        assertEquals(8, f.getCabinKg());
    }

    @Test
    void testToStringContainsAllFields() {
        User owner = new User();
        Flight f = new Flight(3, owner, "SF303", "Plus", 200, 25, 10);
        String s = f.toString();
        assertTrue(s.contains("3"));
        assertTrue(s.contains("SF303"));
        assertTrue(s.contains("Plus"));
        assertTrue(s.contains("200"));
        assertTrue(s.contains("25"));
        assertTrue(s.contains("10"));
    }
}
