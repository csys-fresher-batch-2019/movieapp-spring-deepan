package com.chainsys.movieapp.dao;

import com.chainsys.movieapp.util.DbException;

import java.util.List;

import com.chainsys.movieapp.model.UserInformation;

public interface UserInformationDAO {
	
	int save(UserInformation users) throws DbException;
	void deleteUserInformationByUserId(int userId) throws DbException;
	Integer findByEmailIdAndPassword(String emailId, String epassword) throws DbException;
	boolean updatePasswordByEmailId(String emailId,String epassword) throws DbException;
	String findEmailIdByUserId(int userId) throws DbException;
	List<UserInformation> findAllUserDetails()throws DbException;

}
