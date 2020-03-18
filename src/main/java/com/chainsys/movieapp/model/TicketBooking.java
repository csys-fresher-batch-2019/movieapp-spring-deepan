package com.chainsys.movieapp.model;

import java.time.LocalDate;

public class TicketBooking {
	private int movieTheaterId;
	private int bookedId;
	private int userId;
	private int bookedSeats;
	private int amount;
	private String paymentStatus;
	private LocalDate bookedDate;
	private Long mobileNumber;
	private LocalDate showDate;

	@Override
	public String toString() {
		return "TicketBooking [movieTheaterId=" + getMovieTheaterId() + ", bookedId=" + bookedId + ", userId="
				+ getUserId() + ", bookedSeats=" + getBookedSeats() + ", amount=" + getAmount() + ", paymentStatus="
				+ getPaymentStatus() + ", bookedDate=" + bookedDate + ", mobileNum=" + getMobileNumber() + ",showDate="
				+ getShowDate() + "]";
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

		/**
	 * @return the showDate
	 */
	public LocalDate getShowDate() {
		return showDate;
	}

	/**
	 * @param showDate
	 *            the showDate to set
	 */
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}

	/**
	 * @return the mobileNumber
	 */
	public Long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
