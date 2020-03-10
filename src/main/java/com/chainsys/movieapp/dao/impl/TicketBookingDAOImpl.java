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

import com.chainsys.movieapp.dao.TicketBookingDAO;
import com.chainsys.movieapp.model.TicketBooking;
import com.chainsys.movieapp.util.DbConnection;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.exception.ErrorConstant;

public class TicketBookingDAOImpl implements TicketBookingDAO {

	private static final Logger logger = LoggerFactory.getLogger(TicketBookingDAOImpl.class);

	
public void save(TicketBooking booked) throws DbException {
		String sql = "insert into booked(movie_theatre_id,booked_id,users_id,booked_seats,amount,show_date)values(?,booked_id.nextval,?,?,?,?)";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); 
			 PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, booked.getMovieTheaterId());
			// pst.setInt(2,booked.bookedId);
			pst.setInt(2, booked.getUsersId());
			pst.setInt(3, booked.getBookedSeats());
			pst.setInt(4, booked.getAmount());
			//pst.setLong(5, booked.getMobileNum());
			pst.setDate(5,Date.valueOf( booked.getShowDate()));
			pst.executeUpdate();
			//logger.info(row);
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_ADD);

		}

	}

	

public void deleteBookingDetailsByUserId(int usersId) throws DbException {
		String sql = "delete from booked where users_id=?";
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); 
			 PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, usersId);
			int row = pst.executeUpdate();
			logger.info(""+row);
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_DELETE);

		}

	}

	

public int findPriceByMovieTheatreId(int movieTheatreId) throws DbException {
		String sql = "Select price from movie_theatre where movie_theatre_id=?";
		logger.info("");
		// logger.info(sql);
		int a=0;
		try (Connection con = DbConnection.getConnection(); 
			 PreparedStatement pst = con.prepareStatement(sql))
		{
			
			pst.setInt(1, movieTheatreId);
		try(ResultSet rs = pst.executeQuery())
			  {
			
			
			if (rs.next()) {
				 a = rs.getInt("price");
			}
			//return a;
		}} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return a;

	}

	

public Long findMobileNumberByUserId(int usersId) throws DbException {
		String sql = "select mobile_num from users where user_id in (select users_id from booked where users_id=?)";
		logger.info("");
		// logger.info(sql);
		Long a=null;
		try (Connection con = DbConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, usersId);
			a = (long) 0;
			try(ResultSet rs = pst.executeQuery();){
			if (rs.next()) {
				a = rs.getLong("mobile_num");

			}
			}} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return a;
	}



@Override
public List<TicketBooking> findAllByUserId(int userId) throws DbException {
	
	List<TicketBooking> list = new ArrayList<TicketBooking>();
	String sql = "select * from booked where users_id=?";
	// logger.info(sql);
	logger.info("");
	try (	Connection con = DbConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);)
	{
		       stmt.setInt(1, userId);
		try(ResultSet rs = stmt.executeQuery();)
		{
		while (rs.next()) {
			TicketBooking tl = new TicketBooking();
			tl.setBookedId(rs.getInt("booked_id"));
			tl.setMovieTheaterId(rs.getInt("movie_theatre_id"));
			tl.setUsersId(rs.getInt("users_id"));
			tl.setBookedSeats(rs.getInt("booked_seats"));
			Date d=rs.getDate("show_date");
			if(d!=null) {
				LocalDate ld=d.toLocalDate();
				tl.setShowDate(ld);
			}
			
			Date sd=rs.getDate("booked_date");
			if(sd!=null) {
				LocalDate sld=sd.toLocalDate();
				tl.setBookedDate(sld);
			}
			
			
			tl.setAmount(rs.getInt("amount"));
		    tl.setPaymentStatus(rs.getString("booked_status"));
			list.add(tl);
		}
		}	} catch (SQLException e) {
		logger.debug(e.getMessage());
		throw new DbException(ErrorConstant.INVALID_SELECT);

	}

	return list;
}



@Override
public void updateBookedStatusByBookedId(String bookedId) throws DbException {
	String sql = "update booked set booked_status='CANCELLED' where booked_id = ?";
	logger.info(sql);
	try(Connection connection =DbConnection.getConnection() ;

	PreparedStatement pst = connection.prepareStatement(sql);)
	{
	pst.setString(1,bookedId);

	int rows=pst.executeUpdate();
	logger.info(""+rows);
	}catch(SQLException e)
	{
		logger.debug(e.getMessage());
		throw new DbException(ErrorConstant.INVALID_UPDATE);

	}	
}

}
