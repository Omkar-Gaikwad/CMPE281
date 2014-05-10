package com.cmpe281.project.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmpe281.project.beans.AccessoriesBean;
import com.cmpe281.project.beans.BookBean;
import com.cmpe281.project.beans.MobileBean;
import com.cmpe281.project.beans.ProductBean;
import com.cmpe281.project.beans.Reviews;
import com.cmpe281.project.process.TenantProcess;

public class AccessoryServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mobileId = Integer.parseInt((String) request.getParameter("itemId"));
		
		AccessoriesBean accessoriesBean = null;
		TenantProcess tenantProcess = new TenantProcess();
		accessoriesBean = tenantProcess.getAccessories(mobileId);
		
			System.out.println(accessoriesBean.getCover() + " " + accessoriesBean.getDataCable());
		
		
		List<? extends ProductBean> productList = (List<? extends ProductBean>) request.getSession().getAttribute("productlist");
		
		MobileBean mobileBean = null;
		for (ProductBean productBean : productList) {
			mobileBean = (MobileBean) productBean;
			if (mobileId == mobileBean.getMobileId()) {
				request.getSession().setAttribute("mobileName", mobileBean.getBrandName() + " " + mobileBean.getMobileName());
				break;
			}
		}
	
		request.getSession().setAttribute("accessory", accessoriesBean); 
		String url = "/showAccessory.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

	
	}
}
