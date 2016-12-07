package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import com.example.model.Company;
import com.example.model.Order;
import com.example.model.User;

public interface Service {
	public void save(Object object);

	public void addUserOrder(User user, Order order);

	public List<Object> getAllUser();

	public User login(String email, String password);

	public List<Order> getUserOrder(User user);

	public Order getOrder(int id);

	public Company getCompanyByReNum(String number);

	public void addOrderfromCompanies(Order order, Company company);

	public void close();
}
