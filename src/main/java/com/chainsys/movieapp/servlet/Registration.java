package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.movieapp.dao.UserInformationDAO;
import com.chainsys.movieapp.factory.DAOFactory;
import com.chainsys.movieapp.model.UserInformation;
import com.chainsys.movieapp.service.RegistrationService;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Autowired
private RegistrationService registration;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInformation user = new UserInformation();
		ArrayList<UserInformation> list = new ArrayList<UserInformation>();
		PrintWriter out = response.getWriter();
		user.setUserName(request.getParameter("Name"));
		String id = user.setEmailId(request.getParameter("EmailId"));
		
		long ph = user.setMobileNumber(Long.parseLong(request.getParameter("MobileNumber")));
		user.setGender(request.getParameter("gender"));
		user.setPassword(request.getParameter("Password"));
		list.add(user);
		boolean status = false;
		UserInformationDAO dao = DAOFactory.getUserInformationDAO();

		try {
			List<UserInformation> list1 = dao.findAll();
			for(UserInformation ui : list1) {
				long m =ui.getMobileNumber();
				String email =ui.getEmailId();
				if(m ==ph ||email.equals(id)) {
					status = true;
					
				}
				}
			if(status) {
				request.setAttribute("errorMessage", "Registered already!! Please Login...");
				RequestDispatcher dispatcher = request.getRequestDispatcher("UserRegistration.jsp");
				dispatcher.forward(request, response);
			}
			else {
				for (UserInformation UI : list) {
					registration.addUserDetails(UI);
					response.sendRedirect("Login.jsp");

				}
			
			}
			
			
			out.println(user.getUserName() + " " + "inserted");
		} catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("UserRegistration.jsp");
			dispatcher.forward(request, response);
		}

	}

}
