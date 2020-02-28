package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.util.DbException;
import com.chainsys.movieapp.model.JoinGetTotalAmount;

public interface JoinGetTotAmtDAO {

	public List <JoinGetTotalAmount> getTotalAmount() throws DbException;
}
