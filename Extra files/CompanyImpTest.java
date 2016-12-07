package com.example.dao;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.model.Company;
import com.example.model.Order;

public class CompanyImpTest {

	@Mock
	private EntityManager mockEntityManager;
	@Mock
	private EntityTransaction mockET;
	@Mock
	private Company mockCompany;
	@Mock
	private Order mockOrder;
	@Mock
	private EntityManagerFactory mockEmf;
	private CompanyImp companyImp;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		companyImp = new CompanyImp(mockEntityManager);
		when(mockEntityManager.getTransaction()).thenReturn(mockET);
	}

	@Test
	public void testCompanyImp() {

	}

	@Test
	public void testSave() {
		companyImp.save("anything");
		verify(mockET).begin();
		verify(mockEntityManager).persist("anything");
		verify(mockET).commit();
	}

	@Test
	public void testAddCompayOrder() {
		companyImp.addCompayOrder(mockCompany, mockOrder);
		verify(mockCompany).addOrder(mockOrder);
	}

	@Test
	public void testClose() {
		companyImp.close();
		verify(mockEntityManager).close();
	}

}
