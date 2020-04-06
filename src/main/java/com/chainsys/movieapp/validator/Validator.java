package com.chainsys.movieapp.validator;

import org.springframework.stereotype.Component;

import com.chainsys.movieapp.exception.ValidatorException;
import com.chainsys.movieapp.model.UserInformation;
@Component
	public class Validator {

	public  void validateRegistration(UserInformation u) throws ValidatorException {
			
			if ( u.getUserName() == null || "".equals(u.getUserName().trim())) {
					throw new ValidatorException("Name cannot be blank/empty");
			}
			if(u.getEmailId() == null || "".equals(u.getEmailId().trim())) {
					throw new ValidatorException("Mail-id cannot be blank/empty");
			}
			if(u.getPassword() == null || "".equals(u.getPassword().trim())) {
					throw new ValidatorException("Password cannot be blank/empty");
			}
			if(u.getGender() == null || "".equals(u.getGender().trim())) {
					throw new ValidatorException("Gender cannot be blank/empty");
			}
			if(u.getMobileNumber()== 0 ||Long.toString(u.getMobileNumber()).length()<10||Long.toString(u.getMobileNumber()).length()>10) {
					throw new ValidatorException("Phone-number cannot be blank/empty");
			}
		}
	
	
	public  void validateLoginCheck(UserInformation u) throws ValidatorException {
		
		if(u.getEmailId() == null || "".equals(u.getEmailId().trim())) {
				throw new ValidatorException("Mail-id cannot be blank/empty");
		}
		if(u.getPassword() == null || "".equals(u.getPassword().trim())) {
				throw new ValidatorException("Password cannot be blank/empty");
		}
		}
		}

	
		
		