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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.movieapp.dao.UserInformationDAO;
import com.chainsys.movieapp.factory.DAOFactory;
import com.chainsys.movieapp.model.UserInformation;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(UpdatePass.class);


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInformation user = new UserInformation();
		ArrayList<UserInformation> list = new ArrayList<UserInformation>();
		PrintWriter out = response.getWriter();
		user.setUserName(request.getParameter("Name"));
		String id = user.setEmailId(request.getParameter("EmailId"));
		long ph = user.setMobileNum(Long.parseLong(request.getParameter("MobileNumber")));
		user.setGender(request.getParameter("gender"));
		user.setEpassword(request.getParameter("Password"));
		list.add(user);
		boolean status = false;
		UserInformationDAO dao = DAOFactory.getUserInformationDAO();

		try {
			List<UserInformation> list1 = dao.findAllUserDetails();
			for(UserInformation ui : list1) {
				long m =ui.getMobileNum();
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
					dao.save(UI);
					response.sendRedirect("Login.jsp");

				}
			
			}
			
			
			out.println(user.getUserName() + " " + "inserted");
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}

	}

}
