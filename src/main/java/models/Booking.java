package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Booking {
    private int bookingId;
    private int userId;
    private int flightId;
    private BigDecimal totalAmount;
    private String status;
    private LocalDateTime bookingDate;

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", userId=" + userId +
                ", flightId=" + flightId +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                ", bookingDate=" + bookingDate +
                '}';
    }

    public Booking() {
    }

    public Booking(int bookingId, int userId, int flightId, BigDecimal totalAmount, String status, LocalDateTime bookingDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.flightId = flightId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.bookingDate = bookingDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}
