package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dao.SingleFactory;
import com.example.dao.UserImp;
import com.example.dao.UserService;
import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.User;

/**
 * Servlet implementation class ChangeUserDetail
 */
public class ChangeUserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SingleFactory sf;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeUserDetail() {
		super();
		sf = SingleFactory.GetInstance();
		// TODO Auto-generated constructor stub
	}

	public ChangeUserDetail(SingleFactory sf) {
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
		UserService service = sf.getUserImp();
		HttpSession session = request.getSession();
		try {
			String name = request.getParameter("name");
			String surnname = request.getParameter("surnname");
			String username = request.getParameter("username");
			int age = Integer.parseInt(request.getParameter("age"));
			String dob = request.getParameter("dob");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String encryptedPassword = new JavaMD5Hash().md5(password);
			User user = (User) session.getAttribute("user");
			System.out.println(user.getPassword());
			System.out.println(encryptedPassword);
			if (encryptedPassword.equals(user.getPassword())) {
				User modifiedUser = service.getUser(user.getEmail());
				modifiedUser.setName(name);
				modifiedUser.setSurnname(surnname);
				modifiedUser.setUsername(username);
				modifiedUser.setAge(age);
				modifiedUser.setDob(dob);
				modifiedUser.setAddress(address);
				service.save(modifiedUser);
				service.close();
				session.setAttribute("user", modifiedUser);
				response.sendRedirect("/deliverytrackingsystem/myaccount.jsp");
			} else
				response.sendRedirect("/deliverytrackingsystem/index.jsp");
		} catch (Exception e) {
			System.err.println("error occured: " + e);
			response.sendRedirect("/deliverytrackingsystem/error.jsp");
		} finally {

		}
	}
}
