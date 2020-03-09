package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.TheatreListDAO;
import com.chainsys.movieapp.model.TheatreList;
import com.chainsys.movieapp.util.DbConnection;
import com.chainsys.movieapp.util.DbException;
import com.chainsys.movieapp.util.ErrorConstant;

public class TheatreListDAOImpl implements TheatreListDAO {
	private static final Logger logger = LoggerFactory.getLogger(TheatreListDAOImpl.class);


	

public void save(TheatreList theatre) throws DbException {
		String sql = "insert into theatre(theatre_name,theatre_id,number_seats,theatre_address,theatre_rating)values(?,theatre_id_seq.nextval,?,?,?)";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, theatre.getTheatreName());
			pst.setInt(2, theatre.getNumberSeats());
			pst.setString(3, theatre.getTheatreAddress());
			pst.setInt(4, theatre.getTheatreRating());
			int row = pst.executeUpdate();
			logger.info(""+row);
			con.close();
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_ADD);

		}

	}
	

public void deleteTheatreDetailsByTheatreId(int theatreId) throws DbException {
		String sql = "delete from theatre where theatre_id=?";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); 
			 PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, theatreId);
			int row = pst.executeUpdate();
			logger.info(""+row);
			con.close();
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_DELETE);

		}

	}

	

public void updateTheatreRatingByTheatreName(int theatreRating, String theatreName) throws DbException {
		String sql = "update theatre set theatre_rating=? where theatre_name=?";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, theatreRating);
			pst.setString(2, theatreName);
			int row = pst.executeUpdate();
			logger.info(""+row);
			con.close();
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_UPDATE);

		}

	}

	

public List<TheatreList> findAllTheatreDetails() throws DbException {

		List<TheatreList> list = new ArrayList<TheatreList>();
		String sql = "Select theatre_name,theatre_id,number_seats,theatre_address,theatre_rating from theatre";
		// logger.info(sql);
		logger.info("");
		try (	Connection con = DbConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);)
		{
			try(	ResultSet rs = stmt.executeQuery();)
			{
			while (rs.next()) {
				TheatreList tl = new TheatreList();
				tl.setTheatreName(rs.getString("theatre_name"));
				tl.setTheatreId(rs.getInt("theatre_id"));
				tl.setNumberSeats(rs.getInt("number_seats"));
				tl.setTheatreAddress(rs.getString("theatre_address"));
				tl.setTheatreRating(rs.getInt("theatre_rating"));
				list.add(tl);
			}
			}	} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}

		return list;
	}

	

public List<TheatreList> findTheatreNameByTheatreAddress(String theatreAddress) throws DbException {
		List<TheatreList> list = new ArrayList<TheatreList>();
		String sql = "Select theatre_name from theatre where theatre_address like ?";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); 
				PreparedStatement pst = con.prepareStatement(sql);)
		{
				
			pst.setString(1, "%" + theatreAddress + "%");
			try(ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				TheatreList tl = new TheatreList();
				tl.setTheatreName(rs.getString("theatre_name"));
				list.add(tl);
			}

			}} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}

		return list;
	}
}