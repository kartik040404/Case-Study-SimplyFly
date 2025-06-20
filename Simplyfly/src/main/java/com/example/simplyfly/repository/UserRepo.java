package com.example.simplyfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplyfly.entity.User;
import com.example.simplyfly.enums.Role;

public interface UserRepo extends JpaRepository<User,Integer>{
	User findByEmail(String email);
	  boolean existsByEmail(String email);
	  List<User> findByRole(Role role);

}
