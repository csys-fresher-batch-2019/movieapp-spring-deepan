package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.movieapp.dao.TicketBookingDAO;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.model.TicketBooking;
import com.chainsys.movieapp.util.DbConnection;
@Repository
public class TicketBookingDAOImpl implements TicketBookingDAO {

	private static final Logger logger = LoggerFactory.getLogger(TicketBookingDAOImpl.class);

	public void save(TicketBooking booked) throws DbException {
		String sql = "insert into booked(movie_theatre_id,booked_id,users_id,booked_seats,amount,show_date)values(?,booked_id.nextval,?,?,?,?)";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, booked.getMovieTheaterId());
			// pst.setInt(2,booked.bookedId);
			pst.setInt(2, booked.getUserId());
			pst.setInt(3, booked.getBookedSeats());
			pst.setInt(4, booked.getAmount());
			//pst.setLong(5, booked.getMobileNumber());
			pst.setDate(5, Date.valueOf(booked.getShowDate()));
			pst.executeUpdate();
			// logger.info(row);
		} catch (SQLException e) {
			throw new DbException("Unable to book the tickets", e);

		}

	}

	public void delete(int usersId) throws DbException {
		String sql = "delete from booked where users_id=?";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, usersId);
			int row = pst.executeUpdate();
			logger.info("" + row);
		} catch (SQLException e) {
			throw new DbException("Unable to delete booked details", e);

		}

	}

	public int findPriceByMovieTheatreId(int movieTheatreId) throws DbException {
		String sql = "Select price from movie_theatre where movie_theatre_id=?";
		logger.info("");
		// logger.info(sql);
		int price = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, movieTheatreId);
			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {
					price = rs.getInt("price");
				}
				// return a;
			}
		} catch (SQLException e) {
			throw new DbException("Unable to find Price", e);

		}
		return price;

	}

	public Long findMobileNumberByUserId(int usersId) throws DbException {
		String sql = "select mobile_num from users where user_id in (select users_id from booked where users_id=?)";
		logger.info("");
		// logger.info(sql);
		Long mobileNo = null;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, usersId);
			mobileNo = (long) 0;
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					mobileNo = rs.getLong("mobile_num");

				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to find Mobile Number", e);

		}
		return mobileNo;
	}

	@Override
	public List<TicketBooking> findAllByUserId(int userId) throws DbException {

		List<TicketBooking> list = new ArrayList<>();
		String sql = "select booked_id,movie_theatre_id,users_id,booked_seats,show_date,booked_date,amount,booked_status from booked where users_id=?";
		// logger.info(sql);
		logger.info("");
		try (Connection con = DbConnection.getConnection(); 
				PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, userId);
			
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					
					TicketBooking ticketBooking = new TicketBooking();

					ticketBooking.setBookedId(rs.getInt("booked_id"));
					ticketBooking.setMovieTheaterId(rs.getInt("movie_theatre_id"));
					ticketBooking.setUserId(rs.getInt("users_id"));
					ticketBooking.setBookedSeats(rs.getInt("booked_seats"));
					LocalDate d = rs.getDate("show_date").toLocalDate();
					if (d != null) {
						ticketBooking.setShowDate(d);
					}

					LocalDate sd = rs.getDate("booked_date").toLocalDate();
					if (sd != null) {
						ticketBooking.setBookedDate(sd);
					}

					ticketBooking.setAmount(rs.getInt("amount"));
					ticketBooking.setPaymentStatus(rs.getString("booked_status"));
					list.add(ticketBooking);
					System.out.println(list);
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to find User Booked Details", e);

		}

		return list;
	}
	
	
		
	
	
	

	@Override
	public int update(String bookedId) throws DbException {
		String sql = "update booked set booked_status='CANCELLED' where booked_id = ?";
		logger.info(sql);
		int rows=0;
		try (Connection connection = DbConnection.getConnection();

				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, bookedId);

			rows = pst.executeUpdate();
			logger.info("" + rows);
		} catch (SQLException e) {
			throw new DbException("Unable to Update Booked status", e);

		}
		return rows;
	}

}
