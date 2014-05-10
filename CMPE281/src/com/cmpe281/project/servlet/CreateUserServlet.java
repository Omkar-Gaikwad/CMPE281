package com.cmpe281.project.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmpe281.project.beans.UserBean;
import com.cmpe281.project.process.CreateUserProcess;

public class CreateUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String emailAddress = request.getParameter("emailAddress");
		String password = request.getParameter("password");
		int userId = -1;
		if (!(firstName == null || firstName.trim().equals("") || lastName == null || lastName.trim().equals("") || emailAddress == null || emailAddress.trim().equals(""))) {
			UserBean userBean = new UserBean(emailAddress, password, firstName, lastName);
			CreateUserProcess createUser = new CreateUserProcess();
			userId = createUser.createUser(userBean);
		}
		String url = "/login.jsp";
		if(userId == -1){
			url = "/createUser.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
