package com.example.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplyfly.entity.Flight;

public interface FlightRepo extends JpaRepository<Flight,Integer>{

}
