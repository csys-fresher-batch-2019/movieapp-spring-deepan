package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.util.DbException;
import com.chainsys.movieapp.model.MovieTheatre;

public interface MovieTheatreDAO {
	
	void addMovieTheatre(MovieTheatre list) throws DbException;
	
	void updateMovieTheatre(int movieTheatreId,String movieTiming) throws DbException;
	
	void deleteMovieTheatre(int movieTheatreId) throws DbException;
	
	void updateMoviePrice(int price,int movieTheatreId) throws DbException;
	
	void updateMovieStatus(int active,int movieTheatreId) throws DbException;
	
    List<MovieTheatre> getTheatreDetails(int movieId) throws DbException;
  
    List<MovieTheatre> getMovieTiming(String theatreName) throws DbException;

    List<MovieTheatre> getNumSeats(int movieId) throws DbException ;
    
    List<MovieTheatre> getActiveTheatreDetails(int movieId) throws DbException;
}
