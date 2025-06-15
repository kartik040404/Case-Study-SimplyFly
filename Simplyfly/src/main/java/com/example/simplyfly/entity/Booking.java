package com.example.simplyfly.entity;

import java.time.LocalDateTime;

import com.example.simplyfly.enums.BookingStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Booking {
    @Id private int bookingId;
   @ManyToOne private User user;
    @ManyToOne  Route route;
    private double totalAmount;
    private LocalDateTime bookedAt;
   private BookingStatus status;
   
   
   public Booking() {
	super();
}


   public Booking(int bookingId, User user, Route route, double totalAmount, LocalDateTime bookedAt,
		BookingStatus status) {
	super();
	this.bookingId = bookingId;
	this.user = user;
	this.route = route;
	this.totalAmount = totalAmount;
	this.bookedAt = bookedAt;
	this.status = status;
}


   public int getBookingId() {
	return bookingId;
}


   public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
   }


   public User getUser() {
	return user;
   }


   public void setUser(User user) {
	this.user = user;
   }


   public Route getRoute() {
	return route;
   }


   public void setRoute(Route route) {
	this.route = route;
   }


   public double getTotalAmount() {
	return totalAmount;
   }


   public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
   }


   public LocalDateTime getBookedAt() {
	return bookedAt;
   }


   public void setBookedAt(LocalDateTime bookedAt) {
	this.bookedAt = bookedAt;
   }


   public BookingStatus getStatus() {
	return status;
   }


   public void setStatus(BookingStatus status) {
	this.status = status;
   }


   @Override
   public String toString() {
	return "Booking [bookingId=" + bookingId + ", user=" + user + ", route=" + route + ", totalAmount=" + totalAmount
			+ ", bookedAt=" + bookedAt + ", status=" + status + "]";
   }
   
   

}
