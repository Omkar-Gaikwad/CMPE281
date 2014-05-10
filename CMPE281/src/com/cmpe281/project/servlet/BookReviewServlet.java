package com.cmpe281.project.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmpe281.project.beans.BookBean;
import com.cmpe281.project.beans.ProductBean;
import com.cmpe281.project.beans.Reviews;
import com.cmpe281.project.process.TenantProcess;

public class BookReviewServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("itemId"));
		int bookId = Integer.parseInt((String) request.getParameter("itemId"));
		
		List<Reviews> reviewsList = new ArrayList<Reviews>();
		TenantProcess tenantProcess = new TenantProcess();
		reviewsList = tenantProcess.getReviews(bookId);
		for (Reviews reviews : reviewsList) {
			System.out.println(reviews.getReview());
		}
		
		List<? extends ProductBean> productList = (List<? extends ProductBean>) request.getSession().getAttribute("productlist");
		

		List<BookBean> bookList = (List<BookBean>) (List<?>) productList;
		BookBean bookBean = null;
		for (ProductBean productBean : productList) {
			bookBean = (BookBean) productBean;
			if (bookId == bookBean.getBookId()) {
				request.getSession().setAttribute("bookName", bookBean.getBookName());
				break;
			}
		}
	
		request.getSession().setAttribute("reviews", reviewsList); 
		String url = "/bookreview.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
