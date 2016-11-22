package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Company {

	@Id
	private String name;
	private String manager;
	private String location;
	private String phone;
	private String email;
	private String registrationNumber;

	@ManyToMany
	private List<Order> orderList;

	public Company() {

	}

	public Company(String name, String manager, String location, String phone,
			String email, String registrationNumber) {
		super();
		this.name = name;
		this.manager = manager;
		this.location = location;
		this.phone = phone;
		this.email = email;
		this.registrationNumber = registrationNumber;
		this.orderList = new ArrayList<Order>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void addOrder(Order order) {
		this.orderList.add(order);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setOrder(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", manager=" + manager + ", location="
				+ location + ", phone=" + phone + ", email=" + email
				+ ", registrationNumber=" + registrationNumber + ", orderList="
				+ orderList + "]";
	}

}
