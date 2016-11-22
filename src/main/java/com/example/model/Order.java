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
@Table(name = "USER_ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int id;
	private String fromAddress;
	private String destination;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String size;
	private int weight;
	private DeliveryStatus status;
	private String dealer;
	@Temporal(TemporalType.DATE)
	private Date expectedArrivalDate;

	@ManyToOne
	@JoinColumn(name = "user_email")
	private User user;

	@ManyToMany(mappedBy = "orderList")
	private List<Company> companyList;

	public Order() {

	}

	public Order(String fromAddress, String destination, String size,
			int weight, DeliveryStatus status, String dealer) {
		this.fromAddress = fromAddress;
		this.destination = destination;
		this.date = new Date();
		this.size = size;
		this.weight = weight;
		this.status = status;
		this.dealer = dealer;
		this.expectedArrivalDate = getTheExpectedArrivalDate();
		this.companyList = new ArrayList<Company>();
	}

	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
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

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void addCompany(Company company) {
		this.companyList.add(company);
		company.addOrder(this);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", fromAddress=" + fromAddress
				+ ", destination=" + destination + ", date=" + date + ", size="
				+ size + ", weight=" + weight + ", status=" + status
				+ ", dealer=" + dealer + ", expectedArrivalDate="
				+ expectedArrivalDate + ", user=" + user + ", companyList="
				+ companyList + "]";
	}


}
