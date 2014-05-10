package com.cmpe281.project.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmpe281.project.beans.LaptopAccessoryBean;
import com.cmpe281.project.beans.LaptopBean;
import com.cmpe281.project.beans.MobileBean;
import com.cmpe281.project.beans.ProductBean;
import com.cmpe281.project.process.TenantProcess;

public class LaptopAccessoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int laptopId = Integer.parseInt((String) request.getParameter("itemId"));
		System.out.println(laptopId);
		LaptopAccessoryBean accessoriesBean = null;
		TenantProcess tenantProcess = new TenantProcess();
		accessoriesBean = tenantProcess.getLaptopAccessories(laptopId);
		System.out.println(accessoriesBean.getAccessoryId() + " " + accessoriesBean.getCover() + " " + accessoriesBean.getHardDrive());
		List<? extends ProductBean> productList = (List<? extends ProductBean>) request.getSession().getAttribute("productlist");
		
		LaptopBean laptopBean = null;
		for (ProductBean productBean : productList) {
			laptopBean = (LaptopBean) productBean;
			if (laptopId == laptopBean.getLaptopId()) {
				request.getSession().setAttribute("laptopName", laptopBean.getBrandName() + " " + laptopBean.getLaptopName());
				break;
			}
		}
		request.getSession().setAttribute("laptopAccessory", accessoriesBean); 
		String url = "/showLaptopAccessory.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
