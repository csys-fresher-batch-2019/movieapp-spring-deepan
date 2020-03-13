package com.chainsys.movieapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.movieapp.dao.MovieTheatreDAO;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.exception.ServiceException;
import com.chainsys.movieapp.model.MovieTheatre;

@Service
public class MovieTheatreService {
	
@Autowired
MovieTheatreDAO movieTheatreDAO;

public List<MovieTheatre> findActiveTheatre(int movieId) throws ServiceException{
	List<MovieTheatre> list=null;
	try {
		list= movieTheatreDAO.findActiveTheatreByMovieId(movieId);
	} catch (DbException e) {
throw new ServiceException(e);
}
	return list;
	
}

}
