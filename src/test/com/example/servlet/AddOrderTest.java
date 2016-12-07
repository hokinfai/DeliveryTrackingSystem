package com.example.servlet;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
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

public class AddOrderTest {
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
	private List<String> nameList;
	@Mock
	private EntityManager mockEM;
	@Mock
	private SingleFactory mockSf;
	@Mock
	private UserService mockSer;
	@Mock
	private OrderService mockOrd;
	@Mock
	private Company mockCompany;

	private AddOrder addOrder;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		addOrder = new AddOrder(mockSf);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockRequest.getAttribute("company")).thenReturn(mockCompany);
		when(mockSf.getUserImp()).thenReturn(mockSer);
		when(mockSf.getOrderImp()).thenReturn(mockOrd);
		when(mockSession.getAttribute("company")).thenReturn(mockCompany);
		when(mockRequest.getParameter("from")).thenReturn("HongKong");
		when(mockRequest.getParameter("to")).thenReturn("India");
		when(mockRequest.getParameter("status")).thenReturn("PENDING");
		when(mockRequest.getParameter("weight")).thenReturn("13");
		when(mockRequest.getParameter("size")).thenReturn("13*122");
		when(mockRequest.getParameter("email")).thenReturn("new@example.com");
		when(mockSer.getUser("new@example.com")).thenReturn(mockUser);
		when(mockCompany.getManager()).thenReturn("abc");
		when(mockCompany.getName()).thenReturn("abc");
		when(mockCompany.getRegistrationNumber()).thenReturn("abc");

		when(mockSession.getAttribute("companyOrder"))
				.thenReturn(mockOrderList);
		when(mockSession.getAttribute("username")).thenReturn(nameList);
	}

	@Test
	public void testAddOrder() {

	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse()
			throws ServletException, IOException {
		addOrder.doGet(mockRequest, mockResponse);
	}

	@Test
	public void testAddOrderSuccessfully()
			throws ServletException, IOException {
		when(mockOrd.getCompanyByRegiManaName("abc", "abc", "abc")).thenReturn(
				mockCompany);

		addOrder.doPost(mockRequest, mockResponse);
		verify(mockResponse).sendRedirect(
				"/deliverytrackingsystem/outgoingOrders.jsp");
	}

	@Test
	public void testAddOrderToFail_invalidLoginParameters()
			throws ServletException, IOException {
		when(mockOrd.getCompanyByRegiManaName("ABC123", "apple", "Alan Ho"))
				.thenReturn(mockCompany);

		addOrder.doPost(mockRequest, mockResponse);
		verify(mockResponse).sendRedirect(
				"/deliverytrackingsystem/emailError.jsp");
	}

}
