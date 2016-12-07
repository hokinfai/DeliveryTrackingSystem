package com.example.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.example.dao.OrderImp;
import com.example.dao.OrderService;
import com.example.dao.SingleFactory;
import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.Company;
import com.example.model.Order;
import com.example.model.User;

/**
 * Servlet implementation class CompanyLoginServlet
 */
public class CompanyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SingleFactory sf;
	private OrderService ordSer;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanyLoginServlet() {
		sf = SingleFactory.GetInstance();
		// TODO Auto-generated constructor stub
	}

	public CompanyLoginServlet(SingleFactory sf) {
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
		HttpSession session = request.getSession();
		try {
			String companyName = request.getParameter("companyname");
			String regiNum = request.getParameter("regiNumber");
			String managerName = request.getParameter("managername");
			ordSer = sf.getOrderImp();
			Company company = ordSer.getCompanyByRegiManaName(regiNum,
					companyName, managerName);
			session.setAttribute("company", company);
			List<Order> companyOrder = ordSer.getCompanyOrder(company);
			List<String> username = ordSer.getUserName(companyOrder);
			session.setAttribute("companyOrder", companyOrder);
			session.setAttribute("username", username);
			response.sendRedirect("/deliverytrackingsystem/outgoingOrders.jsp");
		} catch (Exception e) {
			System.err.println("error occured: " + e);
			response.sendRedirect("/deliverytrackingsystem/error.jsp");
		} finally {
			// ordSer.close();
		}
	}
}
