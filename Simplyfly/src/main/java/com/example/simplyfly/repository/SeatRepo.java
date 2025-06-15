package com.example.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplyfly.entity.Seat;

public interface SeatRepo  extends JpaRepository<Seat,Integer>{

}
