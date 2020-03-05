package com.chainsys.movieapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.movieapp.dao.MovieListDAO;
import com.chainsys.movieapp.dao.UserInformationDAO;
import com.chainsys.movieapp.dto.Messagedto;
import com.chainsys.movieapp.factory.DAOFactory;
import com.chainsys.movieapp.model.MovieList;
import com.chainsys.movieapp.model.UserInformation;
import com.chainsys.movieapp.util.DbException;

@RestController
@RequestMapping("api")
public class MovieAppController {
	MovieListDAO mld = DAOFactory.getMovieListDAO();
	UserInformationDAO udao=DAOFactory.getUserInformationDAO();
	@GetMapping("/allMovieList")
	public List<MovieList> allMovieList() throws DbException
	{
		List<MovieList> m = mld.allMovieList();
		return m;
		
	}
	
	@GetMapping("/Register")
	public Messagedto Register(@RequestParam("userName")String Name,@RequestParam("emailId")String EmailId,@RequestParam("mobileNumber")long MobileNumber,@RequestParam("gender")String gender,@RequestParam("Password")String Password) throws DbException {
	UserInformation user = new UserInformation();
	Messagedto msg = new Messagedto();
	user.setUserName(Name);
	user.setEmailId(EmailId);
	user.setMobileNum(MobileNumber);
	user.setGender(gender);
	user.setEpassword(Password);
	int m=udao.addUserInformation(user);
	if(m==1) {
		msg.setInfoMessage("Successfully Registered");
	}
	else
	{
		msg.setErrorMessage("Registration Failed");
	}
	return msg;
	
	}
}
