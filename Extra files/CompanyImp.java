package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.model.Company;
import com.example.model.Order;

public class CompanyImp implements CompanyService {

	EntityManager em;

	public CompanyImp() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("default");
		this.em = emf.createEntityManager();
	}

	public CompanyImp(EntityManager em) {
		this.em = em;
	}

	public void save(Object object) {
		this.em.getTransaction().begin();
		this.em.persist(object);
		this.em.getTransaction().commit();
	}

	public void addCompayOrder(Company company, Order order) {
		company.addOrder(order);
		save(company);
	}

	public void close() {
		if (this.em != null) {
			this.em.close();
		}
	}
}
