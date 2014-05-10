package com.cmpe281.project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmpe281.project.beans.BookBean;
import com.cmpe281.project.beans.CarBean;
import com.cmpe281.project.beans.CartBean;
import com.cmpe281.project.beans.LaptopBean;
import com.cmpe281.project.beans.MobileBean;
import com.cmpe281.project.beans.ProductBean;
import com.cmpe281.project.beans.SportsBean;
import com.cmpe281.project.process.CartProcess;

public class AddToCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemId = Integer.parseInt((String) request.getParameter("itemId"));
		int cartQuantity = Integer.parseInt((String) request.getParameter("quantityCart"));
		int userId = (Integer) request.getSession().getAttribute("userId");
		int tenantId = (Integer) request.getSession().getAttribute("tenantId");

		CartBean cartBean = new CartBean();
		cartBean.setItemId(itemId);
		cartBean.setPurchased(false);
		cartBean.setQuantity(cartQuantity);
		cartBean.setUserId(userId);
		cartBean.setTenantId(tenantId);

		boolean isAdded = new CartProcess().addToCart(cartBean);
		System.out.println("Item Added = " + isAdded);
		List<? extends ProductBean> productList = (List<? extends ProductBean>) request.getSession().getAttribute("productlist");

		if(isAdded) {
			request.setAttribute("itemAdded", "Item added to cart");
		} else {
			request.setAttribute("itemAdded", "Error!! Item not added to cart!");
		}
		
		String url = null;
		if (tenantId == 1) {
			url = "/book.jsp";
			if (isAdded) {
				List<BookBean> bookList = (List<BookBean>) (List<?>) productList;
				for (ProductBean productBean : productList) {
					BookBean bookBean = (BookBean) productBean;
					if (itemId == bookBean.getBookId()) {
						bookBean.setQuantity(bookBean.getQuantity() - cartQuantity);
					}
				}
			}
		}
		if (tenantId == 2) {
			url = "/mobile.jsp";
			if (isAdded) {
				List<MobileBean> mobileList = (List<MobileBean>) (List<?>) productList;
				for (ProductBean productBean : productList) {
					MobileBean mobileBean = (MobileBean) productBean;
					if (itemId == mobileBean.getMobileId()) {
						mobileBean.setQuantity(mobileBean.getQuantity() - cartQuantity);
					}
				}
			}
		}
		if (tenantId == 3) {
			url = "/car.jsp";
			if (isAdded) {
				List<CarBean> carList = (List<CarBean>) (List<?>) productList;
				for (ProductBean productBean : productList) {
					CarBean carBean = (CarBean) productBean;
					if (itemId == carBean.getCarId()) {
						carBean.setQuantity(carBean.getQuantity() - cartQuantity);
					}
				}
			}
		}
		if (tenantId == 4) {
			url = "/laptop.jsp";
			if (isAdded) {
				List<LaptopBean> laptopList = (List<LaptopBean>) (List<?>) productList;
				for (ProductBean productBean : productList) {
					LaptopBean laptopBean = (LaptopBean) productBean;
					if (itemId == laptopBean.getLaptopId()) {
						laptopBean.setQuantity(laptopBean.getQuantity() - cartQuantity);
					}
				}
			}
		}
		if (tenantId == 5) {
			url = "/sport.jsp";
			if (isAdded) {
				List<SportsBean> sportsBeans = (List<SportsBean>) (List<?>) productList;
				for (ProductBean productBean : productList) {
					SportsBean sportBean = (SportsBean) productBean;
					if (itemId == sportBean.getItemId()) {
						sportBean.setQuantity(sportBean.getQuantity() - cartQuantity);
					}
				}
			}
		}
		request.getSession().setAttribute("productlist", productList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
