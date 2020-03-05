package com.chainsys.movieapp.dao;

import com.chainsys.movieapp.util.DbException;

import java.util.List;

import com.chainsys.movieapp.model.UserInformation;

public interface UserInformationDAO {
	
	int addUserInformation(UserInformation users) throws DbException;
	void deleteUserInformation(int userId) throws DbException;
	Integer login(String emailId, String epassword) throws DbException;
	boolean updatePassword(String emailId,String epassword) throws DbException;
	String getEmailId(int userId) throws DbException;
	List<UserInformation> allUserDetails()throws DbException;

}
