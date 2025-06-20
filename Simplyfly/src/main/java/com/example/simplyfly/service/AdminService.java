package com.example.simplyfly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.simplyfly.entity.User;
import com.example.simplyfly.enums.Role;
import com.example.simplyfly.repository.UserRepo;

@Service
public class AdminService {
	
@Autowired
private UserRepo userRepo;

		public String showFlightOwnerService(Model model) {
			 List<User> owners = userRepo.findByRole(Role.FLIGHT_OWNER);
		        model.addAttribute("owners", owners);
			return "/admin/addFlightOwner.jsp";
		}
		
		public String createFlightOwnerService(User owner,Model model) {
	        owner.setRole(Role.FLIGHT_OWNER);
	        userRepo.save(owner);
	        model.addAttribute("msg", "Flight owner created!");
	        return "redirect:/admin/addFlightOwner";
	    }
		
		 public String listUsersService(Model model) {
		        List<User> users = userRepo.findByRole(Role.PASSENGER);
		        model.addAttribute("users", users);
		        return "/admin/manageUsers.jsp";
		    }

		    public String deleteUserService(int userId) {
		    	userRepo.deleteById(userId);
		        return "redirect:/admin/manageUsers";
		    }
		    
		    
		    
		    
		   
		    
		    
		    public ResponseEntity<List<User>> getFlightOwnersAPI() {
		        List<User> users = userRepo.findByRole(Role.FLIGHT_OWNER);
		         return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		         
		    }
		    public ResponseEntity<List<User>> getPassengers() {
		        List<User> users = userRepo.findByRole(Role.PASSENGER);
		         return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		         
		    }
		    
		    public ResponseEntity<User> deletePassenger(int id) {
		    	 Optional<User> user=userRepo.findById(id);
					if(user.isPresent()) {			
						userRepo.deleteById(id);
						return new ResponseEntity<User>(user.get(),HttpStatus.OK);
					}
					else return new ResponseEntity<User>(HttpStatus.NOT_FOUND);  
		    }
		    
			public ResponseEntity<User> updateAdminProfile(@PathVariable int id,@RequestBody User user) {
				Optional<User> user1=userRepo.findById(id);
				if(user1.isPresent()) {	
					user.setUserID(id);
					userRepo.save(user);
					return new ResponseEntity<User>(user,HttpStatus.OK);
				}
				else return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
}
