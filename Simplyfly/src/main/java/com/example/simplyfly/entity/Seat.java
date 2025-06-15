package com.example.simplyfly.entity;

import com.example.simplyfly.enums.SeatClass;
import com.example.simplyfly.enums.SeatStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Seat {
	 @Id 
	 private int seatId;
	@ManyToOne private Route route;
	 private String seatNumber;
	 private SeatClass classType;
	 private SeatStatus status;
	 
	 
	 public Seat() {
		super();
	}


	 public Seat(int seatId, Route route, String seatNumber, SeatClass classType, SeatStatus status) {
		super();
		this.seatId = seatId;
		this.route = route;
		this.seatNumber = seatNumber;
		this.classType = classType;
		this.status = status;
	}


	 public int getSeatId() {
		return seatId;
	}


	 public void setSeatId(int seatId) {
		 this.seatId = seatId;
	 }


	 public Route getRoute() {
		 return route;
	 }


	 public void setRoute(Route route) {
		 this.route = route;
	 }


	 public String getSeatNumber() {
		 return seatNumber;
	 }


	 public void setSeatNumber(String seatNumber) {
		 this.seatNumber = seatNumber;
	 }


	 public SeatClass getClassType() {
		 return classType;
	 }


	 public void setClassType(SeatClass classType) {
		 this.classType = classType;
	 }


	 public SeatStatus getStatus() {
		 return status;
	 }


	 public void setStatus(SeatStatus status) {
		 this.status = status;
	 }


	 @Override
	 public String toString() {
		return "Seat [seatId=" + seatId + ", route=" + route + ", seatNumber=" + seatNumber + ", classType=" + classType
				+ ", status=" + status + "]";
	 }
	 
	 
}
