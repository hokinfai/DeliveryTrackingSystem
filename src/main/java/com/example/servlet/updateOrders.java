package com.example.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.OrderImp;
import com.example.dao.OrderService;
import com.example.dao.UserImp;
import com.example.dao.UserService;
import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.Company;
import com.example.model.Order;
import com.example.model.User;

/**
 * Servlet implementation class updateOrders
 */
public class updateOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateOrders() {
		super();
		// TODO Auto-generated constructor stub
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
		OrderService ordSer = new OrderImp();
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("company"));
		Company company = (Company) session.getAttribute("company");
		int id = Integer.parseInt(request.getParameter("orderId"));
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String status = request.getParameter("status");
		int weight = Integer.parseInt(request.getParameter("weight"));
		String size = request.getParameter("size");
		List<Order> newOrder = new ArrayList<Order>();
		try {
			List<Order> allOrders = ordSer.getCompanyOrder(company);
			for (Order o : allOrders) {
				if (o.getId() == id) {
					System.out.println(o);
					Order order = ordSer.getOrder(o.getId());
					order.setDestination(to);
					order.setFromAddress(from);
					order.setSize(size);
					order.setStatus(status);
					order.setWeight(weight);
					ordSer.save(order);
					newOrder.add(order);
				} else {
					newOrder.add(o);
				}
			}

			ordSer.close();
			session.setAttribute("companyOrder", newOrder);

			response.sendRedirect("/deliverytrackingsystem/outgoingOrders.jsp");
		} catch (Exception e) {
			System.err.println("error occured: " + e);
			response.sendRedirect("/deliverytrackingsystem/emailError.jsp");
		} finally {

		}
	}

}
