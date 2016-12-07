package com.example.model;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.dao.OrderImp;
import com.example.dao.OrderService;
import com.example.dao.UserImp;
import com.example.dao.UserService;

public class OrderTest {

	User alan;
	Order iphone;
	Company apple;

	@Before
	public void setup() {

		alan = new User("hokinfaibb@gmail.com", "Alan",
				"41a38b69f58bc7f2cd8d00591d982826", "Kin Fai", "Ho", 25,
				"1992-9-14", "LS7 1DP");
		iphone = new Order("HongKong", "Manchester", "12*34", 34,
				"DeliveryStatus.DELIVERING");
		apple = new Company("ABC123", "apple", "Alan Ho", "USA", "123456789",
				"adidas@adidas.com");
	}

	@Test
	public void testOrder() {
		// Arrange
		Order order = null;
		// Act
		// Assert
		assertNull(order);
	}

	@Test
	public void testOrderStringStringStringIntString() {
		// Arrange
		// Act
		// Assert
		assertNotNull(alan);

	}

	@Test
	public void testGetCompanyList() {
		iphone.addCompany(apple);
		List<Company> company = iphone.getCompanyList();
		assertNotNull(company);
	}

	@Test
	public void testAddCompany() {
		iphone.addCompany(apple);
		assertNotNull(iphone.getCompanyList());
	}

	@Test
	public void testGetFromAddress() {
		// Arrange
		String address = iphone.getFromAddress();
		// Act

		// Assert
		assertEquals("HongKong", address);
	}

	@Test
	public void testSetFromAddress() {
		// Arrange
		String address = "Macao";
		// Act
		iphone.setFromAddress(address);
		// Assert
		assertEquals(address, iphone.getFromAddress());
	}

	@Test
	public void testGetDestination() {
		// Arrange
		String address = iphone.getDestination();
		// Act

		// Assert
		assertEquals("Manchester", address);
	}

	@Test
	public void testSetDestination() {
		// Arrange
		String address = "Macao";
		// Act
		iphone.setDestination(address);
		// Assert
		assertEquals(address, iphone.getDestination());
	}

	@Test
	public void testGetSize() {
		// Arrange
		String size = iphone.getSize();
		// Act

		// Assert
		assertEquals("12*34", size);
	}

	@Test
	public void testSetSize() {
		// Arrange
		String size = "13*34";
		// Act
		iphone.setSize(size);
		// Assert
		assertEquals(size, iphone.getSize());
	}

	@Test
	public void testGetWeight() {
		// Arrange
		int weight = iphone.getWeight();
		// Act

		// Assert
		assertEquals(34, weight, 0);
	}

	@Test
	public void testSetWeight() {
		// Arrange
		int size = 40;
		// Act
		iphone.setWeight(size);
		// Assert
		assertEquals(size, iphone.getWeight());
	}

	@Test
	public void testGetStatus() {
		// Arrange
		String status = iphone.getStatus();
		// Act

		// Assert
		assertEquals("DeliveryStatus.DELIVERING", status);

	}

	@Test
	public void testSetStatus() {
		// Arrange
		String status = "DeliveryStatus.PENDING";
		// Act
		iphone.setStatus(status);
		// Assert
		assertEquals(status, iphone.getStatus());
	}

	@Test
	public void testGetTheExpectedArrivalDate() {

	}

	@Test
	public void testGetExpectedArrivalDate() {
		// fail("Not yet implemented");
	}

	@Test
	public void testSetExpectedArrivalDate() {
		// fail("Not yet implemented");
	}

	// @Test
	// public void testGetOrderDate() {
	// // Arrange
	// Date date = new Date();
	// // Act
	//
	// // Assert
	// assertEquals(date, iphone.getOrderDate());
	// }

	@Test
	public void testSetOrderDate() {
		// Arrange
		Date date = new Date();
		// Act
		iphone.setOrderDate(date);
		// Assert
		assertEquals(date, iphone.getOrderDate());
	}

	@Test
	public void testGetId() {
		// Arrange
		int id = 1;
		System.out.println("the id is" + id);
		// Act

		// Assert
		assertNotNull(id);
	}

	@Test
	public void testGetUser() {
		// Arrange
		User user = iphone.getUser();
		System.out.println(user);
		// Act
		// Assert
		assertNull(user);
	}

	@Test
	public void testToString() {
		// Arrange
		String print = iphone.toString();
		// Act
		// Assert
		assertNotNull(print);
	}

	@After
	public void teardown() {
		alan = null;
		iphone = null;
		apple = null;
	}
}
