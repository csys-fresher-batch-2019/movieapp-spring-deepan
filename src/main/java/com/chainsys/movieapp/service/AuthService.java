package com.chainsys.movieapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.UserInformationDAO;
import com.chainsys.movieapp.dao.impl.UserInformationDAOImpl;
import com.chainsys.movieapp.exception.BadCredentialsException;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.exception.ServiceException;

public class AuthService {
	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);


	private UserInformationDAO userDAO = new UserInformationDAOImpl();
	
	public Integer login(String emailId, String epassword) throws BadCredentialsException, ServiceException {
		Integer login = null;
		try {
			login = userDAO.findByEmailIdAndPassword(emailId, epassword);
			logger.info(""+login);
			if ( login == null ) {
				throw new BadCredentialsException("Invalid login credentials");
			}
		} catch (DbException e) {
			logger.debug(e.getMessage());
			throw new ServiceException("Unable to validate login", e);
		}
		return login;
	}
}
