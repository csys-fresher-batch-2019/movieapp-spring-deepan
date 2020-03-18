package com.chainsys.movieapp.model;

public class Theatre {
	private String theatreName;
	private int theatreId;
	private int numberOfSeats;
	private String theatreAddress;
	private int theatreRating;
	@Override
	public String toString() {
		return "TheatreList [theatreName=" + getTheatreName() + ", theatreId=" + getTheatreId() + ", numberSeats=" + getNumberOfSeats()
				+ ", theatreAddress=" + getTheatreAddress() + ", theatreRating=" + getTheatreRating() + "]";
	}
	/**
	 * @return the theatreName
	 */
	public String getTheatreName() {
		return theatreName;
	}
	/**
	 * @param theatreName the theatreName to set
	 */
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	
	/**
	 * @return the theatreAddress
	 */
	public String getTheatreAddress() {
		return theatreAddress;
	}
	/**
	 * @param theatreAddress the theatreAddress to set
	 */
	public void setTheatreAddress(String theatreAddress) {
		this.theatreAddress = theatreAddress;
	}
	/**
	 * @return the theatreRating
	 */
	public int getTheatreRating() {
		return theatreRating;
	}
	/**
	 * @param theatreRating the theatreRating to set
	 */
	public void setTheatreRating(int theatreRating) {
		this.theatreRating = theatreRating;
	}
	/**
	 * @return the theatreId
	 */
	public int getTheatreId() {
		return theatreId;
	}
	/**
	 * @param theatreId the theatreId to set
	 */
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	/**
	 * @return the numberOfSeats
	 */
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	/**
	 * @param numberOfSeats the numberOfSeats to set
	 */
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

}
