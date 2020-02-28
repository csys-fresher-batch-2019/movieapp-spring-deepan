package com.chainsys.movieapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.movieapp.dao.impl.UserInformationImpl;
import com.chainsys.movieapp.model.UserInformation;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInformation user = new UserInformation();
		ArrayList<UserInformation> list = new ArrayList<UserInformation>();
		PrintWriter out = response.getWriter();
		user.setUserName(request.getParameter("Name"));
		user.setEmailId(request.getParameter("EmailId"));
		user.setMobileNum(Long.parseLong(request.getParameter("MobileNumber")));
		user.setGender(request.getParameter("gender"));
		user.setEpassword(request.getParameter("Password"));
		list.add(user);
		UserInformationImpl UII = new UserInformationImpl();

		try {
			for (UserInformation UI : list) {
				UII.addUserInformation(UI);

			}
			out.println(user.getUserName() + " " + "inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("Login.jsp");

	}

}
