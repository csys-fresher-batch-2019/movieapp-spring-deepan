package com.chainsys.movieapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TicketBooking {
	private int movieTheaterId;
	private int bookedId;
	private int usersId;
	private int bookedSeats;
	private int amount;
	private String paymentStatus;
	private LocalDate bookedDate;
	private Long mobileNum;
	private LocalDate showDate;
	@Override
	public String toString() {
		return "TicketBooking [movieTheaterId=" + getMovieTheaterId() + ", bookedId=" + bookedId + ", usersId=" + getUsersId()
				+ ", bookedSeats=" + getBookedSeats() + ", amount=" + getAmount() + ", paymentStatus=" + getPaymentStatus()
				+ ", bookedDate=" + bookedDate + ", mobileNum=" + getMobileNum() + ",showDate="+getShowDate()+"]";
	}
	public int getMovieTheaterId() {
		return movieTheaterId;
	}
	public void setMovieTheaterId(int movieTheaterId) {
		this.movieTheaterId = movieTheaterId;
	}
	public int getBookedId() {
		return bookedId;
	}
	public void setBookedId(int bookedId) {
		this.bookedId = bookedId;
	}
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	public int getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public int getAmount() {
		return amount;
	}
	public int setAmount(int amount) {
		return this.amount = amount;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public LocalDate getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(LocalDate sld) {
		this.bookedDate = sld;
	}
	public Long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}
	/**
	 * @return the showDate
	 */
	public LocalDate getShowDate() {
		return showDate;
	}
	/**
	 * @param showDate the showDate to set
	 */
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	
}
	