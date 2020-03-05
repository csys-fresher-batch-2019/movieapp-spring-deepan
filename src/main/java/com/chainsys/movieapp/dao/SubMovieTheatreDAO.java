package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.model.SubMovieTheatre;
import com.chainsys.movieapp.util.DbException;

public interface SubMovieTheatreDAO {

	public List<SubMovieTheatre> getAvailableSeats() throws DbException;

}
