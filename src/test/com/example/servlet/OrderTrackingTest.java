package com.example.servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
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

import com.example.dao.OrderService;
import com.example.dao.SingleFactory;
import com.example.dao.UserImp;
import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.Company;
import com.example.model.Order;
import com.example.model.User;

public class OrderTrackingTest {
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
	private Order mockOrder;
	@Mock
	private Date mockDate;

	private OrderTracking orderTrack;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		orderTrack = new OrderTracking(mockSf);
		Calendar myCal = Calendar.getInstance();
		myCal.set(2016, 11, 24);
		Date theDate = myCal.getTime();
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSf.getOrderImp()).thenReturn(mockSer);
		when(mockRequest.getParameter("id")).thenReturn("1");
		when(mockRequest.getParameter("date")).thenReturn("24th");
		when(mockSer.getOrder(1)).thenReturn(mockOrder);
		when(mockOrder.getOrderDate()).thenReturn(theDate);
	}

	@Test
	public void testOrderTracking() {

	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse()
			throws ServletException, IOException {
		orderTrack.doGet(mockRequest, mockResponse);
	}

	@Test
	public void testTrackingSingleWithValidIdDate()
			throws ServletException, IOException {
		orderTrack.doPost(mockRequest, mockResponse);
		verify(mockResponse).sendRedirect("/deliverytrackingsystem/order.jsp");
	}

	@Test
	public void  testTrackingSingleToFailWithInvalidIdDate()
			throws ServletException, IOException {
		when(mockRequest.getParameter("date")).thenReturn("23th");
		orderTrack.doPost(mockRequest, mockResponse);
		verify(mockResponse).sendRedirect("/deliverytrackingsystem/error.jsp");
	}

}
