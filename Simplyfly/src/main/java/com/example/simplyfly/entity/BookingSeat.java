package com.example.simplyfly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class BookingSeat {
	 @Id private int id;
	  @ManyToOne  Booking booking;
	  @ManyToOne private Seat seat;
	  
	  public BookingSeat() {
		super();
	}

	  public BookingSeat(Integer id, Booking booking, Seat seat) {
		super();
		this.id = id;
		this.booking = booking;
		this.seat = seat;
	}
	  

	  public Integer getId() {
		return id;
	}

	  public void setId(Integer id) {
		  this.id = id;
	  }

	  public Booking getBooking() {
		  return booking;
	  }

	  public void setBooking(Booking booking) {
		  this.booking = booking;
	  }

	  public Seat getSeat() {
		  return seat;
	  }

	  public void setSeat(Seat seat) {
		  this.seat = seat;
	  }

	  @Override
	  public String toString() {
		return "BookingSeat [id=" + id + ", booking=" + booking + ", seat=" + seat + "]";
	  }
	  
}
