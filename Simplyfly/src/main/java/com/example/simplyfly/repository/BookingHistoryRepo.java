package com.example.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplyfly.entity.BookingHistory;

public interface BookingHistoryRepo extends JpaRepository<BookingHistory,Integer>{

}
