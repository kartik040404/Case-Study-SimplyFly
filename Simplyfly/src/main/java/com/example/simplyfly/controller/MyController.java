package com.example.simplyfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplyfly.entity.User;
import com.example.simplyfly.service.UserService;
@RestController
public class MyController {
	@Autowired
	 private  UserService userService;

//	    public MyController(UserService userService) {
//	        this.userService = userService;
//	    }

	    @GetMapping("/users")
	    public void getAllUsers() {
	        List<User> list=userService.displayUsers();
//	        for(User user:list) {
//	        	System.out.println(user.toString());
//	        }
	        list.forEach(user->System.out.println(user.getName()));
	    }
}
