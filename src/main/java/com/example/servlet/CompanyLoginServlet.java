package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.CompanyImp;
import com.example.dao.CompanyService;
import com.example.dao.OrderImp;
import com.example.dao.OrderService;
import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.Company;
import com.example.model.User;

/**
 * Servlet implementation class CompanyLoginServlet
 */
public class CompanyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanyLoginServlet() {
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
		String companyName = request.getParameter("companyname");
		String regiNum = request.getParameter("regiNumber");
		String managerName = request.getParameter("managername");
		OrderService ordSer = new OrderImp();
		try {
			Company company = ordSer.getCompanyByRegiManaName(regiNum,
					companyName, managerName);
			session.setAttribute("company", company);
			System.out.println("+++++++++++++++++++++++++");
			System.out.println(company.toString());
			//ordSer.close();
			response.sendRedirect("/deliverytrackingsystem/outgoingOrders.jsp");
		} catch (Exception e) {
			System.err.println("error occured: " + e);
			response.sendRedirect("/deliverytrackingsystem/emailError.jsp");
		} finally {
			
		}
	}

}
