package com.example.servlet;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dao.SingleFactory;
import com.example.dao.UserImp;
import com.example.dao.UserService;
import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.Order;
import com.example.model.User;

public class RegistrationServletTest {
	private RegistrationServlet registrationServlet;

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
	private UserService mockService;
	@Mock
	private JavaMD5Hash md5;
	@Mock
	private SingleFactory mockSf;
	@Mock
	private UserService mockSer;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		registrationServlet = new RegistrationServlet(mockSf);
		when(mockSf.getUserImp()).thenReturn(mockSer);
		when(md5.md5(anyString())).thenReturn(anyString());
		when(mockRequest.getParameter("name")).thenReturn("Someone");
		when(mockRequest.getParameter("surnname")).thenReturn("Someone");
		when(mockRequest.getParameter("username")).thenReturn("Someone");
		when(mockRequest.getParameter("dob")).thenReturn("Someone");
		when(mockRequest.getParameter("email")).thenReturn("new@example.com");
		when(mockRequest.getParameter("address")).thenReturn("Some Where");
		when(mockRequest.getParameter("password")).thenReturn("123213213");
		when(mockRequest.getParameter("age")).thenReturn("11");
	}

	@Test
	public void testRegistrationServlet() {
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		registrationServlet.doGet(mockRequest, mockResponse);
	}

	@Test
	public void testRegisterWithValidInputs() throws Exception {
		when(mockRequest.getParameter("confirmpassword")).thenReturn("123213213");
		registrationServlet.doPost(mockRequest, mockResponse);
		verify(mockResponse).sendRedirect("/deliverytrackingsystem/index.jsp");
	}

	@Test
	public void testRegisterToFailWithInvalidInputs_wrongConfirmPassword() throws Exception {
		when(mockRequest.getParameter("confirmpassword")).thenReturn("1afd");
		when(md5.md5(anyString())).thenReturn(anyString());
		registrationServlet.doPost(mockRequest, mockResponse);
		verify(mockResponse).sendRedirect("/deliverytrackingsystem/RegistrationPage.jsp");
	}

	@Test
	public void testRegisterToFailWithInvalidInputs_DuplicateEmail() throws Exception {
		when(mockRequest.getParameter("age")).thenReturn("1d");
		registrationServlet.doPost(mockRequest, mockResponse);
		// when(mockSer.save(anyObject())).thenThrow(new RuntimeException());
		verify(mockResponse).sendRedirect("/deliverytrackingsystem/emailError.jsp");
	}

	@After
	public void teardown() {
		registrationServlet = null;
	}
}
