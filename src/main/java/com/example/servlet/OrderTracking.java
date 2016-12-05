package com.example.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.OrderService;
import com.example.dao.SingleFactory;
import com.example.model.Company;
import com.example.model.Order;

/**
 * Servlet implementation class OrderTracking
 */
public class OrderTracking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SingleFactory sf;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderTracking() {
		super();
		sf = SingleFactory.GetInstance();
		// TODO Auto-generated constructor stub
	}

	public OrderTracking(SingleFactory sf) {
		this.sf = sf;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		OrderService ordSer = sf.getOrderImp();
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("date").replace("th", "")
				.replace("st", "").replace("rd", "").replace("nd", "");

		try {
			Order order = ordSer.getOrder(id);
			String dateCheck = ("" + order.getOrderDate() + "")
					.substring(8, 10);
			// System.out.println(dateCheck);
			if (dateCheck.equals(date)) {
				session.setAttribute("order", order);
				response.sendRedirect("/deliverytrackingsystem/order.jsp");
			} else
				response.sendRedirect("/deliverytrackingsystem/error.jsp");
		} catch (Exception e) {
			System.err.println("error occured: " + e);
			response.sendRedirect("/deliverytrackingsystem/error.jsp");
		} finally {
			ordSer.close();
		}
	}
}
