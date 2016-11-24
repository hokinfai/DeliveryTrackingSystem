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

public class UserImp implements UserService {
	EntityManagerFactory emf;
	EntityManager em;

	public UserImp() {
		this.emf = Persistence.createEntityManagerFactory("default");
		this.em = emf.createEntityManager();
	}

	public void save(Object object) {
		this.em.getTransaction().begin();
		this.em.persist(object);
		this.em.getTransaction().commit();
	}

	public User login(String email, String password) {
		Query query = this.em.createQuery("FROM User AS user WHERE user.email=?");
		query.setParameter(0, email);
		User user = (User) query.getSingleResult();
		String encryptedPassword = user.getPassword();
		if (encryptedPassword.equals(new JavaMD5Hash().md5(password)))
			return user;
		else
			return null;
	}

	public User getUser(String email) {
		Query query = this.em.createQuery("FROM User AS user WHERE user.email=?");
		query.setParameter(0, email);
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
