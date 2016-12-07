package com.example.dao;

import com.example.model.Company;
import com.example.model.Order;

public interface CompanyService {
	public void save(Object object);

	public void addCompayOrder(Company company, Order order);

	public void close();
}
