package com.example.simplyfly.controller;

import com.example.simplyfly.entity.User;
import com.example.simplyfly.enums.Role;
import com.example.simplyfly.repository.UserRepo;
import com.example.simplyfly.service.AdminService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private AdminService adminService;
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "adminDashboard.jsp";
    }
    
    @GetMapping("/routes")
    public String routesPage() {
        return "routesPage.jsp";
    }
    @GetMapping("/bookings")
    public String bookingPage() {
        return "bookingPage.jsp";
    }

    
    @GetMapping("/profilePage")
    public String profilePage() {
        return "profilePage.jsp";
    }

    @GetMapping("/addFlightOwner")
    public String showFlightOwners(Model model) {
        return adminService.showFlightOwnerService(model);
    }

    @PostMapping("/addFlightOwner")
    public String createFlightOwner(User owner,Model model) {
      return adminService.createFlightOwnerService(owner, model);
    }
    
    @GetMapping("/manageUsers")
    public String listUsers(Model model) {
        return adminService.listUsersService(model);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int userId) {
       return adminService.deleteUserService(userId);
    }
}
