package com.example.servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

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
import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.Company;
import com.example.model.Order;
import com.example.model.User;

public class UpdateOrdersTest {
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
	private JavaMD5Hash md5;
	@Mock
	private SingleFactory mockSf;
	@Mock
	private OrderService mockSer;
	@Mock
	private Company mockCompany;

	private UpdateOrders update;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		update = new UpdateOrders(mockSf);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSf.getOrderImp()).thenReturn(mockSer);
		when(mockSer.getCompanyByRegiManaName("ABC123", "apple", "Alan Ho"))
				.thenReturn(mockCompany);
		when(mockSession.getAttribute("company")).thenReturn(mockCompany);
		when(mockRequest.getParameter("orderId")).thenReturn("1");
		when(mockRequest.getParameter("from")).thenReturn("HongKong");
		when(mockRequest.getParameter("to")).thenReturn("Macao");
		when(mockRequest.getParameter("status")).thenReturn("DELIVERING");
		when(mockRequest.getParameter("size")).thenReturn("20*20");
		when(mockRequest.getParameter("weight")).thenReturn("40");
		// when(mockSer.getCompanyOrder(mockCompany)).thenReturn(mockOrderList);
	}

	@Test
	public void testUpdateOrders() {

	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse()
			throws ServletException, IOException {
		update.doGet(mockRequest, mockResponse);
	}

	@Test
	public void testSuccessfullyUpdateOrder()
			throws IOException, ServletException {
		update.doPost(mockRequest, mockResponse);
		verify(mockResponse).sendRedirect(
				"/deliverytrackingsystem/outgoingOrders.jsp");

	}

}
