package com.chainsys.movieapp.model;

public class SubMovieTheatre {
	private String movieName;
	private String theatreName;
	private int availableSeats;
	
	@Override
	public String toString() {
		return "SubMovieTheatre [movieName=" + getMovieName() + ", theatreName=" + getTheatreName() + ", availableSeats="
				+ getAvailableSeats() + "]";
	}

	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
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
	 * @return the availableSeats
	 */
	public int getAvailableSeats() {
		return availableSeats;
	}

	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

}
