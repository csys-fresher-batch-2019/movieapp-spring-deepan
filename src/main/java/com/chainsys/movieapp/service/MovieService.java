package com.chainsys.movieapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.movieapp.dao.MovieDAO;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.exception.ServiceException;
import com.chainsys.movieapp.model.Movie;

@Service
public class MovieService {
	@Autowired
	MovieDAO movieDAO;
	public List<Movie> findAllMovies() throws ServiceException{
		List<Movie> list=null;
		try {
			list= movieDAO.findAll();
		} catch (DbException e) {
throw new ServiceException(e);
}
		return list;
		
	}

}
