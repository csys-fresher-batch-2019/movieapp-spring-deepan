package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.model.Theatre;

public interface TheatreListDAO {
	
    void save(Theatre list) throws DbException;
    
    void delete(int theatreId) throws DbException;
    
    void update(int theatreRating, String theatreName) throws DbException;
    
    List<Theatre> findAll() throws DbException;

    List<Theatre> findTheatreNameByTheatreAddress(String theatreAddress) throws DbException;

	
	
}
