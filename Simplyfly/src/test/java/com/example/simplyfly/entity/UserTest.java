package com.example.simplyfly.entity;




import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.simplyfly.entity.User;
import com.example.simplyfly.enums.Role;
import com.example.simplyfly.repository.UserRepo;


@SpringBootTest
public class UserTest {

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
}
