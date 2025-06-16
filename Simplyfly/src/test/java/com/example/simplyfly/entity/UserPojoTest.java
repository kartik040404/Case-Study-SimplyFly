package com.example.simplyfly.entity;

import com.example.simplyfly.enums.Role;
import com.example.simplyfly.repository.UserRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserPojoTest {
	  @Autowired
	    private UserRepo userRepo;

	    @Test
	    void testSave() {
	        User user = new User();
	        user.setUserID(1);
	        user.setName("Kartik");
	        user.setEmail("kartik@example.com");
	        user.setPasswordHash("pass");
	        user.setGender("Male");
	        user.setContactNumber("1234567890");
	        user.setAddress("address");
	        user.setRole(Role.PASSENGER);
	        LocalDateTime date = LocalDateTime.of(2025, 6, 16, 10, 30);
	        user.setCreatedAt(date);

	        User saved = userRepo.save(user);
	        assertNotNull(saved);
	        assertEquals(1,user.getUserID());
			assertEquals("Kartik",user.getName());
			assertEquals("kartik@example.com",user.getEmail());
			assertEquals("address",user.getAddress());
			assertEquals("1234567890",user.getContactNumber());
			assertEquals("Male",user.getGender());
			assertEquals(Role.PASSENGER,user.getRole());
			assertEquals("pass",user.getPasswordHash());
			assertEquals(date,user.getCreatedAt());

	    }

	    @Test
	    void testFindById() {
	        User user = new User(2, "FindUser", "find@example.com", "pwd", "Male", "111", "Somewhere", Role.ADMIN, LocalDateTime.now());
	        userRepo.save(user);

	        User found = userRepo.findById(2).get();
	        assertNotNull(found);
	        assertEquals("FindUser", found.getName());
	    }

	    @Test
	    void testFindAll() {
	        userRepo.save(new User(3, "A", "a@example.com", "p1", "F", "123", "X", Role.PASSENGER, LocalDateTime.now()));
	        userRepo.save(new User(4, "B", "b@example.com", "p2", "M", "456", "Y", Role.ADMIN, LocalDateTime.now()));

	        List<User> users = userRepo.findAll();
	        assertEquals(4, users.size());
	    }

	    @Test
	    void testDeleteById() {
	        User user = userRepo.save(new User(5, "DelUser", "del@example.com", "p3", "Other", "789", "Z", Role.PASSENGER, LocalDateTime.now()));
	        userRepo.deleteById(user.getUserID());

	        Optional<User> deleted = userRepo.findById(5);
	        assertFalse(deleted.isPresent());
	    }
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
