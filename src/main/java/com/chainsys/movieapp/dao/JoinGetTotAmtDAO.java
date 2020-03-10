package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.model.JoinGetTotalAmount;

public interface JoinGetTotAmtDAO {

	public List <JoinGetTotalAmount> findTotalAmountByMovieTheatreId() throws DbException;
}
