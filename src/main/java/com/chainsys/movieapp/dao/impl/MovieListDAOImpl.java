package com.chainsys.movieapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.movieapp.dao.MovieListDAO;
import com.chainsys.movieapp.model.MovieList;
import com.chainsys.movieapp.util.DbConnection;
import com.chainsys.movieapp.util.DbException;

public class MovieListDAOImpl implements MovieListDAO {

	
	
public void addMovie(MovieList movie) throws DbException {
		
		String sql = "insert into movie(movie_id,movie_name,movie_type,movie_language,movie_rating,movie_duration,released_date,image_url)values(movie_id_seq.nextval,?,?,?,?,?,?,?)";
		System.out.println("");
		//System.out.println(sql);
		try (	
				Connection con = DbConnection.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);)
		{
			pst.setString(1, movie.getMovieName());
			pst.setString(2, movie.getMovieType());
			pst.setString(3, movie.getMovieLanguage());
			pst.setInt(4, movie.getMovieRating());
			pst.setInt(5, movie.getMovieDuration());
			pst.setDate(6, Date.valueOf(movie.getReleasedDate()));
			pst.setString(7, movie.getImageUrl());
			int row = pst.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	

public void updateMovieName(String movieName,String movieType,String movieLanguage,int movieRating,int movieDuration,String releasedDate, int movieId) throws DbException {
		
		String sqlb = "update movie set movie_name=?,movie_type=?,movie_language=?,movie_rating=?,movie_duration=?,released_date=? where movie_id=?";
		System.out.println("");
		//System.out.println(sqlb);
		try (   Connection con = DbConnection.getConnection();
				PreparedStatement pst = con.prepareStatement(sqlb);)
		{
			pst.setString(1, movieName);
			pst.setString(2, movieType);
			pst.setString(3, movieLanguage);
			pst.setInt(4, movieRating);
			pst.setInt(5, movieDuration);
			pst.setString(6, releasedDate);
			pst.setInt(7, movieId);
			int rowb = pst.executeUpdate();
			System.out.println(rowb);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
public void deleteMovieList(int movieId) throws DbException {
	
		String sql = "delete from movie where movie_id=?";
		System.out.println("");
		//System.out.println(sql);
		try( 	Connection con = DbConnection.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql);
) {
			stmt.setInt(1,movieId);
			int row = stmt.executeUpdate();
			System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

public List<MovieList> getmovieName(String movieLanguage,String movieType) throws DbException {
		
		List<MovieList> list=new ArrayList<MovieList>();
		String sqla = "Select movie_name from movie where movie_language=? and movie_type=?";
		//System.out.println(sqla);
		System.out.println("");
		try (	Connection con = DbConnection.getConnection();
				PreparedStatement stmta = con.prepareStatement(sqla);
				ResultSet rs = stmta.executeQuery();
)
		{
			stmta.setString(1, movieLanguage);
			stmta.setString(2, movieType);
			while (rs.next()) 
			{
				MovieList ml = new MovieList();
				ml.setMovieName(rs.getString("movie_name"));
				list.add(ml);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


    

public List<MovieList> allMovieList() throws DbException {
		
		List<MovieList> list = new ArrayList<MovieList>();
		String sqla = "select movie_id,movie_name,released_date,image_url,movie_language,movie_type,movie_rating,movie_duration from movie order by released_date desc";
		System.out.println("");
		//System.out.println(sqla);
		try(	Connection con = DbConnection.getConnection();
				Statement stmta = con.createStatement();)
		{
			try(ResultSet rs = stmta.executeQuery(sqla);){
			
			while (rs.next()) {
				MovieList ml = new MovieList();
				ml.setMovieId(rs.getInt("movie_id"));
				ml.setMovieName(rs.getString("movie_name"));
				ml.setImageUrl(rs.getString("image_url"));
				ml.setMovieLanguage(rs.getString("movie_language"));
				ml.setMovieType(rs.getString("movie_type"));
				ml.setMovieRating(rs.getInt("movie_rating"));
				ml.setMovieDuration(rs.getInt("movie_duration"));
				
				Date rd = rs.getDate("released_date");
				if (rd != null) {
					LocalDate ld = rd.toLocalDate();
					ml.setReleasedDate(ld);
				}
				list.add(ml);
			}
			}	} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("Unable to get movie list");
		}
		return list;

	}

		

public List<MovieList> allMovieDetails(String movieName) throws DbException {

		List<MovieList> list = new ArrayList<MovieList>();
		String sqla = "Select * from movie where movie_name='"+movieName+"'";
		System.out.println(sqla);
		//System.out.println(sqla);
		try (	Connection con = DbConnection.getConnection();
				Statement stmta = con.createStatement();)
		{
			try(ResultSet rs = stmta.executeQuery(sqla);){
			while (rs.next()) {
				MovieList ml = new MovieList();
				ml.setMovieId(rs.getInt("movie_id"));
				ml.setMovieName(rs.getString("movie_name"));
				ml.setMovieType(rs.getString("movie_type"));
				ml.setMovieLanguage(rs.getString("movie_language"));
				ml.setMovieRating(rs.getInt("movie_rating"));
				ml.setMovieDuration(rs.getInt("movie_duration"));
				Date rd = rs.getDate("released_date");
				if (rd != null) {
					LocalDate ld = rd.toLocalDate();
					ml.setReleasedDate(ld);
				}
				list.add(ml);
			}
			}} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
