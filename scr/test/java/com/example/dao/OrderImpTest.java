package com.example.dao;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.model.Company;
import com.example.model.Order;

public class OrderImpTest {
	@Mock
	private EntityManager mockEM;
	@Mock
	private EntityTransaction mockET;
	@Mock
	private Query mockQuery;
	@Mock
	private Order mockOrder;
	@Mock
	private Company mockCompany;
	@Mock
	private List<Order> mockOrderList;
	@Mock
	private List<String> mockNameList;
	private OrderImp orderImp;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		orderImp = new OrderImp(mockEM);
		when(mockEM.getTransaction()).thenReturn(mockET);
		when(mockEM.createQuery(anyString())).thenReturn(mockQuery);
		when(mockQuery.getSingleResult()).thenReturn(mockOrder);
	}

	@Test
	public void testOrderImp() {
//		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		orderImp.save("abc");
		verify(mockET).begin();
		verify(mockEM).persist("abc");
		verify(mockEM).flush();
		verify(mockET).commit();
	}

	@Test
	public void testGetOrder() {
		orderImp.getOrder(12);
		verify(mockQuery).getSingleResult();
	}

	@Test
	public void testAddOrderfromCompanies() {
		orderImp.addOrderfromCompanies(mockOrder, mockCompany);
		verify(mockOrder).addCompany(mockCompany);
	}

	@Test
	public void testGetUserName() {
		orderImp.getUserName(mockOrderList);
		for (int i = 0; i < mockOrderList.size(); i++)
			mockNameList.add(mockOrderList.get(i).getUser().getName());
		verify(mockNameList);
	}

	@Test
	public void testGetCompanyOrder() {
		orderImp.getCompanyOrder(mockCompany);
		verify(mockCompany).getOrderList();
	}

	@Test
	public void testGetCompanyByRegiManaName() {
		when(mockQuery.getSingleResult()).thenReturn(mockCompany);
		orderImp.getCompanyByRegiManaName("123", "123", "123");
		verify(mockQuery).getSingleResult();
	}

	@Test
	public void testClose() {
		orderImp.close();
		verify(mockEM).close();
	}

}
