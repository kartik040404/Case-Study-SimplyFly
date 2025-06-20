package com.example.simplyfly.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplyfly.entity.Flight;
import com.example.simplyfly.entity.User;
import com.example.simplyfly.enums.Role;
import com.example.simplyfly.service.AdminService;

@RestController
@RequestMapping("/api/admin/")
public class AdminAPI {
	@Autowired
    private AdminService adminService;

	@GetMapping("/getFlightOwners")
	public ResponseEntity<List<User>> getFlightOwners(){
        return adminService.getFlightOwnersAPI();
	}
	

	@GetMapping("/getPassengers")
	public ResponseEntity<List<User>> getPassengers(){
        return adminService.getPassengers();
	}
	
	@DeleteMapping("/deletePassenger/{id}")
	public ResponseEntity<User> deletePassenger(@PathVariable int id) {
		return adminService.deletePassenger(id);
	}
	
	
	
	@PutMapping("/updateProfile/{id}")
	public ResponseEntity<User> updateAdminProfile(@PathVariable int id,@RequestBody User user){
		return adminService.updateAdminProfile(id, user);
	}

}
