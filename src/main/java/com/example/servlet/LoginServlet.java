package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.UserImp;
import com.example.dao.UserService;
import com.example.model.User;

/**
 * Servlet implementation class LoginServlet
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			UserService service = new UserImp();
			User user = service.login(email, password);
			session.setAttribute("user", user);
			if (!user.equals(null)) {
				response.sendRedirect("/deliverytrackingsystem/index.jsp");
				System.out.println("login servlet: " + user.toString());
			}
		} catch (Exception e) {
			System.err.println("Invalid login parameters: " + e);
			response.sendRedirect("/deliverytrackingsystem/loginError.jsp");
		}
	}

}
