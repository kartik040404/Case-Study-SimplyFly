package com.example.simplyfly.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Route {
	  @Id
	  private int routeId;
	 @ManyToOne private Flight flight;
	    private String origin, destination;
	    private LocalDateTime departureTs, arrivalTs;
	    private double farePerSeat;
	    
	    
		public Route() {
			super();
		}


		public Route(Integer routeId, Flight flight, String origin, String destination, LocalDateTime departureTs,
				LocalDateTime arrivalTs, double farePerSeat) {
			super();
			this.routeId = routeId;
			this.flight = flight;
			this.origin = origin;
			this.destination = destination;
			this.departureTs = departureTs;
			this.arrivalTs = arrivalTs;
			this.farePerSeat = farePerSeat;
		}


		public Integer getRouteId() {
			return routeId;
		}


		public void setRouteId(Integer routeId) {
			this.routeId = routeId;
		}


		public Flight getFlight() {
			return flight;
		}


		public void setFlight(Flight flight) {
			this.flight = flight;
		}


		public String getOrigin() {
			return origin;
		}


		public void setOrigin(String origin) {
			this.origin = origin;
		}


		public String getDestination() {
			return destination;
		}


		public void setDestination(String destination) {
			this.destination = destination;
		}


		public LocalDateTime getDepartureTs() {
			return departureTs;
		}


		public void setDepartureTs(LocalDateTime departureTs) {
			this.departureTs = departureTs;
		}


		public LocalDateTime getArrivalTs() {
			return arrivalTs;
		}


		public void setArrivalTs(LocalDateTime arrivalTs) {
			this.arrivalTs = arrivalTs;
		}


		public double getFarePerSeat() {
			return farePerSeat;
		}


		public void setFarePerSeat(double farePerSeat) {
			this.farePerSeat = farePerSeat;
		}


		@Override
		public String toString() {
			return "Route [routeId=" + routeId + ", flight=" + flight + ", origin=" + origin + ", destination="
					+ destination + ", departureTs=" + departureTs + ", arrivalTs=" + arrivalTs + ", farePerSeat="
					+ farePerSeat + "]";
		}
	    
	    
}
