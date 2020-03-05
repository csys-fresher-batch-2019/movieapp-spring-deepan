package com.chainsys.movieapp.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.movieapp.exception.BadCredentialsException;
import com.chainsys.movieapp.service.AuthService;
import com.chainsys.movieapp.service.ServiceException;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String status=null;
		
		//Step 1: Get form values
		String mail=request.getParameter("EmailId");
		String pass=request.getParameter("Password");
		Integer userId = null;
		try {
			//Step 2: Call Service login
			AuthService authService = new AuthService();
			userId = authService.login(mail,pass);
			System.out.println(userId);
			//Step 2.1 :If success store userid in session
			HttpSession session = request.getSession();
			session.setAttribute("USER_ID", userId);
			//Step 2.1.1:Go to next page
			response.sendRedirect("HomeMovies.jsp");
			status="success";
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			status="Invalid";
			//response.sendRedirect("Login.jsp?errorMessage=Invalid Login");
		} catch (ServiceException e) {
			status="error";
			//response.sendRedirect("Login.jsp?errorMessage=Invalid Login");

		}
		System.out.println(status);
		
		//Struts
		/*if(status.equals("success")) {
			response.sendRedirect("HomeMovies.jsp");

		}else if(status.equals("Invalid")) {
			response.sendRedirect("Login.jsp?errorMessage=Invalid Login");

		}else {
			response.sendRedirect("maintainance.jsp");

		}
*/
	}
}