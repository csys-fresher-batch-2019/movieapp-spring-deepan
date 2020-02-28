package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.util.DbException;
import com.chainsys.movieapp.model.MovieList;

public interface MovieListDAO {
	
	//@SqlUpdate("insert into movie(movie_id,movie_name,movie_type,movie_language,movie_rating,movie_duration,released_date)values(movie_id_seq.nextval,?,?,?,?,?,?)")
	void addMovie( MovieList List) throws DbException;
	
    void updateMovieName(String movieName,String movieType,String movieLanguage,int movieRating,int movieDuration,String releasedDate, int movieId) throws Exception;
	
	void deleteMovieList(int movieId)throws DbException;
    
	//@SqlQuery("Select movie_name from movie where movie_language=? and movie_type=?")
    List<MovieList> getmovieName(String movieLanguage,String movieType) throws DbException;
    
    List<MovieList> allMovieDetails(String movieName) throws DbException;
    
	List<MovieList> allMovieList() throws DbException;
	
	

}
