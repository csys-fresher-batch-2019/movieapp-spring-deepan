package com.chainsys.movieapp.model;

import java.time.LocalTime;
import java.util.Timer;

public class MovieTheatre {
	private int movieTheatreId;
	private int movieId;
	private int theatreId;
	private int active;
	private int price;
	private LocalTime movieTiming;
	private String theatreImageUrl;
	private String theatreName;
	private String theatreAddress;
	private int theatreRating;
	@Override
	public String toString() {
		return "MovieTheatre [movieTheatreId=" + getMovieTheatreId() + ", movieId=" + getMovieId() + ", theatreId=" + getTheatreId()
				+ ", active=" + getActive() + ", price=" + getPrice() + ", movieTiming=" + getMovieTiming() + ",theatreImageUrl="+getTheatreImageUrl()+",theatreName="+getTheatreName()+",theatreAddress="+getTheatreAddress()+",theatreRating="+getTheatreRating()+"]";
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
	 * @return the active
	 */
	public int getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the movieTiming
	 */
	public LocalTime getMovieTiming() {
		return movieTiming;
	}
	/**
	 * @param movieTiming the movieTiming to set
	 */
	public void setMovieTiming(LocalTime movieTiming) {
		this.movieTiming = movieTiming;
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
	 * @return the theatreImageUrl
	 */
	public String getTheatreImageUrl() {
		return theatreImageUrl;
	}
	/**
	 * @param theatreImageUrl the theatreImageUrl to set
	 */
	public void setTheatreImageUrl(String theatreImageUrl) {
		this.theatreImageUrl = theatreImageUrl;
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
    
    
}
