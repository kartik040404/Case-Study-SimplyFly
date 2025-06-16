package com.example.simplyfly.entity;

import com.example.simplyfly.enums.SeatClass;
import com.example.simplyfly.enums.SeatStatus;
import com.example.simplyfly.repository.RouteRepo;
import com.example.simplyfly.repository.SeatRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
@SpringBootTest
class SeatPojoTest {
	 @Autowired
	    private SeatRepo seatRepo;

	    @Autowired
	    private RouteRepo routeRepo;

	    @Test
	    void testSave() {
 	        Route route = new Route();
	        route.setRouteId(100);
	        routeRepo.save(route);

 	        Seat seat = new Seat(10, route, "1A", SeatClass.ECONOMY, SeatStatus.AVAILABLE);
	        Seat saved = seatRepo.save(seat);

	        assertNotNull(saved, "Saved seat should not be null");
	        assertEquals(10, saved.getSeatId());
	        assertEquals("1A", saved.getSeatNumber());
	        assertEquals(SeatClass.ECONOMY, saved.getClassType());
	        assertEquals(SeatStatus.AVAILABLE, saved.getStatus());
	    }

	    @Test
	    void testFindById() {
 	        Route route = new Route();
	        route.setRouteId(200);
	        routeRepo.save(route);

 	        Seat seat = new Seat(20, route, "2B", SeatClass.BUSINESS, SeatStatus.BOOKED);
	        seatRepo.save(seat);

 	        Optional<Seat> found = seatRepo.findById(20);
	        assertTrue(found.isPresent(), "Seat should be found");
	        assertEquals("2B", found.get().getSeatNumber());
	    }

	    @Test
	    void testFindAll() {
 	        seatRepo.deleteAll();
	        routeRepo.deleteAll();

	        Route r1 = new Route(); r1.setRouteId(300); routeRepo.save(r1);
	        Route r2 = new Route(); r2.setRouteId(400); routeRepo.save(r2);

	        seatRepo.save(new Seat(30, r1, "3C", SeatClass.ECONOMY, SeatStatus.AVAILABLE));
	        seatRepo.save(new Seat(31, r2, "3D", SeatClass.BUSINESS, SeatStatus.BOOKED));

	        List<Seat> seats = seatRepo.findAll();
	        assertEquals(2, seats.size(), "Should retrieve two seats");
	    }

	    @Test
	    void testDeleteById() {
 	        Route route = new Route();
	        route.setRouteId(500);
	        routeRepo.save(route);
	        
	        Seat seat = new Seat(40, route, "4E", SeatClass.ECONOMY, SeatStatus.AVAILABLE);
	        seatRepo.save(seat);

 	        seatRepo.deleteById(40);

	        Optional<Seat> deleted = seatRepo.findById(40);
	        assertFalse(deleted.isPresent(), "Seat should be deleted");
	    }
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
