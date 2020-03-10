package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.SubMovieTheatreDAO;
import com.chainsys.movieapp.model.SubMovieTheatre;
import com.chainsys.movieapp.util.DbConnection;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.exception.ErrorConstant;

public class SubMovieTheatreImpl implements SubMovieTheatreDAO{
	private static final Logger logger = LoggerFactory.getLogger(SubMovieTheatreImpl.class);


	public List<SubMovieTheatre> findAvailableSeatsByMovieTheatreId() throws DbException {
		List<SubMovieTheatre> list = new ArrayList<SubMovieTheatre>();
     String sqla = "SELECT M.MOVIE_NAME, T.THEATRE_NAME, (  T.NUMBER_SEATS - ( select nvl(SUM(B.BOOKED_SEATS),0) FROM BOOKED B WHERE B.movie_theatre_id = MT.movie_theatre_id))   AS AVAILABLE_SEATS FROM \r\n"
					+ "THEATRE T, MOVIE_THEATRE MT,MOVIE M\r\n"
					+ "WHERE m.movie_id = mt.movie_id AND t.theatre_id = MT.THEATRE_ID";
			logger.info("");
			try (Connection con = DbConnection.getConnection(); 
					PreparedStatement stmta = con.prepareStatement(sqla);){
				
			
					try(ResultSet rs = stmta.executeQuery();) {


			// logger.info(sqla);
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
				logger.debug(e.getMessage());
				throw new DbException(ErrorConstant.INVALID_SELECT);
		}

		return list;

	}

}
