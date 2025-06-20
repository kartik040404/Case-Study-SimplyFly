package com.example.simplyfly.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplyfly.entity.Route;

public interface RouteRepo extends JpaRepository<Route,Integer>{
	List<Route> findByOriginAndDestinationAndDepartureTsAfter(
            String origin,
            String destination,
            LocalDateTime start);
	
}
