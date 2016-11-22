package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.example.dao.ManagementImp;
import com.example.dao.Service;
import com.example.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Service service = new ManagementImp();
		try {
			User user = service.login(email, password);
			PrintWriter out = response.getWriter();
			out.print("Your details are : <br/>");
			out.print("<p>" + user + "</p>");
		} catch (Exception e) {
			System.err.print(e);
			response.sendRedirect("/deliverytrackingsystem/RegistrationPage.jsp");
		} finally {
			service.close();
		}
	}

}
