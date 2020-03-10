package com.chainsys.movieapp.dao;

import java.util.List;

import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.model.TheatreList;

public interface TheatreListDAO {
	
    void save(TheatreList list) throws DbException;
    
    void deleteTheatreDetailsByTheatreId(int theatreId) throws DbException;
    
    void updateTheatreRatingByTheatreName(int theatreRating, String theatreName) throws DbException;
    
    List<TheatreList> findAllTheatreDetails() throws DbException;

    List<TheatreList> findTheatreNameByTheatreAddress(String theatreAddress) throws DbException;

	
	
}
