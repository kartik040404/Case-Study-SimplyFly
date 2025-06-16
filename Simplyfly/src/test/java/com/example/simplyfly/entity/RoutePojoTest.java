package com.example.simplyfly.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.simplyfly.repository.FlightRepo;
import com.example.simplyfly.repository.RouteRepo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RoutePojoTest {
	@Autowired
    private RouteRepo routeRepo;

    @Autowired
    private FlightRepo flightRepo;

    @Test
    void testSave() {
        // Prepare Flight
        Flight flight = new Flight();
        flight.setFlightId(1);
        flightRepo.save(flight);

        // Save Route with double fare
        LocalDateTime dep = LocalDateTime.of(2025, 1, 1, 6, 0);
        LocalDateTime arr = LocalDateTime.of(2025, 1, 1, 8, 0);
        Route route = new Route(10, flight, "DEL", "BOM", dep, arr, 5500.0);
        Route saved = routeRepo.save(route);

        assertNotNull(saved);
        assertEquals(10, saved.getRouteId());
        assertEquals("DEL", saved.getOrigin());
        assertEquals(5500.0, saved.getFarePerSeat());
    }

    @Test
    void testFindById() {
        Flight flight = new Flight();
        flight.setFlightId(2);
        flightRepo.save(flight);

        Route route = new Route(20, flight, "BLR", "DEL",
            LocalDateTime.now(), LocalDateTime.now().plusHours(2), 6000.0);
        routeRepo.save(route);

        Optional<Route> opt = routeRepo.findById(20);
        assertTrue(opt.isPresent());
        assertEquals("BLR", opt.get().getOrigin());
    }

    @Test
    void testFindAll() {
        routeRepo.deleteAll();
        flightRepo.deleteAll();

        Flight f1 = new Flight(); f1.setFlightId(3); flightRepo.save(f1);
        Flight f2 = new Flight(); f2.setFlightId(4); flightRepo.save(f2);

        routeRepo.save(new Route(30, f1, "MAA", "COK",
            LocalDateTime.now(), LocalDateTime.now().plusHours(2), 6500.0));
        routeRepo.save(new Route(31, f2, "HYD", "BLR",
            LocalDateTime.now(), LocalDateTime.now().plusHours(3), 7000.0));

        List<Route> list = routeRepo.findAll();
        assertEquals(2, list.size());
    }

    @Test
    void testDeleteById() {
        Flight flight = new Flight();
        flight.setFlightId(5);
        flightRepo.save(flight);

        Route r = new Route(40, flight, "PUN", "DEL",
            LocalDateTime.now(), LocalDateTime.now().plusHours(2), 7200.0);
        routeRepo.save(r);

        routeRepo.deleteById(40);
        assertFalse(routeRepo.findById(40).isPresent());
    }
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
