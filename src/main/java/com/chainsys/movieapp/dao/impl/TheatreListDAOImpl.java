package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.movieapp.dao.TheatreListDAO;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.model.Theatre;
import com.chainsys.movieapp.util.DbConnection;
@Repository
public class TheatreListDAOImpl implements TheatreListDAO {
	private static final Logger logger = LoggerFactory.getLogger(TheatreListDAOImpl.class);

	public void save(Theatre theatre) throws DbException {
		String sql = "insert into theatre(theatre_name,theatre_id,number_seats,theatre_address,theatre_rating)values(?,theatre_id_seq.nextval,?,?,?)";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, theatre.getTheatreName());
			pst.setInt(2, theatre.getNumberOfSeats());
			pst.setString(3, theatre.getTheatreAddress());
			pst.setInt(4, theatre.getTheatreRating());
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to add Theatre", e);

		}

	}

	public void delete(int theatreId) throws DbException {
		String sql = "delete from theatre where theatre_id=?";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, theatreId);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to delete Theatre Id", e);

		}

	}

	public int update(int theatreRating, String theatreName) throws DbException {
		String sql = "update theatre set theatre_rating=? where theatre_name=?";
		// logger.info(sql);
		int rows=0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, theatreRating);
			pst.setString(2, theatreName);
			rows = pst.executeUpdate();
			logger.info("" + rows);
		} catch (SQLException e) {
			throw new DbException("Unable to Update theatre rating", e);

		}return rows;

	}

	public List<Theatre> findAll() throws DbException {

		List<Theatre> list = new ArrayList<Theatre>();
		String sql = "Select theatre_name,theatre_id,number_seats,theatre_address,theatre_rating from theatre";
		// logger.info(sql);
		logger.info("");
		try (Connection con = DbConnection.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Theatre theatre = new Theatre();
					theatre.setTheatreName(rs.getString("theatre_name"));
					theatre.setTheatreId(rs.getInt("theatre_id"));
					theatre.setNumberOfSeats(rs.getInt("number_seats"));
					theatre.setTheatreAddress(rs.getString("theatre_address"));
					theatre.setTheatreRating(rs.getInt("theatre_rating"));
					list.add(theatre);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to find Theatre Details", e);

		}

		return list;
	}

	public List<Theatre> findTheatreNameByTheatreAddress(String theatreAddress) throws DbException {
		List<Theatre> list = new ArrayList<Theatre>();
		String sql = "Select theatre_name from theatre where theatre_address like ?";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, "%" + theatreAddress + "%");
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Theatre tl = new Theatre();
					tl.setTheatreName(rs.getString("theatre_name"));
					list.add(tl);
				}

			}
		} catch (SQLException e) {
			throw new DbException("Unable to find theatre Name", e);

		}

		return list;
	}
}