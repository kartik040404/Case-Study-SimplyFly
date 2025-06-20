package com.example.simplyfly.controller;

import com.example.simplyfly.entity.User;
import com.example.simplyfly.enums.Role;
import com.example.simplyfly.service.AuthService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;



    @GetMapping("/login")
    public String loginPage() {
        return "/auth/loginPage.jsp";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "/auth/registerPage.jsp";
    }


    @PostMapping("/register")
    public String register(User user,Model model) {

        user.setRole(Role.PASSENGER);

        return  authService.registerPassenger(user, model);

    }


    @PostMapping("/login")
    public String login(@RequestParam String email,@RequestParam String password,HttpSession session,Model model) {
        return authService.login(email, password, session, model);
    }


    @GetMapping("/passenger")
    public String passengerDashboard() {
        return "/passenger/passengerDashboard.jsp";
    }

    @GetMapping("/flightOwner")
    public String flightOwnerDashboard() {
        return "/flightOwner/flightOwnerDashboard.jsp";
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "/admin/adminDashboard.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
        return "/auth/loginPage.jsp";
    }
}