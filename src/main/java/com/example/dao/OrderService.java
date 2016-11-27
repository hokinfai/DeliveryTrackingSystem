package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import com.example.model.Company;
import com.example.model.Order;

public interface OrderService {
	public void save(Object object);

	public Order getOrder(int id);

	public void addOrderfromCompanies(Order order, Company company);

	public Company getCompanyByRegiManaName(String number, String name,
			String manager);

	public List<Order> getCompanyOrder(Company company);

	public List<String> getUserName(List<Order> order);

	public void close();
}
