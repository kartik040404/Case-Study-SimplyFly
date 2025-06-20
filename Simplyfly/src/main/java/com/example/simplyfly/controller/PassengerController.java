package com.example.simplyfly.controller;

import com.example.simplyfly.entity.Flight;
import com.example.simplyfly.entity.Booking;
import com.example.simplyfly.service.FlightService;

import jakarta.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

  
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("today", LocalDate.now());
        return "passengerDashboard.jsp";
    }

    @GetMapping("/bookingHistory")
    public String bookingHistory(Model model) {
        model.addAttribute("today", LocalDate.now());
        return "bookingHistory.jsp";
    }
    
    @GetMapping("/profile")
    public String profile() {
        return "profilePage";  
    }
}
