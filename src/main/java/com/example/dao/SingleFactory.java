package com.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.desalgorithm.JavaMD5Hash;
import com.example.model.User;

public class SingleFactory {
	private static final SingleFactory singleFactory = new SingleFactory();
	private EntityManagerFactory emf;

	private SingleFactory() {
	}

	public static SingleFactory GetInstance() {
		return singleFactory;
	}

	public EntityManagerFactory getEMF() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("default");
		return emf;
	}

	public EntityManager getEntityManager() {
		EntityManagerFactory emf = getEMF();
		return emf.createEntityManager();
	}

	public UserService getUserImp() {
		return new UserImp(getEntityManager(), new JavaMD5Hash());
	}

	public OrderService getOrderImp() {
		return new OrderImp(getEntityManager());
	}

}
