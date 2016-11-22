package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ManagementImp;
import com.example.dao.Service;
import com.example.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
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
		Service service = new ManagementImp();
		PrintWriter out = response.getWriter();

		try {
			String name = request.getParameter("name");
			String surnname = request.getParameter("surnname");
			String username = request.getParameter("username");
			int age = Integer.parseInt(request.getParameter("age"));
			String dob = request.getParameter("dob");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String confirmpassword = request.getParameter("confirmpassword");
			String address = request.getParameter("address");
			if (password.equals(confirmpassword)) {
				User user = new User(email, username, password, name, surnname,
						age, dob, address);
				System.out.println("I am here__________");
				service.save(user);
				out.print("Your details are : <br/>");
				out.print("<p>" + user + "</p>");
			} else
				response.sendRedirect("/deliverytrackingsystem/RegistrationPage.jsp");
		} catch (Exception e) {
			response.sendRedirect("/deliverytrackingsystem/RegistrationPage.jsp");

		} finally {

			service.close();
		}
	}

}
