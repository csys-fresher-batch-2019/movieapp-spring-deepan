package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.util.DbException;
import com.chainsys.movieapp.model.MovieList;

public interface MovieListDAO {
	
	//@SqlUpdate("insert into movie(movie_id,movie_name,movie_type,movie_language,movie_rating,movie_duration,released_date)values(movie_id_seq.nextval,?,?,?,?,?,?)")
	void save( MovieList List) throws DbException;
	
    void update(String movieName,String movieType,String movieLanguage,int movieRating,int movieDuration,String releasedDate, int movieId) throws Exception;
	
	void delete(int movieId)throws DbException;
    
	//@SqlQuery("Select movie_name from movie where movie_language=? and movie_type=?")
    List<MovieList> findMovieNameByLanguageAndType(String movieLanguage,String movieType) throws DbException;
    
    List<MovieList> findByMovieName(String movieName) throws DbException;
    
	List<MovieList> findByReleasedDate() throws DbException;
	
	

}
