package com.example.dao;

import java.util.List;

import com.example.model.Order;
import com.example.model.User;

public interface Service {
	public void save(Object object);

	public void addUserOrder(User user, Order order);

	public List<Object> getAllUser();

	public User login(String email, String password);

	public List<Order> getUserOrder(User user);

	public void close();
}
