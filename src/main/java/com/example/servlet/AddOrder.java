package com.example.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.CompanyImp;
import com.example.dao.CompanyService;
import com.example.dao.OrderImp;
import com.example.dao.OrderService;
import com.example.dao.SingleFactory;
import com.example.dao.UserImp;
import com.example.dao.UserService;
import com.example.model.Company;
import com.example.model.Order;
import com.example.model.User;

/**
 * Servlet implementation class AddOrder
 */
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SingleFactory sf;
	private UserService service;
	private OrderService ordSer;

	public AddOrder() {
		sf = SingleFactory.GetInstance();
		// TODO Auto-generated constructor stub
	}

	public AddOrder(SingleFactory sf) {
		this.sf = sf;
	}

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
		HttpSession session = request.getSession();

		try {
			Company company = (Company) session.getAttribute("company");
			String managerName = company.getManager();
			String regiNum = company.getRegistrationNumber();
			String companyName = company.getName();
			System.out.println("information here: " + companyName + regiNum
					+ regiNum);
			service = sf.getUserImp();
			ordSer = sf.getOrderImp();
			Company refresh = ordSer.getCompanyByRegiManaName(regiNum,
					companyName, managerName);
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String status = request.getParameter("status");
			int weight = Integer.parseInt(request.getParameter("weight"));
			String size = request.getParameter("size");
			String email = request.getParameter("email");

			User user = service.getUser(email);
			Order order = new Order(from, to, size, weight, status);
			user.addOrder(order);
			refresh.addOrder(order);
			service.save(user);
			ordSer.save(refresh);
			service.save(order);
			service.close();
			ordSer.close();
			List<Order> companyOrder = (List<Order>) session
					.getAttribute("companyOrder");
			List<String> username = (List<String>) session
					.getAttribute("username");
			companyOrder.add(order);
			username.add(user.getName());
			System.out.println(username);
			session.setAttribute("companyOrder", companyOrder);
			session.setAttribute("username", username);
			response.sendRedirect("/deliverytrackingsystem/outgoingOrders.jsp");

		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("/deliverytrackingsystem/emailError.jsp");
		}

	}
}
