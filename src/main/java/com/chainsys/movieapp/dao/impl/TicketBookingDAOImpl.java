package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.movieapp.dao.TicketBookingDAO;
import com.chainsys.movieapp.model.TicketBooking;
import com.chainsys.movieapp.util.DbConnection;
import com.chainsys.movieapp.util.DbException;

public class TicketBookingDAOImpl implements TicketBookingDAO {

	
	
public void addBookingDetails(TicketBooking booked) throws DbException {
		String sql = "insert into booked(movie_theatre_id,booked_id,users_id,booked_seats,amount,show_date)values(?,booked_id.nextval,?,?,?,?)";
		// System.out.println(sql);
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
			//System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

public void deleteBookingDetails(int usersId) throws DbException {
		String sql = "delete from booked where users_id=?";
		// System.out.println(sql);
		try (Connection con = DbConnection.getConnection(); 
			 PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, usersId);
			int row = pst.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

public int getPrice(int movieTheatreId) throws DbException {
		String sql = "Select price from movie_theatre where movie_theatre_id=?";
		System.out.println("");
		// System.out.println(sql);
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
			e.printStackTrace();
		}
		return a;

	}

	

public Long getMobileNumber(int usersId) throws DbException {
		String sql = "select mobile_num from users where user_id in (select users_id from booked where users_id=?)";
		System.out.println("");
		// System.out.println(sql);
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
			e.printStackTrace();
		}
		return a;
	}



@Override
public List<TicketBooking> getUserBookedDetails(int userId) throws DbException {
	
	List<TicketBooking> list = new ArrayList<TicketBooking>();
	String sql = "select * from booked where users_id=?";
	// System.out.println(sql);
	System.out.println("");
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
		e.printStackTrace();
	}

	return list;
}



@Override
public void cancelTicket(String bookedId) throws DbException {
	String sql = "update booked set booked_status='CANCELLED' where booked_id = ?";
	System.out.println(sql);
	try(Connection connection =DbConnection.getConnection() ;

	PreparedStatement pst = connection.prepareStatement(sql);)
	{
	pst.setString(1,bookedId);

	int rows=pst.executeUpdate();
	System.out.println(rows);
	}catch(SQLException e)
	{
		e.printStackTrace();
	}	
}

}
