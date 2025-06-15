package com.example.simplyfly.controller;

import com.example.simplyfly.entity.Route;
import com.example.simplyfly.repository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class RouteController {

    @Autowired
    private RouteRepo routeRepo;

    @GetMapping("/")
    public String listRoutes(Model model) {
        model.addAttribute("routes", routeRepo.findAll());
        return "routes.jsp";                  
    }

    @GetMapping("/addRouteForm")
    public String addRouteForm() {
        return "addRoute.jsp";              
    }

    @PostMapping("/addRoute")
    public String addRoute(Route route) {
        routeRepo.save(route);
        return "redirect:/";                
    }
}
