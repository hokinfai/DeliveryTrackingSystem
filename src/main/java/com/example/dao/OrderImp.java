package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.model.Company;
import com.example.model.Order;

public class OrderImp implements OrderService {

	EntityManager em;

	public OrderImp() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("default");
		this.em = emf.createEntityManager();
	}

	public OrderImp(EntityManager em) {
		this.em = em;
	}

	public void save(Object object) {
		this.em.getTransaction().begin();
		this.em.persist(object);
		this.em.flush();
		this.em.getTransaction().commit();
	}

	public Order getOrder(int id) {
		Query query = this.em
				.createQuery("FROM Order AS order WHERE order.id=?");
		query.setParameter(0, id);
		Order order = (Order) query.getSingleResult();
		return order;
	}

	public void addOrderfromCompanies(Order order, Company company) {
		order.addCompany(company);
		save(order);
		save(company);
	}

	public List<String> getUserName(List<Order> order) {
		List<String> nameList = new ArrayList<String>();
		for (int i = 0; i < order.size(); i++)
			nameList.add(order.get(i).getUser().getName());
		return nameList;
	}

	public List<Order> getCompanyOrder(Company company) {
		List<Order> orderList = new ArrayList<Order>();
		orderList = company.getOrderList();
		return orderList;
	}

	public Company getCompanyByRegiManaName(String number, String name,
			String manager) {
		Query query = this.em
				.createQuery("FROM Company AS company WHERE company.registrationNumber=? AND company.name = ? AND company.manager = ?");
		query.setParameter(0, number);
		query.setParameter(1, name);
		query.setParameter(2, manager);
		Company company = (Company) query.getSingleResult();
		return company;
	}

	public void close() {
		if (this.em != null) {
			this.em.close();
		}
	}

}
