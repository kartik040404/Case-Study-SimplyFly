package com.example.simplyfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplyfly.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Integer>{

}
