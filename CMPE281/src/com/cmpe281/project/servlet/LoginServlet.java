package com.cmpe281.project.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cmpe281.project.beans.UserBean;
import com.cmpe281.project.process.LoginUserProcess;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailAdress = request.getParameter("emailAddress");
		String password = request.getParameter("password");
		UserBean userBean = null;
		HttpSession session = request.getSession();
		if( ! (emailAdress == null || emailAdress.trim().equals("") || password == null || password.trim().equals("")) ){
			UserBean bean = new UserBean();
			bean.setEmail(emailAdress);
			bean.setUserPassword(password);
			LoginUserProcess loginProcess = new LoginUserProcess();
			userBean = loginProcess.loginUser(bean);
			if(userBean != null){
				session.setAttribute("userId", userBean.getUserId());
				session.setAttribute("userBean", userBean);
			}
		}
		String url = "/selectMarketPlace.jsp";
		if(userBean == null){
			url = "/login.jsp";
		} 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
