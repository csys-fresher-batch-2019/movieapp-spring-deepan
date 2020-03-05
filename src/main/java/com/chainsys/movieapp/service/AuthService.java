package com.chainsys.movieapp.service;

import com.chainsys.movieapp.dao.UserInformationDAO;
import com.chainsys.movieapp.dao.impl.UserInformationImpl;
import com.chainsys.movieapp.exception.BadCredentialsException;
import com.chainsys.movieapp.util.DbException;

public class AuthService {

	public UserInformationDAO userDAO = new UserInformationImpl();
	
	public Integer login(String emailId, String epassword) throws BadCredentialsException, ServiceException {
		Integer login = null;
		try {
			login = userDAO.login(emailId, epassword);
			System.out.println(login);
			if ( login == null ) {
				throw new BadCredentialsException("Invalid login credentials");
			}
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to validate login", e);
		}
		return login;
	}
}
