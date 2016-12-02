package com.example.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.dao.CompanyImp;
import com.example.dao.CompanyService;
import com.example.dao.OrderImp;
import com.example.dao.OrderService;
import com.example.dao.UserImp;
import com.example.dao.UserService;

public class UserTest {

	User alan;
	Order iphone;
	Company apple;

	@Before
	public void setup() {

		alan = new User("hokinfaibb@gmail.com", "Alan",
				"41a38b69f58bc7f2cd8d00591d982826", "Kin Fai", "Ho", 25,
				"1992-9-14", "LS7 1DP");
		iphone = new Order("HongKong", "Manchester, UK", "12*34", 34,
				"DeliveryStatus.DELIVERING");
		apple = new Company("ABC123", "apple", "Alan Ho", "USA", "123456789",
				"adidas@adidas.com");
	}

	@Test
	public void testUser() {
		// Arrange
		User user = null;
		// Act

		// Assert
		assertNull(user);
	}

	@Test
	public void testUserStringStringStringStringStringIntStringString() {
		// Arrange
		// Act
		// Assert
		assertNotNull(alan);
	}

	@Test
	public void testGetEmail() {
		// Arrange
		// Act
		String email = alan.getEmail();
		// Assert
		assertEquals("hokinfaibb@gmail.com", email);
	}

	@Test
	public void testSetEmail() {
		// Arrange
		String newEmail = "abc@gmail.com";
		// Act
		alan.setEmail(newEmail);
		// Assert
		assertEquals(newEmail, alan.getEmail());
	}

	@Test
	public void testGetUsername() {
		// Arrange
		// Act
		String username = alan.getUsername();
		// Assert
		assertEquals("Alan", username);
	}

	@Test
	public void testSetUsername() {
		// Arrange
		String username = "abc";
		// Act
		alan.setUsername(username);
		// Assert
		assertEquals(username, alan.getUsername());
	}

	@Test
	public void testGetPassword() {
		// Arrange
		// Act
		String password = alan.getPassword();
		// Assert
		assertEquals("41a38b69f58bc7f2cd8d00591d982826", password);
	}

	@Test
	public void testSetPassword() {
		// Arrange
		String password = "abc";
		// Act
		alan.setPassword(password);
		// Assert
		assertEquals("abc", password);
	}

	@Test
	public void testGetName() {
		// Arrange
		// Act
		String name = alan.getName();
		// Assert
		assertEquals("Kin Fai", name);
	}

	@Test
	public void testSetName() {
		// Arrange
		String name = "abc";
		// Act
		alan.setName(name);
		// Assert
		assertEquals("abc", name);
	}

	@Test
	public void testGetSurnname() {
		// Arrange
		// Act
		String surnname = alan.getSurnname();
		// Assert
		assertEquals("Ho", surnname);
	}

	@Test
	public void testSetSurnname() {
		// Arrange
		String surnname = "abc";
		// Act
		alan.setSurnname(surnname);
		// Assert
		assertEquals("abc", surnname);
	}

	@Test
	public void testGetAge() {
		// Arrange
		// Act
		int age = alan.getAge();
		// Assert
		assertEquals(25, age);
	}

	@Test
	public void testSetAge() {
		// Arrange
		int age = 23;
		// Act
		alan.setAge(age);
		// Assert
		assertEquals(23, age, 0);
	}

	@Test
	public void testGetDob() {
		// Arrange
		// Act
		String dob = alan.getDob();
		// Assert
		assertEquals("1992-9-14", dob);
	}

	@Test
	public void testSetDob() {
		// Arrange
		String dob = "12/12/12";
		// Act
		alan.setDob(dob);
		// Assert
		assertEquals("12/12/12", dob);
	}

	@Test
	public void testGetAddress() {
		// Arrange
		// Act
		String address = alan.getAddress();
		// Assert
		assertEquals("LS7 1DP", address);
	}

	@Test
	public void testSetAddress() {
		// Arrange
		String address = "Macao";
		// Act
		alan.setAddress(address);
		// Assert
		assertEquals("Macao", alan.getAddress());
	}

	@Test
	public void testGetOrder() {
		// Arrange
		alan.addOrder(iphone);
		// Act
		List<Order> order = alan.getOrder();
		// Assert
		assertNotNull(order);
	}

	@Test
	public void testAddOrder() {
		// Arrange

		// Act

		// Assert
		alan.addOrder(iphone);
	}

	@Test
	public void testToString() {
		// Arrange
		String toString = "User [email=" + alan.getEmail() + ", username="
				+ alan.getUsername() + ", password=" + alan.getPassword()
				+ ", name=" + alan.getName() + ", surnname="
				+ alan.getSurnname() + ", age=" + alan.getAge() + ", dob="
				+ alan.getDob() + ", address=" + alan.getAddress();
		// Act
		String alanString = alan.toString();
		// Assert
		assertEquals(toString, alanString);
	}

	@After
	public void teardown() {
		alan = null;
		iphone = null;
		apple = null;
	}

}
