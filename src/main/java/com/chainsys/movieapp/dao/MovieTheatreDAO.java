package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.util.DbException;
import com.chainsys.movieapp.model.MovieTheatre;

public interface MovieTheatreDAO {
	
	void save(MovieTheatre list) throws DbException;
	
	void updateMovieTimingByMovieTheatreId(int movieTheatreId,String movieTiming) throws DbException;
	
	void deleteMovieTheatreByMovieTheatreId(int movieTheatreId) throws DbException;
	
	void updateMoviePriceByMovieTheatreId(int price,int movieTheatreId) throws DbException;
	
	void updateMovieStatusByMovieTheatreId(int active,int movieTheatreId) throws DbException;
	
    List<MovieTheatre> findByMovieId(int movieId) throws DbException;
  
    List<MovieTheatre> findMovieIdAndTimingsByTheatreName(String theatreName) throws DbException;

    List<MovieTheatre> findSeatsByMovieId(int movieId) throws DbException ;
    
    List<MovieTheatre> findActiveTheatreByTheatreIdAndMovieId(int movieId) throws DbException;
}
