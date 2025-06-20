package com.example.simplyfly.dto;

public class RouteRequest {
    private int routeId;
    private String origin;
    private String destination;
    private String departureTs;
    private String arrivalTs;
    private double farePerSeat;
    public int getRouteId() { return routeId; }
    public void setRouteId(int routeId) { this.routeId = routeId; }
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getDepartureTs() { return departureTs; }
    public void setDepartureTs(String departureTs) { this.departureTs = departureTs; }
    public String getArrivalTs() { return arrivalTs; }
    public void setArrivalTs(String arrivalTs) { this.arrivalTs = arrivalTs; }
    public double getFarePerSeat() { return farePerSeat; }
    public void setFarePerSeat(double farePerSeat) { this.farePerSeat = farePerSeat; }
}