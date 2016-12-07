package com.example.servlet;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

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

import com.example.dao.OrderImp;
import com.example.dao.OrderService;
import com.example.dao.SingleFactory;
import com.example.dao.UserImp;
import com.example.dao.UserService;
import com.example.model.Company;
import com.example.model.Order;
import com.example.model.User;

public class CompanyLoginServletTest {
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
	private OrderService mockOrd;

	private CompanyLoginServlet companylogin;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		companylogin = new CompanyLoginServlet(mockSf);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSf.getOrderImp()).thenReturn(mockOrd);
		when(mockOrd.getCompanyByRegiManaName("ABC123", "apple", "Alan Ho")).thenReturn(mockCompany);

	}

	@Test
	public void testCompanyLoginServlet() {
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		companylogin.doGet(mockRequest, mockResponse);
	}

	@Test
	public void testCompanyLoginSuccessfully() throws ServletException, IOException {
		when(mockRequest.getParameter("companyname")).thenReturn("sumsung");
		when(mockRequest.getParameter("regiNumber")).thenReturn("bbc123");
		when(mockRequest.getParameter("managername")).thenReturn("Jose");
		companylogin.doPost(mockRequest, mockResponse);
		verify(mockResponse).sendRedirect("/deliverytrackingsystem/outgoingOrders.jsp");
	}

}
