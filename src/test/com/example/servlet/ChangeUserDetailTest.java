package com.example.servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyString;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dao.SingleFactory;
import com.example.dao.UserImp;
import com.example.dao.UserService;
import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.Company;
import com.example.model.Order;
import com.example.model.User;

public class ChangeUserDetailTest {
	@Mock
	private HttpServletRequest mockRequest;
	@Mock
	private HttpServletResponse mockResponse;
	@Mock
	private HttpSession mockSession;
	@Mock
	private UserImp mockUserImp;
	@Mock
	private User mockUser;
	@Mock
	private List<Order> mockOrderList;
	@Mock
	private EntityManager mockEM;
	@Mock
	private Company mockCompany;
	@Mock
	private EntityManagerFactory mockEMF;
	@Mock
	private EntityTransaction mockET;
	@Mock
	private Query mockQuery;
	@Mock
	private SingleFactory mockSf;
	@Mock
	private UserService mockSer;
	@Mock
	private JavaMD5Hash md5;
	private ChangeUserDetail change;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		change = new ChangeUserDetail(mockSf);
		when(mockRequest.getSession()).thenReturn(mockSession);

	}

	@Test
	public void testChangeUserDetail() {

	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		change.doGet(mockRequest, mockResponse);
	}

	@Test
	public void testChangeUserDetailSuccessfully() throws ServletException, IOException {
		// when(new JavaMD5Hash().md5("123")).thenReturn("123213213");
		when(mockRequest.getParameter("name")).thenReturn("someone");
		when(mockRequest.getParameter("surnname")).thenReturn("someone");
		when(mockRequest.getParameter("username")).thenReturn("someone");
		when(mockRequest.getParameter("age")).thenReturn("12");
		when(mockRequest.getParameter("dob")).thenReturn("12/12/1992");
		when(mockRequest.getParameter("password")).thenReturn("123");
		when(md5.md5("123")).thenReturn("123213213");
		when(mockSession.getAttribute("user")).thenReturn(mockUser);
		when(mockRequest.getParameter("address")).thenReturn("Earth");

		change.doPost(mockRequest, mockResponse);
		verify(mockResponse).sendRedirect("/deliverytrackingsystem/index.jsp");
	}

}
