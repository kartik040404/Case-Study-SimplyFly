package models;

public class Seat {
    private int seatId;
    private int flightId;
    private String seatNumber;
    private boolean isBooked;
    private String seatClass;

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", flightId=" + flightId +
                ", seatNumber='" + seatNumber + '\'' +
                ", isBooked=" + isBooked +
                ", seatClass='" + seatClass + '\'' +
                '}';
    }

    public Seat() {
    }

    public Seat(int seatId, int flightId, String seatNumber, boolean isBooked, String seatClass) {
        this.seatId = seatId;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
        this.seatClass = seatClass;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }
}
