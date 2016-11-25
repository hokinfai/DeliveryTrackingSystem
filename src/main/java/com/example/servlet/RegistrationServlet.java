package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UserImp;
import com.example.dao.UserService;
import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.User;

/**
 * Servlet implementation class RegistrationServlet
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserImp();
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
			String encryptedPassword = new JavaMD5Hash().md5(password);
			if (password.equals(confirmpassword)) {
				User user = new User(email, username, encryptedPassword, name, surnname, age, dob, address);
				service.save(user);
				service.close();
				response.sendRedirect("/deliverytrackingsystem/index.jsp");
			} else
				response.sendRedirect("/deliverytrackingsystem/RegistrationPage.jsp");
		} catch (Exception e) {
			System.err.println("error occured: " + e);
			response.sendRedirect("/deliverytrackingsystem/emailError.jsp");
		} finally {
		
		}
	}

}
