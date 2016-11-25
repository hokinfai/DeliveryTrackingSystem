package com.example.view;

import java.util.List;

import com.example.dao.CompanyImp;
import com.example.dao.CompanyService;
import com.example.dao.DeliveryStatus;
import com.example.dao.ManagementImp;
import com.example.dao.OrderService;
import com.example.dao.Service;
import com.example.dao.UserService;
import com.example.dao.UserImp;
import com.example.dao.OrderImp;
import com.example.model.Company;
import com.example.model.Order;
import com.example.model.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserImp();
		OrderService orderService = new OrderImp();
		CompanyService companyService = new CompanyImp();
		// Service service = new ManagementImp();
		// ManagementImp studentServices = (ManagementImp) service;

		// Creating User objects
		User alan = new User("hokinfaibb@gmail.com", "Alan",
				"41a38b69f58bc7f2cd8d00591d982826", "Kin Fai", "Ho", 25,
				"1992-9-14", "LS7 1DP");
		User kirana = new User("kira-nurz@gmail.com", "Kirana", "3006",
				"Kirana", "Ngamvichan", 26, "1990-11-01", "LS7 1DP");
		Order iphone = new Order("HongKong", "Manchester, UK", "12*34", 34,
				"DeliveryStatus.DELIVERING");
		Order ipad = new Order("Macao", "Manchester, UK", "10*23", 12,
				"DeliveryStatus.CANCELLED");
		Order iwatch = new Order("Macao", "Thailand", "1*21", 34,
				"DeliveryStatus.PENDING");
		Order mac = new Order("HongKong", "UK", "123*21", 340,
				"DeliveryStatus.PENDING");
		Company apple = new Company("ABC123", "apple", "Alan Ho", "USA",
				"123456789", "adidas@adidas.com");
		Company sumsung = new Company("bbc123", "sumsung", "Jose", "Korea",
				"456789123", "sumsung@gmail.com");
		// userService.addUserOrder(alan, iphone);
		// userService.addUserOrder(alan, ipad);
		// userService.addUserOrder(kirana, ipad);
		// userService.close();

		// companyService.save(apple);
		// companyService.save(sumsung);

		// CODE THAT COMPANY ADDS ORDER TO USER
		User user = userService.getUser("hokinfaibb@gmail.com");
		user.addOrder(iwatch);
		Company company = orderService.getCompanyByRegiManaName("ABC123",
				"apple", "Alan Ho");
		company.addOrder(iwatch);
		userService.save(user);
		orderService.save(company);
		userService.save(iwatch);

		// CODE THAT WORKS WITH COMPANY ADDS ORDERS
		// Order order = orderService.getOrder(20);
		// System.out.println(order.toString());
		// Company company = orderService.getCompanyByRegiManaName("ABC123",
		// "apple", "Alan Ho");
		// company.addOrder(order);
		// orderService.save(company);
		// System.out.println(company.toString());
		// System.out.println(company.getOrderList().get(0).getId());

		// CODE THAT WORKS WITH ORDER ADDS COMPANYS
		// Order order = orderService.getOrder(4);
		// System.out.println(order.toString());
		// Company company = orderService.getCompanyByReNum("ABC123");
		// System.out.println(company.toString());
		// order.addCompany(company);
		// System.out.println(order.getCompanyList().get(0).getEmail());
		// orderService.save(order);

		// CODE THAT TESTS OBJECT AND DATABASE
		// Company company = orderService.getCompanyByRegiManaName("ABC123",
		// "apple", "Alan Ho");
		// company.addOrder(mac);
		// orderService.save(company);
		// orderService.save(mac);
		// service.addUserOrder(kirana, ipad);
		// service.addCompayOrder(apple, iphone);
		// service.addCompayOrder(apple, ipad);
		// service.addOrderfromCompanies(ipad, apple);
		// Retrieving user
		// User checkpoint = service.login("hokinfaibb@gmail.com",
		// "199291456Ab");
		// checkpoint.setName("Kin Fai");
		// studentServices.save(checkpoint);

		// User user = userService.getUser("hokinfaibb@gmail.com");
		// System.out.println(user.toString());
		// System.out.println(user.getOrder().get(0));
		// List<Order> order = userService.getUserOrder(user);
		// for (Order o : order)
		// System.out.println(o.toString());

		orderService.close();
		companyService.close();
	}
}
