package com.example.simplyfly.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RoutePojoTest {

    @Test
    void testSettersAndGetters() {
        Flight flight = new Flight();
        Route r = new Route();
        r.setRouteId(1);
        r.setFlight(flight);
        r.setOrigin("DEL");
        r.setDestination("BOM");
        LocalDateTime dep = LocalDateTime.of(2025,1,1,6,0);
        LocalDateTime arr = LocalDateTime.of(2025,1,1,8,0);
        r.setDepartureTs(dep);
        r.setArrivalTs(arr);
        r.setFarePerSeat(5500);

        assertEquals(1, r.getRouteId());
        assertEquals(flight, r.getFlight());
        assertEquals("DEL", r.getOrigin());
        assertEquals("BOM", r.getDestination());
        assertEquals(dep, r.getDepartureTs());
        assertEquals(arr, r.getArrivalTs());
        assertEquals(5500, r.getFarePerSeat());
    }

    @Test
    void testAllArgsConstructor() {
        Flight flight = new Flight();
        LocalDateTime dep = LocalDateTime.of(2025,1,2,6,0);
        LocalDateTime arr = LocalDateTime.of(2025,1,2,8,0);
        Route r = new Route(2, flight, "BLR", "DEL", dep, arr, 6000);
        assertEquals(2, r.getRouteId());
        assertEquals("BLR", r.getOrigin());
        assertEquals("DEL", r.getDestination());
        assertEquals(6000, r.getFarePerSeat());
    }

    @Test
    void testToStringContainsAllFields() {
        Flight flight = new Flight();
        LocalDateTime dep = LocalDateTime.of(2025,1,3,6,0);
        LocalDateTime arr = LocalDateTime.of(2025,1,3,8,0);
        Route r = new Route(3, flight, "MAA", "COK", dep, arr,6500);
        String s = r.toString();
        assertTrue(s.contains("3"));
        assertTrue(s.contains("MAA"));
        assertTrue(s.contains("COK"));
        assertTrue(s.contains("6500"));
    }
}
