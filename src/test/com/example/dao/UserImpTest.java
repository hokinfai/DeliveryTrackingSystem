package com.example.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.Order;
import com.example.model.User;

public class UserImpTest {
	@Mock
	private EntityManager mockEntityManager;
	@Mock
	private Query mockQuery;
	@Mock
	private User mockUser;
	@Mock
	private JavaMD5Hash md5;
	@Mock
	private Order mockOrder;
	@Mock
	private EntityTransaction mockET;
	@Mock
	private List<Object> mockUserList;
	@Mock
	private List<Order> mockOrderList;
	private UserImp userImp;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		userImp = new UserImp(mockEntityManager, md5);
		when(mockEntityManager.createQuery(anyString())).thenReturn(mockQuery);
		when(mockQuery.getResultList()).thenReturn(mockUserList);
		when(mockQuery.getSingleResult()).thenReturn(mockUser);
		when(mockUser.getPassword()).thenReturn("123");
		when(md5.md5("123")).thenReturn("123");
		when(mockUser.getOrder()).thenReturn(mockOrderList);
		when(mockEntityManager.getTransaction()).thenReturn(mockET);

	}

	@Test
	public void testUserImp() {
		// fail("Not yet implemented");
	}

	/*
	 * OrderBOImp bo = new OrderBOImpl(); bo.setDao(dao);
	 * Mockito.when(bo.placeOrder()).thenReturn(true);
	 * assertTrue(bo.placeOrder()); Mockito.verify(dao).placeOrder();
	 */

	@Test
	public void testSave() {
		userImp.save("abc");
		verify(mockET).begin();
		verify(mockET).commit();
		verify(mockEntityManager).persist("abc");
	}

	@Test
	public void testLogin() {
		userImp.login("123@gmail.com", "123");
		verify(mockQuery).getSingleResult();
	}

	@Test
	public void testLoginFail() {
		userImp.login("123@gmail.com", "134");
		verify(mockQuery).getSingleResult();
	}

	@Test
	public void testGetUser() {
		userImp.getUser("em@gmail.com");
		verify(mockQuery).getSingleResult();
	}

	@Test
	public void testAddUserOrder() {

		userImp.addUserOrder(mockUser, mockOrder);
		verify(mockUser).addOrder(mockOrder);
	}

	@Test
	public void testGetAllUser() {
		userImp.getAllUser();
		verify(mockQuery).getResultList();
	}

	@Test
	public void testGetUserOrder() {
		userImp.getUserOrder(mockUser);
		verify(mockUser).getOrder();
	}

	@Test
	public void testClose() {
		userImp.close();
		verify(mockEntityManager).close();

	}

	@After
	public void validate() {
		validateMockitoUsage();
	}

}
