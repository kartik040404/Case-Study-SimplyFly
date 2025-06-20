package com.example.simplyfly.entity;
import java.time.LocalDateTime;

public class RouteResponse {
    private int routeId;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTs;
    private LocalDateTime arrivalTs;
    private double farePerSeat;

    public RouteResponse(int routeId, String flightNumber, String origin, String destination,
                         LocalDateTime departureTs, LocalDateTime arrivalTs, double farePerSeat) {
        this.routeId = routeId;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTs = departureTs;
        this.arrivalTs = arrivalTs;
        this.farePerSeat = farePerSeat;
    }

    // Getters and setters
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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
}