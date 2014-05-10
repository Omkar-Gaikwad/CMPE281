package com.cmpe281.project.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmpe281.project.process.PaymentProcess;

/**
 * Servlet implementation class MakePaymentServlet
 */
@WebServlet("/creditCardPayment")
public class MakePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakePaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("form submitted");
		System.out.println("Attr" + request.getParameter("quantityCart"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("form submitted");
		System.out.println("card number" + request.getParameter("carditCardText"));
		long cardNumber = Long.parseLong((String) request.getParameter("carditCardText"));
		int csvNumber = Integer.parseInt((String) request.getParameter("csvNumberText"));
		int userId = (Integer) request.getSession().getAttribute("userId");
		int tenantId = (Integer) request.getSession().getAttribute("tenantId");
		
		PaymentProcess paymentProcess = new PaymentProcess();
		boolean isSuccess = paymentProcess.makePayment(cardNumber, csvNumber, tenantId, userId);
		System.out.println("is pay" + isSuccess);
		
		if(isSuccess) {
			request.setAttribute("paymentStatus", "Payment Success!! Order Placed!!");
		} else {
			request.setAttribute("paymentStatus", "Error!! Please try again!");
		}
		
		String url = null;
		if (tenantId == 1) {
			url = "/book.jsp";
		}
		if (tenantId == 2) {
			url = "/mobile.jsp";
		}
		if (tenantId == 3) {
			url = "/car.jsp";
		}
		if (tenantId == 4) {
			url = "/laptop.jsp";
		}
		if (tenantId == 5) {
			url = "/sport.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
