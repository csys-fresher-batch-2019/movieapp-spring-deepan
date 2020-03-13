package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.model.Movie;

public interface MovieDAO {
	
	//@SqlUpdate("insert into movie(movie_id,movie_name,movie_type,movie_language,movie_rating,movie_duration,released_date)values(movie_id_seq.nextval,?,?,?,?,?,?)")
	void save( Movie List) throws DbException;
	
    void update(String movieName,String movieType,String movieLanguage,int movieRating,int movieDuration,String releasedDate, int movieId) throws Exception;
	
	void delete(int movieId)throws DbException;
    
	//@SqlQuery("Select movie_name from movie where movie_language=? and movie_type=?")
    List<Movie> findMovieNameByLanguageAndType(String movieLanguage,String movieType) throws DbException;
    
    List<Movie> findByMovieName(String movieName) throws DbException;
    
	List<Movie> findAll() throws DbException;
	
	

}
