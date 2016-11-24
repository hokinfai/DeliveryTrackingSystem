package com.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.model.Company;
import com.example.model.Order;

public class OrderImp implements OrderService {
	EntityManagerFactory emf;
	EntityManager em;

	public OrderImp() {
		this.emf = Persistence.createEntityManagerFactory("default");
		this.em = emf.createEntityManager();
	}

	public void save(Object object) {
		this.em.getTransaction().begin();
		this.em.persist(object);
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

	public Company getCompanyByReNum(String number) {
		Query query = this.em
				.createQuery("FROM Company AS company WHERE company.registrationNumber=?");
		query.setParameter(0, number);
		Company company = (Company) query.getSingleResult();
		return company;
	}

	public void close() {
		if (this.em != null || this.emf != null) {
			this.em.close();
			this.emf.close();
		}
	}

}
