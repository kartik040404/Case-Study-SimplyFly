package com.example.simplyfly.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplyfly.entity.Flight;

public interface FlightRepo extends JpaRepository<Flight,Integer>{
//	List<Flight> findByOriginAndDestinationAndDate(String origin, String destination, LocalDate date);
}
