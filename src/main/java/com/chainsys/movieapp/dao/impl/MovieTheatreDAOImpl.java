package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.MovieTheatreDAO;
import com.chainsys.movieapp.model.MovieTheatre;
import com.chainsys.movieapp.util.DbConnection;
import com.chainsys.movieapp.util.DbException;
import com.chainsys.movieapp.util.ErrorConstant;

public class MovieTheatreDAOImpl implements MovieTheatreDAO {
	private static final Logger logger = LoggerFactory.getLogger(MovieTheatreDAOImpl.class);


	public void save(MovieTheatre theatre) throws DbException {
		String sql = "insert into movie_theatre(movie_theatre_id,movie_id,theatre_id,active,price,movie_timing)values(movie_theatre_id_seq.nextval,?,?,?,?,?)";
		logger.info("");
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, theatre.getMovieId());
			pst.setInt(2, theatre.getTheatreId());
			pst.setInt(3, theatre.getActive());
			pst.setInt(4, theatre.getPrice());
			pst.setString(5, theatre.getMovieTiming().toString());
			int row = pst.executeUpdate();
			logger.info(""+row);
			con.close();
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_ADD);

		}

	}

	public void updateMovieTimingByMovieTheatreId(int movieTheatreId, String movieTiming) throws DbException {
		String sql = "update movie_theatre set movie_timing=? where movie_theatre_id=?";
		logger.info("");
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, movieTiming.toString());
			pst.setInt(2, movieTheatreId);

			int row = pst.executeUpdate();
			logger.info(""+row);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_UPDATE);

		}

	}

	public void deleteMovieTheatreByMovieTheatreId(int movieTheatreId) throws DbException {
		String sql = "delete from  movie_theatre where movie_theatre_id=?";
		logger.info("");
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); 
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, movieTheatreId);
			int row = pst.executeUpdate();
			logger.info(""+row);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_DELETE);

		}

	}

	public List<MovieTheatre> findByMovieId(int movieId) throws DbException {

		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		String sql = "Select movie_theatre_id,movie_id,theatre_id,active,price,movie_timing from movie_theatre where movie_id=?";
		logger.info("");
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); 
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, movieId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					MovieTheatre ml = new MovieTheatre();
					ml.setMovieTheatreId(rs.getInt("movie_theatre_id"));
					ml.setMovieId(rs.getInt("movie_id"));
					ml.setTheatreId(rs.getInt("theatre_id"));
					ml.setActive(rs.getInt("active"));
					ml.setPrice(rs.getInt("price"));
					ml.setMovieTiming(LocalTime.parse(rs.getString("movie_timing")));
					list.add(ml);
				}
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return list;

	}

	public List<MovieTheatre> findActiveTheatreByTheatreIdAndMovieId(int movieId) throws DbException {
		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		String sql = "Select m.movie_id,m.movie_theatre_id,m.theatre_id,t.theatre_name,m.active,t.theatre_address,t.theatre_rating,m.price,m.movie_timing,t.theatre_image_url from movie_theatre m, theatre t where m.theatre_id = t.theatre_id and movie_id=?";
		logger.info("");
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); 
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, movieId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					MovieTheatre ml = new MovieTheatre();
					ml.setMovieId(rs.getInt("movie_id"));
					ml.setMovieTheatreId(rs.getInt("movie_theatre_id"));
					ml.setTheatreId(rs.getInt("theatre_id"));
					ml.setTheatreName(rs.getString("theatre_name"));
					ml.setActive(rs.getInt("active"));
					ml.setTheatreAddress(rs.getString("theatre_address"));
					ml.setTheatreRating(rs.getInt("theatre_rating"));
					ml.setPrice(rs.getInt("price"));
					ml.setTheatreImageUrl(rs.getString("theatre_image_url"));
					ml.setMovieTiming(LocalTime.parse(rs.getString("movie_timing")));
					list.add(ml);
				}
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		
		
		
		List<MovieTheatre> activeList = new ArrayList<MovieTheatre>();
		for (MovieTheatre movieTheatre : list) {
			
			if ( movieTheatre.getActive() ==1) {
				activeList.add(movieTheatre);
			}
		}
		return activeList;

	}

	public void updateMoviePriceByMovieTheatreId(int price, int movieTheatreId) throws DbException {
		String sql = "update movie_theatre set price=? where movie_theatre_id=?";
		logger.info("");
		// logger.info(sql);
		try (Connection con = DbConnection.getConnection(); 
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, price);
			pst.setInt(2, movieTheatreId);
			int row = pst.executeUpdate();
			logger.info(""+row);
			con.close();
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_UPDATE);

		}

	}

	public List<MovieTheatre> findMovieIdAndTimingsByTheatreName(String theatreName) throws DbException {
		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		String sql = "select movie_id,movie_timing from movie_theatre where theatre_id in(select theatre_id from theatre where theatre_name=?)";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);) {
			logger.info("deepan");
			pst.setString(1, theatreName);
			
			try(	ResultSet rs = pst.executeQuery();)
			{
			while (rs.next()) {
				MovieTheatre tl = new MovieTheatre();
				tl.setMovieId(rs.getInt("movie_id"));
				tl.setMovieTiming(LocalTime.parse(rs.getString("movie_timing")));
				list.add(tl);
			}
			con.close();
			}} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}

		return list;
	}

	public List<MovieTheatre> findSeatsByMovieId(int movieId) throws DbException {
		List<MovieTheatre> list = new ArrayList<MovieTheatre>();
		String sql = "Select number_seats from movie_theatre where movie_id=?";
		logger.info(sql);
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, movieId);
			try(ResultSet rs = pst.executeQuery();){
			while (rs.next()) {
				MovieTheatre ml = new MovieTheatre();
				ml.setMovieTheatreId(rs.getInt("movie_theatre_id"));
				ml.setMovieId(rs.getInt("movie_id"));
				ml.setTheatreId(rs.getInt("theatre_id"));
				ml.setActive(rs.getInt("active"));
				ml.setPrice(rs.getInt("price"));
				ml.setMovieTiming(rs.getTime("movie_timing").toLocalTime());
				list.add(ml);
			}
			con.close();
			}} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);

		}
		return list;

	}

	public void updateMovieStatusByMovieTheatreId(int active, int movieTheatreId) throws DbException {
		String sql = "update movie_theatre set active=? where movie_theatre_id=?";
		logger.info("");
		logger.info(sql);
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, active);
			pst.setInt(2, movieTheatreId);
			int row = pst.executeUpdate();
			logger.info(""+row);
			con.close();
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_UPDATE);

		}
	}

}
