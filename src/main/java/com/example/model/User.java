package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dts_user")
public class User {
	@Id
	@Column(unique = true, nullable = false)
	private String email;
	private String username;
	private String password;
	private String name;
	private String surnname;
	private int age;
	@Column(name = "Date_of_birth")
	private String dob;
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_email")
	private List<Order> orderList;

	public User() {
	}

	public User(String email, String username, String password, String name, String surnname, int age, String dob,
			String address) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surnname = surnname;
		this.age = age;
		this.dob = dob;
		this.address = address;
		this.orderList = new ArrayList<Order>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnname() {
		return surnname;
	}

	public void setSurnname(String surnname) {
		this.surnname = surnname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrder() {
		return this.orderList;
	}

	public void addOrder(Order order) {
		this.orderList.add(order);
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", surnname=" + surnname + ", age=" + age + ", dob=" + dob + ", address=" + address;
	}
}
