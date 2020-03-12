package com.chainsys.movieapp.dao;

import com.chainsys.movieapp.exception.DbException;

import java.util.List;

import com.chainsys.movieapp.model.UserInformation;

public interface UserInformationDAO {
	
	int save(UserInformation users) throws DbException;
	void delete(int userId) throws DbException;
	Integer findByEmailIdAndPassword(String emailId, String epassword) throws DbException;
	boolean update(String emailId,String epassword) throws DbException;
	String findEmailIdByUserId(int userId) throws DbException;
	List<UserInformation> findAll()throws DbException;

}
