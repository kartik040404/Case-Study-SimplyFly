package com.example.simplyfly.entity;

import com.example.simplyfly.enums.Role;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserPojoTest {

    @Test
    void testSettersAndGetters() {

        User u = new User();  

        u.setUserID(1);
        u.setName("Alice");
        u.setEmail("alice@example.com");
        u.setPasswordHash("hash");
        u.setGender("Female");
        u.setContactNumber("1234567890");
        u.setAddress("Wonderland");
        u.setRole(Role.PASSENGER);
        LocalDateTime now = LocalDateTime.now();
        u.setCreatedAt(now);

        assertEquals(1, u.getUserID());
        assertEquals("Alice", u.getName());
        assertEquals("alice@example.com", u.getEmail());
        assertEquals("hash", u.getPasswordHash());
        assertEquals("Female", u.getGender());
        assertEquals("1234567890", u.getContactNumber());
        assertEquals("Wonderland", u.getAddress());
        assertEquals(Role.PASSENGER, u.getRole());
        assertEquals(now, u.getCreatedAt());
    }


    @Test
    void testAllArgsConstructor() {

        LocalDateTime now = LocalDateTime.now();

        User u = new User(
                2,
                "Bob",
                "bob@example.com",
                "pw",
                "Male",
                "9876543210",
                "City",
                Role.ADMIN,
                now
        );

        assertEquals(2, u.getUserID());
        assertEquals("Bob", u.getName());
        assertEquals("bob@example.com", u.getEmail());
        assertEquals("pw", u.getPasswordHash());
        assertEquals("Male", u.getGender());
        assertEquals("9876543210", u.getContactNumber());
        assertEquals("City", u.getAddress());
        assertEquals(Role.ADMIN, u.getRole());
        assertEquals(now, u.getCreatedAt());
    }


    @Test
    void testToStringContainsAllFields() {

        LocalDateTime now = LocalDateTime.of(2025, 1, 15, 10, 0);

        User u = new User(
                3,
                "Charlie",
                "charlie@example.com",
                "pw123",
                "Other",
                "1112223333",
                "Town",
                Role.PASSENGER,
                now
        );

        String s = u.toString();

        assertTrue(s.contains("3"));
        assertTrue(s.contains("Charlie"));
        assertTrue(s.contains("charlie@example.com"));
        assertTrue(s.contains("pw123"));
        assertTrue(s.contains("Other"));
        assertTrue(s.contains("1112223333"));
        assertTrue(s.contains("Town"));
        assertTrue(s.contains("PASSENGER"));
        assertTrue(s.contains("2025"));   
    }
}
