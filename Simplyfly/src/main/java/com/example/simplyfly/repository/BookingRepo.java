package com.example.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplyfly.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking,Integer>{

}
