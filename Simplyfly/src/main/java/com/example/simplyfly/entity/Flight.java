package com.example.simplyfly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Flight {
		@Id
	    private int flightId;
	    @ManyToOne User owner;
	    private String flightNumber;
	    private String flightName;
	    private int totalSeats;
	    private int checkinKg;
	    private int cabinKg;
	    
		public Flight() {
			super();
		}

		public Flight(Integer flightId, User owner, String flightNumber, String flightName, int totalSeats,
				int checkinKg, int cabinKg) {
			super();
			this.flightId = flightId;
			this.owner = owner;
			this.flightNumber = flightNumber;
			this.flightName = flightName;
			this.totalSeats = totalSeats;
			this.checkinKg = checkinKg;
			this.cabinKg = cabinKg;
		}
		

		public Integer getFlightId() {
			return flightId;
		}

		public void setFlightId(Integer flightId) {
			this.flightId = flightId;
		}

		public User getOwner() {
			return owner;
		}

		public void setOwner(User owner) {
			this.owner = owner;
		}

		public String getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}

		public String getFlightName() {
			return flightName;
		}

		public void setFlightName(String flightName) {
			this.flightName = flightName;
		}

		public int getTotalSeats() {
			return totalSeats;
		}

		public void setTotalSeats(int totalSeats) {
			this.totalSeats = totalSeats;
		}

		public int getCheckinKg() {
			return checkinKg;
		}

		public void setCheckinKg(int checkinKg) {
			this.checkinKg = checkinKg;
		}

		public int getCabinKg() {
			return cabinKg;
		}

		public void setCabinKg(int cabinKg) {
			this.cabinKg = cabinKg;
		}

		@Override
		public String toString() {
			return "Flight [flightId=" + flightId + ", owner=" + owner + ", flightNumber=" + flightNumber
					+ ", flightName=" + flightName + ", totalSeats=" + totalSeats + ", checkinKg=" + checkinKg
					+ ", cabinKg=" + cabinKg + "]";
		}
	    
	    
}
