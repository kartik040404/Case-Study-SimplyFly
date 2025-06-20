package com.example.simplyfly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.simplyfly.entity.*;
import com.example.simplyfly.enums.*;
import com.example.simplyfly.repository.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/passenger")
public class passengerControllerAPI {

    private RouteRepo routeRepo;


    @GetMapping("/api/passenger/routes/search")
    public ResponseEntity<List<RouteResponse>> searchRoutes(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam  LocalDate date) {

        List<Route> routes = routeRepo
                .findByOriginAndDestinationAndDepartureTsAfter(
                        origin,
                        destination,
                        date.atStartOfDay());

        List<RouteResponse> response = routes.stream()
                .map(r -> new RouteResponse(
                        r.getRouteId(),
                        r.getFlight().getFlightNumber(),
                        r.getOrigin(),
                        r.getDestination(),
                        r.getDepartureTs(),
                        r.getArrivalTs(),
                        r.getFarePerSeat()))
                .collect(Collectors.toList());

        return new ResponseEntity<List<RouteResponse>>(response,HttpStatus.OK);
    }

}
