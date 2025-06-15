package com.example.simplyfly.entity;

import java.time.LocalDateTime;

import com.example.simplyfly.enums.PaymentMethod;
import com.example.simplyfly.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Payment {
	 @Id
	 private Integer paymentId;
	    @ManyToOne Booking booking;
	    private PaymentMethod paymentMethod;
	    private PaymentStatus paymentStatus;
	    private double amountPaid;
	    private LocalDateTime paymentDate;
	    
	    
		public Payment() {
			super();
		}


		public Payment(Integer paymentId, Booking booking, PaymentMethod paymentMethod, PaymentStatus paymentStatus,
				double amountPaid, LocalDateTime paymentDate) {
			super();
			this.paymentId = paymentId;
			this.booking = booking;
			this.paymentMethod = paymentMethod;
			this.paymentStatus = paymentStatus;
			this.amountPaid = amountPaid;
			this.paymentDate = paymentDate;
		}


		public Integer getPaymentId() {
			return paymentId;
		}


		public void setPaymentId(Integer paymentId) {
			this.paymentId = paymentId;
		}


		public Booking getBooking() {
			return booking;
		}


		public void setBooking(Booking booking) {
			this.booking = booking;
		}


		public PaymentMethod getPaymentMethod() {
			return paymentMethod;
		}


		public void setPaymentMethod(PaymentMethod paymentMethod) {
			this.paymentMethod = paymentMethod;
		}


		public PaymentStatus getPaymentStatus() {
			return paymentStatus;
		}


		public void setPaymentStatus(PaymentStatus paymentStatus) {
			this.paymentStatus = paymentStatus;
		}


		public double getAmountPaid() {
			return amountPaid;
		}


		public void setAmountPaid(double amountPaid) {
			this.amountPaid = amountPaid;
		}


		public LocalDateTime getPaymentDate() {
			return paymentDate;
		}


		public void setPaymentDate(LocalDateTime paymentDate) {
			this.paymentDate = paymentDate;
		}


		@Override
		public String toString() {
			return "Payment [paymentId=" + paymentId + ", booking=" + booking + ", paymentMethod=" + paymentMethod
					+ ", paymentStatus=" + paymentStatus + ", amountPaid=" + amountPaid + ", paymentDate=" + paymentDate
					+ "]";
		}
	    
	    
}
