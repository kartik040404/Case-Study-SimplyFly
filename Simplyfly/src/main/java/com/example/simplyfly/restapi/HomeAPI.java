package com.example.simplyfly.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeAPI {
	
	@GetMapping("/")
	public ResponseEntity<String> home(){
		return new ResponseEntity<String>("Welcome User",HttpStatus.OK);
	}
}
