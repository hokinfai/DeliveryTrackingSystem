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
		// UserService userService = new UserImp();
		// OrderService orderService = new OrderImp();
		Service service = new ManagementImp();
		ManagementImp studentServices = (ManagementImp) service;

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
		Company apple = new Company("ABC123", "apple", "Alan Ho", "USA",
				"123456789", "adidas@adidas.com");
		Company sumsung = new Company("bbc123", "sumsung", "Jose", "Korea",
				"456789123", "sumsung@gmail.com");
		// service.addUserOrder(alan, iphone);
		// service.addUserOrder(alan, ipad);
		// service.addUserOrder(kirana, ipad);
		// service.close();
		//

		// Order order = service.getOrder(2);
		// order.addCompany(company);
		// System.out.println(order.toString());
		// service.save(order);
		// System.out.println(order.getCompanyList().get(0));
		// service.addOrderfromCompanies(order, company);

		// CODE THAT WORKS WITH COMPANY ADDS ORDERS
		// Company company = service.getCompanyByReNum("bbc123");
		// System.out.println(company.toString());
		// service.save(iphone);
		// service.save(ipad);
		// company.addOrder(ipad);
		// company.addOrder(iphone);
		// service.save(company);

		// CODE THAT WORKS WITH ORDER ADDS COMPANYS
		Order order = service.getOrder(4);
		System.out.println(order.toString());
		Company company = service.getCompanyByReNum("ABC123");
		System.out.println(company.toString());
		order.addCompany(company);
		System.out.println(order.getCompanyList().get(0).getEmail());
		iphone.addCompany(apple);
		ipad.addCompany(sumsung);
		service.save(order);

		// service.addUserOrder(kirana, ipad);
		// service.addCompayOrder(apple, iphone);
		// service.addCompayOrder(apple, ipad);
		// service.addOrderfromCompanies(ipad, apple);
		// Retrieving user
		// User checkpoint = service.login("hokinfaibb@gmail.com",
		// "199291456Ab");
		// checkpoint.setName("Kin Fai");

		// List<Order> order = service.getUserOrder(checkpoint);
		// for (Order o : order)
		// System.out.println(o.toString());
		// studentServices.save(checkpoint);
		// orderService.close();
		service.close();
	}

}
