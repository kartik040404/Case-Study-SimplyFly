package com.example.simplyfly.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplyfly.JWTCheck;
import com.example.simplyfly.dto.LoginRequest;
import com.example.simplyfly.entity.User;
import com.example.simplyfly.service.AuthService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class AuthAPI {
	@Autowired
	private AuthService authService;

	@Autowired
	private JWTCheck jwtCheck;
	
	@PostMapping("/login")
	public ResponseEntity<String>login(@RequestBody LoginRequest req,HttpSession session){
		return authService.loginAPI(req,session);
	}
	
	@PostMapping("/register")
	public ResponseEntity<User>register(@RequestBody User user){
		return authService.registerAPI(user);
	}
	
	@GetMapping("/verifyToken/{token}")
	public ResponseEntity<String>verify(@PathVariable String token){
		if(jwtCheck.validateToken(token)) {			
		return new ResponseEntity<String>("True",HttpStatus.OK);
		}
		return new ResponseEntity<String>("False",HttpStatus.UNAUTHORIZED);

	}
	
	@GetMapping("/getSubject/{token}")
	public ResponseEntity<Claims>getSubject(@PathVariable String token){
		Claims email=jwtCheck.extractUsername(token);
		return new ResponseEntity<Claims>(email,HttpStatus.UNAUTHORIZED);

	}

}
