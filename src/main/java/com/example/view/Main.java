package com.example.view;

import java.util.List;

import com.example.dao.DeliveryStatus;
import com.example.dao.Service;
import com.example.dao.ManagementImp;
import com.example.model.Company;
import com.example.model.Order;
import com.example.model.User;

public class Main {

	public static void main(String[] args) {
		Service service = new ManagementImp();

		// Creating objects

		User alan = new User("hokinfaibb@gmail.com", "Alan", "199291456Ab",
				"Kin Fai", "Ho", 25, "1992-9-14", "LS7 1DP");
		User kirana = new User("kira-nurz@gmail.com", "Kirana", "3006",
				"Kirana", "Ngamvichan", 26, "1990-11-01", "LS7 1DP");
		Order iphone = new Order("HongKong", "Manchester, UK", "12*34", 34,
				DeliveryStatus.DELIVERING, "Jackson");
		Order ipad = new Order("Macao", "Manchester, UK", "10*23", 12,
				DeliveryStatus.CANCELLED, "lillian");
		Company adidas = new Company("adidas", "David", "USA", "1234567",
				"sdfsad", "fdsafas");
		Company nike = new Company("nike", "Matt", "USA", "1234567", "sdfsad",
				"fdsafas");

		adidas.addOrder(iphone);
		adidas.addOrder(ipad);
		service.save(iphone);
		service.save(ipad);
		service.save(adidas);
		service.save(nike);
		service.save(alan);
		service.save(kirana);
		service.addUserOrder(alan, iphone);
		service.addUserOrder(kirana, ipad);

		// Retrieving user
		// User checkpoint = service.login("hokinfaibb@gmail.com",
		// "199291456Ab");
		// checkpoint.setName("Kin Fai");

		// List<Order> order = service.getUserOrder(checkpoint);
		// for (Order o : order)
		// System.out.println(o.toString());
		// studentServices.save(checkpoint);

		service.close();

	}

}
