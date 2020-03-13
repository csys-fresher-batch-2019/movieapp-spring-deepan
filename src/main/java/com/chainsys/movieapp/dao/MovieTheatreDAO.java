package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.model.MovieTheatre;

public interface MovieTheatreDAO {
	
	void save(MovieTheatre list) throws DbException;
	
	int updateMovieTimingByMovieTheatreId(int movieTheatreId,String movieTiming) throws DbException;
	
	void delete(int movieTheatreId) throws DbException;
	
	int updateMoviePriceByMovieTheatreId(int price,int movieTheatreId) throws DbException;
	
	int updateMovieStatusByMovieTheatreId(int active,int movieTheatreId) throws DbException;
	
    List<MovieTheatre> findByMovieId(int movieId) throws DbException;
  
    List<MovieTheatre> findMovieIdAndTimingsByTheatreName(String theatreName) throws DbException;

    List<MovieTheatre> findSeatsByMovieId(int movieId) throws DbException ;
    
    List<MovieTheatre> findActiveTheatreByMovieId(int movieId) throws DbException;
}
