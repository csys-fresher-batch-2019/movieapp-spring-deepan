package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.movieapp.dao.TheatreListDAO;
import com.chainsys.movieapp.model.TheatreList;
import com.chainsys.movieapp.util.DbConnection;
import com.chainsys.movieapp.util.DbException;

public class TheatreListDAOImpl implements TheatreListDAO {

	

public void addTheatreDetails(TheatreList theatre) throws DbException {
		String sql = "insert into theatre(theatre_name,theatre_id,number_seats,theatre_address,theatre_rating)values(?,theatre_id_seq.nextval,?,?,?)";
		// System.out.println(sql);
		try (Connection con = DbConnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, theatre.getTheatreName());
			pst.setInt(2, theatre.getNumberSeats());
			pst.setString(3, theatre.getTheatreAddress());
			pst.setInt(4, theatre.getTheatreRating());
			int row = pst.executeUpdate();
			System.out.println(row);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

public void deleteTheatreDetails(int theatreId) throws DbException {
		String sql = "delete from theatre where theatre_id=?";
		// System.out.println(sql);
		try (Connection con = DbConnection.getConnection(); 
			 PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, theatreId);
			int row = pst.executeUpdate();
			System.out.println(row);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

public void updateTheatreRating(int theatreRating, String theatreName) throws DbException {
		String sql = "update theatre set theatre_rating=? where theatre_name=?";
		// System.out.println(sql);
		try (Connection con = DbConnection.getConnection(); 
			PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, theatreRating);
			pst.setString(2, theatreName);
			int row = pst.executeUpdate();
			System.out.println(row);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

public List<TheatreList> allTheatreDetails() throws DbException {

		List<TheatreList> list = new ArrayList<TheatreList>();
		String sql = "Select theatre_name,theatre_id,number_seats,theatre_address,theatre_rating from theatre";
		// System.out.println(sql);
		System.out.println("");
		try (	Connection con = DbConnection.getConnection();
				Statement stmt = con.createStatement();)
		{
			try(	ResultSet rs = stmt.executeQuery(sql);)
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
			e.printStackTrace();
		}

		return list;
	}

	

public List<TheatreList> getTheatreName(String theatreAddress) throws DbException {
		List<TheatreList> list = new ArrayList<TheatreList>();
		String sql = "Select theatre_name from theatre where theatre_address like ?";
		// System.out.println(sql);
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
			e.printStackTrace();
		}

		return list;
	}
}