package com.chainsys.movieapp.model;

public class BookedMailModel {
	private String from;
	private String password;
	private String to;
	private String sub;
	private String Msg;
	private int bookedId;
	private int usersId;
	private int movieTheatreId;
	private int bookedSeats;
	private int amount;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
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
	public int getMovieTheatreId() {
		return movieTheatreId;
	}
	public void setMovieTheatreId(int movieTheatreId) {
		this.movieTheatreId = movieTheatreId;
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
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
