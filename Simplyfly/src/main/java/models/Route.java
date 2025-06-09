package models;

import java.time.LocalTime;

public class Route {
    private int routeId;
    private String origin;
    private String destination;
    private LocalTime duration;

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", duration=" + duration +
                '}';
    }

    public Route() {
    }

    public Route(int routeId, String origin, String destination, LocalTime duration) {
        this.routeId = routeId;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
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

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
}
