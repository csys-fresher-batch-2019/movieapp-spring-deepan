package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.util.DbConnection;

import com.chainsys.movieapp.dao.JoinGetTotAmtDAO;
import com.chainsys.movieapp.model.JoinGetTotalAmount;

import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.exception.ErrorConstant;

public class JoinGetTotAmtDAOImpl implements JoinGetTotAmtDAO{
	private static final Logger logger = LoggerFactory.getLogger(JoinGetTotAmtDAOImpl.class);


	public List<JoinGetTotalAmount> findTotalAmountByMovieTheatreId() throws DbException {
		List<JoinGetTotalAmount> list=new ArrayList<JoinGetTotalAmount>();
		
		logger.info("***Display the Total Amount***");
		String sqla = "select b.movie_theatre_id, mt.movie_id, mt.theatre_id, sum(amount) as total_amount from \r\n" + 
				"booked b, movie_theatre mt where mt.movie_theatre_id = b.movie_theatre_id \r\n" + 
				"group by b.movie_theatre_id, movie_id, theatre_id";
		logger.info(sqla);
		
		try(Connection con = DbConnection.getConnection();
				Statement stmta = con.createStatement();
				ResultSet rs = stmta.executeQuery(sqla);) 
		{
			while (rs.next()) {
				
				JoinGetTotalAmount ta = new JoinGetTotalAmount();
				ta.setMovieTheatreId(rs.getInt("movie_theatre_id"));
				ta.setMovieId(rs.getInt("movie_id"));
				ta.setTheatreId(rs.getInt("theatre_id"));
				ta.setTotalAmount(rs.getInt("total_amount"));
				list.add(ta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return list;
	}

}
