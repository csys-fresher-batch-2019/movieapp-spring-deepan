package com.chainsys.movieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.movieapp.dao.UserInformationDAO;
import com.chainsys.movieapp.exception.DbException;
import com.chainsys.movieapp.exception.ValidatorException;
import com.chainsys.movieapp.model.UserInformation;
import com.chainsys.movieapp.validator.Validator;
@Service
public class RegistrationService {

		@Autowired
		Validator validator;
		@Autowired
       UserInformationDAO userInfo;
		public void addUserDetails(UserInformation userInformation) throws ServiceException {
			try {
				Validator.validateRegistration(userInformation);
				userInfo.save(userInformation);
			} catch (DbException e) {
				throw new ServiceException(e);
			} catch (ValidatorException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}
}
