package com.example.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.dao.OrderImp;

import static org.mockito.Mockito.mock;

public class CompanyTest {

	User alan;
	Order iphone;
	Company apple;

	@Before
	public void setup() {
		alan = new User(
				"hokinfaibb@http://repo.maven.apache.org/maven2/org/mockito/mockito-all/1.9.5/mockito-all-1.9.5.pomgmail.com",
				"Alan", "41a38b69f58bc7f2cd8d00591d982826", "Kin Fai", "Ho",
				25, "1992-9-14", "LS7 1DP");
		iphone = new Order("HongKong", "Manchester", "12*34", 34,
				"DeliveryStatus.DELIVERING");
		apple = new Company("ABC123", "apple", "Alan Ho", "USA", "123456789",
				"adidas@adidas.com");
	}

	@Test
	public void testCompany() {
		// Arrange
		Company company = null;
		// Assert
		assertNull(company);
	}

	@Test
	public void testCompanyStringStringStringStringStringString() {
		// Arrange
		// Act
		// Assert
		assertNotNull(apple);
	}

	@Test
	public void testGetRegistrationNumber() {
		// Arrange
		String number = apple.getRegistrationNumber();
		// Act
		// Assert
		assertEquals("ABC123", number);
	}

	@Test
	public void testSetRegistrationNumber() {
		// Arrange
		String number = "bbc";
		// Act
		apple.setRegistrationNumber(number);
		// Assert
		assertEquals("bbc", apple.getRegistrationNumber());
	}

	@Test
	public void testGetName() {
		// Arrange
		String name = apple.getName();
		// Act
		// Assert
		assertEquals("apple", name);
	}

	@Test
	public void testSetName() {
		// Arrange
		String name = "bbc";
		// Act
		apple.setName(name);
		// Assert
		assertEquals("bbc", apple.getName());
	}

	@Test
	public void testGetManager() {
		// Arrange
		String manager = apple.getManager();
		// Act
		// Assert
		assertEquals("Alan Ho", manager);
	}

	@Test
	public void testSetManager() {
		// Arrange
		String name = "bbc";
		// Act
		apple.setManager(name);
		// Assert
		assertEquals("bbc", apple.getManager());
	}

	@Test
	public void testGetLocation() {
		// Arrange
		String location = apple.getLocation();
		// Act
		// Assert
		assertEquals("USA", location);
	}

	@Test
	public void testSetLocation() {
		// Arrange
		String location = "UK";
		// Act
		apple.setLocation(location);
		// Assert
		assertEquals("UK", apple.getLocation());
	}

	@Test
	public void testGetPhone() {
		// Arrange
		String phone = apple.getPhone();
		// Act
		// Assert
		assertEquals("123456789", phone);
	}

	@Test
	public void testSetPhone() {
		// Arrange
		String phone = "1223";
		// Act
		apple.setPhone(phone);
		// Assert
		assertEquals("1223", apple.getPhone());
	}

	@Test
	public void testGetEmail() {
		// Arrange
		String email = apple.getEmail();
		// Act
		// Assert
		assertEquals("adidas@adidas.com", email);
	}

	@Test
	public void testSetEmail() {
		// Arrange
		String email = "1223@gmail.com";
		// Act
		apple.setEmail(email);
		// Assert
		assertEquals(email, apple.getEmail());
	}

	@Test
	public void testGetOrderList() {
		assertNotNull(apple.getOrderList());
	}

	@Test
	public void testAddOrder() {
		// Arrange
		apple.addOrder(iphone);
		// Act
		// Assert
		assertNotNull(apple.getOrderList());
	}

	@Test
	public void testToString() {
		// Arrange
		String print = apple.toString();
		// Act
		// Assert
		assertNotNull(print);
	}

}
