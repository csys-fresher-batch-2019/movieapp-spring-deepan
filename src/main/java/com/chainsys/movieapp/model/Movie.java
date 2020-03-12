package com.chainsys.movieapp.model;

//import java.sql.Date;
//import java.time.LocalDate;
import java.time.LocalDate;

public class Movie {
	private int movieId;
	private String movieName;
	private String movieType;
	private String movieLanguage;
	private int movieRating;
	private int movieDuration;
	private String imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	private LocalDate releasedDate;
	
	@Override
	public String toString() {
		return "MovieList [movieId=" + movieId + ", movieName=" + movieName + ", movieType=" + movieType
				+ ", movieLanguage=" + movieLanguage + ", movieRating=" + movieRating + ", movieDuration="
				+ movieDuration + ", imageUrl=" + imageUrl + ", releasedDate=" + releasedDate + "]";
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
	 * @return the movieType
	 */
	public String getMovieType() {
		return movieType;
	}

	/**
	 * @param movieType the movieType to set
	 */
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	/**
	 * @return the movieLanguage
	 */
	public String getMovieLanguage() {
		return movieLanguage;
	}

	/**
	 * @param movieLanguage the movieLanguage to set
	 */
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	/**
	 * @return the movieRating
	 */
	public int getMovieRating() {
		return movieRating;
	}

	/**
	 * @param movieRating the movieRating to set
	 */
	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	/**
	 * @return the movieDuration
	 */
	public int getMovieDuration() {
		return movieDuration;
	}

	/**
	 * @param movieDuration the movieDuration to set
	 */
	public void setMovieDuration(int movieDuration) {
		this.movieDuration = movieDuration;
	}

	/**
	 * @return the releasedDate
	 */
	public LocalDate getReleasedDate() {
		return releasedDate;
	}

	/**
	 * @param releasedDate the releasedDate to set
	 */
	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
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
	
	

}
