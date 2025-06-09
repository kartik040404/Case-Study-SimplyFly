package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Flight {
    private int flightId;
    private String flightName;
    private String flightNumber;
    private int routeId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int totalSeats;
    private BigDecimal farePerSeat;
    private int ownerId;

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightName='" + flightName + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", routeId=" + routeId +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", totalSeats=" + totalSeats +
                ", farePerSeat=" + farePerSeat +
                ", ownerId=" + ownerId +
                '}';
    }

    public Flight() {
    }

    public Flight(int flightId, String flightName, String flightNumber, int routeId, LocalDateTime departureTime, LocalDateTime arrivalTime, int totalSeats, BigDecimal farePerSeat, int ownerId) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.flightNumber = flightNumber;
        this.routeId = routeId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.farePerSeat = farePerSeat;
        this.ownerId = ownerId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public BigDecimal getFarePerSeat() {
        return farePerSeat;
    }

    public void setFarePerSeat(BigDecimal farePerSeat) {
        this.farePerSeat = farePerSeat;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
