package com.example.simplyfly.entity;

import com.example.simplyfly.enums.Role;
import com.example.simplyfly.repository.FlightRepo;
import com.example.simplyfly.repository.UserRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
//@SpringBootTest
@DataJpaTest
class FlightPojoTest {
    @Autowired
    private FlightRepo flightRepo;

    @Autowired
    private UserRepo userRepo;

    @Test
    void testSave() {
        // Prepare owner
        User owner = new User();
        owner.setUserID(1);
        owner.setName("Owner");
        userRepo.save(owner);

        // Create and save Flight
        Flight f = new Flight(10, owner, "SF101", "Express", 180, 15, 7);
        Flight saved = flightRepo.save(f);

        assertNotNull(saved, "Saved flight should not be null");
        assertEquals(10, saved.getFlightId());
        assertEquals("SF101", saved.getFlightNumber());
        assertEquals("Express", saved.getFlightName());
        assertEquals(180, saved.getTotalSeats());
        assertEquals(15, saved.getCheckinKg());
        assertEquals(7, saved.getCabinKg());
    }

    @Test
    void testFindById() {
        // Prepare owner
        User owner = new User(); owner.setUserID(2); owner.setName("Owner2"); userRepo.save(owner);

        Flight f = new Flight(20, owner, "SF202", "Max", 150, 20, 8);
        flightRepo.save(f);

        Optional<Flight> opt = flightRepo.findById(20);
        assertTrue(opt.isPresent(), "Flight should be found by ID");
        assertEquals("SF202", opt.get().getFlightNumber());
    }


    @Test
    void testDeleteById() {
        User owner = new User(); owner.setUserID(5); owner.setName("O5"); userRepo.save(owner);

        Flight f = new Flight(40, owner, "SF505", "Prime", 160, 18, 9);
        flightRepo.save(f);

        flightRepo.deleteById(40);
        assertFalse(flightRepo.findById(40).isPresent(), "Flight should be deleted");
    }
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
