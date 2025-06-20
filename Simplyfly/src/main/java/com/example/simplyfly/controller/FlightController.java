package com.example.simplyfly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.simplyfly.dto.RouteRequest;
import com.example.simplyfly.entity.Flight;
import com.example.simplyfly.entity.Route;
import com.example.simplyfly.repository.FlightRepo;
import com.example.simplyfly.repository.RouteRepo;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private RouteRepo routeRepo;

   
    @PostMapping("/{flightId}/routes")
    public ResponseEntity<Route> createRoute(@PathVariable int flightId,@RequestBody RouteRequest req) {

        Optional<Flight> flight = flightRepo.findById(flightId);
                
if(flight.isPresent()) {
	
        Route route = new Route();
        route.setRouteId(req.getRouteId());
        route.setOrigin(req.getOrigin());
        route.setDestination(req.getDestination());
        route.setDepartureTs(LocalDateTime.parse(req.getDepartureTs()));
        route.setArrivalTs(LocalDateTime.parse(req.getArrivalTs()));
        route.setFarePerSeat(req.getFarePerSeat());
        route.setFlight(flight.get());

        Route saved = routeRepo.save(route);
        return new ResponseEntity<Route>(saved,HttpStatus.OK);
}
else return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
    }


   
}
