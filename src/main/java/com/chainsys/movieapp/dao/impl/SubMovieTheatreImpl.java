package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.movieapp.dao.SubMovieTheatreDAO;
import com.chainsys.movieapp.model.SubMovieTheatre;
import com.chainsys.movieapp.util.DbConnection;
import com.chainsys.movieapp.util.DbException;

public class SubMovieTheatreImpl implements SubMovieTheatreDAO{

	public List<SubMovieTheatre> getAvailableSeats() throws DbException {
		List<SubMovieTheatre> list = new ArrayList<SubMovieTheatre>();
     String sqla = "SELECT M.MOVIE_NAME, T.THEATRE_NAME, (  T.NUMBER_SEATS - ( select nvl(SUM(B.BOOKED_SEATS),0) FROM BOOKED B WHERE B.movie_theatre_id = MT.movie_theatre_id))   AS AVAILABLE_SEATS FROM \r\n"
					+ "THEATRE T, MOVIE_THEATRE MT,MOVIE M\r\n"
					+ "WHERE m.movie_id = mt.movie_id AND t.theatre_id = MT.THEATRE_ID";
			System.out.println("");
			try (Connection con = DbConnection.getConnection(); 
					PreparedStatement stmta = con.prepareStatement(sqla);){
				
			
					try(ResultSet rs = stmta.executeQuery();) {


			// System.out.println(sqla);
			while (rs.next()) {

				SubMovieTheatre sm = new SubMovieTheatre();
				sm.setMovieName(rs.getString("movie_name"));
				sm.setTheatreName(rs.getString("theatre_name"));
				sm.setAvailableSeats(rs.getInt("AVAILABLE_SEATS"));
				list.add(sm);
			}
		}
			}	catch(SQLException e)
		{
			throw new DbException("Error");
		}

		return list;

	}

}
