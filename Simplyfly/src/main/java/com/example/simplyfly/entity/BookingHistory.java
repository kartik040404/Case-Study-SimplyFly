package com.example.simplyfly.entity;

import java.time.LocalDateTime;

import com.example.simplyfly.enums.HistoryAction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class BookingHistory {
	  @Id 
	  private int historyId;
	    @ManyToOne Booking booking;
	    private HistoryAction action;
	    private LocalDateTime actionDate;
	    
	    
		public BookingHistory() {
			super();
		}


		public BookingHistory(int historyId, Booking booking, HistoryAction action, LocalDateTime actionDate) {
			super();
			this.historyId = historyId;
			this.booking = booking;
			this.action = action;
			this.actionDate = actionDate;
		}


		public int getHistoryId() {
			return historyId;
		}


		public void setHistoryId(int historyId) {
			this.historyId = historyId;
		}


		public Booking getBooking() {
			return booking;
		}


		public void setBooking(Booking booking) {
			this.booking = booking;
		}


		public HistoryAction getAction() {
			return action;
		}


		public void setAction(HistoryAction action) {
			this.action = action;
		}


		public LocalDateTime getActionDate() {
			return actionDate;
		}


		public void setActionDate(LocalDateTime actionDate) {
			this.actionDate = actionDate;
		}


		@Override
		public String toString() {
			return "BookingHistory [historyId=" + historyId + ", booking=" + booking + ", action=" + action
					+ ", actionDate=" + actionDate + "]";
		}
	    
	    
}
