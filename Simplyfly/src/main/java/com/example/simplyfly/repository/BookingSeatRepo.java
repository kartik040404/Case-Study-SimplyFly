package com.example.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplyfly.entity.BookingSeat;

public interface BookingSeatRepo extends JpaRepository<BookingSeat,Integer>{

}
