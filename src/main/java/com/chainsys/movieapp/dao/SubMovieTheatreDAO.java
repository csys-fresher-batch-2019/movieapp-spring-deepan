package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.model.SubMovieTheatre;
import com.chainsys.movieapp.exception.DbException;

public interface SubMovieTheatreDAO {

	public List<SubMovieTheatre> findAvailableSeatsByMovieTheatreId() throws DbException;

}
