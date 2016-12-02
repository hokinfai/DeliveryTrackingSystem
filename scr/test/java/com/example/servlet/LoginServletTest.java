package com.example.servlet;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;
import java.util.List;

import javax.persistence.EntityManager;
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
import com.example.model.Order;
import com.example.model.User;

public class LoginServletTest {

	private LoginServlet loginServlet;

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
	private UserService mockSer;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		loginServlet = new LoginServlet(mockSf);
		when(mockRequest.getSession()).thenReturn(mockSession);
		when(mockSf.getUserImp()).thenReturn(mockSer);

	}

	@Test
	public void testLoginServlet() {

	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse()
			throws Exception {

		loginServlet.doGet(mockRequest, mockResponse);
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse()
			throws Exception {
		when(mockRequest.getParameter("email")).thenReturn("123");
		when(mockRequest.getParameter("password")).thenReturn("123");
		when(mockSer.login("123", "123")).thenReturn(mockUser);
		when(mockSer.getUserOrder(mockUser)).thenReturn(mockOrderList);
		loginServlet.doPost(mockRequest, mockResponse);
		verify(mockResponse).sendRedirect("/deliverytrackingsystem/index.jsp");
		mockUserImp.close();
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponseToFail()
			throws Exception {

		when(mockRequest.getParameter("email")).thenReturn("123");
		when(mockRequest.getParameter("password")).thenReturn("123");
		loginServlet.doPost(mockRequest, mockResponse);
		new RuntimeException();
		verify(mockResponse).sendRedirect(
				"/deliverytrackingsystem/loginError.jsp");

		
	}
}
