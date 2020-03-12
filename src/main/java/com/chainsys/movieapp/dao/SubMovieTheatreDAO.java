package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.model.MovieTheatreDTO;
import com.chainsys.movieapp.exception.DbException;

public interface SubMovieTheatreDAO {

	public List<MovieTheatreDTO> findAll() throws DbException;

}
