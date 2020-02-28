package com.chainsys.movieapp.model;

public class JoinGetTotalAmount {

	private int movieTheatreId;
	private int movieId;
	private int theatreId;
	private int totalAmount;
	@Override
	public String toString() {
		return "JoinGetTotalAmount [movieTheatreId=" + getMovieTheatreId() + ", movieId=" + getMovieId() + ", theatreId="
				+ getTheatreId() + ", totalAmount=" + getTotalAmount() + "]";
	}
	/**
	 * @return the movieTheatreId
	 */
	public int getMovieTheatreId() {
		return movieTheatreId;
	}
	/**
	 * @param movieTheatreId the movieTheatreId to set
	 */
	public void setMovieTheatreId(int movieTheatreId) {
		this.movieTheatreId = movieTheatreId;
	}
	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
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
	 * @return the totalAmount
	 */
	public int getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
}
