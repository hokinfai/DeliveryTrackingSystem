package com.example.dao;

import javax.persistence.Query;

import com.example.model.Company;
import com.example.model.Order;

public interface OrderService {
	public void save(Object object);

	public Order getOrder(int id);

	public void addOrderfromCompanies(Order order, Company company);

	public Company getCompanyByReNum(String number);

	public void close();
}
