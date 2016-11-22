package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

	public User login(String email, String password) {
		Query query = this.em
				.createQuery("FROM User AS user WHERE user.email=? AND user.password = ?");
		query.setParameter(0, email);
		query.setParameter(1, password);
		User user = (User) query.getSingleResult();
		return user;
	}
		
	public void addUserOrder(User user, Order order) {
		user.addOrder(order);
		save(user);
		save(order);
	}

	public List<Object> getAllUser() {
		List<Object> userList = new ArrayList<Object>();
		Query query = this.em.createQuery("from User");
		userList = query.getResultList();
		return userList;
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
