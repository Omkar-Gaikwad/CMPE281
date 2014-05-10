package com.cmpe281.project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmpe281.project.beans.CartItemsBean;
import com.cmpe281.project.process.CartProcess;

public class ShowCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = (Integer) request.getSession().getAttribute("userId");
		int tenantId = (Integer) request.getSession().getAttribute("tenantId");
		float totalAmount = 0.0f;
		CartProcess cartProcess = new CartProcess();
		List<CartItemsBean> cartItemsList = cartProcess.getCartItems(tenantId, userId);
		
		int index = 1;
		for (CartItemsBean cartItemsBean : cartItemsList) {
			cartItemsBean.setIndex(index++);
			totalAmount = totalAmount + cartItemsBean.getAmount();
		}
		
		request.getSession().setAttribute("cartList", cartItemsList);
		request.getSession().setAttribute("totalAmount", totalAmount);
		
		String url = "/userCartItems.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
