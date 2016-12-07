package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.Company;
import com.example.model.Order;
import com.example.model.User;

public class ManagementImp implements Service {
	EntityManagerFactory emf;
	EntityManager em;

	public ManagementImp() {
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

	public User login(String email, String password) {
		Query query = this.em
				.createQuery("FROM User AS user WHERE user.email=?");
		query.setParameter(0, email);
		User user = (User) query.getSingleResult();
		String encryptedPassword = user.getPassword();
		if (encryptedPassword.equals(new JavaMD5Hash().md5(password)))
			return user;
		else
			return null;
	}

	public void addUserOrder(User user, Order order) {
		user.addOrder(order);
		save(user);
		save(order);
	}

	public void addCompayOrder(Company company, Order order) {
		company.addOrder(order);
		save(company);
		save(order);
	}

	public List<Object> getAllUser() {
		List<Object> userList = new ArrayList<Object>();
		Query query = this.em.createQuery("from User");
		userList = query.getResultList();
		return userList;
	}

	public Company getCompanyByReNum(String number) {
		Query query = this.em
				.createQuery("FROM Company AS company WHERE company.registrationNumber=?");
		query.setParameter(0, number);
		Company company = (Company) query.getSingleResult();
		return company;
	}

	public void addOrderfromCompanies(Order order, Company company) {
		order.addCompany(company);
		save(order);
		save(company);
	}

	public List<Order> getUserOrder(User user) {
		List<Order> orderList = new ArrayList<Order>();
		orderList = user.getOrder();
		return orderList;
	}

	public void close() {
		if (this.em != null || this.emf != null) {
			this.em.close();
			this.emf.close();
		}
	}
}
