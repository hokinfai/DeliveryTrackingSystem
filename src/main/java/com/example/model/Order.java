package com.example.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.dao.DeliveryStatus;

@Entity
@Table(name = "dts_ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int id;
	private String shipFrom;
	private String shipTo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	private String boxDimension;
	private int weight;
	private String orderStatus;
	@Temporal(TemporalType.DATE)
	private Date expectedArrivalDate;

	@ManyToOne
	@JoinColumn(name = "user_email")
	private User user;

	@ManyToMany
	private List<Company> companyList;

	public Order() {

	}

	public Order(String shipFrom, String shipTo, String boxDimension,
			int weight, String orderStatus) {
		this.shipFrom = shipFrom;
		this.shipTo = shipTo;
		this.orderDate = new Date();
		this.boxDimension = boxDimension;
		this.weight = weight;
		this.orderStatus = orderStatus;
		this.expectedArrivalDate = getTheExpectedArrivalDate();
		this.companyList = new ArrayList<Company>();
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void addCompany(Company company) {
		this.companyList.add(company);
		// company.addOrder(this);
	}

	public String getFromAddress() {
		return shipFrom;
	}

	public void setFromAddress(String fromAddress) {
		this.shipFrom = fromAddress;
	}

	public String getDestination() {
		return shipTo;
	}

	public void setDestination(String destination) {
		this.shipTo = destination;
	}

	public String getSize() {
		return boxDimension;
	}

	public void setSize(String size) {
		this.boxDimension = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getStatus() {
		return orderStatus;
	}

	public void setStatus(String status) {
		this.orderStatus = status;
	}

	public Date getTheExpectedArrivalDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 84);
		return (Date) calendar.getTime();
	}

	public Date getExpectedArrivalDate() {
		return expectedArrivalDate;
	}

	public void setExpectedArrivalDate(Date expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Date setOrderDate(Date orderDate) {
		return this.orderDate = orderDate;
	}

	public int getId() {
		return this.id;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "Order [fromAddress=" + shipFrom + ", destination=" + shipTo
				+ ", date=" + orderDate + ", size=" + boxDimension
				+ ", weight=" + weight + ", status=" + orderStatus
				+ ", expectedArrivalDate=" + expectedArrivalDate + "]";
	}

}
