package com.example.servlet;

import java.io.IOException;
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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOrder() {
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
		HttpSession session = request.getSession();
		UserService service = new UserImp();
		OrderService ordSer = new OrderImp();
		Company thisCompany = (Company) session.getAttribute("company");
		Company company = ordSer.getCompanyByRegiManaName(
				thisCompany.getRegistrationNumber(), thisCompany.getName(),
				thisCompany.getManager());

		System.out.println("company information here: "
				+ company.getRegistrationNumber());
		try {
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String status = request.getParameter("status");
			int weight = Integer.parseInt(request.getParameter("weight"));
			String size = request.getParameter("size");
			String email = request.getParameter("email");
			Order order = new Order(from, to, size, weight, status);
			User user = service.getUser(email);
			System.out.println("user information here: " + user.toString());
			user.addOrder(order);
			company.addOrder(order);
			service.save(user);
			ordSer.save(company);
			ordSer.save(order);
			service.close();
			ordSer.close();
			response.sendRedirect("outgoingOrders.jsp");
		} catch (Exception e) {
		}

	}
}
