package com.example.simplyfly.controller;

import com.example.simplyfly.entity.Route;
import com.example.simplyfly.repository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SearchController {

    @Autowired
    private RouteRepo routeRepo;

    @GetMapping("/searchRoute")
    public String showSearchForm() {
        return "search.jsp";
    }

    @PostMapping("/searchRoute")
    public String doSearch(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date,
            Model model)
    {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end   = date.plusDays(1).atStartOfDay();

        List<Route> all = routeRepo.findAll();
        List<Route> filtered = all.stream()
            .filter(r -> r.getOrigin().equalsIgnoreCase(origin))
            .filter(r -> r.getDestination().equalsIgnoreCase(destination))
            .filter(r -> !r.getDepartureTs().isBefore(start)
                      && r.getDepartureTs().isBefore(end))
            .collect(Collectors.toList());

        model.addAttribute("routes", filtered);
        return "search.jsp";
    }
}
