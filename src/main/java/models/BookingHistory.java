package models;


import java.time.LocalDateTime;

public class BookingHistory {
    private int historyId;
    private int bookingId;
    private String action;
    private LocalDateTime actionDate;

    @Override
    public String toString() {
        return "BookingHistory{" +
                "historyId=" + historyId +
                ", bookingId=" + bookingId +
                ", action='" + action + '\'' +
                ", actionDate=" + actionDate +
                '}';
    }

    public BookingHistory() {
    }

    public BookingHistory(int historyId, int bookingId, String action, LocalDateTime actionDate) {
        this.historyId = historyId;
        this.bookingId = bookingId;
        this.action = action;
        this.actionDate = actionDate;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }
}
