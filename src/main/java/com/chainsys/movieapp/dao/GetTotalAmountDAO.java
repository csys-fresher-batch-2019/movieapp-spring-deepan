package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.model.MovieTheatreBookingDTO;

public interface GetTotalAmountDAO {

	public List <MovieTheatreBookingDTO> findAll() throws DbException;
}
