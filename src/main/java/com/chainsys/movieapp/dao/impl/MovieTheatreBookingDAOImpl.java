package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.GetTotalAmountDAO;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.model.MovieTheatreBookingDTO;
import com.chainsys.movieapp.util.DbConnection;

public class MovieTheatreBookingDAOImpl implements GetTotalAmountDAO {
	private static final Logger logger = LoggerFactory.getLogger(MovieTheatreBookingDAOImpl.class);

	public List<MovieTheatreBookingDTO> findAll() throws DbException {
		List<MovieTheatreBookingDTO> list = new ArrayList<MovieTheatreBookingDTO>();

		logger.info("***Display the Total Amount***");
		String sql = "select b.movie_theatre_id, mt.movie_id, mt.theatre_id, sum(amount) as total_amount from \r\n"
				+ "booked b, movie_theatre mt where mt.movie_theatre_id = b.movie_theatre_id \r\n"
				+ "group by b.movie_theatre_id, movie_id, theatre_id";
		logger.info(sql);

		try (Connection con = DbConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {

				MovieTheatreBookingDTO movieTheatreBookingDTO = new MovieTheatreBookingDTO();
				movieTheatreBookingDTO.setMovieTheatreId(rs.getInt("movie_theatre_id"));
				movieTheatreBookingDTO.setMovieId(rs.getInt("movie_id"));
				movieTheatreBookingDTO.setTheatreId(rs.getInt("theatre_id"));
				movieTheatreBookingDTO.setTotalAmount(rs.getInt("total_amount"));
				list.add(movieTheatreBookingDTO);
			}
		} catch (SQLException e) {
			throw new DbException("Unable to list the amount", e);

		}
		return list;
	}

}
