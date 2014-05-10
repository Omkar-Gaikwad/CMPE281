package com.cmpe281.project.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cmpe281.project.beans.BookBean;
import com.cmpe281.project.beans.CarBean;
import com.cmpe281.project.beans.LaptopBean;
import com.cmpe281.project.beans.MobileBean;
import com.cmpe281.project.beans.ProductBean;
import com.cmpe281.project.beans.SportsBean;
import com.cmpe281.project.beans.TenantBean;
import com.cmpe281.project.process.ProductProcess;
import com.cmpe281.project.process.TenantProcess;

public class SelectTenantServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenantName = request.getParameter("market");
		System.out.println(tenantName);
		TenantProcess tenantProcess = new TenantProcess();
		TenantBean tenantBean = null;
		tenantBean = tenantProcess.getTenantDetails(tenantName);
		HttpSession session = request.getSession();
		session.setAttribute("tenantId", tenantBean.getTenantId());

		ProductProcess productProcess = new ProductProcess();
		List<? extends ProductBean> productList = null;
		// List<BookBean> bookList = new ArrayList<BookBean>();
		String url = null;
		if (tenantBean.getTenantId() == 1) {
			productList = productProcess.getProductList(tenantBean.getTenantId());
			List<BookBean> bookList = (List<BookBean>) (List<?>) productList;

			url = "/book.jsp";
			for (ProductBean productBean : productList) {
				BookBean bookBean = (BookBean) productBean;

				System.out.println(bookBean.getBookName() + " " + bookBean.getAuthor() + " " + bookBean.getPrice() + " " + bookBean.getQuantity() + " " + bookBean.getBookId());
			}
		}
		if (tenantBean.getTenantId() == 2) {
			productList = productProcess.getProductList(tenantBean.getTenantId());
			List<MobileBean> mobileList = (List<MobileBean>) (List<?>) productList;

			url = "/mobile.jsp";
			for (ProductBean productBean : productList) {
				MobileBean mobileBean = (MobileBean) productBean;

				System.out.println(mobileBean.getBrandName() + " " + mobileBean.getMobileId() + " " + mobileBean.getMobileName() + " " + mobileBean.getOperatingSystem() + " "
						+ mobileBean.getTenantId());
			}
		}
		if (tenantBean.getTenantId() == 3) {
			productList = productProcess.getProductList(tenantBean.getTenantId());
			List<CarBean> carList = (List<CarBean>) (List<?>) productList;

			url = "/car.jsp";
			for (ProductBean productBean : productList) {
				CarBean carBean = (CarBean) productBean;

				System.out.println(carBean.getBrandName() + " " + carBean.getCarId() + " " + carBean.getType() + " " + carBean.getColor() + " " + carBean.getQuantity());
			}
		}
		if (tenantBean.getTenantId() == 4) {
			productList = productProcess.getProductList(tenantBean.getTenantId());
			List<LaptopBean> laptopList = (List<LaptopBean>) (List<?>) productList;

			url = "/laptop.jsp";
			for (ProductBean productBean : productList) {
				LaptopBean carBean = (LaptopBean) productBean;

				System.out.println(carBean.getBrandName() + " " + carBean.getLaptopId() + " " + carBean.getOperatingSystem() + " " + carBean.getPrice() + " " + carBean.getQuantity());
			}
		}
		if (tenantBean.getTenantId() == 5) {
			productList = productProcess.getProductList(tenantBean.getTenantId());
			List<SportsBean> sportsList = (List<SportsBean>) (List<?>) productList;

			url = "/sport.jsp";
			for (ProductBean productBean : productList) {
				SportsBean carBean = (SportsBean) productBean;

				System.out.println(carBean.getBrandName() + " " + carBean.getItemId() + " " + carBean.getSports() + " " + carBean.getPrice() + " " + carBean.getQuantity());
			}
		}
		session.setAttribute("productlist", productList);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
