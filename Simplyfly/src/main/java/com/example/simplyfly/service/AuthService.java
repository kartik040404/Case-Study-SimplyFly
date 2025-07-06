package com.example.simplyfly.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.simplyfly.JWTCheck;
import com.example.simplyfly.dto.LoginRequest;
import com.example.simplyfly.entity.User; 
import com.example.simplyfly.enums.Role;
import com.example.simplyfly.repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class AuthService {
		@Autowired
		private UserRepo userRepo;
		
		@Autowired
		private JWTCheck jwtCheck;

		 public String login(String email,String password,HttpSession session,Model model) {
			 User user = userRepo.findByEmail(email); 
			 System.out.println(user);
		        if (user != null&&user.getPassword().equals(password)) {

		        	session.setAttribute("user", user);
		            switch (user.getRole().name()) {
		                case "PASSENGER":
		                    return "redirect:/passenger/passengerDashboard.jsp";
		                case "FLIGHT_OWNER":
		                    return "redirect:/flightOwner/flightOwnerDashboard.jsp";
		                case "ADMIN":
		                    return "redirect:/admin/adminDashboard.jsp";
		                default:
		                    model.addAttribute("error", "Unknown role");
		                    return "/auth/loginPage.jsp";
		            }
		        }

		        model.addAttribute("error", "Invalid email or password");
		        return "/auth/loginPage.jsp";
		    }

		    public String registerPassenger(User user,Model model) {
		        if (userRepo.existsByEmail(user.getEmail())) {
		            model.addAttribute("error", "Email already in use");
		            return "/auth/registerPage.jsp";
		        }
		        user.setRole(Role.PASSENGER);
		        user.setCreatedAt(LocalDateTime.now());
		        userRepo.save(user);

		        model.addAttribute("msg", "Registration successful—please log in.");
		        return "/auth/loginPage.jsp";
		    }
		    
		    
		    
		    
		    
		    public ResponseEntity<String> loginAPI(LoginRequest req,HttpSession session){
		    	 User user = userRepo.findByEmail(req.getEmail()); 
			        if (user != null&&user.getPassword().equals(req.getPassword())) {
			        	 String token = jwtCheck.generateToken(user.getEmail());
//			        	session.setAttribute("token", token);
//				        return new ResponseEntity<String>(token,HttpStatus.OK);
			        	 return ResponseEntity
			                     .ok()
			                     .header(HttpHeaders.AUTHORIZATION, "Bearer " + token).body(token);
			                    
			        }
			        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		    }
		    
		    
		    public ResponseEntity<User> registerAPI(User user){
		    	 if (userRepo.existsByEmail(user.getEmail())) {
			            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			        }
			        user.setRole(Role.PASSENGER);
			        user.setCreatedAt(LocalDateTime.now());
			        userRepo.save(user);
			    
		            return new ResponseEntity<>(user,HttpStatus.OK);
		    }
}